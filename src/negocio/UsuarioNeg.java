package negocio;

import entidad.Usuario;
import java.util.ArrayList;
import entidad.Cuenta;


public interface UsuarioNeg {
	
	public ArrayList<Cuenta> listarCuentas(int Id);	
	public boolean validarUsuario(Usuario usuario) ;	
	public Usuario buscarUsuario(Usuario usuario);

}
