package negocio;

import java.util.ArrayList;

import entidad.Movimiento;
import entidad.Movimientos;

public interface MovimientoNeg {
	
	public ArrayList<Movimiento> listarMovimientos(int Id);
	
	boolean generarMovimiento(Movimientos mov);
	
}
