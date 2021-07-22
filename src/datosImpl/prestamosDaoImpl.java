package datosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import datos.prestamosDao;
import entidad.Prestamo;
import entidad.PrestamoP;

public class prestamosDaoImpl implements prestamosDao{
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdbanco";
	private Conexion cn;
	
	public boolean insertar(Prestamo Prestamo) {
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
			CallableStatement proc = cn.prepareCall("CALL SP_AgregarPrestamo(?,?,?,?,?,?,?,?,?)");
			proc.setInt(1, Prestamo.getIdCuenta());
			proc.setInt(2, Prestamo.getIdUsuario());
			proc.setFloat(3, Prestamo.getMontoSolicitado());
			proc.setFloat(4, Prestamo.getMontoFinal());
			proc.setInt(5, Prestamo.getCantCuotas());
			proc.setInt(6, Prestamo.getRestCuotas());
			proc.setFloat(7, Prestamo.getMontoCuotas());
			proc.setString(8, Prestamo.getFecha());
			proc.setInt(9, Prestamo.getEstado());
			proc.execute();
			System.out.println(Prestamo.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public ArrayList<Prestamo> listarPrestamos(int id) {
		cn = new Conexion();
		cn.Open();
		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		try
		{
			ResultSet rs= cn.query("Select * From prestamos Where IdUsuario = "+id);
			while(rs.next())
			{
				Prestamo x = new Prestamo();
				 
				x.setIdCuenta(rs.getInt("prestamos.IdPrestamos"));
				x.setMontoSolicitado(rs.getFloat("prestamos.MontoSolicitado"));
				x.setMontoFinal(rs.getFloat("prestamos.MontoTotalPagar"));
				x.setCantCuotas(rs.getInt("prestamos.CuotasTotales"));
				x.setMontoCuotas(rs.getFloat("prestamos.ValorCuotas"));
				x.setFecha(rs.getString("prestamos.FechaInicio"));
				x.setEstado(rs.getInt("prestamos.Estado"));
				x.setIdUsuario(rs.getInt("prestamos.IdUsuario"));
				x.setRestCuotas(rs.getInt("prestamos.CuotasRestantes"));
				list.add(x);
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
		
	}

	public boolean insertarP(PrestamoP prestamoP) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		Connection cn = null;
		Connection cn1 = null;
		Connection cn2 = null;
		Connection cn3 = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			
			for(int i = 1; i <= prestamoP.getCantCuotas() ; i++) {
				CallableStatement proc = cn.prepareCall("CALL SP_AgregarMovimiento(?,?,?,?,?)");
				proc.setInt(1,prestamoP.getCuentaUsar());
				proc.setString(2,"Pago de prestamo Id:" + prestamoP.getIdCuenta());
				proc.setInt(3,3);
				proc.setFloat(4,-prestamoP.getMontoCuotas());
				proc.setString(5,prestamoP.getFecha());
				proc.execute();
				System.out.println(prestamoP.toString());
				
				cn1 = DriverManager.getConnection(host+dbName, user,pass);
				CallableStatement proc1 = cn1.prepareCall("CALL SP_ActualizarMontoCuenta(?,?)");
				proc1.setInt(1,prestamoP.getCuentaUsar());
				proc1.setFloat(2, -prestamoP.getMontoCuotas());
				proc1.execute();
			}
			
			cn2 = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement proc2 = cn2.prepareCall("CALL SP_ActualizarCantidadCuotas(?,?)");
			proc2.setInt(1,prestamoP.getIdCuenta());
			proc2.setFloat(2,prestamoP.getCantCuotas());
			proc2.execute();
			
			cn3 = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement proc3 = cn3.prepareCall("CALL SP_AgregarPrestamoPagado(?,?,?,?,?,?,?)");
			proc3.setInt(1,prestamoP.getIdUsuario());
			proc3.setInt(2,prestamoP.getCuentaUsar());
			proc3.setInt(3,prestamoP.getIdCuenta());
			proc3.setInt(4,prestamoP.getCantCuotas());
			proc3.setFloat(5,prestamoP.getMontoCuotas());
			proc3.setString(6,prestamoP.getFecha());
			proc3.setFloat(7,prestamoP.getMontoPago());
			proc3.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	
	@Override
	public boolean autorizarPrestamo(String idPrestamo,String fecha,int estado) {
		
		boolean r=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE prestamos SET Estado='"+estado+"', FechaInicio='"+fecha+"' WHERE IdPrestamos='"+idPrestamo+"'";
		try
		 {
			r=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return r;
	}
	@Override
	public ArrayList<Prestamo> listaPrestamos(String filtro) {
		cn = new Conexion();
		cn.Open();
		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		String condicion="";
		if(!filtro.equals("")) {
			condicion="Where IdUsuario="+filtro;
		}
		try
		 {
			 ResultSet rs= cn.query("Select * From prestamos "+condicion);
			 while(rs.next())
			 {
				 Prestamo p = new Prestamo();
				 
				 p.setIdPrestamo(rs.getInt("prestamos.IdPrestamos"));
				 p.setIdUsuario(rs.getInt("prestamos.IdUsuario"));
				 p.setIdCuenta(rs.getInt("prestamos.IdCuenta"));
				 p.setMontoSolicitado(rs.getFloat("prestamos.MontoSolicitado"));
				 p.setMontoFinal(rs.getFloat("prestamos.MontoTotalPagar"));
				 p.setCantCuotas(rs.getInt("prestamos.CuotasTotales"));
				 p.setRestCuotas(rs.getInt("prestamos.CuotasRestantes"));
				 p.setMontoCuotas(rs.getFloat("prestamos.ValorCuotas"));
				 p.setFecha(rs.getString("prestamos.FechaInicio"));
				 p.setEstado(rs.getInt("prestamos.Estado"));
				 list.add(p);
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

	
}
