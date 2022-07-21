package py.edu.ucsa.bargains.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Subasta {

	private Long id;
	private LocalDateTime fechaHoraCierre;
	private LocalDateTime fechaCreacion;
	private double totalBase;
	private double totalFinal;
	private Opcion estado;
	private String observaciones;
	private int nroSubasta;
	private String tituloSubasta;
	private List<SubastaDetalle> detalles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHoraCierre() {
		return fechaHoraCierre;
	}

	public void setFechaHoraCierre(LocalDateTime fechaHoraCierre) {
		this.fechaHoraCierre = fechaHoraCierre;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public double getTotalBase() {
		return totalBase;
	}

	public void setTotalBase(double totalBase) {
		this.totalBase = totalBase;
	}

	public double getTotalFinal() {
		return totalFinal;
	}

	public void setTotalFinal(double totalFinal) {
		this.totalFinal = totalFinal;
	}

	public Opcion getEstado() {
		return estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getNroSubasta() {
		return nroSubasta;
	}

	public void setNroSubasta(int nroSubasta) {
		this.nroSubasta = nroSubasta;
	}

	public String getTituloSubasta() {
		return tituloSubasta;
	}

	public void setTituloSubasta(String tituloSubasta) {
		this.tituloSubasta = tituloSubasta;
	}

	public List<SubastaDetalle> getDetalles() {
		if (detalles == null) {
			detalles = new ArrayList<>();
		}
		return detalles;
	}

	public void setDetalles(List<SubastaDetalle> detalles) {
		this.detalles = detalles;
	}

}
