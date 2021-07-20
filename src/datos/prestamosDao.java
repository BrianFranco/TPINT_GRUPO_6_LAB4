package datos;

import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Prestamo;
import entidad.Transferencia;

public interface prestamosDao {

	public boolean insertar(Prestamo prestamo);

	public ArrayList<Prestamo> listarPrestamos(int id);
	
}
