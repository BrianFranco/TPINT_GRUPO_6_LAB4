package entidad;

public class Prestamo {
	private int idPrestamo;
	private int idCuenta;
	private int idUsuario;
	private float montoSolicitado;
	


	private float montoFinal;
	private int cantCuotas;
	private int restCuotas;
	private float montoCuotas;
	private String Fecha;
	private int Estado;
	private String alDia;
	
	public Prestamo() {
		this.idCuenta = 1;
		this.idUsuario = 1;
		this.montoSolicitado = 1;
		this.montoFinal = 1;
		this.cantCuotas = 1;
		this.restCuotas = 1;
		this.montoCuotas = 1;
		Fecha = "";
		Estado = 1;
	}

	public Prestamo(int idCuenta, int idUsuario, float montoSolicitado, float montoFinal, int cantCuotas,
			int restCuotas, float montoCuotas, String fecha, int estado) {
		super();
		this.idCuenta = idCuenta;
		this.idUsuario = idUsuario;
		this.montoSolicitado = montoSolicitado;
		this.montoFinal = montoFinal;
		this.cantCuotas = cantCuotas;
		this.restCuotas = restCuotas;
		this.montoCuotas = montoCuotas;
		Fecha = fecha;
		Estado = estado;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public float getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(float montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public float getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(float montoFinal) {
		this.montoFinal = montoFinal;
	}

	
	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public int getRestCuotas() {
		return restCuotas;
	}

	public void setRestCuotas(int restCuotas) {
		this.restCuotas = restCuotas;
	}

	public float getMontoCuotas() {
		return montoCuotas;
	}

	public void setMontoCuotas(float montoCuotas) {
		this.montoCuotas = montoCuotas;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}
	
	public String isAlDia() {
		return alDia;
	}

	public void setAlDia(boolean alDia) {
		if (alDia) {
			this.alDia = "SI";
		} else {
			this.alDia = "NO";
		}
	}

	@Override
	public String toString() {
		return "Prestamo [idCuenta=" + idCuenta + ", idUsuario=" + idUsuario + ", montoSolicitado=" + montoSolicitado
				+ ", montoFinal=" + montoFinal + ", cantCuotas=" + cantCuotas + ", restCuotas=" + restCuotas
				+ ", montoCuotas=" + montoCuotas + ", Fecha=" + Fecha + ", Estado=" + Estado + "]";
	}
	
	
	public String toStringList() {
		return "Prestamo: " + idCuenta + ", Monto Solicitado= " + montoSolicitado + ", Cuotas Restantes=" + restCuotas
				+ ", Monto de las Cuotas=" + montoCuotas;
	}

	
}
