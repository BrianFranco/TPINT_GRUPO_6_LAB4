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
<a href="ServletsInicio?Param=Inicio">Inicio</a>
<a href="ServletsInicio?Param=previoInsert">Añadir Usuario</a>
<a href="ServletsInicio?Param=ListUsu">Listar Usuario</a>
<a href="ServletsInicio?Param=Prestamo">Solicitar Prestamo</a><br>

<h1>Transferencias</h1>
<table>
			<tr>
				<td><label>Seleccionar cuenta: </label></td>
				<td>
					<select>
					<option>Cta:Nro. 0001 - Disponible: 0000$</option>
					<option>Cta:Nro. 0002 - Disponible: 0000$</option>
					<option>Cta:Nro. 0003 - Disponible: 0000$</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Importe:</td>
				<td><input type="text" name="txtImport" /></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="txtNombre" /></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="txtApellido" /></td>
			</tr>

			<tr>
				<td>Numero de cuenta destinada:</td>
				<td><input type="text" name="txtNcuenta" /></td>
			</tr>
<tr>
				<td>Referencia:</td>
				<td><input type="text" name="txtReferencia" /></td>
			</tr>
			
				
			<tr>
				<td></td>
				<td><input type="submit" name="btnAceptar" value="Aceptar">
				</td>
			</tr>
		</table>
</body>
</html>