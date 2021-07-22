<jsp:include page="_baseAdministrador.jsp"></jsp:include>
<%@page import="entidad.Prestamo" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autorizacion de Prestamos</title>
</head>
<div style="margin-left:20em;">
	<h2>Prestamos pendientes de Autorizacion</h2>
	
	<form class="row mb-3" method="post" action="ServletAutorizacionPrestamos">
		<div class="col-auto">
      			<label class="form-label" for="cuentaOrigen">Filtrar por IdUsuario: </label>
      		</div>
      		<div class="col-auto">
			    	<input type="text" class="form-control" name="cliente">			    	
			</div>
		<div class="col-auto">
				<input class="form-control" type="submit" name="btnListar" value="Listar" />
			</div>
	</form>
	
	<%
	ArrayList<Prestamo> listaPrestamos = null;
	if(session.getAttribute("listaPrestamos") != null)
	{
		listaPrestamos = (ArrayList<Prestamo>) session.getAttribute("listaPrestamos");
	}
	%>
	<div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">IdUsuario</th>
              <th scope="col">Cuenta a depositar</th>
              <th scope="col">Monto de Prestamo</th>
              <th scope="col">Monto a pagar con intereses</th>
              <th scope="col">Cuotas elegidas</th>
              <th scope="col">Mostrar informacion</th>
              <th scope="col">Autorizar Prestamo</th>
              <th scope="col">Rechazar Prestamo</th>
            </tr>
          </thead>
          <tbody>
          <%  	if(listaPrestamos != null)
				for(Prestamo p : listaPrestamos) 
				{
					if(p.getEstado() == 1){
				%>
          		<form name="prestamo" action="ServletAutorizacionPrestamos" method="post">
		            <tr>
		              <td><%=p.getIdUsuario() %><input type="hidden" name="n_usuario" value="<%=p.getIdUsuario() %>" /></td>
		              <td><%=p.getIdCuenta() %><input type="hidden" name="n_cuenta" value="<%=p.getIdCuenta() %>" /></td>
		              <td><%=p.getMontoSolicitado() %><input type="hidden" name="saldo" value="<%=p.getMontoSolicitado() %>" /></td>
		              <td><%=p.getMontoFinal() %></td>
		              <td><%=p.getCantCuotas() %></td>
		              <input type="hidden" name="n_prestamo" value="<%=p.getIdPrestamo() %>" />
		              <td><input type="submit" name="btnMostrarInformacion" value="Mostrar mas informacion" class="btn btn-primary"></td>
		              <td><input type="submit" name="btnAutorizarPrestamo" value="Autorizar el prestamo" class="btn btn-primary"></td>
		              <td><input type="submit" name="btnRechazarPrestamo" value="Rechazar Prestamo" class="btn btn-primary"></td>
		            </tr>
            	</form>
            	<%} %>
            <%} %>
          </tbody>
        </table>
      </div>
      <% if (request.getAttribute("MsjPrestamo") != null){ 	
        	 %>
        	 	<div class="alert alert-secondary" role="alert">
        	 		<%=request.getAttribute("MsjPrestamo")%>
				</div>
       		<%}%>
      
      <%
      	
      	if(request.getAttribute("usuarioHistorial") != null)
      		if(!request.getAttribute("usuarioHistorial").equals("0")){	
      %>
      <h4>Historial de Prestamos del Cliente</h4>
      <div class="table-responsive">
      	<table class="table table-striped table-sm">
      		<thead>
      		<tr>
      				<th scope="col">Fecha de Inicio</th>
      				<th scope="col">Monto de Prestamo</th>
      				<th scope="col">Monto de total a pagar</th>
      				<th scope="col">Cuotas Restantes</th>
      				<th scope="col">Cuotas totales</th>
      				<th scope="col">Valor de cuota</th>
      				<th scope="col">Valor restante a pagar</th>
      		</tr>
      		</thead>
      		<tbody>
      		<%  if(listaPrestamos!=null)
				for(Prestamo p : listaPrestamos) {
					if(p.getIdUsuario()==Integer.parseInt((request.getAttribute("usuarioHistorial").toString())))
					if(p.getEstado() == 2){
				%>
      		<tr>
      			<td> <%=p.getFecha()%> </td>
      			<td> <%=p.getMontoSolicitado()%> </td>
      			<td> <%=p.getMontoFinal() %> </td>
      			<td> <%=p.getRestCuotas() %> </td>
      			<td> <%=p.getCantCuotas()%> </td>
      			<td> <%=p.getMontoCuotas()%> </td>
      			<td> <%=p.getRestCuotas() * p.getMontoCuotas() %> </td>
      		</tr>
      			<%}
      		}%>
      		</tbody>
      	</table>
      </div>
      <%}else{ %>
     	<div class="alert alert-secondary" role="alert">
        Este usuario aun no tiene historial de prestamos.</div>
      <%} %>
</div>