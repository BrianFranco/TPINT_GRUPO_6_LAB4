package datosImpl;

import entidad.Transferencia;
import java.time.LocalDate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import datos.transferenciaDao;

public class transferenciaDaoImpl implements transferenciaDao{
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "bdbanco";
	
	
	LocalDate today = LocalDate.now();

	
	public boolean insertar(Transferencia transferencia) {
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
		Connection cn4 = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement proc = cn.prepareCall("CALL SP_AgregarTransferencia(?,?,?)");
			proc.setInt(1,transferencia.getIdCuentaOrigen());
			proc.setInt(2,transferencia.getIdCuentaDestino());
			proc.setFloat(3, transferencia.getMonto());
			//proc.setString(4, transferencia.getDescripcion());
			proc.execute();
			//System.out.println(transferencia.toString());
			//System.out.println(proc.toString());
			
			cn4 = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement proc4 = cn4.prepareCall("CALL SP_ActualizarMontoCuenta(?,?)");
			proc4.setInt(1,transferencia.getIdCuentaDestino());
			proc4.setFloat(2, transferencia.getMonto());
			proc4.execute();
			
			cn1 = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement proc1 = cn1.prepareCall("CALL SP_ActualizarMontoCuenta(?,?)");
			proc1.setInt(1,transferencia.getIdCuentaOrigen());
			proc1.setFloat(2, -transferencia.getMonto());
			proc1.execute();
			
			
			
			
			
			cn2 = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement proc2 = cn2.prepareCall("CALL SP_AgregarMovimiento(?,?,?,?,?)");
			proc2.setInt(1,transferencia.getIdCuentaOrigen());
			proc2.setString(2, "Extraccion");
			proc2.setInt(3, 4);
			proc2.setFloat(4, -transferencia.getMonto());
			proc2.setString(5,today.toString());
			proc2.execute();
						
			cn3 = DriverManager.getConnection(host+dbName, user,pass);
			CallableStatement proc3 = cn3.prepareCall("CALL SP_AgregarMovimiento(?,?,?,?,?)");
			proc3.setInt(1,transferencia.getIdCuentaDestino());
			proc3.setString(2, "Deposito");
			proc3.setInt(3, 4);
			proc3.setFloat(4, transferencia.getMonto());
			proc3.setString(5,today.toString());
			proc3.execute();

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
}
