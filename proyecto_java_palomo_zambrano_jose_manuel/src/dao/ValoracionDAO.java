package dao;

import model.Valoracion;
import util.ConexionBD;

import java.sql.*;

public class ValoracionDAO {
    public void agregarValoracion(Valoracion valoracion) throws SQLException {
        String sql = "INSERT INTO valoracion (id_libro, id_usuario, puntuacion, comentario, fecha) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, valoracion.getIdLibro());
            ps.setInt(2, valoracion.getIdUsuario());
            ps.setInt(3, valoracion.getPuntuacion());
            ps.setString(4, valoracion.getComentario());
            ps.setDate(5, new java.sql.Date(valoracion.getFecha().getTime()));
            ps.executeUpdate();
        }
    }
}
