package datosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import datos.cuentaDao;
import entidad.Cuenta;
import entidad.Prestamo;
import entidad.TipoCuenta;

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
			proc.setInt(4, cuenta.getTipoCuenta().getIDTipoCuenta());
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
			 ResultSet rs= cn.query("Select * From cuentas ");
			 while(rs.next())
			 {
				 Cuenta cu = new Cuenta();
				 
				 cu.setN_Cuenta(String.valueOf(rs.getInt("cuentas.N_cuenta")));
				 cu.setFecha(rs.getString("cuentas.F_Creacion"));
				 cu.setIdUsuario(String.valueOf(rs.getInt("cuentas.IdUsuario")));
				 cu.setCBU(rs.getString("cuentas.CBU"));
				 ResultSet rs2= cn.query("Select * From tipocuenta WHERE IdTipoCuenta =" + rs.getInt("cuentas.IdTipoCuenta")  );
				 TipoCuenta tc = new TipoCuenta();
				 while(rs2.next()) {					 
					 tc.setIDTipoCuenta(rs2.getInt(1));
					 tc.setDescripcion(rs2.getString(2));					  
				 }		
				 cu.setTipoCuenta(tc);
				 
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
	
	//@Override
	public ArrayList<Cuenta> obtenerCuentasUsuario(int id) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 con = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = con.prepareStatement("Select A.*,B.DESCRIPCION From cuentas A JOIN tipocuenta B on A.IdTipoCuenta = B.IdTipoCuenta where idUsuario = ?");
			 miSentencia.setInt(1, id);
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {								 				 										 
				 Cuenta cu = new Cuenta();
				 ResultSet rs2= cn.query("Select * From tipocuenta WHERE IdTipoCuenta =" + rs.getInt("cuentas.IdTipoCuenta"));
				 while(rs2.next()) {					 
					 cu.setN_Cuenta(String.valueOf(rs2.getInt("N_Cuenta")));										 
				 }
				 cu.setFecha(rs.getString("F_Creacion"));
				 cu.setIdUsuario(String.valueOf(rs.getInt("IdUsuario")));
				 cu.setCBU(rs.getString("CBU"));			
				 TipoCuenta tc = new TipoCuenta();
				 int idtipo = rs.getInt("IdTipoCuenta");
				 cu.getTipoCuenta().setIDTipoCuenta(idtipo);
				 cu.getTipoCuenta().setDescripcion(rs.getString("DESCRIPCION"));
				 cu.setSaldo(String.valueOf(rs.getFloat("Saldo")));
				 cu.setActivo(rs.getInt("Activo"));
				 list.add(cu);
			 }
			 con.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 
		 }
		 return list;
	}

	@Override
	public Cuenta obtenerUno(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cuenta> obtenerCuentasFiltro(String filtro) {
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 ResultSet rs= cn.query("Select * From cuentas "+filtro);
			 while(rs.next())
		    	 
			 {
				 Cuenta cu = new Cuenta();				 
				 cu.setN_Cuenta(String.valueOf(rs.getInt("cuentas.N_cuenta")));
				 cu.setFecha(rs.getString("cuentas.F_Creacion"));
				 cu.setIdUsuario(String.valueOf(rs.getInt("cuentas.IdUsuario")));
				 cu.setCBU(rs.getString("cuentas.CBU"));				 
				 ResultSet rs2= cn.query("Select * From tipocuenta WHERE IdTipoCuenta =" + rs.getInt("cuentas.IdTipoCuenta")  );
				 TipoCuenta tc = new TipoCuenta();
				 while(rs2.next()) {					 
					 tc.setIDTipoCuenta(rs2.getInt(1));
					 tc.setDescripcion(rs2.getString(2));					  
				 }		
				 cu.setTipoCuenta(tc);
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
	public boolean editar(Cuenta cuenta) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE cuentas SET N_Cuenta='"+cuenta.getN_Cuenta()+"', F_Creacion='"
		+cuenta.getFecha()+"', IdUsuario='"+cuenta.getIdUsuario()+"', CBU='"+cuenta.getCBU()
		+"', IdTipoCuenta='"+cuenta.getTipoCuenta().getIDTipoCuenta()+"', Saldo='"+cuenta.getSaldo()
		+"', Activo='"+cuenta.getActivo()+"' WHERE N_Cuenta='"+cuenta.getN_Cuenta()+"'";
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
	
	//@Override
	public ArrayList<Prestamo> obtenerTodosPrestamos(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		 try
		 {
			 cn = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = cn.prepareStatement("SELECT A.*,MAX(CASE WHEN MONTH(B.FechaMovimiento) = MONTH(NOW())  THEN true ELSE false END) 'AlDia' FROM prestamos A JOIN moviminetos B ON B.IdCuenta = A.IdCuenta WHERE A.IdCuenta = ? AND (B.IdTipoMovimiento = 3 OR B.IdTipoMovimiento = 2)");
			 miSentencia.setInt(1, Integer.parseInt(id));
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Prestamo pr = new Prestamo();
				 
				 pr.setIdCuenta(rs.getInt("IdCuenta"));
				 pr.setMontoSolicitado(rs.getFloat("MontoSolicitado"));
				 pr.setMontoFinal(rs.getFloat("MontoTotalPagar"));
				 pr.setMontoCuotas(rs.getFloat("Meses_Pre"));
				 pr.setRestCuotas(rs.getInt("Cuotas"));
				 pr.setFecha(rs.getString("FechaInicio"));
				 pr.setAlDia(rs.getBoolean("AlDia"));
				 
				 list.add(pr);
			 }
			 cn.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
		 }
		 return list;
	}

	public ArrayList<Prestamo> obtenerTodosPrestamos(int id,String desde, String hasta) {
		
		 return null;
	}


	public ArrayList<Cuenta> obtenerTodos(String desde, String hasta) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 cn = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = cn.prepareStatement("SELECT A.*,B.DESCRIPCION FROM cuentas A JOIN tipocuenta B ON A.IdTipoCuenta = B.IdTipoCuenta WHERE F_Creacion BETWEEN ? AND ?");
			 miSentencia.setString(1, desde);
			 miSentencia.setString(2, hasta);
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Cuenta cu = new Cuenta();
				 
				 cu.setN_Cuenta(String.valueOf(rs.getInt("N_cuenta")));
				 cu.setFecha(rs.getString("F_Creacion"));
				 cu.setIdUsuario(String.valueOf(rs.getInt("IdUsuario")));
				 cu.setCBU(rs.getString("CBU"));
				 TipoCuenta tc = new TipoCuenta();
				 int idtipo = rs.getInt("IdTipoCuenta");
				 tc.setIDTipoCuenta(idtipo);
				 tc.setDescripcion(rs.getString("DESCRIPCION"));
				 cu.setTipoCuenta(tc);
				 cu.setSaldo(String.valueOf(rs.getFloat("Saldo")));
				 cu.setActivo(rs.getInt("Activo"));
				 list.add(cu);
			 }
			 cn.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
		 }
		 return list;
	}

	//@Override
	public ArrayList<Cuenta> obtenerTodosConPrestamos() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 cn = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = cn.prepareStatement("SELECT A.*,B.DESCRIPCION FROM cuentas A JOIN tipocuenta B ON A.IdTipoCuenta = B.IdTipoCuenta JOIN prestamos C on C.IdCuenta = A.N_Cuenta");
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Cuenta cu = new Cuenta();
				 
				 cu.setN_Cuenta(String.valueOf(rs.getInt("N_cuenta")));
				 cu.setFecha(rs.getString("F_Creacion"));
				 cu.setIdUsuario(String.valueOf(rs.getInt("IdUsuario")));
				 cu.setCBU(rs.getString("CBU"));
				 TipoCuenta tc = new TipoCuenta();
				 int idtipo = rs.getInt("IdTipoCuenta");
				 tc.setIDTipoCuenta(idtipo);
				 tc.setDescripcion(rs.getString("DESCRIPCION"));
				 cu.setTipoCuenta(tc);
				 cu.setSaldo(String.valueOf(rs.getFloat("Saldo")));
				 cu.setActivo(rs.getInt("Activo"));
				 list.add(cu);
			 }
			 cn.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
		 }
		 return list;
	}

	//@Override
	public ArrayList<Cuenta> obtenerTodosConPrestamos(String desde, String hasta) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 cn = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = cn.prepareStatement("SELECT A.*,B.DESCRIPCION FROM cuentas A JOIN tipocuenta B ON A.IdTipoCuenta = B.IdTipoCuenta JOIN prestamos C on C.IdCuenta = A.N_Cuenta WHERE F_Creacion BETWEEN ? AND ?");
			 miSentencia.setString(1, desde);
			 miSentencia.setString(2, hasta);
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Cuenta cu = new Cuenta();
				 
				 cu.setN_Cuenta(String.valueOf(rs.getInt("N_cuenta")));
				 cu.setFecha(rs.getString("F_Creacion"));
				 cu.setIdUsuario(String.valueOf(rs.getInt("IdUsuario")));
				 cu.setCBU(rs.getString("CBU"));
				 TipoCuenta tc = new TipoCuenta();
				 int idtipo = rs.getInt("IdTipoCuenta");
				 tc.setIDTipoCuenta(idtipo);
				 tc.setDescripcion(rs.getString("DESCRIPCION"));
				 cu.setTipoCuenta(tc);
				 cu.setSaldo(String.valueOf(rs.getFloat("Saldo")));
				 cu.setActivo(rs.getInt("Activo"));
				 list.add(cu);
			 }
			 cn.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
		 }
		 return list;
	}

	//@Override
	public ArrayList<Prestamo> obtenerTodosPrestamos(String id, String desde, String hasta) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
