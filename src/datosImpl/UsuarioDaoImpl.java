package datosImpl;
import java.sql.ResultSet;

import datos.UsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	private Conexion cn;
	
	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		
		cn = new Conexion();
		cn.Open();
		Usuario usu = null;
		try {
			ResultSet rs = null;
			rs = cn.query(
					"Select * From Usuarios"
					+ " where NombreUsuario='"+usuario.getNomUsuario()+
					"' AND Password= '"+ usuario.getContraseña() +"'");
			
			rs.next();
			usu = new Usuario();
			usu.setApellido(rs.getString("usuarios.apellido"));
			usu.setNombre(rs.getString("usuarios.nombre"));
			usu.setNomUsuario(rs.getString("usuarios.nombreusuario"));
			usu.setRolUsu(rs.getInt("usuarios.idrol"));
			usu.setContraseña(rs.getString("usuarios.Password"));
			usu.setDni(rs.getInt("usuarios.Dni"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			cn.close();
		}
		return usu;
	}
}
