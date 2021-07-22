package negocio;
import java.util.ArrayList;
import entidad.Movimientos;
import entidad.Cuenta;

public interface cuentaNeg {
	
		public ArrayList<Cuenta> listarArticulos();
		public ArrayList<Cuenta> listarCuentasFiltros(String filtro);
		public Cuenta obtenerUno(int id);
		public boolean insertar(Cuenta cuenta);
		public boolean editar(Cuenta cuenta);
		public boolean borrar(int id);
		public boolean sumarSaldo(Movimientos mov);
		
	}