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
       <form class="row mb-3">            		
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
      			<label class="form-label" for="cuentaOrigen">Filtrar por Cliente Número: </label>
      		</div>
      	
			    <div class="col-auto">
			    	<input type="text" class="form-control" id="cliente">			    	
				</div>	
						
			<div class="col-auto">
				<input type="submit" name="btnFiltrar" class="btn btn-primary" value="Filtrar"/>
			</div>
					
      </form>  
      		
        
       <h4>Cuentas</h4>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">Cliente</th>
              <th scope="col">Cuenta</th>
              <th scope="col">Tipo de Cuenta</th>
              <th scope="col">Saldo</th>              
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>000001</td>
              <td>666666666666</td>
              <td>Cuenta Corriente</td>
              <td>15634</td>
              <td><input type="submit" name="btnModificar" class="btn btn-info" value="Modificar"/></td>
              <td><input type="submit" name="btnEliminar" class="btn btn-danger" value="Eliminar"/></td>
            </tr>
            <tr>
              <td>000002</td>
              <td>777777777777</td>
              <td>Caja de Ahorro</td>
              <td>-3500</td>
              <td><input type="submit" name="btnModificar" class="btn btn-info" value="Modificar"/></td>
              <td><input type="submit" name="btnEliminar" class="btn btn-danger" value="Eliminar"/></td>
            </tr>
            <tr>
              <td>000003</td>
              <td>888888888888</td>
              <td>Cuenta Corriente</td>
              <td>759000</td>              
              <td><input type="submit" name="btnModificar" class="btn btn-info" value="Modificar"/></td>
              <td><input type="submit" name="btnEliminar" class="btn btn-danger" value="Eliminar"/></td>
            </tr>
            <tr>
              <td>000004</td>
              <td>999999999999</td>
              <td>Caja de Ahorro</td>
              <td>24300</td>
              <td><input type="submit" name="btnModificar" class="btn btn-info" value="Modificar"/></td>
              <td><input type="submit" name="btnEliminar" class="btn btn-danger" value="Eliminar"/></td>
            </tr>                                   
          </tbody>
        </table>      
      </div>
      </div>
</main>
