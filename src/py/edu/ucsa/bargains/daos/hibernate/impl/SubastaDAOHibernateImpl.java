package py.edu.ucsa.bargains.daos.hibernate.impl;

import java.sql.SQLException;
import java.util.List;

import py.edu.ucsa.bargains.daos.SubastaDAO;
import py.edu.ucsa.bargains.dtos.Producto;
import py.edu.ucsa.bargains.dtos.Subasta;

public class SubastaDAOHibernateImpl implements SubastaDAO {

	@Override
	public void marcarDetalleComoPagado() {

	}

	@Override
	public void marcarDetalleComoEntregado() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Producto> listarProductosGanadosPorClienteYSubasta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProductosGanadosPorClienteEnTodasLasSubastas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subasta> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subasta buscarID(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Subasta t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Subasta t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
