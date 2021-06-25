package entidad;

public class Usuario {
private String Nombre;
private String Apellido;
private int Dni;
private String NomUsuario;
private String Contraseña;
private int dia;
private int mes;
private int año;
//constructor
public Usuario()
{
	this.Nombre="";
	this.Apellido="";
	this.Dni=0000000;
	this.NomUsuario="";
	this.Contraseña="";
	this.dia=00;
	this.mes=00;
	this.año=00;
}
public Usuario(String Nombre,String Apellido, int Dni, String NomUsuario, String Contraseña, int dia, int mes, int año)
{
	this.Nombre=Nombre;
	this.Apellido=Apellido;
	this.Dni=Dni;
	this.NomUsuario=NomUsuario;
	this.Contraseña=Contraseña;
	this.dia=dia;
	this.mes=mes;
	this.año=año;
}
//gets y sets
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getApellido() {
	return Apellido;
}
public void setApellido(String apellido) {
	Apellido = apellido;
}
public int getDni() {
	return Dni;
}
public void setDni(int dni) {
	Dni = dni;
}
public String getNomUsuario() {
	return NomUsuario;
}
public void setNomUsuario(String nomUsuario) {
	NomUsuario = nomUsuario;
}
public String getContraseña() {
	return Contraseña;
}
public void setContraseña(String contraseña) {
	Contraseña = contraseña;
}
public int getDia() {
	return dia;
}
public void setDia(int dia) {
	this.dia = dia;
}
public int getMes() {
	return mes;
}
public void setMes(int mes) {
	this.mes = mes;
}
public int getAño() {
	return año;
}
public void setAño(int año) {
	this.año = año;
}
@Override
public String toString() {
	return "Usuario [Nombre=" + Nombre + ", Apellido=" + Apellido + ", Dni=" + Dni + ", NomUsuario=" + NomUsuario
			+ ", Contraseña=" + Contraseña + ", dia=" + dia + ", mes=" + mes + ", año=" + año + "]";
}
public void setRolUsu(int parseInt) {
	// TODO Auto-generated method stub
	
}

}
