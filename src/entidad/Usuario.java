package entidad;

public class Usuario {
private String Nombre;
private String Apellido;
private int Dni;
private String NomUsuario;
private String Contrase�a;
private int dia;
private int mes;
private int a�o;
//constructor
public Usuario()
{
	this.Nombre="";
	this.Apellido="";
	this.Dni=0000000;
	this.NomUsuario="";
	this.Contrase�a="";
	this.dia=00;
	this.mes=00;
	this.a�o=00;
}
public Usuario(String Nombre,String Apellido, int Dni, String NomUsuario, String Contrase�a, int dia, int mes, int a�o)
{
	this.Nombre=Nombre;
	this.Apellido=Apellido;
	this.Dni=Dni;
	this.NomUsuario=NomUsuario;
	this.Contrase�a=Contrase�a;
	this.dia=dia;
	this.mes=mes;
	this.a�o=a�o;
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
public String getContrase�a() {
	return Contrase�a;
}
public void setContrase�a(String contrase�a) {
	Contrase�a = contrase�a;
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
public int getA�o() {
	return a�o;
}
public void setA�o(int a�o) {
	this.a�o = a�o;
}
@Override
public String toString() {
	return "Usuario [Nombre=" + Nombre + ", Apellido=" + Apellido + ", Dni=" + Dni + ", NomUsuario=" + NomUsuario
			+ ", Contrase�a=" + Contrase�a + ", dia=" + dia + ", mes=" + mes + ", a�o=" + a�o + "]";
}
public void setRolUsu(int parseInt) {
	// TODO Auto-generated method stub
	
}

}
