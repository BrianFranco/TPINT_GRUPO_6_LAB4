package negocio;
import entidad.Usuario;

public interface UsuarioNeg {
	
	public boolean validarUsuario(Usuario usuario) ;
	
	public Usuario buscarUsuario(Usuario usuario);

}
