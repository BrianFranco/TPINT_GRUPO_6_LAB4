package datos;

import java.util.ArrayList;

import entidad.Movimiento;

public interface MovimientoDao {
	public ArrayList<Movimiento> obtenerTodos();
	public ArrayList<Movimiento> obtenerMovimientosUsuario(int id);
	public ArrayList<Movimiento> obtenerReporteMovimiento();
	public ArrayList<Movimiento> obtenerReporteMovimiento(String desde,String hasta);
	public boolean insertar(Movimiento movimiento);
	public boolean editar(Movimiento movimiento);
	public boolean borrar(int id);
	//public ArrayList<Movimiento> listarMovimientos(int id);
}
