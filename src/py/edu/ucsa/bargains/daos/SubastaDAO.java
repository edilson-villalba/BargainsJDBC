package py.edu.ucsa.bargains.daos;

import java.util.List;

import py.edu.ucsa.bargains.dtos.Producto;
import py.edu.ucsa.bargains.dtos.Subasta;

public interface SubastaDAO extends GenericDAO<Subasta>{
	public void marcarDetalleComoPagado();
	public void marcarDetalleComoEntregado();
	public List<Producto> listarProductosGanadosPorClienteYSubasta();
	public List<Producto> listarProductosGanadosPorClienteEnTodasLasSubastas();
}
