package model;

import java.util.Date;

public class Respuesta {
    private int id;
    private int idPregunta;
    private int idUsuario;
    private String contenido;
    private Date fecha;

    public Respuesta() {}

    public Respuesta(int id, int idPregunta, int idUsuario, String contenido, Date fecha) {
        this.id = id;
        this.idPregunta = idPregunta;
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

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
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
		return "Respuesta [id=" + id + ", idPregunta=" + idPregunta + ", idUsuario=" + idUsuario + ", contenido="
				+ contenido + ", fecha=" + fecha + "]";
	}



}
