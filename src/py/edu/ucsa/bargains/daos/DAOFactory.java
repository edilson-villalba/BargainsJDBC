package py.edu.ucsa.bargains.daos;

import static py.edu.ucsa.bargains.daos.DataAccessFramework.HIBERNATE;
import static py.edu.ucsa.bargains.daos.DataAccessFramework.JDBC;

import java.sql.SQLException;

import py.edu.ucsa.bargains.daos.hibernate.impl.OpcionDAOHibernateImpl;
import py.edu.ucsa.bargains.daos.hibernate.impl.OpcionDAOJdbcImpl;
import py.edu.ucsa.bargains.daos.hibernate.impl.ProductoDAOHibernateImpl;
import py.edu.ucsa.bargains.daos.hibernate.impl.SubastaDAOHibernateImpl;
import py.edu.ucsa.bargains.daos.jdbc.impl.ProductoDAOJdbcImpl;
import py.edu.ucsa.bargains.daos.jdbc.impl.SubastaDAOJdbcImpl;

public abstract class DAOFactory {
	private static DataAccessFramework CURRENT = JDBC;

	public static ProductoDAO getProductoDAO() throws SQLException {
		if (CURRENT == JDBC) {
			return new ProductoDAOJdbcImpl();
		} else if (CURRENT == HIBERNATE) {
			// RETORNAR LA IMPLM DE HIBERNATE
			return (ProductoDAO) new ProductoDAOHibernateImpl();
		} else {
			return new ProductoDAOJdbcImpl();
		}
	}

	public static SubastaDAO getSubastaDAO() throws SQLException {
		if (CURRENT == JDBC) {
			return new SubastaDAOJdbcImpl();
		} else if (CURRENT == HIBERNATE) {
			return (SubastaDAO) new SubastaDAOHibernateImpl();
		} else {
			return new SubastaDAOJdbcImpl();
		}
	}

	public static OpcionDAO getOpcionDAO() throws SQLException {
		if (CURRENT == JDBC) {
			return new OpcionDAOJdbcImpl();
		} else if (CURRENT == HIBERNATE) {
			return new OpcionDAOHibernateImpl();
		} else {
			return new OpcionDAOJdbcImpl();
		}
	}
}
