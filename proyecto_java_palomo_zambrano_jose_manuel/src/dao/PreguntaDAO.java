package dao;

import model.Pregunta;
import util.ConexionBD;

import java.sql.*;
import java.util.*;

public class PreguntaDAO {
    public void publicarPregunta(Pregunta pregunta) throws SQLException {
        String sql = "INSERT INTO pregunta (id_libro, id_usuario, contenido, fecha) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pregunta.getIdLibro());
            ps.setInt(2, pregunta.getIdUsuario());
            ps.setString(3, pregunta.getContenido());
            ps.setDate(4, new java.sql.Date(pregunta.getFecha().getTime()));
            ps.executeUpdate();
        }
    }

    public List<Pregunta> obtenerPreguntasPorLibro(int idLibro) throws SQLException {
        List<Pregunta> preguntas = new ArrayList<>();
        String sql = "SELECT * FROM pregunta WHERE id_libro = ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLibro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                preguntas.add(new Pregunta(
                    rs.getInt("id_pregunta"),
                    rs.getInt("id_libro"),
                    rs.getInt("id_usuario"),
                    rs.getString("contenido"),
                    rs.getDate("fecha")
                ));
            }
        }
        return preguntas;
    }
}
