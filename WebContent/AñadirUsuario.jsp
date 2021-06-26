<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<jsp:include page="/Css/EstilosAñadirUsuario.css"></jsp:include>
<title>Registrarse</title>
</head>
<body>
<div class="sidenav">
         <div class="login-main-text">
            <h2>BANCO UTN<br></h2>
            <p></p>
         </div>
      </div>
	<main style="margin-left:20em;">
	<h2>Registrarse</h2>
	<hr>
		<form class="row g-3">
		  <div class="col-md-6">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control" id="nombre">
		  </div>
		  <div class="col-md-6">
		    <label for="apellido" class="form-label">Apellido</label>
		    <input type="text" class="form-control" id="apellido">
		  </div>
		  <div class="col-md-6">
		    <label for="email" class="form-label">Email</label>
		    <input type="email" class="form-control" id="email">
		  </div>
		  <div class="col-md-6">
		    <label for="dni" class="form-label">DNI</label>
		    <input type="number" class="form-control" id="dni">
		  </div>
		  <hr>
		  <div class="col-12">
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Seleccione el tipo de usuario</option>
			  <option value="1">Cliente</option>
			  <option value="2">Administrador</option>
			</select>
		  </div>
		  <div class="col-6">
		    <label for="nombreUsuario" class="form-label">Nombre de Usuario</label>
		    <input type="text" class="form-control" id="nombreUsuario">
		  </div>
		  <div class="col-6">
		    <label for="inputCity" class="form-label">Contraseña</label>
		    <input type="password" class="form-control" id="contraseña">
		  </div>
		  <div class="col-12">
		    <label for="inputZip" class="form-label">Fecha de Nacimiento</label>
		    <input type="date"class="form-control" id="inputZip">
		  </div>
		  <div class="col-12">
		    <input type="submit" name="btnAceptar" class="btn btn-primary" value="Registrarse">
		  </div>
		</form>
		


	<%
		if (request.getAttribute("estadoUsuario") != null) {
	%>
	Usuario agregado con exito
	<%
		}
	%>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</main>
</body>
</html>