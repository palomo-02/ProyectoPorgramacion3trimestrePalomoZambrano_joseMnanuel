package dao;

import model.Categoria;
import util.ConexionBD;

import java.sql.*;

public class CategoriaDAO {
    public Categoria obtenerCategoriaPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categorias WHERE id_categoria = ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                );
            }
        }
        return null;
    }
}
