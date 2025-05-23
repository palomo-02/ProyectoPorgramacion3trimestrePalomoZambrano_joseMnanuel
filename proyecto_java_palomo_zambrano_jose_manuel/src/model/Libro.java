package model;

import java.util.Date;
import java.util.List;

public class Libro {
    private int id;
    private String titulo;
    private String sinopsis;
    private int idCategoria;
    private Date fechaPublicacion;
    private int idUsuario;
    private List<Autor> autores;

    public Libro() {}

    public Libro(int id, String titulo, String sinopsis, int idCategoria, Date fechaPublicacion, int idUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.idCategoria = idCategoria;
        this.fechaPublicacion = fechaPublicacion;
        this.idUsuario = idUsuario;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", sinopsis=" + sinopsis + ", idCategoria=" + idCategoria
				+ ", fechaPublicacion=" + fechaPublicacion + ", idUsuario=" + idUsuario + ", autores=" + autores + "]";
	}

    // Getters y setters
}
