package py.edu.ucsa.bargains.daos;

import java.util.logging.Logger;

import py.edu.ucsa.bargains.connections.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO<T> implements GenericDAO<T>{
	
	// Para la conexión
	protected Connection conexion;
	
	// Para el despliegue de errores 
    public static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	
	public AbstractDAO() throws SQLException {
		this.conexion = DBConnector.getConexion();
	}
}
