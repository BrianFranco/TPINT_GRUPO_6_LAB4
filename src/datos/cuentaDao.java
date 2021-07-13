package datos;

import java.util.ArrayList;

import entidad.Cuenta;

public interface cuentaDao {
	
	public ArrayList<Cuenta> obtenerTodos();
	public ArrayList<Cuenta> obtenerCuentasFiltro (String filtro);
	public Cuenta obtenerUno(int id);
	public boolean insertar(Cuenta cuenta);
	public boolean editar(Cuenta cuenta);
	public boolean borrar(int id);
	
}
