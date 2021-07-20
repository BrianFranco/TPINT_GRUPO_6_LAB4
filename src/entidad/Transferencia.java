package entidad;

public class Transferencia {
	private int IdCuentaOrigen;
	private int IdCuentaDestino;
	private float Monto;
	//private String Descripcion;
	
	public Transferencia() {
		IdCuentaOrigen = 1;
		IdCuentaDestino = 1;
		Monto = 0;
		//Descripcion = "";
	}
	
	public Transferencia(int idCuentaOrigen, int idCuentaDestino, float monto/*, String descripcion*/) {
		this.IdCuentaOrigen = idCuentaOrigen;
		this.IdCuentaDestino = idCuentaDestino;
		this.Monto = monto;
		//this.Descripcion = descripcion;
	}

	public int getIdCuentaOrigen() {
		return IdCuentaOrigen;
	}

	public void setIdCuentaOrigen(int idCuentaOrigen) {
		IdCuentaOrigen = idCuentaOrigen;
	}

	public int getIdCuentaDestino() {
		return IdCuentaDestino;
	}

	public void setIdCuentaDestino(int idCuentaDestino) {
		IdCuentaDestino = idCuentaDestino;
	}

	public float getMonto() {
		return Monto;
	}

	public void setMonto(float monto) {
		Monto = monto;
	}
	
	/*public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}*/

	@Override
	public String toString() {
		return "Transferencia [IdCuentaOrigen=" + IdCuentaOrigen + ", IdCuentaDestino=" + IdCuentaDestino + ", Monto="
				+ Monto + /*", Descripcion=" + Descripcion +*/ "]";
	}
	
}
