
<jsp:include page="_baseAdministrador.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABML de Cuentas</title>
</head>

<main style="margin-left:20em;">
	
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
	<h2>Generar una nueva Cuenta</h2>
	
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		
	<form class="row mb-3">
      		<div class="col-auto">
      			<label class="form-label" for="cuentaOrigen">Ingrese Número de Cliente: </label>
      		</div>
      		<div class="col-auto">
			    <input type="text" class="form-control" id="cliente">
			</div>
			
      </form>
      
      <form class="row mb-3">            		
      		<div class="col-auto">
      			<label class="form-label" for="cuentaOrigen">Seleccionar tipo de cuenta: </label>
      		</div>
      		<div class="col-auto">
			    <select class="form-select" aria-label="Default select example" name="cuentaOrigen">
				  		<option selected></option>
				  		<option value="1">Caja de Ahorro</option>
						<option value="2">Cuenta Corriente</option>						
				</select>
			</div>			
      </form>        
      
      <div class="col-auto">
				<input type="submit" name="btnGenerar" class="btn btn-primary" value="Generar Cuenta"/>
			</div><br>
			
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
	<h2>Listado de Cuentas</h2>
      
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