package py.edu.ucsa.bargains.dtos;

public class Producto {
	
	private Long id;
	private String codigo;
	private String descripcion;
	private Opcion paisOrigen;
	private Opcion tipoProducto;
	private Opcion unidadMedida;
	private Opcion estado;
	private boolean esLote;
	private Moneda moneda;
	private String denominacion;
	private Opcion serie;
	private String imagen;
	private int anhoEmision;

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

	public Opcion getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(Opcion paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public Opcion getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Opcion tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Opcion getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(Opcion unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Opcion getEstado() {
		return estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}

	public boolean isEsLote() {
		return esLote;
	}

	public void setEsLote(boolean esLote) {
		this.esLote = esLote;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public Opcion getSerie() {
		return serie;
	}

	public void setSerie(Opcion serie) {
		this.serie = serie;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getAnhoEmision() {
		return anhoEmision;
	}

	public void setAnhoEmision(int anhoEmision) {
		this.anhoEmision = anhoEmision;
	}
	
	
}
