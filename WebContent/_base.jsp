<%@ page import="entidad.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://unpkg.com/feather-icons"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<jsp:include page="/Css/Estilos_base.css"></jsp:include>

<%
	Usuario u = new Usuario();
	if(session.getAttribute("Usuario") != null){
		u = (Usuario) session.getAttribute("Usuario");
	}
%>

</head>
<body>
	<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
	  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="_base.jsp" style="font-size: large;">Banco UTN</a>
	  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	    <div class="navbar-nav mr-auto ">
	      <a class="nav-link px-3" >
	      	<span data-feather="user-check"></span>
	      	<%= u.getNombre() %>
	      </a> 
	      <a class="nav-link px-3" href="#">
	      	<span data-feather="user-x"></span>
	      	Cerrar Sesión
	      </a>
	    </div>
	</header>

<div class="container-fluid" style="margin-right: 30px;">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse" style="margin-top: 5px;">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
           <li class="nav-item">
	           <a class="nav-link" aria-current="page" href="Cuentas.jsp">
	            <span data-feather="home"></span>
	             Cuentas
	           </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="DatosPersonales.jsp">
              <span data-feather="users"></span>
              Datos Personales
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
          <li class="nav-item">
          		<a class="nav-link" href="PagoPrestamo.jsp">
          			<span data-feather="edit-3"></span>
          			Pagar prestamos
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