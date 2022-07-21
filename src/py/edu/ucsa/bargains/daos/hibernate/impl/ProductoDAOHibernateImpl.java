package py.edu.ucsa.bargains.daos.hibernate.impl;

import java.sql.SQLException;
import java.util.List;

import py.edu.ucsa.bargains.daos.ProductoDAO;
import py.edu.ucsa.bargains.dtos.Producto;

public class ProductoDAOHibernateImpl implements ProductoDAO {

	@Override
	public List<Producto> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto buscarID(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Producto t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Producto t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Producto> getProductosPorTipo(Long idTipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getProductosPorPais(Long idPais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getProductosConExistencia() {
		// TODO Auto-generated method stub
		return null;
	}

}
