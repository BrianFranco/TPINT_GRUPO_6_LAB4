<%@page import="entidad.Cuenta" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="_baseAdministrador.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABML de Cuentas</title>
</head>

<main style="margin-left:20em;">
	
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom border-top my-3">
		<h2>Generar una nueva Cuenta</h2>
	</div>		
	<form class="row mb-3 mx-1" action="servletCuenta" method="post">
		<div class="col input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Id Usuario</span>
			<input type="text" class="form-control" name="idUsuario" placeholder="Id Usuario">
		</div>
		<div class="col input-group mb-3">
			<span class="input-group-text" id="basic-addon1">CBU</span>
			<input type="text" class="form-control" name="nroCBU" placeholder="CBU">
		</div>
		<div class="col">
			<select class="form-select" name="comboCuenta">
				<option selected>Elija un tipo de cuenta</option>
				<option value="1">Cuenta Corriente</option>
				<option value="2">Caja de ahorro</option>
			</select>
		</div>
		<div class="row"></div>
		<div class="col input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Saldo</span>
			<input type="text" class="form-control" disabled="disabled" name="saldo" value="10000">
		</div>  
		<div class="col input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Fecha</span>
			<input type="text" class="form-control" disabled="disabled" name="fecha" value="<%= java.time.LocalDate.now() %>">
		</div>  			
	    <div class="col-auto">
			<input type="submit" name="btnGenerar" class="btn btn-primary" value="Generar Cuenta"/>
		</div>
	</form>
	
	<% if (request.getAttribute("msjGenerar") != null){ 	
        	 %>
        	 	<div class="alert alert-secondary" role="alert">
        	 		<%=request.getAttribute("msjGenerar")%>
				</div>
       		<%	}%>
			
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom border-top my-3">
		<h2>Listado de cuentas</h2>
	</div>	
      
        
       <form class="row mb-3" method="post" action="servletCuenta" >            		
      		<div class="col-auto">
      			<label class="form-label" for="cuentaOrigen">Filtrar por tipo de cuenta: </label>
      		</div>
      		<div class="col-auto">
			    <select class="form-select" aria-label="Default select example" name="cuentaOrigen">
				  		<option value ="0" selected>Elegir cuenta</option>
				  		<option value="2">Caja de Ahorro</option>
						<option value="1">Cuenta Corriente</option>						
				</select>
			</div>	
			<div class="col-auto">
      			<label class="form-label" for="cuentaOrigen">Filtrar por Cliente Numero: </label>
      		</div>
			<div class="col-auto">
			    	<input type="text" class="form-control" name="cliente">			    	
			</div>	
			<div class="col-auto">
				<input class="form-control" type="submit" name="btnListar" value="Listar" />
			</div>
		</form>			
		
			<% if (request.getAttribute("msjTabla") != null){ 	
        	 %>
        	 	<div class="alert alert-secondary" role="alert">
        	 		<%=request.getAttribute("msjTabla")%>
				</div>
       		<%	}%>
				
				
				<div class="table-responsive"> 
				<% 
				ArrayList<Cuenta> listaCuentas = null;
				if(session.getAttribute("listaC")!=null)
				{
					listaCuentas = (ArrayList<Cuenta>) session.getAttribute("listaC");
				}
				%>
				
				<table class="table table-striped table-hover">
				<caption> Resultado de busqueda </caption>
				<thead class="table-dark">
					<tr>
						<th scope="col">Numero de Cuenta</th>
						<th scope="col">Fecha de creacion</th>
						<th scope="col">Id de Usuario</th>
						<th scope="col">Tipo Cuenta</th>
						<th scope="col">CBU</th>
						<th scope="col">Saldo</th>
						<th scope="col">Activo</th>
					</tr>
				</thead>
				<tbody>
				
				<%  if(listaCuentas!=null)
				for(Cuenta cu : listaCuentas) 
				{
				%>
				<tr>
					<form name="formulario" action="servletCuenta" method="post">
					
									<%
									if(request.getAttribute("N_cuentaModificable")!=null && request.getAttribute("N_cuentaModificable").equals(cu.getN_Cuenta())){
									%>
									<td><input type="text" name="n_cuenta" value="<%=cu.getN_Cuenta()%>"/> </td>
							    	<td><input type="date" name="fecha" value="<%=cu.getFecha()%>"/> </td> 
									<td><input type="text" name="id_usuario" value="<%=cu.getIdUsuario()%>"/></td>									 									  								
									<td> <select name="comboCuenta">
											<%if(cu.getTipoCuenta().getIDTipoCuenta()==1){ %>
												<option value="1" selected>Cuenta Corriente</option>
												<option value="2">Caja de ahorro</option>												
											<% }else{%>											    
												<option value="1">Cuenta Corriente</option>
												<option value="2" selected>Caja de ahorro</option>
											<% }%>
											</select></td>
									<td> <input type="text" name="CBU" value="<%=cu.getCBU()%>"/> </td>
									<td> <input type="text" name="Saldo" value="<%=cu.getSaldo()%>"/> </td>
									<td> <select name="activo">
											<%if(cu.getActivo() == 1){ %>
												<option value="1" selected>1</option>
												<option value="0">0</option>
											<% }else{%>
												<option value="1">1</option>
												<option value="0" selected>0</option>
											<% }%>
											</select> </td>
									
									<td> <input type="submit" class="btn btn-info" name="btnGuardar" value="Guardar"> </td>
									<td> <input type="submit" class="btn btn-danger" name="btnCancelar" value="Cancelar"> </td>   
									
									<% }else{%>
									<td><%=cu.getN_Cuenta() %><input type="hidden" name="n_cuenta" value="<%=cu.getN_Cuenta()%>"/> </td>
							    	<td> <%=cu.getFecha() %> </td> 
									<td> <%=cu.getIdUsuario() %> </td>   
									<td> <%=cu.getTipoCuenta().getDescripcion() %> </td>
									<td><%=cu.getCBU() %></td>
									<td><%=cu.getSaldo() %></td>
									<td><%=cu.getActivo() %></td>
									
									<td> <input type="submit" class="btn btn-info" name="btnModificar" value="Modificar"> </td>
									<%if(cu.getActivo() == 1){ %>
									<td> <input type="submit" class="btn btn-danger" name="btnEliminar" value="Eliminar"> </td>   
									<%} %>
							
								<%}	%>
					</form>
			</tr>
		<%  } %>

				</tbody>
				</table>
			</div>
</main>
