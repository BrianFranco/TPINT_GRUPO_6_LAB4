package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.MovimientoDao;
import entidad.Movimiento;
import entidad.Movimientos;
import entidad.TipoCuenta;
import entidad.TipoMovimiento;
import entidad.Cuenta;

public class MovimientoDaoImpl implements MovimientoDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "bdbanco";
	private Conexion cn;

	public MovimientoDaoImpl() {
		
	}
	
	
	@Override
	public ArrayList<Movimiento> obtenerTodos() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cn = new Conexion();
		cn.Open();
		ArrayList<Movimiento> list = new ArrayList<Movimiento>();
		 try
		 {
			 ResultSet rs= cn.query("Select * From moviminetos");
			 while(rs.next())
			 {
				 Movimiento m = new Movimiento();
				 m.setIdMovimiento(rs.getInt("IdMovimientos"));
				 m.setFecha(String.valueOf(rs.getInt("IdCuenta")));
				 m.setConcepto(rs.getString("Descripcion"));				 
				 String idTipoMovimiento = (String.valueOf(rs.getInt("IdTipoMovimiento")));
				 TipoMovimiento tipo = new TipoMovimiento();
				 tipo.setIDTipoMovimiento(idTipoMovimiento);
				 m.setTipoMovimiento(tipo);
				 m.setImporte(rs.getDouble("Saldo"));
				 m.setFecha(rs.getString("FechaMovimiento"));
				 list.add(m);
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
	public ArrayList<Movimiento> obtenerMovimientosUsuario(int id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection cnx = null;
		
		
		cn = new Conexion();
		cn.Open();
		
		ArrayList<Movimiento> list = new ArrayList<Movimiento>();
		 try
		 {
			 cnx = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = cnx.prepareStatement("SELECT A.*,B.DESCRIPCION From movimientos A JOIN tipomovimiento B on A.IdTipoMovimiento = B.IdTipoMovimiento where idCuenta =  ?");
			 miSentencia.setInt(1, id);
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Movimiento m = new Movimiento();
				 m.setIdMovimiento(rs.getInt("IdMovimientos"));
				 
				 Cuenta cu = new Cuenta();
				 TipoCuenta tc = new TipoCuenta();
				 ResultSet rs2= cn.query("Select * From cuentas WHERE N_cuenta="+rs.getInt("IdCuenta"));
				 while(rs2.next())
				 {			 
					 cu.setN_Cuenta(String.valueOf(rs2.getInt("cuentas.N_cuenta")));
					 cu.setFecha(rs2.getString("cuentas.F_Creacion"));
					 cu.setIdUsuario(String.valueOf(rs2.getInt("cuentas.IdUsuario")));
					 cu.setCBU(rs2.getString("cuentas.CBU"));				 
					 ResultSet rs3= cn.query("Select * From tipocuenta WHERE IdTipoCuenta =" + rs2.getInt("cuentas.IdTipoCuenta")  );
					 while(rs3.next()) {					 
						 tc.setIDTipoCuenta(rs3.getInt(1));
						 tc.setDescripcion(rs3.getString(2));					  
					 }		
					 cu.setTipoCuenta(tc);
					 cu.setSaldo(String.valueOf(rs2.getFloat("cuentas.Saldo")));
					 cu.setActivo(rs2.getInt("cuentas.Activo"));
					 m.setCuenta(cu);			
				 }		
				 m.setCuenta(cu);
				 m.setConcepto(rs.getString("Descripcion"));				 
				 String idTipoMovimiento = (String.valueOf(rs.getInt("IdTipoMovimiento")));
				 TipoMovimiento tipo = new TipoMovimiento();
				 tipo.setIDTipoMovimiento(idTipoMovimiento);
				 tipo.setDescripcion(rs.getString("DESCRIPCION"));
				 m.setTipoMovimiento(tipo);
				 m.setImporte(rs.getDouble("Saldo"));
				 m.setFecha(rs.getString("F_Movimiento"));
				 m.toString();
				 list.add(m);
			 }
			 cnx.close();
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
	public boolean insertar(Movimiento movimiento) {

		return false;
	}

	@Override
	public boolean editar(Movimiento movimiento) {

		return false;
	}

	@Override
	public boolean borrar(int id) {

		return false;
	}

	@Override
	public ArrayList<Movimiento> obtenerReporteMovimiento() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection cn = null;
		ArrayList<Movimiento> list = new ArrayList<Movimiento>();
		 try
		 {
			 cn = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = cn.prepareStatement("Select F_Movimiento,YEAR(F_Movimiento),MONTH(F_Movimiento),Descripcion,SUM(ABS(Saldo)) Saldo From movimientos GROUP BY YEAR(F_Movimiento),MONTH(F_Movimiento),Descripcion ORDER BY F_Movimiento DESC");
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Movimiento m = new Movimiento();
				 m.setFecha(String.valueOf(rs.getString("F_Movimiento")));
				 m.setConcepto(rs.getString("Descripcion"));
				 m.setImporte(rs.getDouble("Saldo"));
				 list.add(m);
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

	@Override
	public ArrayList<Movimiento> obtenerReporteMovimiento(String desde, String hasta) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection cn = null;
		ArrayList<Movimiento> list = new ArrayList<Movimiento>();
		 try
		 {
			 cn = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = cn.prepareStatement("Select F_Movimiento,YEAR(F_Movimiento),MONTH(F_Movimiento),Descripcion,SUM(ABS(Saldo)) Saldo From movimientos GROUP BY YEAR(F_Movimiento),MONTH(F_Movimiento),Descripcion HAVING F_Movimiento BETWEEN ? AND ? ORDER BY F_Movimiento DESC");
			 miSentencia.setString(1, desde + "-00");
			 miSentencia.setString(2, hasta + "-00");
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Movimiento m = new Movimiento();
				 m.setFecha(String.valueOf(rs.getString("F_Movimiento")));
				 m.setConcepto(rs.getString("Descripcion"));
				 m.setImporte(rs.getDouble("Saldo"));
				 list.add(m);
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
	
		public boolean generarMovimiento(Movimientos mov) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO movimientos (IdCuenta,Descripcion,IdTipoMovimiento,Saldo,F_Movimiento) VALUES ('"+mov.getIdCuenta()+"','"+mov.getDescripcion()+"','"+mov.getIdTipoMovimiento()+"','"+mov.getSaldo()+"','"+mov.getFecha()+"')";
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
	
	
	/*public ArrayList<Movimiento> listarMovimientos(int id) {
	cn = new Conexion();
	cn.Open();
	 ArrayList<Movimiento> list = new ArrayList<Movimiento>();
	 try
	 {
		 ResultSet rs= cn.query("Select * From movimientos Where IdCuenta = "+id);
		 while(rs.next())
		 {
			 Movimiento mov = new Movimiento();
			 
			 Cuenta c = new Cuenta();
			 c.setN_Cuenta(String.valueOf(rs.getInt("movimientos.IdCuenta")));
			 
			 mov.setCuenta(c);
			 mov.setConcepto((rs.getString("movimientos.Descripcion")));
			 
			 TipoMovimiento tMov= new TipoMovimiento();
			 tMov.setIDTipoMovimiento(rs.getInt("movimientos.IdTipoMovimiento"));
			 mov.setTipoMovimiento(new TipoMovimiento(rs.getInt("movimientos.IdTipoMovimiento")));
			 mov.setSaldo(rs.getFloat("movimientos.Saldo"));
			 mov.setFechaMov(rs.getString("movimientos.F_Movimiento"));
			 list.add(mov);
			 //System.out.println(cu.toStringListaTr());
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
}*/

}
