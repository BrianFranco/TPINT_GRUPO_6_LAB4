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
		  <div class="col-md-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" disabled="disabled"  class="form-control" id="nombre" value="Ignacio">
		  </div>
		  <div class="col-md-3">
		    <label for="apellido" class="form-label">Apellido</label>
		    <input type="text" disabled="disabled" class="form-control" id="apellido" value="Keegan">
		  </div>
		  <div class="col-md-3">
		    <label for="fechaNac" class="form-label">Fecha de nacimiento</label>
		    <input type="text" disabled="disabled" class="form-control" id="fechaNac" value="1999/01/01">
		  </div>
		  <div class="col-md-3">
		    <label for="dni" class="form-label">DNI</label>
		    <input type="text" class="form-control" id="dni" disabled="disabled" value="3324445">
		  </div>
		  <div class="col-md-3">
		    <label for="cuil" class="form-label">CUIL</label>
		    <input type="text" class="form-control" id="cuil" disabled="disabled" value="20-3324445-7">
		  </div>
		  <div class="col-md-3">
		    <label for="genero" class="form-label">Genero</label>
		    <input type="text" class="form-control" id="genero" disabled="disabled" value="Masculino">
		  </div>
		  <div class="col-md-3">
		    <label for="nacionalidad" class="form-label">Nacionalidad</label>
		    <input type="text" class="form-control" id="nacionalidad" disabled="disabled" value="Argentino">
		  </div>
		  <div class="col-md-3">
		    <label for="direccion" class="form-label">Direccion</label>
		    <input type="text" class="form-control" id="direccion" disabled="disabled" value="742 de Evergreen Terrace">
		  </div>
		  <div class="col-md-3">
		    <label for="localidad" class="form-label">Localidad</label>
		    <input type="text" class="form-control" id="localidad" disabled="disabled" value="Pacheco">
		  </div>
		  <div class="col-md-3">
		    <label for="provincia" class="form-label">Provincia</label>
		    <input type="text" class="form-control" id="provincia" disabled="disabled" value="Buenos Aires">
		  </div>
		  <div class="col-md-3">
		    <label for="correo" class="form-label">Correo</label>
		    <input type="text" class="form-control" id="correo" disabled="disabled" value="ikeegan@gmail.com">
		  </div>
		  <div class="col-md-3">
		    <label for="telefono" class="form-label">Telefono</label>
		    <input type="text" class="form-control" id="telefono" disabled="disabled" value="1123459087">
		  </div>
		  <div class="col-md-3">
		    <label for="usuario" class="form-label">Nombre de Usuario</label>
		    <input type="text" class="form-control" id="usuario" disabled="disabled" value="ikeegan">
		  </div>
		  <div class="col-md-3">
		    <label for="password" class="form-label">Contraseña</label>
		    <input type="password" disabled="disabled" class="form-control" id="password" value="1234151">
		  </div>
		  <hr>
		</form>
</main>
