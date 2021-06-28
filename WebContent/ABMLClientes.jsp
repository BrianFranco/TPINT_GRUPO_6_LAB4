
<jsp:include page="_baseAdministrador.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABML de Clientes</title>
<style>
table {
  border-collapse: collapse;
  width: 20%;
}

th, td {
  text-align: center;
  padding: 3px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: black;
  color: white;
}
</style>
</head>
<div style="height: 5px; margin-left:20em;aling:center;">
	<span>
		<h3>Registrar cliente</h3>
		<form>
		  <div class="col-md-6">
		    <label for="usuario" class="form-label">Usuario</label>
		    <input type="text" class="form-control" id="nombre">
		  </div>
		  <div class="col-md-6">
			    <label for="password" class="form-label">Contraseña</label>
			    <input type="text" class="form-control" id="apellido">
		  </div>
		  <input type="submit" name="btnRegistrar" value="Registrar" style="margin-top:1em;" class="btn btn-primary">		 
</div>
<div style="margin-left:20em;margin-top:17em;">
	<h3>Clientes</h3>
	<form>
		<table border="1">
			<tr>
				<th></th>
				<th style="padding-left:10px; padding-right:10px;">Id</th>
				<th style="padding-left:10px; padding-right:10px;">Contraseña</th>
			</tr>
			<tr>
				<td><input type="radio" name="group"></td>
				<td>666</td>
				<td>ejemplo</td>
			</tr>
			<tr>
				<td><input type="radio" name="group"></td>
				<td>333</td>
				<td>ejemplo2</td>
			</tr>
		</table>
		<input type="submit" value="Modificar" style="margin-top:1em;" class="btn btn-danger">
		<input type="submit" value="Eliminar" style="margin-top:1em;" class="btn btn-primary">
	</form>
</div>
