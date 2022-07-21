package py.edu.ucsa.bargains.daos;

import java.util.Optional;

import py.edu.ucsa.bargains.dtos.Usuario;

public interface AuthDAO {
	Iterable<String> getLoginRequiredURLs();
//	Optional<Usuario> autenticar(String usuario, String Clave);
	Optional<Usuario> getUserDetails(String usuario);
}
