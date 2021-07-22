package entidad;

public class PrestamoP {
	
	private int idUsuario;
	private int cuentaUsar;
	private int idCuenta;//idPrestamo
	private float montoCuotas;
	private int cantCuotas;
	private String Fecha;
	private float montoPago;
	
	public PrestamoP() {
		super();
		this.idUsuario = 1;
		this.cuentaUsar = 1;
		this.idCuenta = 1;
		this.montoCuotas = 1;
		this.cantCuotas = 1;
		Fecha = "";
		this.montoPago = 1;
	}
	
	public PrestamoP(int idUsuario, int cuentaUsar, int idCuenta, float montoCuotas, int cantCuotas, String fecha,
			float montoPago) {
		super();
		this.idUsuario = idUsuario;
		this.cuentaUsar = cuentaUsar;
		this.idCuenta = idCuenta;
		this.montoCuotas = montoCuotas;
		this.cantCuotas = cantCuotas;
		Fecha = fecha;
		this.montoPago = montoPago;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getCuentaUsar() {
		return cuentaUsar;
	}

	public void setCuentaUsar(int cuentaUsar) {
		this.cuentaUsar = cuentaUsar;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public float getMontoCuotas() {
		return montoCuotas;
	}

	public void setMontoCuotas(float montoCuotas) {
		this.montoCuotas = montoCuotas;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public float getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(float montoPago) {
		this.montoPago = montoPago;
	}

	@Override
	public String toString() {
		return "PrestamoP [idUsuario=" + idUsuario + ", cuentaUsar=" + cuentaUsar + ", idCuenta=" + idCuenta
				+ ", montoCuotas=" + montoCuotas + ", cantCuotas=" + cantCuotas + ", Fecha=" + Fecha + ", montoPago="
				+ montoPago + "]";
	}
	
}
