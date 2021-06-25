<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio de sesión</title>
</head>
<body>
	<div class="header">
		<div class="nav">
		<a href="ServletsInicio?Param=previoInsert">Añadir Usuario</a>
		<a href="ServletsInicio?Param=ListUsu">Listar Usuario</a>
		<a href="ServletsInicio?Param=Tranferir">Trasferir Dinero</a>
		<a href="ServletsInicio?Param=Mirar cuenta">Mirar cuenta</a>
		<a href="ServletsInicio?Param=Prestamo">Solicitar Prestamo</a>
		<a href="ServletsInicio?Param=Datos">Datos Personales</a><br/>
		</div>
	</div>
	<div class ="main">
		<h1>Inicio de Sesión</h1><br/>
		<form action="servletUsuario" method="get" class="formIngreso">
			<label>Ingrese su usuario: </label>
			<input type="text" name="txtNombreUsu" /><br/>
			<label>Ingrese su contraseña: </label>
			<input type="password" name="txtContraseña" /><br/>
			<input type="submit" name="btnIngresar" value="Ingresar"><br/>
			<a href="#"><small><b>¿Olvido su contraseña?</b></small></a>
		</form>
	</div>
	
</body>
</html>