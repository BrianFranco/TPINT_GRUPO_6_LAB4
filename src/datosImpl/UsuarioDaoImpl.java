package datosImpl;

import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import entidad.Usuario;
import datos.UsuarioDao;

public class UsuarioDaoImpl implements UsuarioDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdbanco";
	private Conexion cn;
	
		public void eliminarUsuario(int id)
		{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Connection cn = null;
			try
			{
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement proc = cn.prepareCall(" CALL SP_EliminarUsuario(?) ");
	            proc.setInt(1, id);
	            proc.execute();  
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}

		
		public void agregarUsuario(Usuario usuario)
		{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			Connection cn = null;
			try
			{
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement proc = cn.prepareCall(" CALL SP_AgregarUsuarios(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
	            proc.setInt(1, usuario.getDni());
	            proc.setString(2, usuario.getCuil());
	            proc.setString(3, usuario.getGenero());
	            proc.setString(4, usuario.getNacionalidad());
	            proc.setString(5, usuario.getFechaNac());
	            proc.setString(6, usuario.getDireccion());
	            proc.setString(7, usuario.getLocalidad());
	            proc.setString(8, usuario.getProvincia());
	            proc.setString(9, usuario.getTelefono());
	            proc.setString(10, usuario.getNomUsuario());
	            proc.setString(11, usuario.getNombre());
	            proc.setString(12, usuario.getApellido());
	            proc.setString(13, usuario.getEmail());
	            proc.setString(14, usuario.getContraseña());
	            proc.setInt(15, 1);
	            proc.execute();  
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public ArrayList<Usuario> obtenerUsuarios() {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			Connection conn = null;
			try{
				conn = DriverManager.getConnection(host + dbName, user, pass);
				Statement st = conn.createStatement();
				
				ResultSet rs = st.executeQuery("Select * FROM usuarios");
				
				while(rs.next()){
					
					Usuario usuarioRs = new Usuario();
					usuarioRs.setIdUsuario(rs.getInt(1));
					usuarioRs.setDni(rs.getInt(2));
					usuarioRs.setCuil(rs.getString(3));
					usuarioRs.setCuil(rs.getString(4));
					usuarioRs.setCuil(rs.getString(5));
					usuarioRs.setFechaNac(rs.getDate(6).toString());
					usuarioRs.setDireccion(rs.getString(7));
					usuarioRs.setLocalidad(rs.getString(8));
					usuarioRs.setProvincia(rs.getString(9));
					usuarioRs.setTelefono(rs.getString(10));
					usuarioRs.setNomUsuario(rs.getString(11));
					usuarioRs.setNombre(rs.getString(12));
					usuarioRs.setApellido(rs.getString(13));
					usuarioRs.setEmail(rs.getString(14));
					usuarioRs.setContraseña(rs.getString(15));
					usuarioRs.setActivo(rs.getInt(17));
					
					
					lista.add(usuarioRs);
				}
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
			
			}
			
			return lista;
		}

		
		
		public Usuario obtenerUnUsuario(int id)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Usuario usuario = new Usuario();
			Connection con = null;
			try{
				con = DriverManager.getConnection(host + dbName, user, pass);
				PreparedStatement miSentencia = con.prepareStatement("Select * from usuarios where IdUsuario = ?");
				miSentencia.setInt(1, id); //Cargo el ID recibido
				ResultSet resultado = miSentencia.executeQuery();
				resultado.next();
				
				usuario.setIdUsuario(resultado.getInt(1));
				usuario.setDni(resultado.getInt(2));
				usuario.setCuil(resultado.getString(3));
				usuario.setGenero(resultado.getString(4));
				usuario.setNacionalidad(resultado.getString(5));
			    usuario.setFechaNac(resultado.getDate(6).toString());
			    usuario.setDireccion(resultado.getString(7));
			    usuario.setLocalidad(resultado.getString(8));
			    usuario.setProvincia(resultado.getString(9));
			    usuario.setTelefono(resultado.getString(10));
			    usuario.setNomUsuario(resultado.getString(11));
			    usuario.setNombre(resultado.getString(12));
			    usuario.setApellido(resultado.getString(13));
			    usuario.setEmail(resultado.getString(14));
			    usuario.setContraseña(resultado.getString(15));
			    usuario.setActivo(resultado.getInt(17));
			    
			    con.close();
			}
			catch(Exception e)
			{
				System.out.println("Conexion fallida");
			}
			finally
			{
			}
			return usuario;
		}
		
		
		public void modificarContraseña(int dni, String new_pass)
		{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Connection cn = null;
			try
			{
				cn = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement proc = cn.prepareCall(" CALL SP_ModificarContraseña(?,?) ");
	            proc.setInt(1, dni);
	            proc.setString(2, new_pass);
	            proc.execute();  
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}


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
				
				if(rs.next()) {
					usu = new Usuario();
					usu.setApellido(rs.getString("usuarios.apellido"));
					usu.setNombre(rs.getString("usuarios.nombre"));
					usu.setNomUsuario(rs.getString("usuarios.nombreusuario"));
					usu.setRolUsu(rs.getInt("usuarios.idrol"));
					usu.setContraseña(rs.getString("usuarios.Password"));
					usu.setDni(rs.getInt("usuarios.Dni"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				cn.close();
			}
			return usu;
		}

		
}
