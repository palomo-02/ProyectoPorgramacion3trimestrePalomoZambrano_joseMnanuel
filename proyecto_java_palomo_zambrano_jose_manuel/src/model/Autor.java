package model;

import java.util.Date;

public class Autor {
    private int id;
    private String nombre;
    private String biografia;
    private String nacionalidad;
    private Date fechaNacimiento;

    public Autor() {}

    public Autor(int id, String nombre, String biografia, String nacionalidad, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.biografia = biografia;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
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

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", biografia=" + biografia + ", nacionalidad=" + nacionalidad
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
