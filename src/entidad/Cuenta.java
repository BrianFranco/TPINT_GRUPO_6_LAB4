package Entidad;

import org.apache.tomcat.util.buf.StringCache;

public class Cuenta {
	
	private String IDCuenta;
	private Usuario Usuario;
	private TipoCuenta TipoCuenta;
	private double saldo;
	private boolean activo;
	
	public String getIDCuenta() {
		return IDCuenta;
	}
	public void setIDCuenta(String iDCuenta) {
		IDCuenta = iDCuenta;
	}
	public String getIDUsuario() {
		return IDUsuario;
	}
	public void setIDUsuario(String iDUsuario) {
		IDUsuario = iDUsuario;
	}
	public TipoCuenta getTipoCuenta() {
		return TipoCuenta;
	}
	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
