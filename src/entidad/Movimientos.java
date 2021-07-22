package entidad;

public class Movimientos {
	private int idMovimiento;
	private int idCuenta;
	private String descripcion;
	private int idTipoMovimiento;
	private float saldo;
	private String fecha;
	
	
	public Movimientos() {
		
	}
	
	public Movimientos(int idCuenta,int idTipoMovimiento,String detalle,float saldo,String fecha) {
		this.idCuenta=idCuenta;
		this.idTipoMovimiento=idTipoMovimiento;
		this.descripcion=detalle;
		this.saldo=saldo;
		this.fecha=fecha;
	}
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
