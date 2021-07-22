<jsp:include page="_base.jsp" />
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/Css/EstilosTransferir.css"></jsp:include>
<title>Transferencias</title> 
</head>

	<%
		List<Cuenta> listaC = new ArrayList<Cuenta>();
		if (request.getAttribute("listaCuenta") != null) {
			listaC = (List<Cuenta>) request.getAttribute("listaCuenta");
		}
	%>

<main style="margin-left:20em;" >
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 my-3 border-bottom"><h2>Transferencias</h2></div>
	<input type="hidden">
	<form class="row g-3" action="servletTransferencias" method="post">
		<div class="col-12">
			<label class="form-label" for="cuentaOrigen">Seleccionar cuenta: </label>
			<select class="form-select" aria-label="Default select example" name="cuentaOrigen">
				<option selected>Selecciones una cuenta </option>
				<%
					for (Cuenta c : listaC) {
				%>
				<option value="<%=c.getN_Cuenta()%>"><%=c.toStringListaTr()%></option>
				<%
					}
				%>
			</select>
		</div>
		<div class="col-md-12">
			<label for="importe" class="form-label">Importe</label>
			<input type="text" class="form-control" name="txtImporte" id="importe">
		</div>
		<div class="col-md-12">
			<label for="cuenta" class="form-label">Numero de cuenta destinada</label>
			<input type="text" class="form-control" id="cuenta" name="txtCuentaDestino" >
		</div>
		<!-- iv class="col-md-12">
			<label for="referencia" class="form-label">Referencia</label>
			<input type="text" class="form-control" id="referencia" name="txtReferencia">
		</div-->
		<div class="col-12">
			<input type="submit" name="btnAceptar" class="btn btn-primary" value="Aceptar"/>
		</div>
	</form>
</main>
