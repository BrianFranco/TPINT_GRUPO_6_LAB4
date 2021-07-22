<%@ page import="entidad.Usuario" %>
<jsp:include page="_base.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Personales</title>
<%
	Usuario u = new Usuario();
	if(session.getAttribute("Usuario") != null){
		u = (Usuario) session.getAttribute("Usuario");
	}
%>

</head>
<main style="margin-left:20em;">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
<h2>Datos Personales</h2>
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		<form class="row g-3">
		  <div class="col-md-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" disabled="disabled"  class="form-control" id="nombre" value=<%=u.getNombre() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="apellido" class="form-label">Apellido</label>
		    <input type="text" disabled="disabled" class="form-control" id="apellido" value=<%=u.getApellido() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="fechaNac" class="form-label">Fecha de nacimiento</label>
		    <input type="text" disabled="disabled" class="form-control" id="fechaNac" value=<%=u.getFechaNac() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="dni" class="form-label">DNI</label>
		    <input type="text" class="form-control" id="dni" disabled="disabled" value=<%=u.getDni() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="cuil" class="form-label">CUIL</label>
		    <input type="text" class="form-control" id="cuil" disabled="disabled" value=<%=u.getCuil() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="genero" class="form-label">Genero</label>
		    <input type="text" class="form-control" id="genero" disabled="disabled" value=<%=u.getGenero() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="nacionalidad" class="form-label">Nacionalidad</label>
		    <input type="text" class="form-control" id="nacionalidad" disabled="disabled" value=<%=u.getNacionalidad() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="direccion" class="form-label">Direccion</label>
		    <input type="text" class="form-control" id="direccion" disabled="disabled" value=<%=u.getDireccion() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="localidad" class="form-label">Localidad</label>
		    <input type="text" class="form-control" id="localidad" disabled="disabled" value=<%=u.getLocalidad() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="provincia" class="form-label">Provincia</label>
		    <input type="text" class="form-control" id="provincia" disabled="disabled" value=<%=u.getProvincia() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="correo" class="form-label">Correo</label>
		    <input type="text" class="form-control" id="correo" disabled="disabled" value=<%=u.getEmail() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="telefono" class="form-label">Telefono</label>
		    <input type="text" class="form-control" id="telefono" disabled="disabled" value=<%=u.getTelefono() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="usuario" class="form-label">Nombre de Usuario</label>
		    <input type="text" class="form-control" id="usuario" disabled="disabled" value=<%=u.getNomUsuario() %>>
		  </div>
		  <div class="col-md-3">
		    <label for="password" class="form-label">Contraseña</label>
		    <input type="password" disabled="disabled" class="form-control" id="password" value=<%= u.getContraseña() %>>
		  </div>
		  <hr>
		</form>
</main>
