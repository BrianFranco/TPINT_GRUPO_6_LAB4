package negocioImpl;

import datos.transferenciaDao;
import datosImpl.transferenciaDaoImpl;
import entidad.Transferencia;
import negocio.transferenciaNeg;

public class transferenciaNegImpl implements transferenciaNeg{

	private transferenciaDao transfDao = new transferenciaDaoImpl();
	
	

	public boolean insertar(Transferencia transferencia) {
		return transfDao.insertar(transferencia);
	}
	
}
