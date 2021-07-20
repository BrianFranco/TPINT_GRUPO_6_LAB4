package negocio;
import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Usuario;

public interface UsuarioNeg {
	
	public ArrayList<Cuenta> listarCuentas(int Id);
	
	public boolean validarUsuario(Usuario usuario) ;
	
	public Usuario buscarUsuario(Usuario usuario);

}
