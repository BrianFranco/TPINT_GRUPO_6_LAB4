<jsp:include page="_base.jsp" />
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE HTML>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas</title>
</head>

	<%
		Usuario u = new Usuario();
		if(session.getAttribute("Usuario") != null){
			u = (Usuario) session.getAttribute("Usuario");
		}
	
	%>
	
<div style="margin-left:20em;">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"><h2>Cuentas</h2></div>
    <% if (request.getParameter("Param") != null){
    
    	List<Cuenta> listaC = new ArrayList<Cuenta>();
		if (request.getAttribute("listaCuenta") != null) {
			listaC = (List<Cuenta>) request.getAttribute("listaCuenta");
		}
    
    %>
      <form action="servletCuentasUser" method="post">
      	<div class="col-5">
			<label class="form-label" for="cuentaOrigen">Seleccionar cuenta: </label>
			<select class="form-select" aria-label="Default select example" name="cuentaSeleccionada">
				<option selected>Seleccione una cuenta </option>
				<%
					for (Cuenta c : listaC) {
				%>
				<option value="<%=c.getN_Cuenta()%>"><%=c.toStringListaTr()%></option>
				<%
					}
				%>
			</select>
			<input type="hidden" name="idUsuario" value="<%= u.getIdUsuario() %>" />
		</div>
		<br>
		<div class="col-1">
			<input type="submit" name="btnContinuar" class="btn btn-success" value="Continuar"/>
		</div>
      </form>
      <% }else{ 
      
     	List<Movimiento> listaMov = new ArrayList<Movimiento>();
		if (request.getAttribute("listaMov") != null) {
		listaMov = (List<Movimiento>) request.getAttribute("listaMov");
		}
      
      %> 
      <div class="col-8">
		<table class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th scope="col">Cuenta</th>
						<th scope="col">Descripcion</th>
						<th scope="col">Tipo de Movimiento</th>
						<th scope="col">Monto</th>
						<th scope="col">Fecha</th>
					</tr>
				</thead>
				<tbody>
				<%
				for (Movimiento m : listaMov) {
					
				%>
				<tr>
					<form action="servletPagoPestamos" method="post">
						<td><%= m.getCuenta().getN_Cuenta()%></td>
						<td><%= m.getConcepto() %></td>
						<% if(m.getTipoMovimiento().getIDTipoMovimiento().equals("1")){ %>
							<td>Alta de Cuenta</td>
						<% }%>
						<% if(m.getTipoMovimiento().getIDTipoMovimiento().equals("2")){ %>
							<td>Alta de prestamo</td>
						<% }%>
						<% if(m.getTipoMovimiento().getIDTipoMovimiento().equals("3")){ %>
							<td>Pago de prestamo</td>
						<% }%>
						<% if(m.getTipoMovimiento().getIDTipoMovimiento().equals("4")){ %>
							<td>Transferencia</td>
						<% }%>
						<td><%= m.getImporte()%></td>
						<td><%= m.getFecha()%></td>
					</form>
				</tr>
				<%
				}
				%>
		</tbody>
		</table>
		</div>
		<!-- input type="input" class="btn btn-success" name="btnVolver" value="Volver"-->
		<a class="btn btn-info" href="servletCuentasUser?Param=list&id=<%=u.getIdUsuario()%>">Elegir otra cuenta</a>
      <% } %>
</div>
