package negocioImpl;

import java.util.ArrayList;

import datos.MovimientoDao;
import datosImpl.MovimientoDaoImpl;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.Movimientos;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg{
	
	MovimientoDao movDao = new MovimientoDaoImpl();
	
	public ArrayList<Movimiento> listarMovimientos(int Id){
		return (ArrayList<Movimiento>) movDao.obtenerMovimientosUsuario(Id);
	}
	
	
	public boolean generarMovimiento(Movimientos mov) {
		// TODO Auto-generated method stub
		return movDao.generarMovimiento(mov);
	}
}
