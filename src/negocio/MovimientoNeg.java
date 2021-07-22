package negocio;

import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Movimiento;

public interface MovimientoNeg {
	
	public ArrayList<Movimiento> listarMovimientos(int Id);
	
}
