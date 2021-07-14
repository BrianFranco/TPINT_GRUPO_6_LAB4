package entidad;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Usuario {
private int IdUsuario;
private String Nombre;
private String Apellido;
private int Dni;
private String Cuil;
private Date fechaNac;
private String Genero;
private String Nacionalidad;
private String NomUsuario;
private String Contraseña;
private String Direccion;
private String Localidad;
private String Provincia;
private String Telefono;
private String Email;
private int idRol;
private int Activo;

//constructor
public Usuario()
{
	this.Nombre="nuevoNombre";
	this.Apellido="nuevoApellido";
	this.Dni=0;
	this.Cuil ="2000";
	this.NomUsuario="";
	this.Contraseña="";
	this.Direccion = "";
	this.Localidad = "";
	this.Provincia = "";
	this.Telefono = "";
	this.Email = "email@gmail.com";
	this.idRol = 1;
	DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	String dateInString = "1980-01-01";
	try {
		this.fechaNac = formatter.parse(dateInString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.Genero = "O";
	this.Nacionalidad = "Argentino";
}

public Usuario(String Nombre,String Apellido, int Dni, String cuil,String NomUsuario, Date fechaNac,
			String genero,String nacionalidad,String Contraseña,
			String Direccion,String Localidad,String Provincia,String Telefono,String Email,int idRol)
{
	this.Nombre=Nombre;
	this.Apellido=Apellido;
	this.Dni=Dni;
	this.Cuil = cuil;
	this.NomUsuario=NomUsuario;
	this.Contraseña=Contraseña;
	this.fechaNac = fechaNac;
	this.Genero = genero;
	this.Nacionalidad = nacionalidad;
	this.Direccion = Direccion;
	this.Localidad = Localidad;
	this.Provincia = Provincia;
	this.Telefono = Telefono;
	this.Email = Email;
	this.idRol = idRol;
	this.Activo = 1;
}

public int getIdRol() {
	return idRol;
}

public void setIdRol(int idRol) {
	this.idRol = idRol;
}

public void setFechaNac(Date fechaNac) {
	this.fechaNac = fechaNac;
}

public int getActivo() {
	return Activo;
}
public void setActivo(int activo) {
	Activo = activo;
}
public String getFechaNac() {
	DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	
	return formatter.format(this.fechaNac);
}
public void setFechaNac(String fechaNac) {
	DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	String dateInString = fechaNac;
	try {
		this.fechaNac = formatter.parse(dateInString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public String getDireccion() {
	return Direccion;
}
public void setDireccion(String direccion) {
	Direccion = direccion;
}
public String getLocalidad() {
	return Localidad;
}
public void setLocalidad(String localidad) {
	Localidad = localidad;
}
public String getTelefono() {
	return Telefono;
}
public void setTelefono(String telefono) {
	Telefono = telefono;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

public String getCuil() {
	return Cuil;
}
public void setCuil(String cuil) {
	Cuil = cuil;
}
public String getGenero() {
	return Genero;
}
public void setGenero(String genero) {
	Genero = genero;
}
public String getNacionalidad() {
	return Nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	Nacionalidad = nacionalidad;
}



public int getIdUsuario() {
	return IdUsuario;
}
public void setIdUsuario(int idUsuario) {
	IdUsuario = idUsuario;
}
public String getProvincia() {
	return Provincia;
}
public void setProvincia(String provincia) {
	Provincia = provincia;
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

@Override
public String toString() {
	return "Usuario [Nombre=" + Nombre + ", Apellido=" + Apellido + ", Dni=" + Dni + ", NomUsuario=" + NomUsuario
			+ ", Contraseña=" + Contraseña + " ]";
}

}
