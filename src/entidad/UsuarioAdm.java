package entidad;

public class UsuarioAdm extends Usuario {
private int rolUsu;

public int getRolUsu() {
	return rolUsu;
}

public void setRolUsu(int rolUsu) {
	this.rolUsu = rolUsu;
}

public UsuarioAdm(String Nombre,String Apellido, int Dni, String NomUsuario, String Contraseña, int dia, int mes, int año,int rolUsu)
{
	//super(Nombre,Apellido, Dni,NomUsuario,Contraseña,dia,mes,año);
	this.rolUsu=rolUsu;
}

@Override
public String toString() {
	return "UsuarioAdm [rolUsu=" + rolUsu + "]";
}

}
