package model;

import java.util.Date;

public class Valoracion {
    private int id;
    private int idLibro;
    private int idUsuario;
    private int puntuacion;
    private String comentario;
    private Date fecha;

    public Valoracion() {}

    public Valoracion(int id, int idLibro, int idUsuario, int puntuacion, String comentario, Date fecha) {
        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
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

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", idLibro=" + idLibro + ", idUsuario=" + idUsuario + ", puntuacion="
				+ puntuacion + ", comentario=" + comentario + ", fecha=" + fecha + "]";
	}

    
    
    
    
}
