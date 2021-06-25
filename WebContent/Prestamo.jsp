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
<a href="ServletsInicio?Param=previoInsert">Inicio</a>
<a href="ServletsInicio?Param=previoInsert">Añadir Usuario</a>
<a href="ServletsInicio?Param=ListUsu">Listar Usuario</a>
<a href="ServletsInicio?Param=Tranferir">Trasferir Dinero</a>
<a href="ServletsInicio?Param=Mirar cuenta">Mirar cuenta</a>
<br>
<h1>Prestamo</h1>
Cantidad a pedir:
<input type="text" name="txtCant"><br>
		
		<label>Cuenta destino: </label>
		<select>
			<option>Cta:Nro. 0001 - Disponible: 0000$</option>
			<option>Cta:Nro. 0002 - Disponible: 0000$</option>
			<option>Cta:Nro. 0003 - Disponible: 0000$</option>
		</select><br/>

Numero de cuotas:
<select name="Cantidad de cuatas">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>					
				</select><br>
				Tipo de cuenta
				<select name="Tipo de cuenta">
						<option value="0">Caja de ahorro</option>
						<option value="1">Cuenta corriente</option>
						</select><br>
				<input type="submit" value="Aceptar" name="btnAceptar">
				<%!int cant=0; %>
				<!--Poner Funcion para calcular el pago -->
				<br>
				Los pagos seran <b><%=cant%></b> al mes.
</body>
</html>