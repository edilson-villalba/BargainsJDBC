package py.edu.ucsa.bargains.daos.hibernate.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import py.edu.ucsa.bargains.daos.OpcionDAO;
import py.edu.ucsa.bargains.dtos.Opcion;

public class OpcionDAOHibernateImpl implements OpcionDAO {

	@Override
	public List<Opcion> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Opcion buscarID(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Opcion t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Opcion t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Opcion> getOpcionByCodigoYIdDominio(String codOpcion, Integer idDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Opcion> getOpcionByCodigoYCodDominio(String codOpcion, Integer codDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Opcion> getOpcionesByCodDominio(String codDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Opcion> getOpcionesByIdDominio(Integer codDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Opcion> getOpcionesByIdDominioPadre(Integer idDominioPadre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Opcion> getOpcionesByCodDominioPadre(String codDominioPadre) {
		// TODO Auto-generated method stub
		return null;
	}

}
