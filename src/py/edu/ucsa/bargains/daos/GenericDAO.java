package py.edu.ucsa.bargains.daos;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
	List<T> listarTodos() throws SQLException;
	T buscarID(Long id) throws SQLException;
	void insertar(T t) throws SQLException;
	void modificar(T t) throws SQLException;
	void eliminar(Long id) throws SQLException;
}
