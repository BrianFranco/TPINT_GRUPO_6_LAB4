package entidad;

public class Movimiento {

	private int IdMovimiento;
	private String Fecha;
	private String Concepto;
	private double Importe;
	private TipoMovimiento TipoMovimiento;
	private Cuenta Cuenta;
	
	public Movimiento() {
		IdMovimiento = 0;
		Fecha="";
		Concepto = "";
		Importe = 0;
		TipoMovimiento= new TipoMovimiento();
	}
	
	

	public Cuenta getCuenta() {
		return Cuenta;
	}



	public void setCuenta(Cuenta cuenta) {
		Cuenta = cuenta;
	}



	public int getIdMovimiento() {
		return IdMovimiento;
	}



	public void setIdMovimiento(int idMovimiento) {
		IdMovimiento = idMovimiento;
	}



	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getConcepto() {
		return Concepto;
	}

	public void setConcepto(String concepto) {
		Concepto = concepto;
	}

	public double getImporte() {
		return Importe;
	}

	public void setImporte(double importe) {
		Importe = importe;
	}

	public TipoMovimiento getTipoMovimiento() {
		return TipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}
	
}
