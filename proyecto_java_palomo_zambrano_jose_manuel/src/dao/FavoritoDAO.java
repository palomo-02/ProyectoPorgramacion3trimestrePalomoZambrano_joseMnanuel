package dao;

import model.Favorito;
import util.ConexionBD;

import java.sql.*;
import java.util.*;

public class FavoritoDAO {
    public void agregarAFavoritos(Favorito favorito) throws SQLException {
        String sql = "INSERT INTO favorito (id_usuario, id_libro) VALUES (?, ?)";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, favorito.getIdUsuario());
            ps.setInt(2, favorito.getIdLibro());
            ps.executeUpdate();
        }
    }

    public List<Integer> obtenerFavoritosPorUsuario(int idUsuario) throws SQLException {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT id_libro FROM favorito WHERE id_usuario = ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt("id_libro"));
            }
        }
        return ids;
    }
}
