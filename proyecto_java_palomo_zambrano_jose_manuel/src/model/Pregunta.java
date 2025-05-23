package model;

import java.util.Date;

public class Pregunta {
    private int id;
    private int idLibro;
    private int idUsuario;
    private String contenido;
    private Date fecha;

    public Pregunta() {}

    public Pregunta(int id, int idLibro, int idUsuario, String contenido, Date fecha) {
        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
        this.fecha = fecha;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", idLibro=" + idLibro + ", idUsuario=" + idUsuario + ", contenido=" + contenido
				+ ", fecha=" + fecha + "]";
	}

    
    
}
