package model;

import java.util.Date;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String tipoUsuario;
    private Date fechaRegistro;

    public Usuario() {}

    public Usuario(int id, String nombre, String email, String tipoUsuario, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", tipoUsuario=" + tipoUsuario
				+ ", fechaRegistro=" + fechaRegistro + "]";
	}

}
