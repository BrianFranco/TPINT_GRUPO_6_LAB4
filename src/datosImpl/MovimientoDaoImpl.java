package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.MovimientoDao;
import entidad.Movimiento;
import entidad.TipoMovimiento;

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
		Connection cn = null;
		ArrayList<Movimiento> list = new ArrayList<Movimiento>();
		 try
		 {
			 cn = DriverManager.getConnection(host + dbName, user, pass);
			 PreparedStatement miSentencia = cn.prepareStatement("SELECT A.*,B.DESCRIPCION From movimientos A JOIN tipomovimiento B on A.IdTipoMovimiento = B.IdTipoMovimiento where idCuenta =  ?");
			 miSentencia.setInt(1, id);
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Movimiento m = new Movimiento();
				 m.setIdMovimiento(rs.getInt("IdMovimientos"));
				 m.setFecha(String.valueOf(rs.getInt("IdCuenta")));
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
			 PreparedStatement miSentencia = cn.prepareStatement("Select FechaMovimiento,YEAR(FechaMovimiento),MONTH(FechaMovimiento),Descripcion,SUM(ABS(Saldo)) Saldo From moviminetos GROUP BY YEAR(FechaMovimiento),MONTH(FechaMovimiento),Descripcion ORDER BY FechaMovimiento DESC");
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Movimiento m = new Movimiento();
				 m.setFecha(String.valueOf(rs.getString("FechaMovimiento")));
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
			 PreparedStatement miSentencia = cn.prepareStatement("Select FechaMovimiento,YEAR(FechaMovimiento),MONTH(FechaMovimiento),Descripcion,SUM(ABS(Saldo)) Saldo From moviminetos GROUP BY YEAR(FechaMovimiento),MONTH(FechaMovimiento),Descripcion HAVING FechaMovimiento BETWEEN ? AND ? ORDER BY FechaMovimiento DESC");
			 miSentencia.setString(1, desde + "-00");
			 miSentencia.setString(2, hasta + "-00");
			 ResultSet rs = miSentencia.executeQuery();
			 while(rs.next())
			 {
				 Movimiento m = new Movimiento();
				 m.setFecha(String.valueOf(rs.getString("FechaMovimiento")));
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
			 
			 mov.setIdCuenta(rs.getInt("movimientos.IdCuenta"));
			 mov.setDescripcion(rs.getString("movimientos.Descripcion"));
			 mov.setIdTipoMovimiento(rs.getInt("movimientos.IdTipoMovimiento"));
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
