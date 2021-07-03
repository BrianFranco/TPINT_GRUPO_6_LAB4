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
					"Select * From Usuario"
					+ " where NombreUsuario='"+usuario.getNomUsuario()+
					"' AND Password= '"+ usuario.getContraseña() +"'");
			
			rs.next();
			usu = new Usuario();
			usu.setApellido(rs.getString("usuario.apellido"));
			usu.setNombre(rs.getString("usuario.nombre"));
			usu.setNomUsuario(rs.getString("usuario.nombreusuario"));
			usu.setRolUsu(rs.getInt("usuario.idrol"));
			usu.setContraseña(rs.getString("usuario.Password"));
			usu.setDni(rs.getInt("usuario.Dni"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			cn.close();
		}
		return usu;
	}
}
