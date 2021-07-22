<jsp:include page="_base.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>
    <%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos</title>
<jsp:include page="/Css/EstilosPrestamo.css"></jsp:include>
</head>
	

	<%
		Usuario u = new Usuario();
		if(session.getAttribute("Usuario") != null){
			u = (Usuario) session.getAttribute("Usuario");
		}
	
		List<Cuenta> listaC = new ArrayList<Cuenta>();
		if (request.getAttribute("listaCuenta") != null) {
			listaC = (List<Cuenta>) request.getAttribute("listaCuenta");
		}
		
	%>

<main style="margin-left:20em;">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
<h2>Pedido de Prestamo</h2>
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		<form class="row g-3" action="servletPredidoPrestamos" method="post">
		<div class="col input-group">
			<span class="input-group-text" id="basic-addon1">Fecha</span>
			<input type="text" class="form-control" disabled="disabled" name="fecha" value="<%= java.time.LocalDate.now() %>">
		</div>
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
		<div>
			<input type="hidden" name="idUser" value="<%= u.getIdUsuario() %>">
		</div>
		<div class="col-12">
		    <label for="monto" class="form-label">Monto de prestamo</label>
		    <input type="text" class="form-control" name="txtImporte" id="monto">
		  </div>
		  <div class="col-12">
		  	<label class="form-label">Cuotas</label>
		    <select class="form-select" aria-label="Default select example" name="cantCuotas">
			  <option selected>Numero de cuotas</option>
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
			</select>
		  </div>
		  <div class="col-12">
		  	<input type="submit" value="Aceptar" name="btnAceptar" class="btn btn-primary"/>
		  </div>
		</form>
</main>
