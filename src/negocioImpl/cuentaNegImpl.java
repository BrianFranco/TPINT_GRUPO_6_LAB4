package negocioImpl;

import java.util.ArrayList;

import datos.cuentaDao;
import datosImpl.cuentaDaoImpl;
import entidad.Cuenta;
import negocio.cuentaNeg;

public class cuentaNegImpl implements cuentaNeg{

	private cuentaDao artDao = new cuentaDaoImpl();
	
	//Se puede recibir por constructor
	public cuentaNegImpl(cuentaDao artDao)
	{
		this.artDao = artDao;
	}
	
	public cuentaNegImpl()
	{
	}
	
	@Override
	public ArrayList<Cuenta> listarCuentasFiltros(String filtro) {

		return (ArrayList<Cuenta>) artDao.obtenerCuentasFiltro(filtro);
	}

	@Override
	public ArrayList<Cuenta> listarArticulos() {
		return (ArrayList<Cuenta>) artDao.obtenerTodos();
	}

	@Override
	public Cuenta obtenerUno(int id) {
		return artDao.obtenerUno(id);
	}

	@Override
	public boolean insertar(Cuenta cuenta) {
		return artDao.insertar(cuenta);
	}

	@Override
	public boolean editar(Cuenta cuenta) {
		return artDao.editar(cuenta);
	}

	@Override
	public boolean borrar(int id) {
		
		return artDao.borrar(id);
	}

	
	
}