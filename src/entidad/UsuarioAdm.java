package entidad;

public class UsuarioAdm extends Usuario {
private int rolUsu;

public int getRolUsu() {
	return rolUsu;
}

public void setRolUsu(int rolUsu) {
	this.rolUsu = rolUsu;
}

public UsuarioAdm(String Nombre,String Apellido, int Dni, String NomUsuario, String Contrase�a, int dia, int mes, int a�o,int rolUsu)
{
	//super(Nombre,Apellido, Dni,NomUsuario,Contrase�a,dia,mes,a�o);
	this.rolUsu=rolUsu;
}

@Override
public String toString() {
	return "UsuarioAdm [rolUsu=" + rolUsu + "]";
}

}
