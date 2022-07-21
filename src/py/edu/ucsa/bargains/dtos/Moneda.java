package py.edu.ucsa.bargains.dtos;

public class Moneda {
	
	private Long id;
	private String codigoIso;
	private String simbolo;
	private String unidadMonetaria;
	private Opcion pais;
	private Opcion unidadFraccionaria;
	private int division;
	private String observaciones;
	private Opcion estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoIso() {
		return codigoIso;
	}

	public void setCodigoIso(String codigoIso) {
		this.codigoIso = codigoIso;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getUnidadMonetaria() {
		return unidadMonetaria;
	}

	public void setUnidadMonetaria(String unidadMonetaria) {
		this.unidadMonetaria = unidadMonetaria;
	}

	public Opcion getPais() {
		return pais;
	}

	public void setPais(Opcion pais) {
		this.pais = pais;
	}

	public Opcion getUnidadFraccionaria() {
		return unidadFraccionaria;
	}

	public void setUnidadFraccionaria(Opcion unidadFraccionaria) {
		this.unidadFraccionaria = unidadFraccionaria;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Opcion getEstado() {
		return estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}
	

}
