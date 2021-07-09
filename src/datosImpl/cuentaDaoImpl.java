package datosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import datos.cuentaDao;
import entidad.Cuenta;

public class cuentaDaoImpl implements cuentaDao{
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdbanco";
	
	private Conexion cn;
	
	public cuentaDaoImpl()
	{
		
	}
	
	@Override
	public boolean insertar(Cuenta cuenta) {
	
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
			CallableStatement proc = cn.prepareCall("CALL SP_AgregarCuenta(?,?,?,?,?,?)");
			proc.setString(1, cuenta.getFecha());
			proc.setInt(2,Integer.parseInt(cuenta.getIdUsuario()));
			proc.setString(3, cuenta.getCBU());
			proc.setInt(4, Integer.parseInt(cuenta.getTipoCuenta()));
			proc.setFloat(5, Float.parseFloat(cuenta.getSaldo()));
			proc.setInt(6, cuenta.getActivo());
            proc.execute();  
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Cuenta> obtenerTodos() {
		
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 ResultSet rs= cn.query("Select * From cuentas");
			 while(rs.next())
			 {
				 Cuenta cu = new Cuenta();
				 
				 cu.setN_Cuenta(String.valueOf(rs.getInt("cuentas.N_cuenta")));
				 cu.setFecha(rs.getString("cuentas.F_Creacion"));
				 cu.setIdUsuario(String.valueOf(rs.getInt("cuentas.IdUsuario")));
				 cu.setCBU(rs.getString("cuentas.CBU"));
				 cu.setTipoCuenta(String.valueOf(rs.getInt("cuentas.IdTipoCuenta")));
				 cu.setSaldo(String.valueOf(rs.getFloat("cuentas.Saldo")));
				 cu.setActivo(rs.getInt("cuentas.Activo"));
				 list.add(cu);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}

	@Override
	public Cuenta obtenerUno(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(int id) {
			boolean estado=true;
			cn = new Conexion();
			cn.Open();		 
			String query = "UPDATE cuentas SET Activo=0 WHERE N_Cuenta="+id;
			try
			 {
				estado=cn.execute(query);
			 }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				cn.close();
			}
			return estado;
		}
	

	
}
