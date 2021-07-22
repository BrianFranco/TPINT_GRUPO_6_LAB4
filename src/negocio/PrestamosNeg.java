package negocio;

import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Prestamo;
import entidad.PrestamoP;
import entidad.Transferencia;

public interface PrestamosNeg {
	public boolean insertar(Prestamo Prestamo);

	public ArrayList<Prestamo> listarPrestamos(int Id);
	
	public boolean insertarP(PrestamoP PrestamoP);
	
	public ArrayList<Prestamo> listaPrestamos(String filtro);
	public boolean autorizarPrestamo(String idPrestamo,String fecha,int estado); 
}
