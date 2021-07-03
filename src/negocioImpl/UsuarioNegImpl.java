package negocioImpl;
import negocio.UsuarioNeg;
import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;

public class UsuarioNegImpl implements UsuarioNeg{

	private UsuarioDao usuDao = new UsuarioDaoImpl();
	
	public UsuarioNegImpl(UsuarioDao usuDao) {
		this.usuDao=usuDao;
	}
	public UsuarioNegImpl() {}
	
	@Override
	public boolean validarUsuario(Usuario usuario) {
		Usuario usu = new Usuario();
		usu=usuDao.buscarUsuario(usuario);
		if(usu != null) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		
		return usuDao.buscarUsuario(usuario);
	}
	
	
	
}
