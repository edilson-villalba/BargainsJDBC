package py.edu.ucsa.bargains.daos.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import py.edu.ucsa.bargains.daos.AbstractDAO;
import py.edu.ucsa.bargains.daos.AuthDAO;
import py.edu.ucsa.bargains.dtos.Opcion;
import py.edu.ucsa.bargains.dtos.Usuario;

public class AuthDAOJdbcImpl extends AbstractDAO<Usuario> implements AuthDAO {


	public AuthDAOJdbcImpl() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<String> getLoginRequiredURLs() {
		List<String> recursos = new ArrayList<>();
		try (Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT r.* from recursos r where requiere_login = true")) {

			while(rs.next()) {
				recursos.add(rs.getString("descripcion"));
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener los recursos ", e);
		}
		return recursos;
	}

	@Override
	public Optional<Usuario> getUserDetails(String usuario) {
		Optional<Usuario> usu = null;
		try (Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT u.*, o.codigo cod_tipo_usuario, o.descripcion desc_tipo_usuario "
						+ "FROM usuarios u WHERE u.usuario = ? JOIN opciones o ON o.id = u.id_tipo_usuario")) {

			if(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getLong("id"));
				u.setNombreApellido(rs.getString("nombre_apellido"));
				Opcion o = new Opcion();
				o.setId(rs.getLong("id_tipo_usuario"));
				o.setCodigo(rs.getString("cod_tipo_usuario"));
				o.setDescripcion(rs.getString("desc_tipo_usuario"));
				u.setTipoUsuario(o);
				u.setUsuario(usuario);
				u.setClave(rs.getString("clave"));
				usu = Optional.of(u);
			}else {
				usu = Optional.empty();
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Hubo un error al intentar obtener los datos del usuario " + usuario, e);
			usu = Optional.empty();
		}
		return usu;
	}

	@Override
	public List<Usuario> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarID(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Usuario t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Usuario t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
