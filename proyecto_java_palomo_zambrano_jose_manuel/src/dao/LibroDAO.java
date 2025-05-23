package dao;

import model.Libro;
import util.ConexionBD;

import java.sql.*;
import java.util.*;

public class LibroDAO {
    public void crearLibro(Libro libro, List<Integer> idAutores) throws SQLException {
        String sql = "INSERT INTO libros (titulo, sinopsis, id_categoria, fecha_publicacion, id_usuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getSinopsis());
            ps.setInt(3, libro.getIdCategoria());
            ps.setDate(4, new java.sql.Date(libro.getFechaPublicacion().getTime()));
            ps.setInt(5, libro.getIdUsuario());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idLibro = rs.getInt(1);
                for (int idAutor : idAutores) {
                    PreparedStatement ps2 = con.prepareStatement("INSERT INTO autor_libro (id_autor, id_libro) VALUES (?, ?)");
                    ps2.setInt(1, idAutor);
                    ps2.setInt(2, idLibro);
                    ps2.executeUpdate();
                    ps2.close();
                }
            }
        }
    }

    public List<Libro> buscarLibroPorTitulo(String titulo) throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE titulo LIKE ?";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + titulo + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                libros.add(new Libro(
                    rs.getInt("id_libro"),
                    rs.getString("titulo"),
                    rs.getString("sinopsis"),
                    rs.getInt("id_categoria"),
                    rs.getDate("fecha_publicacion"),
                    rs.getInt("id_usuario")
                ));
            }
        }
        return libros;
    }

    public List<Libro> obtenerTopLibrosPorCategoria(int idCategoria) throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT l.*, AVG(v.puntuacion) as promedio FROM libros l JOIN valoracion v ON l.id_libro = v.id_libro WHERE l.id_categoria = ? GROUP BY l.id_libro ORDER BY promedio DESC LIMIT 5";
        try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                libros.add(new Libro(
                    rs.getInt("id_libro"),
                    rs.getString("titulo"),
                    rs.getString("sinopsis"),
                    rs.getInt("id_categoria"),
                    rs.getDate("fecha_publicacion"),
                    rs.getInt("id_usuario")
                ));
            }
        }
        return libros;
    }
}
