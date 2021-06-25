<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagar Prestamos</title>
</head>
<body>
	<div class="header">
		<div class="nav">
			<a href="ServletsInicio?Param=previoInsert">Añadir Usuario</a>
			<a href="ServletsInicio?Param=ListUsu">Listar Usuario</a>
			<a href="ServletsInicio?Param=Tranferir">Trasferir Dinero</a>
			<a href="ServletsInicio?Param=Mirar cuenta">Mirar cuenta</a>
			<a href="ServletsInicio?Param=Prestamo">Solicitar Prestamo</a><br>
		</div>
	</div>
	<div class="main">
	<h1>Pagar cuotas de prestamos</h1>
		<div>
		<label>Cuenta a debitar: </label>
			<select>
					<option>Cta:Nro. 0001 - Disponible: 0000$</option>
					<option>Cta:Nro. 0002 - Disponible: 0000$</option>
					<option>Cta:Nro. 0003 - Disponible: 0000$</option>
			</select><br/>
			<label>Prestamos a pagar: </label>
			<select>
					<option>Prestamo: Nro. 0001</option>
					<option>Prestamo: Nro. 0002</option>
					<option>Prestamo: Nro. 0003</option>
			</select><br/>
			<table border="2">
				<tr>
					<th>
						<label>Nro de Cuota</label>
					</th>
					<th>
						<label>Valor</label>
					</th>
					<th>
						Pagar
					</th>
				</tr>
				<tr>
					<td>
						<label>1</label>
					</td>
					<td>
						<label>1000</label>
					</td>
					<td>
						<input type="submit" value="Pagar" name="btnPagar"/>
					</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>