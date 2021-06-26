<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://unpkg.com/feather-icons"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script><%-- Este script no lo encuentra el navegador(Quizas esta mal escrito?)--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<jsp:include page="/Css/Estilos_base.css"></jsp:include>
<title>Banco UTN</title>
</head>
<body>
	<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
	  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="_base.jsp" style="font-size: large;">Banco UTN</a>
	  <div class="navbar-nav me-auto">
	      <a class="nav-link px-3" href="DatosPersonales.jsp">Perfil</a>
	      <a class="nav-link px-3" href="AñadirUsuario.jsp">Añadir Usuario</a>
	    </div>
	  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	    <div class="navbar-nav mr-auto ">
	      <a class="nav-link px-3" href="Login.jsp">Log In</a>
	      <a class="nav-link px-3" href="#">Sign out</a>
	    </div>
	</header>

<div class="container-fluid" style="margin-right: 30px;">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse" style="margin-top: 5px;">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
           <li class="nav-item">
	           <a class="nav-link active" aria-current="page" href="Saldo.jsp">
	            <span data-feather="home"></span>
	             Cuentas
	           </a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="Cuentas.jsp">
              <span data-feather="users"></span>
              Crear Cuenta
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Transferir.jsp">
              <span data-feather="send"></span>
              Transferir Dinero
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Prestamo.jsp">
              <span data-feather="dollar-sign"></span>
              Solicitar Prestamo
            </a>
          </li>
          
        </ul>
        
        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span style="font-size: large;">Reportes</span>
          <a class="link-secondary" href="#" aria-label="Add a new report">
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="ListarUsuarios.jsp">
              <span data-feather="file-text"></span>
              Lista de Usuarios
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Reporte de Prestamos
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Movimientos por Concepto
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Usuarios Morosos
            </a>
          </li>
        </ul>

        
      </div>
    </nav>

  </div>
</div>

<script>
      feather.replace()
    </script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>