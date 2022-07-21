package py.edu.ucsa.bargains.daos.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import py.edu.ucsa.bargains.daos.AbstractGenericDAO;
import py.edu.ucsa.bargains.daos.GenericDAO;
import py.edu.ucsa.bargains.daos.SubastaDAO;
import py.edu.ucsa.bargains.dtos.Opcion;
import py.edu.ucsa.bargains.dtos.Producto;
import py.edu.ucsa.bargains.dtos.Subasta;
import py.edu.ucsa.bargains.dtos.SubastaDetalle;

public class SubastaDAOJdbcImpl extends AbstractGenericDAO<Subasta> implements SubastaDAO {
	
	private static final String QUERY_BASE = "SELECT s.id, s.titulo_subasta, "
			+ "s.nro_subasta, s.observaciones, s.id_estado, "
			+ "s.fecha_hora_cierre, s.fecha_creacion, s.total_base,"
			+ "s.total_final, "
			+ "e.codigo cod_estado, "
			+ "e.descripcion desc_estado "
			+ "FROM subastas_cabecera s ";


	public SubastaDAOJdbcImpl() throws SQLException {
		super();
	}

	@Override
	public List<Subasta> listarTodos() {
		List<Subasta> subastas = new ArrayList<>();
		try (Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery(
						QUERY_BASE
						+ "INNER JOIN opciones e "
						+ "ON s.id_estado = e.id")) {
			LOGGER.log(Level.INFO, "estamos ejecutando el query " + stmt);
			while(rs.next()) {
				subastas.add(getSubasta(rs));
			}

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener todas las SUBASTAS", e);
		}
		return subastas;
	}

	@Override
	public Subasta buscarID(Long id) {
		Subasta subasta = new Subasta();
		try (PreparedStatement stmt = conexion.prepareStatement(QUERY_BASE
				+ "INNER JOIN opciones e ON s.id_estado = e.id "
				+ "WHERE s.id = ?")) {

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				subasta = getSubasta(rs);
			}
			rs.close();

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener la SUBASTA con ID = " + id, e);
		}
		return subasta;
	}

	@Override
	public void insertar(Subasta t) throws SQLException {
		LocalDateTime fechaCreacion = LocalDateTime.now();

		try (PreparedStatement stmt = conexion.
				prepareStatement("INSERT INTO subasta(fecha_hora_cierre, fecha_creacion, total_base, total_final, "
						+ "id_estado, observaciones, nro_subasta, titulo_subasta) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

			conexion.setAutoCommit(false);

			stmt.setTimestamp(1, Timestamp.from(t.getFechaHoraCierre().atZone(ZoneId.systemDefault()).toInstant()) );
			stmt.setTimestamp(2, Timestamp.from(fechaCreacion.atZone(ZoneId.systemDefault()).toInstant()));
			stmt.setDouble(3, t.getTotalBase());
			stmt.setDouble(4, t.getTotalFinal());
			stmt.setLong(5, t.getEstado().getId());
			stmt.setString(6, t.getObservaciones());
			stmt.setInt(7, t.getNroSubasta());
			stmt.setString(8, t.getTituloSubasta());

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				Long id = rs.getLong(1);
				for(SubastaDetalle det : t.getDetalles()) {
					try (PreparedStatement stmt2 = conexion.prepareStatement(
							"INSERT INTO subasta(id_estado_venta, id_estado_pago, "
							+ "id_estado_entrega, id_cabecera, id_producto, "
							+ "id_cliente_ganador, monto_base, puja_minima, "
							+ "fecha_hora_cierre, id_moneda_subasta, "
							+ "fecha_pago, fecha_entrega, id_forma_entrega) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

							stmt2.setLong(1, id);
							stmt2.setLong(5, det.getProducto().getId());

					}
				}
			}

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar guardar el PRODUCTO", e);
			conexion.rollback();
		} finally {
			conexion.setAutoCommit(true);
		}
	}

	@Override
	public void modificar(Subasta t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void marcarDetalleComoPagado() {
		// TODO Auto-generated method stub

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

	private Subasta getSubasta(ResultSet rs) throws SQLException {
		Subasta subasta = new Subasta();
		subasta.setId(rs.getLong("id"));
		subasta.setFechaHoraCierre(rs.getTimestamp("fecha_hora_cierre").toLocalDateTime());
		subasta.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
		subasta.setTotalBase(rs.getLong("total_base"));
		subasta.setTotalFinal(rs.getLong("total_final"));

		Opcion o = new Opcion();
		o.setId(rs.getLong("id_estado"));
		o.setCodigo(rs.getString("cod_estado"));
		o.setDescripcion(rs.getString("desc_estado"));
		subasta.setEstado(o);

		subasta.setObservaciones(rs.getString("observaciones"));
		subasta.setNroSubasta(rs.getInt("nro_subasta"));
		subasta.setTituloSubasta(rs.getString("titulo_subasta"));

		return subasta;
	}


	public static void main(String arg[]) {
		try {
			GenericDAO<Subasta> repository = new SubastaDAOJdbcImpl();

			System.out.println("<---- TODOS ---->");
			repository.listarTodos().forEach((producto) -> {
				System.out.println(producto.toString());
			});

			System.out.println("\n<---- POR ID ---->");
			Subasta p = repository.buscarID(22L);
			if(p != null) {
				System.out.println(p.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
