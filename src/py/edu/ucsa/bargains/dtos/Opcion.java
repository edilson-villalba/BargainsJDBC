package py.edu.ucsa.bargains.dtos;

public class Opcion {
	private Long id;
	private Dominio dominio;
	private String codigo;
	private String descripcion;
	private String estado;
	private Opcion opcionPadre;
	
	

	public Opcion() {
		super();
	}

	public Opcion(String codigo) {
		super();
		this.codigo = codigo;
	}

	public Opcion(Long id) {
		super();
		this.id = id;
	}

	public Opcion(Long id, Dominio dominio, String codigo, String descripcion, String estado, Opcion opcionPadre) {
		super();
		this.id = id;
		this.dominio = dominio;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.opcionPadre = opcionPadre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dominio getDominio() {
		return dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Opcion getOpcionPadre() {
		return opcionPadre;
	}

	public void setOpcionPadre(Opcion opcionPadre) {
		this.opcionPadre = opcionPadre;
	}

}
