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
<a href="ServletsInicio?Param=Tranferir">Trasferir Dinero</a>
<a href="ServletsInicio?Param=Prestamo">Solicitar Prestamo</a><br>

<h1>Cuentas</h1>

Numero de cuenta:
		<select>
			<option>Cta:Nro. 0001 - Disponible: 0000$</option>
			<option>Cta:Nro. 0002 - Disponible: 0000$</option>
			<option>Cta:Nro. 0003 - Disponible: 0000$</option>
		</select><br/>
Tipo de cuenta
<select name="Cantidad de cuatas">
						<option value="0">Cuenta corriente</option>
						<option value="1">Caja de ahorro</option>									
				</select><br>
<table id="table_id" class="display">
		<thead>
			<tr>
				<th>Fecha</th>
				<th>Cantidad</th>
				<th>Cuenta Transferida</th>
			</tr>
		
		</table>
</body>
</html>