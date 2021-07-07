<%@page import="entidad.Usuario"%>
<jsp:include page="_baseAdministrador.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Contraseña</title>
</head>
<main style="margin-left:20em;">
<% 
	String passAnterior= "";
	passAnterior = (String)request.getSession().getAttribute("passAnterior");  
%>

<% 

	 %>
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		<form method="post" action="ModificarContraseña" class="row g-3">
		  <div class="col-md-3">
		    <label for="nombre" class="form-label">Contraseña Anterior</label>
		    <input type="text" disabled="disabled" class="form-control" id="nombre" value="<%=passAnterior%>">
		  </div>
		  <div class="col-md-3">
		    <label for="apellido" class="form-label">Nueva Contraseña</label>
		    <input name="txtPassword" type="text" class="form-control" id="apellido" value="">
		  </div >
		  <hr>
		  <div class="col-md-6">
		  	<input type="submit" class="btn btn-primary" name="btnModificar" class="btn btn-black" value="Modificar">
		  </div>
		  
		</form>
		</div>
</main>