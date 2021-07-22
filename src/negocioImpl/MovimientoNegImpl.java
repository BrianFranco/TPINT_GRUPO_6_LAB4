package negocioImpl;

import java.util.ArrayList;

import datos.MovimientoDao;
import datosImpl.MovimientoDaoImpl;
import entidad.Cuenta;
import entidad.Movimiento;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg{
	
	MovimientoDao movDao = new MovimientoDaoImpl();
	
	public ArrayList<Movimiento> listarMovimientos(int Id){
		return (ArrayList<Movimiento>) movDao.obtenerMovimientosUsuario(Id);
	}
}
