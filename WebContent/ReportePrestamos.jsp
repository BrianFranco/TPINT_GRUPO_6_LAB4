<jsp:include page="_baseAdministrador.jsp" />
<%@page import="entidad.Prestamo"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Reporte Prestamos</title>
</head>
<main> <main style="margin-left:20em;">
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
<h2>Reporte de Prestamos</h2>
<%
	ArrayList<Cuenta> listaCuentas = null;
	ArrayList<Prestamo> listaPrestamos = null;
	if (request.getAttribute("ReporteC") != null) {
		listaCuentas = (ArrayList<Cuenta>) request.getAttribute("ReporteC");
	}
	if (request.getAttribute("ReporteP") != null) {
		listaPrestamos = (ArrayList<Prestamo>) request.getAttribute("ReporteP");
	}
%>

<div style="margin-top: 2em;">
	<form class="row g-3" method="get" action="ReportePrestamos">
		<div class="col-md-3">
			<label for="datepickerdesde" class="form-label">Desde</label> <input
				type="text" name="desde" class="form-control" id="datepickerdesde">
		</div>
		<div style="margin-left: 15px;" class="col-md-3">
			<label for="datepickerhasta" class="form-label">Hasta</label> <input
				type="text" name="hasta" class="form-control" id="datepickerhasta">
		</div>
		<div style="margin-left: 25px;" class="col-md-3">
			<input type="submit" name="btnFiltrar" value="Filtrar"
				style="margin-top: 1em;" class="btn btn-primary">
		</div>
	</form>

	<table class="table table-striped table-sm">
		<tr>
			<th>Numero de Cuenta</th>
			<th>Tipo de cuenta</th>
			<th>Fecha de Alta de Cuenta</th>
			<th></th>
		</tr>

		<%
			if (listaCuentas != null)
				for (Cuenta cuenta : listaCuentas) {
		%>
		<tr>
			<form name="formulario"
				action="ReportePrestamos?idCuenta=<%=cuenta.getN_Cuenta()%>"
				method="get">
				<td><%=cuenta.getN_Cuenta()%> <input type="hidden"
					name="idCuenta" value="<%=cuenta.getN_Cuenta()%>">
				<td><%=cuenta.getTipoCuenta().getDescripcion()%></td>
				<td><%=cuenta.getFecha()%></td>
				<td><input type="submit" class="btn btn-info" name="btnMostrar"
					value="Mostrar Detalles"></td>
			</form>
		</tr>
		<%
			}
		%>
	</table>
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">Fecha de Alta</th>
				<th scope="col">Monto Solicitado</th>
				<th scope="col">Monto Final</th>
				<th scope="col">Cantidad de Cuotas</th>
				<th scope="col">Cuotas Restantes</th>
				<th scope="col">Al Dia</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (listaPrestamos != null) {
					for (Prestamo p : listaPrestamos) {
			%>
			<tr>
				<td><%=p.getFecha()%></td>
				<td><%=p.getMontoSolicitado()%></td>
				<td><%=p.getMontoFinal()%></td>
				<td><%=p.getCantCuotas()%></td>
				<td><%=p.getRestCuotas()%></td>
				<td><%=p.isAlDia()%></td>
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