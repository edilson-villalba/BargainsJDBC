package py.edu.ucsa.bargains.daos;

import java.util.List;

import py.edu.ucsa.bargains.dtos.Producto;

public interface ProductoDAO extends GenericDAO<Producto> {
	public List<Producto> getProductosPorTipo(Long idTipo);
	public List<Producto> getProductosPorPais(Long idPais);
	public List<Producto> getProductosConExistencia();
}
