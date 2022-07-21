package py.edu.ucsa.bargains.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import py.edu.ucsa.bargains.daos.AbstractDAO;
import py.edu.ucsa.bargains.daos.GenericDAO;
import py.edu.ucsa.bargains.daos.ProductoDAO;
import py.edu.ucsa.bargains.dtos.Moneda;
import py.edu.ucsa.bargains.dtos.Opcion;
import py.edu.ucsa.bargains.dtos.Producto;

public class ProductoDAOImpl extends AbstractDAO<Producto> implements ProductoDAO {

	private static final String QUERY_PRODUCTOS = 
			"SELECT p.*, po.codigo cod_pais_origen, po.descripcion desc_pais_origen, "
			+ "tp.codigo cod_tipo_producto, tp.descripcion desc_tipo_producto, "
			+ "um.codigo cod_unidad_medida, um.descripcion desc_unidad_medida, "
			+ "e.codigo cod_estado, e.descripcion desc_estado, "
			+ "s.codigo cod_serie, s.descripcion desc_serie, "
			+ "m.simbolo, m.unidad_monetaria "
			+ "FROM productos p INNER JOIN opciones po ON po.id = p.id_pais_origen "
			+ "INNER JOIN opciones tp ON tp.id = p.id_tipo_producto "
			+ "INNER JOIN opciones um ON um.id = p.id_unidad_medida "
			+ "INNER JOIN opciones e ON e.id = p.id_estado "
			+ "INNER JOIN monedas m ON m.id = p.id_moneda "
			+ "LEFT OUTER JOIN opciones s ON s.id = p.id_serie ";

	public ProductoDAOImpl() throws SQLException {
		super();
	}

	@Override
	public List<Producto> listarTodos() {
		List<Producto> productos = new ArrayList<>();
		try (Statement stmt = conexion.createStatement(); 
				ResultSet rs = stmt.executeQuery(QUERY_PRODUCTOS)) {

			while(rs.next()) {
				productos.add(getProducto(rs));
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener todos los PRODUCTOS", e);
		}
		return productos;
	}

	@Override
	public Producto buscarID(Long id) {
		Producto producto = null;
		try (PreparedStatement stmt = conexion.prepareStatement(QUERY_PRODUCTOS + " WHERE p.id = ?")) {

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				producto = getProducto(rs);
			}
			rs.close();

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener el PRODUCTO con ID = " + id, e);
		}
		return producto;
	}

