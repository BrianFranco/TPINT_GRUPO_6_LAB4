package datos;

import java.util.ArrayList;
import entidad.Usuario;

public interface UsuarioDao {

	public void eliminarUsuario(int id);
	public void agregarUsuario(Usuario usuario);
	public ArrayList<Usuario> obtenerUsuarios();
	public Usuario obtenerUnUsuario(int dni);
	public void modificarContraseña(int id,String new_pass);
	public Usuario buscarUsuario(Usuario usuario);
	
}
