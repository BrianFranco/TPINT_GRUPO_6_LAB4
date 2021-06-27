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
		  <div class="col-md-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text"  class="form-control" id="nombre" value="Ignacio">
		  </div>
		  <div class="col-md-3">
		    <label for="apellido" class="form-label">Apellido</label>
		    <input type="text" class="form-control" id="apellido" value="Keegan">
		  </div>
		  <div class="col-md-3">
		    <label for="fechaNac" class="form-label">Fecha de nacimiento</label>
		    <input type="date" class="form-control" id="fechaNac" value="1999/01/01">
		  </div>
		  <div class="col-md-3">
		    <label for="dni" class="form-label">DNI</label>
		    <input type="text" class="form-control" id="dni" value="3324445">
		  </div>
		  <div class="col-md-3">
		    <label for="cuil" class="form-label">CUIL</label>
		    <input type="text" class="form-control" id="cuil" value="20-3324445-7">
		  </div>
		  <div class="col-md-3">
		  
		    <label for="genero" class="form-label">Genero</label>
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Seleccione genero</option>
			  <option value="1">Masculino</option>
			  <option value="2">Femenino</option>
			  <option value="3">Otro</option>
			</select>
		  </div>
		  <div class="col-md-3">
		    <label for="nacionalidad" class="form-label">Nacionalidad</label>
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Seleccione la nacionalidad</option>
			  <option value="1">Argentina</option>
			  <option value="2">Peru</option>
			  <option value="3">Colombia</option>
			</select>
		  </div>
		  <div class="col-md-3">
		    <label for="direccion" class="form-label">Direccion</label>
		    <input type="text" class="form-control" id="direccion" value="742 de Evergreen Terrace">
		  </div>
		  <div class="col-md-3">
		    <label for="localidad" class="form-label">Localidad</label>
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Seleccione localidad</option>
			  <option value="1">Capital</option>
			  <option value="2">San Fernando</option>
			  <option value="3">Tigre</option>
			</select>
		  </div>
		  <div class="col-md-3">
		    <label for="provincia" class="form-label">Provincia</label>
		    <label class="form-label">Cuenta destino</label>
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Seleccione la provincia</option>
			  <option value="1">Buenos Aires</option>
			  <option value="2">Entre Rios</option>
			  <option value="3">La Pampa</option>
			</select>
		  </div>
		  <div class="col-md-3">
		    <label for="correo" class="form-label">Correo</label>
		    <input type="email" class="form-control" id="correo" value="ikeegan@gmail.com">
		  </div>
		  <div class="col-md-3">
		    <label for="telefono" class="form-label">Telefono</label>
		    <input type="number" class="form-control" id="telefono" value="1123459087">
		  </div>
		  <div class="col-md-3">
		    <label for="usuario" class="form-label">Nombre de Usuario</label>
		    <input type="text" class="form-control" id="usuario" value="ikeegan">
		  </div>
		  <div class="col-md-3">
		    <label for="password" class="form-label">Contraseña</label>
		    <input type="password"  class="form-control" id="password" value="1234151">
		  </div>
		  <hr/>
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