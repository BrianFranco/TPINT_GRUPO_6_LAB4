<jsp:include page="_base.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos</title>
<jsp:include page="/Css/EstilosPrestamo.css"></jsp:include>
</head>

<main style="margin-left:20em;">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
<h2>Pedido de Prestamo</h2>
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		<form class="row g-3">
		<div class="col-12">
		<label class="form-label">Cuenta destino</label>
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Seleccione la cuenta</option>
			  <option value="1">Cta:Nro. 0001 - Disponible: 0000$</option>
			  <option value="2">Cta:Nro. 0002 - Disponible: 0000$</option>
			  <option value="3">Cta:Nro. 0003 - Disponible: 0000$</option>
			</select>
		  </div>
		  <div class="col-12">
		    <label for="importe" class="form-label">Monto de prestamo</label>
		    <input type="text" class="form-control" id="importe">
		  </div>
		  <div class="col-12">
		  	<label class="form-label">Cuotas</label>
		    <select class="form-select" aria-label="Default select example">
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
		  <hr>

		  <div class="col-12">
		  	<a href="Cuentas.jsp" class="btn btn-danger">Cancelar</a>
		  	<input type="submit" value="Aceptar" name="btnAceptar" class="btn btn-primary"/>
		  </div>
		</form>
				<%!int cant=0; %>
				<!--Poner Funcion para calcular el pago -->
				<br>
		<h4>Los pagos seran <b><%=cant%></b> al mes.</h4>
</main>