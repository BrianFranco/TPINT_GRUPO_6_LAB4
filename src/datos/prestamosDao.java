package datos;

import java.util.ArrayList;


import entidad.Prestamo;
import entidad.PrestamoP;


public interface prestamosDao {

	public boolean insertar(Prestamo prestamo);

	public ArrayList<Prestamo> listarPrestamos(int id);
	
	public boolean insertarP(PrestamoP prestamoP);
	
	public ArrayList<Prestamo> listaPrestamos(String filtro);
	public boolean autorizarPrestamo(String idPrestamo,String fecha,int estado);
	
}
