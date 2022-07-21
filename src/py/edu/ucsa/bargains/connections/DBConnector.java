package py.edu.ucsa.bargains.connections;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public abstract class DBConnector {
	
	private static String currentDB = "postgres";
	
	private static PoolConexiones pool;
	
	public static Connection getConexion(String archivo) throws SQLException {
		if (pool == null) {
			ResourceBundle bundle = ResourceBundle.getBundle(archivo);		
			pool = new PoolConexiones(bundle.getString("jdbcURL"), 
					bundle.getString("user"), 
					bundle.getString("pwd"), 3, 5, true);
		}

		return pool.getConnection();
	}
	
	/**
	 * Método que devuelve una conexión a la base de datos estipulada en la 
	 * variable currentDB
	 * @return Una conexión a la base de datos seteada por defecto en currentDB
	 * @throws SQLException
	 */
	public static Connection getConexion() throws SQLException {
		return getConexion(currentDB);
	}

	public static Connection getConexionORCL() throws SQLException {
		return getConexion("oracle");
	}
	
	public static Connection getConexionPG() throws SQLException {
		return getConexion("postgres");
	}
	
	/**
	 * Método que recibe el nombre del archivo .properties y setea la variable
	 * que contiene la base de datos a la cual me quiero conectar desde la aplicación
	 * @param database
	 */
	public static void setCurrentDB(String database) {
		currentDB = database;
	}

}
