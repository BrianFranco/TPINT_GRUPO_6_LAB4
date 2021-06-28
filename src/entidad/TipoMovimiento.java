package Entidad;

import org.apache.tomcat.util.buf.StringCache;

public class TipoMovimiento {
	private String IDTipoMovimiento;
	
	public String getIDTipoMovimiento() {
		return IDTipoMovimiento;
	}
	public void setIDTipoMovimiento(String iDTipoMovimiento) {
		IDTipoMovimiento = iDTipoMovimiento;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	private String Descripcion;
}
