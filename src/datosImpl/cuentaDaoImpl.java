package datosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import datos.cuentaDao;
import entidad.Cuenta;

public class cuentaDaoImpl implements cuentaDao{
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdbanco";
	
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
			CallableStatement proc = cn.prepareCall("CALL SP_AgregarCuenta(?,?,?,?,?)");
			proc.setString(1, cuenta.getFecha());
			proc.setString(2, cuenta.getCBU());
			proc.setInt(3, Integer.parseInt(cuenta.getTipoCuenta()));
			proc.setFloat(4, Float.parseFloat(cuenta.getSaldo()));
			proc.setBoolean(5, cuenta.isActivo());
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT cuentas.N_Cuenta, cuentas.F_Creacion, cuentas.CBU, cuentas.Saldo\r\n" + 
					"FROM cuentas\r\n" + 
					"INNER JOIN cuentasxclientes\r\n" + 
					"ON cuentas.N_Cuenta = cuentasxclientes.N_Cuenta");
			while(rs.next()) {
				
			}
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		return lista;
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
		// TODO Auto-generated method stub
		return false;
	}

	
}
