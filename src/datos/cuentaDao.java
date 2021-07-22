package datos;

import java.util.ArrayList;
import entidad.Cuenta;
import entidad.Movimientos;
import entidad.Prestamo;

public interface cuentaDao {
	
	public ArrayList<Cuenta> obtenerTodos();
	public ArrayList<Cuenta> obtenerTodosConPrestamos();
	public ArrayList<Cuenta> obtenerTodosConPrestamos(String desde, String hasta);
	public ArrayList<Cuenta> obtenerCuentasUsuario(int id);
	public ArrayList<Prestamo> obtenerTodosPrestamos(String id);
	public ArrayList<Prestamo> obtenerTodosPrestamos(String id,String desde, String hasta);
	public ArrayList<Cuenta> obtenerCuentasFiltro (String filtro);
	public Cuenta obtenerUno(int id);
	public boolean insertar(Cuenta cuenta);
	public boolean editar(Cuenta cuenta);
	public boolean borrar(int id);
	public boolean sumarSaldo(Movimientos mov);
}
