package py.edu.ucsa.bargains.dtos;

public class Dominio {
	private Long id;
	private String codigo;
	private String descripcion;
	private Dominio dominio_padre;
	private char estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Dominio getDominio_padre() {
		return dominio_padre;
	}

	public void setDominio_padre(Dominio dominio_padre) {
		this.dominio_padre = dominio_padre;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

}
