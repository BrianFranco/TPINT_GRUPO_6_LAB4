package negocioImpl;

import java.util.ArrayList;

import datos.prestamosDao;
import datos.transferenciaDao;
import datosImpl.prestamosDaoImpl;
import datosImpl.transferenciaDaoImpl;
import entidad.Cuenta;
import entidad.Prestamo;
import entidad.Transferencia;
import negocio.PrestamosNeg;

public class PrestamosNegImpl implements PrestamosNeg {
	
	private prestamosDao prestDao = new prestamosDaoImpl();
	
	public boolean insertar(Prestamo prestamo) {
		return prestDao.insertar(prestamo);
	}

	public ArrayList<Prestamo> listarPrestamos(int Id) {
		return (ArrayList<Prestamo>) prestDao.listarPrestamos(Id);
		
	}
	
}
