<jsp:include page="_base.jsp" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/Css/EstilosTransferir.css"></jsp:include>

<title>Transferencias</title> 
</head>


<main style="margin-left:20em;" >
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>

<h2>Transferencias</h2>
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>

<form class="row g-3">
		<div class="col-12">
			<label class="form-label" for="cuentaOrigen">Seleccionar cuenta: </label>
		    <select class="form-select" aria-label="Default select example" name="cuentaOrigen">
			  		<option selected></option>
			  		<option value="1">Cta:Nro. 0001 - Disponible: 0000$</option>
					<option value="2">Cta:Nro. 0002 - Disponible: 0000$</option>
					<option value="3">Cta:Nro. 0003 - Disponible: 0000$</option>
			</select>
		  </div>
		  <div class="col-md-12">
		    <label for="importe" class="form-label">Importe</label>
		    <input type="text" class="form-control" name="txtImporte" id="importe">
		  </div>
		  <div class="col-md-12">
		    <label for="cuenta" class="form-label">Numero de cuenta destinada</label>
		    <input type="text" class="form-control" id="cuenta" name="txtNcuenta" >
		  </div>
		  <div class="col-md-12">
		    <label for="referencia" class="form-label">Referencia</label>
		    <input type="text" class="form-control" id="referencia" name="txtReferencia">
		  </div>
		  <hr>

		  <div class="col-12">
		  	<a href="Saldo.jsp" class="btn btn-danger">Cancelar</a>
		  	<input type="submit" name="btnAceptar" class="btn btn-primary" value="Aceptar"/>
		  </div>
		</form>
</main>