	@Override
	public void insertar(Producto t) {
		try (PreparedStatement stmt = conexion
				.prepareStatement("INSERT INTO productos(codigo, descripcion, id_pais_origen, id_tipo_producto, "
						+ "id_unidad_medida, id_estado, es_lote, id_moneda, denominacion, id_serie, imagen, anho_emision) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

			stmt.setString(1, t.getCodigo());
			stmt.setString(2, t.getDescripcion());
			if (t.getPaisOrigen() != null) {
				stmt.setLong(3, t.getPaisOrigen().getId());
			} else {
				stmt.setNull(3, Types.NUMERIC);
			}

			if (t.getTipoProducto() != null) {
				stmt.setLong(4, t.getTipoProducto().getId());
			} else {
				stmt.setNull(4, Types.NUMERIC);
			}

			if (t.getUnidadMedida() != null) {
				stmt.setLong(5, t.getUnidadMedida().getId());
			} else {
				stmt.setNull(5, Types.NUMERIC);
			}

			if (t.getEstado() != null) {
				stmt.setLong(6, t.getEstado().getId());
			} else {
				stmt.setNull(6, Types.NUMERIC);
			}

			stmt.setBoolean(7, t.isEsLote());

			if (t.getMoneda() != null) {
				stmt.setLong(8, t.getMoneda().getId());
			} else {
				stmt.setNull(8, Types.NUMERIC);
			}

			stmt.setString(9, t.getDenominacion());

			if (t.getSerie() != null) {
				stmt.setLong(10, t.getSerie().getId());
			} else {
				stmt.setNull(10, Types.NUMERIC);
			}

			if (t.getImagen() == null) {
				stmt.setNull(11, Types.VARCHAR);
			} else {
				stmt.setString(11, t.getImagen());
			}

			stmt.setInt(12, t.getAnhoEmision());

			stmt.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar guardar el PRODUCTO", e);
		}
	}

	@Override
	public void modificar(Producto t) {
		try (PreparedStatement stmt = conexion.prepareStatement(
				"UPDATE productos SET codigo = ?, descripcion = ?, id_pais_origen = ?, id_tipo_producto = ?, "
						+ "id_unidad_medida = ?, id_estado = ?, es_lote = ?, id_moneda = ?, denominacion = ?, id_serie = ?, "
						+ "imagen = ?, anho_emision = ? " + "WHERE id = ?")) {

			setValoresProducto(t, stmt);
			stmt.setLong(13, t.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar modificar el PRODUCTO", e);
		}
	}

	private void setValoresProducto(Producto t, PreparedStatement stmt) throws SQLException {
		stmt.setString(1, t.getCodigo());
		stmt.setString(2, t.getDescripcion());
		if (t.getPaisOrigen() != null) {
			stmt.setLong(3, t.getPaisOrigen().getId());
		} else {
			stmt.setNull(3, Types.NUMERIC);
		}

		if (t.getTipoProducto() != null) {
			stmt.setLong(4, t.getTipoProducto().getId());
		} else {
			stmt.setNull(4, Types.NUMERIC);
		}

		if (t.getUnidadMedida() != null) {
			stmt.setLong(5, t.getUnidadMedida().getId());
		} else {
			stmt.setNull(5, Types.NUMERIC);
		}

		if (t.getEstado() != null) {
			stmt.setLong(6, t.getEstado().getId());
		} else {
			stmt.setNull(6, Types.NUMERIC);
		}

		stmt.setBoolean(7, t.isEsLote());

		if (t.getMoneda() != null) {
			stmt.setLong(8, t.getMoneda().getId());
		} else {
			stmt.setNull(8, Types.NUMERIC);
		}

		stmt.setString(9, t.getDenominacion());

		if (t.getSerie() != null) {
			stmt.setLong(10, t.getSerie().getId());
		} else {
			stmt.setNull(10, Types.NUMERIC);
		}

		if (t.getImagen() == null) {
			stmt.setNull(11, Types.VARCHAR);
		} else {
			stmt.setString(11, t.getImagen());
		}

		stmt.setInt(12, t.getAnhoEmision());

		stmt.executeUpdate();

		stmt.setInt(12, t.getAnhoEmision());
	}

	@Override
	public void eliminar(Long id) {
		try (PreparedStatement stmt = conexion.prepareStatement("DELETE FROM productos WHERE id = ?")) {

			stmt.setLong(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar eliminar el PRODUCTO", e);
		}
	}

	@Override
	public List<Producto> getProductosPorTipo(Long idTipo) {
		List<Producto> productos = new ArrayList<>();
		try (PreparedStatement stmt = conexion.prepareStatement(QUERY_PRODUCTOS + " WHERE id_tipo_producto = ?")) {

			stmt.setLong(1, idTipo);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				productos.add(getProducto(rs));
			}
			rs.close();

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener todos los PRODUCTOS con ID TIPO = " + idTipo,
					e);
		}
		return productos;
	}

	@Override
	public List<Producto> getProductosPorPais(Long idPais) {
		List<Producto> productos = new ArrayList<>();
		try (PreparedStatement stmt = conexion.prepareStatement(QUERY_PRODUCTOS + " WHERE id_pais_origen = ?")) {

			stmt.setLong(1, idPais);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				productos.add(getProducto(rs));
			}
			rs.close();

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener todos los PRODUCTOS con ID PAIS = " + idPais,
					e);
		}
		return productos;
	}

	@Override
	public List<Producto> getProductosConExistencia() {
		List<Producto> productos = new ArrayList<>();
		try (Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY_PRODUCTOS + " INNER JOIN  stock_productos sp "
						+ " ON sp.id_producto = p.id " + " WHERE existencia_actual > 0")) {

			while (rs.next()) {
				productos.add(getProducto(rs));
			}
			rs.close();

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener todos los PRODUCTOS con EXISTENCIA", e);
		}
		return productos;
	}

	private Producto getProducto(ResultSet rs) throws SQLException {
		Producto p = new Producto();
		p.setId(rs.getLong("id"));
		p.setCodigo(rs.getString("codigo").toUpperCase());
		p.setDescripcion(rs.getString("descripcion").toUpperCase());
		// seteamos el pais de origen
		Opcion opcion = new Opcion();
		opcion.setId(rs.getLong("id_pais_origen"));
		opcion.setCodigo(rs.getString("cod_pais_origen"));
		opcion.setDescripcion(rs.getString("desc_pais_origen"));
		p.setPaisOrigen(opcion);

		// seteamos tipo de producto
		opcion = new Opcion();
		opcion.setId(rs.getLong("id_tipo_producto"));
		opcion.setCodigo(rs.getString("cod_tipo_producto"));
		opcion.setDescripcion(rs.getString("desc_tipo_producto"));
		p.setTipoProducto(opcion);

		// seteamos unidad de medida
		opcion = new Opcion();
		opcion.setId(rs.getLong("id_unidad_medida"));
		opcion.setCodigo(rs.getString("cod_unidad_medida"));
		opcion.setDescripcion(rs.getString("desc_unidad_medida"));
		p.setUnidadMedida(opcion);

		// seteamos estado
		opcion = new Opcion();
		opcion.setId(rs.getLong("id_estado"));
		opcion.setCodigo(rs.getString("cod_estado"));
		opcion.setDescripcion(rs.getString("desc_estado"));
		p.setEstado(opcion);

		// seteamos serie
		opcion = new Opcion();
		opcion.setId(rs.getLong("id_serie"));
		opcion.setCodigo(rs.getString("cod_serie"));
		opcion.setDescripcion(rs.getString("desc_serie"));
		p.setSerie(opcion);

		// seteamos moneda
		Moneda moneda = new Moneda();
		moneda.setId(rs.getLong("id_moneda"));
		moneda.setSimbolo(rs.getString("simbolo"));
		moneda.setUnidadMonetaria(rs.getString("unidad_monetaria"));
		p.setMoneda(moneda);

		p.setEsLote(rs.getBoolean("es_lote"));
		p.setDenominacion(rs.getString("denominacion").toUpperCase());
		p.setImagen(rs.getString("imagen"));
		p.setAnhoEmision(rs.getInt("anho_emision"));
		return p;
	}

	public static void main(String arg[]) {
		try {
			GenericDAO<Producto> repository = new ProductoDAOImpl();

			System.out.println("<---- TODOS ---->");
			repository.listarTodos().forEach((producto) -> {
				System.out.println(producto.toString());
			});

			System.out.println("\n<---- POR ID ---->");
			Producto p = repository.buscarID(17L);
			if(p != null) {
				System.out.println(p.toString());
			}

			System.out.println("\n<---- POR TIPO ---->");
			ProductoDAO productoDAO = (ProductoDAO) repository;
			productoDAO.getProductosPorTipo(23L).forEach((producto) -> {
				System.out.println(producto.toString());
			});

			System.out.println("\n<---- POR PAIS ---->");
			productoDAO.getProductosPorPais(862L).forEach((producto) -> {
				System.out.println(producto.toString());
			});

			System.out.println("\n<---- CON EXISTENCIA ---->");
			productoDAO.getProductosConExistencia().forEach((producto) -> {
				System.out.println(producto.toString());
			});

			// INSERTAR REGISTRO
//			p.setCodigo("555");
//			p.setDescripcion("BILLETE DE MIL GUARAN�ES");
//			p.setIdPaisOrigen(929L);
//			p.setIdTipoProducto(23L);
//			p.setIdUnidadMedida(11L);
//			p.setIdEstado(19L);
//			p.setEsLote(false);
//			p.setIdMoneda(442L);
//			p.setDenominacion("1000");
//			p.setIdSerie(990L);
//			p.setAnhoEmision(2000);
//			productoDAO.insertar(p);


			// ACTUALIZAR REGISTRO
//			p.setId(22L);
//			p.setCodigo("555");
//			p.setDescripcion("BILLETE DE 5 MIL GUARAN�ES");
//			p.setIdPaisOrigen(929L);
//			p.setIdTipoProducto(23L);
//			p.setIdUnidadMedida(11L);
//			p.setIdEstado(19L);
//			p.setEsLote(false);
//			p.setIdMoneda(442L);
//			p.setDenominacion("5000");
//			p.setIdSerie(990L);
//			p.setAnhoEmision(2000);
//			productoDAO.modificar(p);


			// ELIMINAR REGISTRO
			productoDAO.eliminar(22L);

			System.out.println("\n<---- TODOS ---->");
			repository.listarTodos().forEach((producto) -> {
				System.out.println(producto.toString());
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
