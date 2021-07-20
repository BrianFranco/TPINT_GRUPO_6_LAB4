package datosImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import datos.prestamosDao;
import entidad.Cuenta;
import entidad.Prestamo;
import entidad.Transferencia;

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
	
}
