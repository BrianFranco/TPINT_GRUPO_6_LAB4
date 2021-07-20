package entidad;


public class Cuenta {
	private String N_Cuenta;
	private String CBU;
	private String idUsuario;
	private String TipoCuenta;
	private String Fecha;
	private String saldo;
	private int activo;
	
	
	
	public Cuenta() {
		super();
		N_Cuenta="";
		CBU = "";
		idUsuario = "";
		Fecha="";
		TipoCuenta = "";
		this.saldo = "10000";
		this.activo = 1;
	}
	

	public Cuenta(String N_Cuenta, String cBU,String idusuario , String tipoCuenta, String fecha, String saldo, boolean activo) {
		super();
		CBU = cBU;
		idUsuario = idusuario;
		TipoCuenta = tipoCuenta;
		Fecha=fecha;
		this.saldo = saldo;
		this.activo = 1;
	}
	
	public String getN_Cuenta() {
		return N_Cuenta;
	}


	public void setN_Cuenta(String n_Cuenta) {
		N_Cuenta = n_Cuenta;
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public String toStringListaTr() {
		return "Numero de Cuenta " + N_Cuenta + ", CBU=" + CBU + ", saldo=" + saldo;
	}
}
