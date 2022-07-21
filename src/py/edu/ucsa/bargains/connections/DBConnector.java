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
	 * M�todo que devuelve una conexi�n a la base de datos estipulada en la 
	 * variable currentDB
	 * @return Una conexi�n a la base de datos seteada por defecto en currentDB
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
	 * M�todo que recibe el nombre del archivo .properties y setea la variable
	 * que contiene la base de datos a la cual me quiero conectar desde la aplicaci�n
	 * @param database
	 */
	public static void setCurrentDB(String database) {
		currentDB = database;
	}

}
