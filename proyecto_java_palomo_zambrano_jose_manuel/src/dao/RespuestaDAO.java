package dao;

import model.Respuesta;
import util.ConexionBD;

import java.sql.*;
import java.util.*;

public class RespuestaDAO {
    public void responderPregunta(Respuesta respuesta) throws SQLException {
        String sql = "INSERT INTO respuesta (id_pregunta, id_usuario, contenido, fecha) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, respuesta.getIdPregunta());
            ps.setInt(2, respuesta.getIdUsuario());
            ps.setString(3, respuesta.getContenido());
            ps.setDate(4, new java.sql.Date(respuesta.getFecha().getTime()));
            ps.executeUpdate();
        }
    }

    public List<Respuesta> obtenerRespuestasPorPregunta(int idPregunta) throws SQLException {
        List<Respuesta> respuestas = new ArrayList<>();
        String sql = "SELECT * FROM respuesta WHERE id_pregunta = ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPregunta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                respuestas.add(new Respuesta(
                    rs.getInt("id_respuesta"),
                    rs.getInt("id_pregunta"),
                    rs.getInt("id_usuario"),
                    rs.getString("contenido"),
                    rs.getDate("fecha")
                ));
            }
        }
        return respuestas;
    }
}
