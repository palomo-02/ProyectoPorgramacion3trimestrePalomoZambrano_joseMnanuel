package model;

public class Favorito {
    private int idUsuario;
    private int idLibro;

    public Favorito() {}

    public Favorito(int idUsuario, int idLibro) {
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	@Override
	public String toString() {
		return "Favorito [idUsuario=" + idUsuario + ", idLibro=" + idLibro + "]";
	}




}
