package py.edu.ucsa.bargains.dtos;

import java.time.LocalDateTime;

public class SubastaDetalle {

	private Long id;
	private Opcion estadoVenta;
	private Opcion estadoPago;
	private Opcion estadoEntrega;
	private Subasta cabecera;
	private Producto producto;
	private Cliente clienteGanador;
	private double montoBase;
	private double pujaMinima;
	private LocalDateTime fechaHoraCierre;
	private Opcion monedaSubasta;
	private LocalDateTime fechaPago;
	private LocalDateTime fechaEntrega;
	private Opcion formaEntrega;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Opcion getEstadoVenta() {
		return estadoVenta;
	}

	public void setEstadoVenta(Opcion estadoVenta) {
		this.estadoVenta = estadoVenta;
	}

	public Opcion getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(Opcion estadoPago) {
		this.estadoPago = estadoPago;
	}

	public Opcion getEstadoEntrega() {
		return estadoEntrega;
	}

	public void setEstadoEntrega(Opcion estadoEntrega) {
		this.estadoEntrega = estadoEntrega;
	}

	public Subasta getCabecera() {
		return cabecera;
	}

	public void setCabecera(Subasta cabecera) {
		this.cabecera = cabecera;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getClienteGanador() {
		return clienteGanador;
	}

	public void setClienteGanador(Cliente clienteGanador) {
		this.clienteGanador = clienteGanador;
	}

	public double getMontoBase() {
		return montoBase;
	}

	public void setMontoBase(double montoBase) {
		this.montoBase = montoBase;
	}

	public double getPujaMinima() {
		return pujaMinima;
	}

	public void setPujaMinima(double pujaMinima) {
		this.pujaMinima = pujaMinima;
	}

	public LocalDateTime getFechaHoraCierre() {
		return fechaHoraCierre;
	}

	public void setFechaHoraCierre(LocalDateTime fechaHoraCierre) {
		this.fechaHoraCierre = fechaHoraCierre;
	}

	public Opcion getMonedaSubasta() {
		return monedaSubasta;
	}

	public void setMonedaSubasta(Opcion monedaSubasta) {
		this.monedaSubasta = monedaSubasta;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Opcion getFormaEntrega() {
		return formaEntrega;
	}

	public void setFormaEntrega(Opcion formaEntrega) {
		this.formaEntrega = formaEntrega;
	}

}
