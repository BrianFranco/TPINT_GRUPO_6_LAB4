<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<jsp:include page="/Css/EstilosIniciarSesion.css"></jsp:include>
<title>Inicio de sesión</title>
</head>
<body>

<div class="sidenav">
         <div class="login-main-text">
            <h2>BANCO UTN<br></h2>
            <p>Ingrese usuario y contraseña para ingresar.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form action="ServletIniciarSesion" method="post" >
                  <div class="form-group">
                     <label>Usuario</label>
                     <input type="text" class="form-control" name="txtUsuario" >
                  </div>
                  <div class="form-group">
                     <label>Contraseña</label>
                     <input type="password" class="form-control" name="txtContraseña">
                  </div>
                  <div style="margin-top:10px;">
	                  <input type="submit" name="inputIngresar" class="btn btn-black" value="Ingresar">
	                  <a class="btn btn-primary" href="AñadirUsuario.jsp" role="button">Registrarse</a>
                  </div>
               </form>
            </div>
         </div>
         <% if (request.getAttribute("errorCampoVacio") != null){
        	 	
        	 %>
        	 	<div class="alert alert-danger" role="alert">
  					Error. Debe completar todos los campos.
				</div>
        <%	 	
         }	         
         %>
         
         <% if (request.getAttribute("errorUsuarioIncorrecto") != null){
        	 	
        	 %>
        	 	<div class="alert alert-danger" role="alert">
  					Error. El usuario o contraseña ingresado es incorrecto.
				</div>
        <%	 	
         }	         
         %>
         
         
         
         
      </div>
	
</body>
</html>