<%@page import="entidad.Usuario"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="_baseAdministrador.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABML de Clientes</title>
<style>
table {
  border-collapse: collapse;
  width: 20%;
}

th, td {
  text-align: center;
  padding: 3px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: black;
  color: white;
}
</style>
</head>
<div style="margin-left:20em">
	<span>
		<h3>Registrar cliente</h3>
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">	
		<form method="post" action="ABMLClientes" class="row g-3">
		  <div class="col-md-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input name="txtNombre" type="text" class="form-control" id="nombre" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="apellido" class="form-label">Apellido</label>
		    <input name="txtApellido" type="text"  class="form-control" id="apellido" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="fechaNac" class="form-label">Fecha de nacimiento</label>
		    <input name="txtFechaNac" type="text" class="form-control" id="fechaNac" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="dni" class="form-label">DNI</label>
		    <input name="txtDni" type="text" class="form-control" id="dni" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="cuil" class="form-label">CUIL</label>
		    <input name="txtCuil" type="text" class="form-control" id="cuil" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="genero" class="form-label">Genero</label>
		    <input name="txtGenero" type="text" class="form-control" id="genero" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="nacionalidad" class="form-label">Nacionalidad</label>
		    <input name="txtNacionalidad" type="text" class="form-control" id="nacionalidad" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="direccion" class="form-label">Direccion</label>
		    <input name="txtDireccion" type="text" class="form-control" id="direccion" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="localidad" class="form-label">Localidad</label>
		    <input name="txtLocalidad" type="text" class="form-control" id="localidad" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="provincia" class="form-label">Provincia</label>
		    <input name="txtProvincia" type="text" class="form-control" id="provincia" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="correo" class="form-label">Correo</label>
		    <input name="txtEmail" type="text" class="form-control" id="correo" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="telefono" class="form-label">Telefono</label>
		    <input name="txtTelefono" type="text" class="form-control" id="telefono" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="usuario" class="form-label">Nombre de Usuario</label>
		    <input name="txtNombreUsuario" type="text" class="form-control" id="usuario" value="">
		  </div>
		  <div class="col-md-3">
		    <label for="password" class="form-label">Contraseña</label>
		    <input name="txtPassword" type="password"  class="form-control" id="password" value="">
		  </div>
		  <hr>
		  <div>
		  	<input type="submit" name="btnRegistrar" value="Registrar" style="margin-top:1em;" class="btn btn-primary">
		  </div>	
		</form>	 
		</div>
</div>
<div style="margin-left:20em;margin-top:2em;">
	<h3>Clientes</h3>
	<a class="btn btn-primary" href="ABMLClientes?Param=list">Mostrar Usuarios</a>
	<% 
	ArrayList<Usuario> listaUsuarios = null;
	if(request.getAttribute("listaU")!=null)
	{
		listaUsuarios = (ArrayList<Usuario>) request.getAttribute("listaU");
	}
	
	 %>
	 <hr>
	<table border="1" class="display">
		<tr> <th>ID</th>  <th>Nombre</th>  <th>Apellido</th>  <th></th> <th></th> </tr>
		
		<% 			
		if(listaUsuarios!=null)
			for(Usuario user : listaUsuarios) 
			{
			if(user.getActivo() == 1) {
		%>
		<tr>  
			<form name="formulario" action="ABMLClientes?idUsuario=<%=user.getIdUsuario()%>" method="get">
				<td><%=user.getIdUsuario() %>    <input type="hidden" name="idUsuario" value="<%=user.getIdUsuario()%>"> </td> 
				<td><%=user.getNombre() %></td>   
				<td><%=user.getApellido() %></td>
				<td> <input type="submit" class="btn btn-danger" name="btnEliminar" value="Eliminar"> </td>  
				<td> <input type="submit" class="btn btn-info" name="btnModificar" value="Modificar Contraseña"> </td>  
			</form> 
		</tr>
		<%  } %>
		<%  } %>
	</table>

</div>
