package py.edu.ucsa.bargains.dtos;

public class Stock {
	private Long id;
	private Producto producto;
	private Long unidad_medida;
	private double existencia_actual;
	private double existencia_minima;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(Long unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public double getExistencia_actual() {
		return existencia_actual;
	}

	public void setExistencia_actual(double existencia_actual) {
		this.existencia_actual = existencia_actual;
	}

	public double getExistencia_minima() {
		return existencia_minima;
	}

	public void setExistencia_minima(double existencia_minima) {
		this.existencia_minima = existencia_minima;
	}

}
