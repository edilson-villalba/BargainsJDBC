package py.edu.ucsa.bargains.daos;

import java.util.Optional;

import py.edu.ucsa.bargains.dtos.Opcion;

public interface OpcionDAO extends GenericDAO<Opcion>{
	public Optional<Opcion> getOpcionByCodigoYIdDominio(String codOpcion, Integer idDominio);
	public Optional<Opcion> getOpcionByCodigoYCodDominio(String codOpcion, Integer codDominio);
	public Iterable<Opcion> getOpcionesByCodDominio(String codDominio);
	public Iterable<Opcion> getOpcionesByIdDominio(Integer codDominio);
	public Iterable<Opcion> getOpcionesByIdDominioPadre(Integer idDominioPadre);
	public Iterable<Opcion> getOpcionesByCodDominioPadre(String codDominioPadre);

}