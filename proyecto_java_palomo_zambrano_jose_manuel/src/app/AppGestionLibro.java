package app;

import dao.*;
import model.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AppGestionLibro {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		LibroDAO libroDAO = new LibroDAO();
		AutorDAO autorDAO = new AutorDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ValoracionDAO valoracionDAO = new ValoracionDAO();
		PreguntaDAO preguntaDAO = new PreguntaDAO();
		RespuestaDAO respuestaDAO = new RespuestaDAO();
		FavoritoDAO favoritoDAO = new FavoritoDAO();

		while (true) {
			System.out.println("\n--- Menú Principal ---");
			System.out.println("1. Subir entrada de un libro por categoría");
			System.out.println("2. Publicar valoración");
			System.out.println("3. Publicar pregunta en foro de un libro");
			System.out.println("4. Responder una pregunta");
			System.out.println("5. Ver historial de preguntas y respuestas");
			System.out.println("6. Ver libros mejor valorados por categoría");
			System.out.println("7. Ver libros de un autor específico");
			System.out.println("8. Buscar información de un libro");
			System.out.println("9. Añadir libro a favoritos");
			System.out.println("10. Ver lista de libros favoritos");
			System.out.println("0. Salir");
			System.out.print("Opción: ");
			int opcion = Integer.parseInt(scanner.nextLine());

			try {
				switch (opcion) {
				case 1 -> subirLibro(libroDAO);
				case 2 -> publicarValoracion(valoracionDAO);
				case 3 -> publicarPregunta(preguntaDAO);
				case 4 -> responderPregunta(respuestaDAO);
				case 5 -> verHistorial(preguntaDAO, respuestaDAO);
				case 6 -> verTopLibrosPorCategoria(libroDAO);
				case 7 -> verLibrosPorAutor(autorDAO);
				case 8 -> buscarLibro(libroDAO);
				case 9 -> anadirAFavoritos(favoritoDAO);
				case 10 -> verFavoritos(favoritoDAO, libroDAO);
				case 0 -> {
					System.out.println("Saliendo...");
					return;
				}
				default -> System.out.println("Opción no válida.");
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	private static void subirLibro(LibroDAO libroDAO) throws Exception {
		System.out.print("Título: ");
		String titulo = scanner.nextLine();
		System.out.print("Sinopsis: ");
		String sinopsis = scanner.nextLine();
		System.out.print("ID Categoría: ");
		int idCategoria = Integer.parseInt(scanner.nextLine());
		System.out.print("Fecha publicación (yyyy-MM-dd): ");
		Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
		System.out.print("ID Usuario creador: ");
		int idUsuario = Integer.parseInt(scanner.nextLine());
		System.out.print("IDs de autores (separados por coma): ");
		String[] ids = scanner.nextLine().split(",");
		List<Integer> idAutores = new ArrayList<>();
		for (String id : ids)
			idAutores.add(Integer.parseInt(id.trim()));

		Libro libro = new Libro(0, titulo, sinopsis, idCategoria, fecha, idUsuario);
		libroDAO.crearLibro(libro, idAutores);
		System.out.println("Libro subido correctamente.");
	}

	private static void publicarValoracion(ValoracionDAO dao) throws Exception {
		System.out.print("ID Libro: ");
		int idLibro = Integer.parseInt(scanner.nextLine());
		System.out.print("ID Usuario: ");
		int idUsuario = Integer.parseInt(scanner.nextLine());
		System.out.print("Puntuación (1-5): ");
		int puntuacion = Integer.parseInt(scanner.nextLine());
		System.out.print("Comentario (opcional): ");
		String comentario = scanner.nextLine();

		Valoracion v = new Valoracion(0, idLibro, idUsuario, puntuacion, comentario, new Date());
		dao.agregarValoracion(v);
		System.out.println("Valoración registrada.");
	}

	private static void publicarPregunta(PreguntaDAO dao) throws Exception {
		System.out.print("ID Libro: ");
		int idLibro = Integer.parseInt(scanner.nextLine());
		System.out.print("ID Usuario: ");
		int idUsuario = Integer.parseInt(scanner.nextLine());
		System.out.print("Pregunta: ");
		String contenido = scanner.nextLine();

		Pregunta p = new Pregunta(0, idLibro, idUsuario, contenido, new Date());
		dao.publicarPregunta(p);
		System.out.println("Pregunta publicada.");
	}

	private static void responderPregunta(RespuestaDAO dao) throws Exception {
		System.out.print("ID Pregunta: ");
		int idPregunta = Integer.parseInt(scanner.nextLine());
		System.out.print("ID Usuario: ");
		int idUsuario = Integer.parseInt(scanner.nextLine());
		System.out.print("Respuesta: ");
		String contenido = scanner.nextLine();

		Respuesta r = new Respuesta(0, idPregunta, idUsuario, contenido, new Date());
		dao.responderPregunta(r);
		System.out.println("Respuesta publicada.");
	}

	private static void verHistorial(PreguntaDAO pDao, RespuestaDAO rDao) throws Exception {
		System.out.print("ID Libro: ");
		int idLibro = Integer.parseInt(scanner.nextLine());

		List<Pregunta> preguntas = pDao.obtenerPreguntasPorLibro(idLibro);
		for (Pregunta p : preguntas) {
			System.out.println("Pregunta [" + p.getId() + "]: " + p.getContenido());
			List<Respuesta> respuestas = rDao.obtenerRespuestasPorPregunta(p.getId());
			for (Respuesta r : respuestas) {
				System.out.println("  ↳ Respuesta: " + r.getContenido());
			}
		}
	}

	private static void verTopLibrosPorCategoria(LibroDAO dao) throws SQLException {
		System.out.print("ID Categoría: ");
		int idCategoria = Integer.parseInt(scanner.nextLine());

		List<Libro> libros = dao.obtenerTopLibrosPorCategoria(idCategoria);
		for (Libro libro : libros) {
			System.out.println("Libro: " + libro.getTitulo());
		}
	}

	private static void verLibrosPorAutor(AutorDAO dao) throws SQLException {
		System.out.print("ID Autor: ");
		int idAutor = Integer.parseInt(scanner.nextLine());

		List<String> libros = dao.obtenerLibrosPorAutor(idAutor);
		for (String titulo : libros) {
			System.out.println("Libro: " + titulo);
		}
	}

	private static void buscarLibro(LibroDAO dao) throws SQLException {
		System.out.print("Título (o parte): ");
		String titulo = scanner.nextLine();

		List<Libro> libros = dao.buscarLibroPorTitulo(titulo);
		for (Libro libro : libros) {
			System.out.println("Libro encontrado: " + libro.getTitulo() + " (ID: " + libro.getId() + ")");
		}
	}

	private static void anadirAFavoritos(FavoritoDAO dao) throws SQLException {
		System.out.print("ID Usuario: ");
		int idUsuario = Integer.parseInt(scanner.nextLine());
		System.out.print("ID Libro: ");
		int idLibro = Integer.parseInt(scanner.nextLine());

		Favorito favorito = new Favorito(idUsuario, idLibro);
		dao.agregarAFavoritos(favorito);
		System.out.println("Libro añadido a favoritos.");
	}

	private static void verFavoritos(FavoritoDAO dao, LibroDAO libroDAO) throws SQLException {
		System.out.print("ID Usuario: ");
		int idUsuario = Integer.parseInt(scanner.nextLine());

		List<Integer> ids = dao.obtenerFavoritosPorUsuario(idUsuario);
		for (int idLibro : ids) {
			List<Libro> libros = libroDAO.buscarLibroPorTitulo(""); // Simula búsqueda para obtener info
			for (Libro libro : libros) {
				if (libro.getId() == idLibro) {
					System.out.println("Favorito: " + libro.getTitulo());
				}
			}
		}
	}
}
