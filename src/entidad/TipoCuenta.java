package Entidad;

import org.apache.tomcat.util.buf.StringCache;

public class TipoCuenta {
	public String getIDTipoCuenta() {
		return IDTipoCuenta;
	}
	public void setIDTipoCuenta(String iDTipoCuenta) {
		IDTipoCuenta = iDTipoCuenta;
	}
	public StringCache getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(StringCache descripcion) {
		Descripcion = descripcion;
	}
	private String IDTipoCuenta;
	private StringCache Descripcion;
}
