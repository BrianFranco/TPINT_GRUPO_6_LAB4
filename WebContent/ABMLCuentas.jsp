<%@ page import="entidad.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
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
			
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom border-top my-3">
		<h2>Listado de cuentas</h2>
	</div>	
      
      <div class="table-responsive">   
       <form class="row mb-3" method="post" action="servletCuenta" >            		
      		<div class="col-auto">
      			<label class="form-label" for="cuentaOrigen">Filtrar por tipo de cuenta: </label>
      		</div>
      		<div class="col-auto">
			    <select class="form-select" aria-label="Default select example" name="cuentaOrigen">
				  		<option selected></option>
				  		<option value="1">Caja de Ahorro</option>
						<option value="2">Cuenta Corriente</option>						
				</select>
			</div>	
			<div class="col-auto">
      			<label class="form-label" for="cuentaOrigen">Filtrar por Cliente Numero: </label>
      		</div>
      	
			    <div class="col-auto">
			    	<input type="text" class="form-control" id="cliente">			    	
				</div>	
						
			<div style="margin-left:20em;margin-top:2em;">
	<h3>Cuentas</h3>
	<a class="btn btn-primary" href="ABMLCuentas?Param=list">Mostrar Cuentas</a>
	<% 
	ArrayList<Cuenta> listaCuentas = null;
	if(request.getAttribute("listaU")!=null)
	{
		listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listaC");
	}
	
	 %>
	 <hr>
	<table border="1" class="display">
		<tr> <th>Numero de Cuenta</th> <th>idUsuario</th> <th>Tipo Cuenta</th> <th>CBU</th> <th>Saldo</th> <th></th> <th></th> </tr>
		
		<% 			
		if(listaCuentas!=null)
			for(Cuenta cu : listaCuentas) 
			{
			if(cu.getActivo() == 1) {
		%>
		<tr>  
			<form name="formulario" action="ABMLCuentas?N_Cuenta=<%=cu.getN_Cuenta()%>" method="get">
				<td><%=cu.getN_Cuenta() %>    <input type="hidden" name="idUsuario" value="<%=cu.getN_Cuenta()%>"> </td> 
				<td><%=cu.getIdUsuario() %></td>   
				<td><%=cu.getTipoCuenta() %></td>
				<td><%=cu.getCBU() %></td>
				<td><%=cu.getSaldo() %></td>
				<td> <input type="submit" class="btn btn-danger" name="btnEliminar" value="Eliminar"> </td>  
				<td> <input type="submit" class="btn btn-info" name="btnModificar" value="Modificar"> </td>  
			</form> 
		</tr>
		<%  } %>
		<%  } %>
	</table>

</div>
</main>
