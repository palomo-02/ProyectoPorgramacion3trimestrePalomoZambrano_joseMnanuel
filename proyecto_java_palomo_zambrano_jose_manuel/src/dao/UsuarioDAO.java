package dao;

import model.Usuario;
import util.ConexionBD;

import java.sql.*;

public class UsuarioDAO {
    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("tipo_usuario"),
                    rs.getDate("fecha_registro")
                );
            }
        }
        return null;
    }
}
