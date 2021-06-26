<jsp:include page="_base.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Personales</title>
</head>
<main style="margin-left:20em;">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
<h2>Datos Personales</h2>
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		<form class="row g-3">
		  <div class="col-md-6">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control" id="nombre" placeholder="Ignacio">
		  </div>
		  <div class="col-md-6">
		    <label for="apellido" class="form-label">Apellido</label>
		    <input type="text" class="form-control" id="apellido" placeholder="Keegan">
		  </div>
		  <div class="col-md-6">
		    <label for="fechaNac" class="form-label">Fecha de nacimiento</label>
		    <input type="text" class="form-control" id="fechaNac" placeholder="1999/01/01">
		  </div>
		  <div class="col-md-6">
		    <label for="dni" class="form-label">DNI</label>
		    <input type="text" class="form-control" id="dni" placeholder="3324445">
		  </div>
		  <div class="col-md-6">
		    <label for="usuario" class="form-label">Nombre de Usuario</label>
		    <input type="text" class="form-control" id="usuario" placeholder="ikeegan">
		  </div>
		  <div class="col-md-6">
		    <label for="password" class="form-label">Contraseña</label>
		    <input type="password" class="form-control" id="password" placeholder="6548451">
		  </div>
		  <hr>

		  <div class="col-md-12">
		    <a href="Saldo.jsp" class="btn btn-danger">Cancelar</a>
		    <input type="submit" name="btnAceptar" class="btn btn-success" style="margin-left:1em;" value="Modificar">
		  </div>
		</form>
</main>
