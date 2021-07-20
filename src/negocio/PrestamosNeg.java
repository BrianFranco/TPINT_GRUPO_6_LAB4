package negocio;

import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Prestamo;
import entidad.Transferencia;

public interface PrestamosNeg {
	public boolean insertar(Prestamo Prestamo);

	public ArrayList<Prestamo> listarPrestamos(int Id);

}
