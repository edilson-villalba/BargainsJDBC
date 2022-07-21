package py.edu.ucsa.bargains.dtos;

public class Usuario {

	private Long id;
	private String nombreApellido;
	private String usuario;
	private String clave;
	private Opcion tipoUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Opcion getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Opcion tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
