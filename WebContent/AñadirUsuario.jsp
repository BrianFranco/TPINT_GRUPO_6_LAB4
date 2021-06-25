<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vj</title>
</head>
<body>
Usuario:<br>
<a href="Principal.jsp">Inicio</a>
<a href="ServletsInicio?Param=ListUsu">Listar Usuario</a>
<a href="ServletsInicio?Param=Tranferir">Trasferir Dinero</a>
<a href="ServletsInicio?Param=Mirar cuenta">Mirar cuenta</a>
<a href="ServletsInicio?Param=Prestamo">Solicitar Prestamo</a>
<a href="ServletsInicio?Param=Datos">Datos Personales</a><br>


		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txtNombre" /></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="txtApellido" /></td>
			</tr>
			<tr>
				<td>DNI:</td>
				<td><input type="text" name="txtDNI" /></td>
			</tr>

			<tr>
				<td>Tipo de usuario:</td>
				<td><select name="Tipo_de_usuario">
						<option value="0">Cliente</option>
						<option value="1">Administrador</option>
				</select></td>
			</tr>
<tr>
				<td>NombreUsuario:</td>
				<td><input type="text" name="txtNombreUsu" /></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type="text" name="txtContraseña" /></td>
			</tr>
			<tr>
				<td>NombreUsuario:</td>
				<td><input type="text" name="txtNombreUsu" /></td>
			</tr>
			
			<tr>
				<td>Dia:</td>
				<td><input type="text" name="txtDia" /></td>
			</tr>
			<tr>
				<td>Mes:</td>
				<td><input type="text" name="txtMes" /></td>
			</tr>
			<tr>
				<td>Año:</td>
				<td><input type="text" name="txtAño" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="btnAceptar" value="Aceptar">
				</td>
			</tr>
		</table>


	<%
		if (request.getAttribute("estadoUsuario") != null) {
	%>
	Usuario agregado con exito
	<%
		}
	%>
</body>
</html>