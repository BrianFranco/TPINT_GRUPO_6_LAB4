<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Usuario:<br>
<a href="ServletsInicio?Param=previoInsert">Añadir Usuario</a>
<a href="ServletsInicio?Param=ListUsu">Listar Usuario</a>
<a href="ServletsInicio?Param=Tranferir">Trasferir Dinero</a>
<a href="ServletsInicio?Param=Mirar cuenta">Mirar cuenta</a>
<a href="ServletsInicio?Param=Prestamo">Solicitar Prestamo</a>
<a href="ServletsInicio?Param=Datos">Datos Personales</a><br>
<form action="servletUsuario" method="get">
Ingrese Usuario     <input type="text" name="txtNombreUsu"><br>
Ingrese Contraseña <input type="text" name="txtContraseña"><br>
<input type="submit" value="Aceptar" name="btnAceptar">
</form>
</body>
</html>