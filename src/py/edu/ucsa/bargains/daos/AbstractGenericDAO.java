package py.edu.ucsa.bargains.daos;

import java.sql.SQLException;

public abstract class AbstractGenericDAO<T> extends AbstractDAO<T> implements GenericDAO<T>{

	public AbstractGenericDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}


}
