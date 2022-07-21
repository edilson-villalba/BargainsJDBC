package py.edu.ucsa.bargains.daos.hibernate.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import py.edu.ucsa.bargains.daos.AbstractGenericDAO;
import py.edu.ucsa.bargains.daos.OpcionDAO;
import py.edu.ucsa.bargains.dtos.Dominio;
import py.edu.ucsa.bargains.dtos.Opcion;

public class OpcionDAOJdbcImpl extends AbstractGenericDAO<Opcion> implements OpcionDAO {
	
	public OpcionDAOJdbcImpl() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

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
		List<Opcion> opciones = new ArrayList<>();
		try (PreparedStatement ps = crearPreparedStatement(codDominio);
				ResultSet rs = ps.executeQuery()) {
			while(rs.next()) {
				opciones.add(getOpcion(rs));
			}

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener las opciones del dominio " + codDominio, e);
		}
		return opciones;
	}

	private PreparedStatement crearPreparedStatement(String codDominio) throws SQLException {
		PreparedStatement ps = conexion.prepareStatement("SELECT o.id, o.codigo, o.id_opcion_padre, p.codigo cod_opcion_padre, p.descripcion desc_opcion_padre, "
				+ "o.descripcion, o.estado, o.id_dominio, d.codigo cod_dominio, d.descripcion desc_dominio "
				+ "FROM opciones o "
				+ "INNER JOIN dominios d "
				+ "ON o.id_dominio = d.id "
				+ "LEFT OUTER JOIN opciones p ON o.id_opcion_padre = p.id WHERE d.codigo = ?");
		ps.setString(1, codDominio);
		return ps;
		
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
	
	private Opcion getOpcion(ResultSet rs) throws SQLException {
		Opcion opcion = new Opcion();
		opcion.setId(rs.getLong("id"));
		opcion.setCodigo(rs.getString("codigo"));
		opcion.setDescripcion(rs.getString("descripcion"));
		opcion.setEstado(rs.getString("estado"));

		if (rs.getLong("id_opcion_padre") > 0) {
			Opcion padre = new Opcion();
			padre.setId(rs.getLong("id_opcion_padre"));
			padre.setCodigo(rs.getString("cod_opcion_padre"));
			padre.setDescripcion(rs.getString("desc_opcion_padre"));
			opcion.setOpcionPadre(padre);
		}

		Dominio d = new Dominio();
		d.setId(rs.getLong("id_dominio"));
		d.setCodigo(rs.getString("cod_dominio"));
		d.setDescripcion(rs.getString("desc_dominio"));
		opcion.setDominio(d);

		return opcion;
	}

}
