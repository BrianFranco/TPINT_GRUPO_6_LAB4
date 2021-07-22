<jsp:include page="_baseAdministrador.jsp" />
<%@page import="entidad.Usuario"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Listar Usuarios</title>

</head>
<main style="margin-left:20em;">
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
<h2>Reporte de Usuarios</h2>

<div style="margin-top: 2em;">

	<form class="row g-3" method="get" action="ReporteUsuarios">
		<div class="col-md-3">
			<label for="nombre" class="form-label">Nombre</label> <input
				type="text" name="nombre" class="form-control" id="nombre">
		</div>
		<div style="margin-left: 15px;" class="col-md-3">
			<label for="apellido" class="form-label">Apellido</label> <input
				type="text" name="apellido" class="form-control" id="apellido">
		</div>
		<div style="margin-left: 25px;" class="col-md-3">
			<input type="submit" name="btnFiltrar" value="Filtrar"
				style="margin-top: 1em;" class="btn btn-primary">
		</div>
	</form>
	<h3>Usuarios</h3>
	<%
		ArrayList<Usuario> listaUsuarios = null;
		ArrayList<Cuenta> listaCuentas = null;
		if (request.getAttribute("ReporteU") != null) {
			listaUsuarios = (ArrayList<Usuario>) request.getAttribute("ReporteU");
		}

		if (request.getAttribute("ReporteC") != null) {
			listaCuentas = (ArrayList<Cuenta>) request.getAttribute("ReporteC");
		}
	%>
	<hr>
	<table class="table table-striped table-sm">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Dni</th>
			<th>Nombre de Usuario</th>
			<th>Fecha de Nacimiento</th>
			<th></th>
		</tr>

		<%
			if (listaUsuarios != null)
				for (Usuario user : listaUsuarios) {
					if (user.getActivo() == 1) {
		%>
		<tr>
			<form name="formulario"
				action="ReporteUsuarios?idUsuario=<%=user.getIdUsuario()%>"
				method="get">
				<td><%=user.getIdUsuario()%> <input type="hidden"
					name="idUsuario" value="<%=user.getIdUsuario()%>">
				<td><%=user.getNombre()%></td>
				<td><%=user.getApellido()%></td>
				<td><%=user.getDni()%></td>
				<td><%=user.getNomUsuario()%></td>
				<td><%=user.getFechaNac()%></td>
				<td><input type="submit" class="btn btn-info" name="btnMostrar"
					value="Mostrar Cuentas"></td>
			</form>
		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
		<h3>Cuentas del Usuario</h3>
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">Tipo de Cuenta</th>
				<th scope="col">Moneda</th>
				<th scope="col">Nro de Cuenta</th>
				<th scope="col">Saldo</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (listaCuentas != null) {
					for (Cuenta c : listaCuentas) {
			%>
			<tr>
				<td><%=c.getTipoCuenta().getDescripcion()%></td>
				<td>$</td>
				<td><%=c.getN_Cuenta()%></td>
				<td><%=c.getSaldo()%></td>
			</tr>
			<%
				}
				}
			%>
		</tbody>

	</table>

</div>

<script>
	$(function() {
		$("#datepickerdesde").datepicker();
	});
	$(function() {
		$("#datepickerhasta").datepicker();
	});
</script> </main>