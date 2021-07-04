package entidad;


public class Cuenta {
	private String CBU;
	private String TipoCuenta;
	private String Fecha;
	private String saldo;
	private boolean activo;
	
	public Cuenta() {
		super();
		CBU = "";
		Fecha="";
		TipoCuenta = "";
		this.saldo = "10000";
		this.activo = true;
	}
	

	public Cuenta(String cBU, String tipoCuenta, String fecha, String saldo, boolean activo) {
		super();
		CBU = cBU;
		TipoCuenta = tipoCuenta;
		Fecha=fecha;
		this.saldo = saldo;
		this.activo = activo;
	}
	
	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getCBU() {
		return CBU;
	}
	public void setCBU(String cBU) {
		CBU = cBU;
	}
	public String getTipoCuenta() {
		return TipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String i) {
		this.saldo = i;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	


}