package py.edu.ucsa.bargains.dtos;

public class Cliente {
	private Long id;
	private String nombre;
	private Opcion tipDoc;
	private String numeroDoc;
	private double saldoPendiente;
	private double compraAcumulada;
	private String numeroCelular;
	private String direccion;
	private String correo;
	private Opcion ciudad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Opcion getTipDoc() {
		return tipDoc;
	}

	public void setTipDoc(Opcion tipDoc) {
		this.tipDoc = tipDoc;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public double getCompraAcumulada() {
		return compraAcumulada;
	}

	public void setCompraAcumulada(double compraAcumulada) {
		this.compraAcumulada = compraAcumulada;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Opcion getCiudad() {
		return ciudad;
	}

	public void setCiudad(Opcion ciudad) {
		this.ciudad = ciudad;
	}

}
