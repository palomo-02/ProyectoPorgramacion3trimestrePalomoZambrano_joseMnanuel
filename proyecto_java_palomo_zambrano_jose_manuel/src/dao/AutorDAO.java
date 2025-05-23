package dao;

import model.Autor;
import util.ConexionBD;

import java.sql.*;
import java.util.*;

public class AutorDAO {
    public List<Autor> obtenerAutoresPorLibro(int idLibro) throws SQLException {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT a.* FROM autor a JOIN autor_libro al ON a.id_autor = al.id_autor WHERE al.id_libro = ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLibro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                autores.add(new Autor(
                    rs.getInt("id_autor"),
                    rs.getString("nombre"),
                    rs.getString("biografia"),
                    rs.getString("nacionalidad"),
                    rs.getDate("fecha_nacimiento")
                ));
            }
        }
        return autores;
    }

    public List<String> obtenerLibrosPorAutor(int idAutor) throws SQLException {
        List<String> libros = new ArrayList<>();
        String sql = "SELECT l.titulo FROM libros l JOIN autor_libro al ON l.id_libro = al.id_libro WHERE al.id_autor = ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAutor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                libros.add(rs.getString("titulo"));
            }
        }
        return libros;
    }
}
