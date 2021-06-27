<jsp:include page="_base.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE HTML>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas</title>
</head>
<main style="margin-left:20em;">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
	<h2>Cuentas</h2>
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
      
      <form class="row mb-3">
      		<div class="col-auto">
      			<label class="form-label" for="cuentaOrigen">Seleccionar cuenta: </label>
      		</div>
      		<div class="col-auto">
			    <select class="form-select" aria-label="Default select example" name="cuentaOrigen">
				  		<option selected></option>
				  		<option value="1">Cta:Nro. 0001 - Disponible: 14000$</option>
						<option value="2">Cta:Nro. 0002 - Disponible: 0000$</option>
						<option value="3">Cta:Nro. 0003 - Disponible: 0000$</option>
				</select>
			</div>
			<div class="col-auto">
				<input type="submit" name="btnAceptar" class="btn btn-primary" value="Seleccionar cuenta"/>
			</div>
      </form>
      
      
      
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">Tipo de Cuenta</th>
              <th scope="col">Moneda</th>
              <th scope="col">Nro de Cuenta</th>
              <th scope="col">Saldo</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Caja de Ahorro</td>
              <td>$</td>
              <td>0001</td>
              <td>14000</td>
            </tr>
          </tbody>
        </table>
        
       <h4>Ultimos Movimientos</h4>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">Fecha</th>
              <th scope="col">Tipo de Movimiento</th>
              <th scope="col">Detalle</th>
              <th scope="col">Saldo</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>25/06/2021</td>
              <td>Pago Prestasmo</td>
              <td>Pago cuota de prestamo otorgado</td>
              <td>-1000</td>
            </tr>
            <tr>
              <td>22/06/2021</td>
              <td>Transferencia</td>
              <td>Transferencia a cuenta 0002</td>
              <td>-4000</td>
            </tr>
            <tr>
              <td>15/06/2021</td>
              <td>Alta Prestamo</td>
              <td>Prestamo otorgado</td>
              <td>+9000</td>
            </tr>
            <tr>
              <td>14/06/2021</td>
              <td>Alta de cuenta</td>
              <td>Nuevo Usuario</td>
              <td>+10000</td>
            </tr>
          </tbody>
        </table>
      <h4>Saldo actual: 14000</h4>  
      </div>
      </div>
</main>
