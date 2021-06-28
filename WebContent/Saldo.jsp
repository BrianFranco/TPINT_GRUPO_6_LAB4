<jsp:include page="_base.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saldo</title>
</head>
<main style="margin-left:20em;">
	<h2>Saldo Actual</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">Tipo de Cuenta</th>
              <th scope="col">Moneda</th>
              <th scope="col">Nro de Cuenta</th>
              <th scope="col">Saldo</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Caja de Ahorro</td>
              <td>$</td>
              <td>999999999999</td>
              <td>8354.64</td>
              <td><button type="submit" name="btnAceptar" class="btn btn-primary">Ver ultimos movimientos</button></td>
            </tr>
          </tbody>
        </table>
        
       <h2>Ultimos Movimientos</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">Fecha</th>
              <th scope="col">Tipo de Movimiento</th>
              <th scope="col">Saldo</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>25/06/2021</td>
              <td>Extraccion Cajero</td>
              <td>-2000</td>
            </tr>
            <tr>
              <td>24/06/2021</td>
              <td>Deposito</td>
              <td>+6000</td>
            </tr>
            <tr>
              <td>22/06/2021</td>
              <td>Transferencia</td>
              <td>-4000</td>
            </tr>
            <tr>
              <td>19/06/2021</td>
              <td>Extraccion Cajero</td>
              <td>-4000</td>
            </tr>
            <tr>
              <td>19/06/2021</td>
              <td>Transferencia</td>
              <td>-6000</td>
            </tr>
            <tr>
              <td>15/06/2021</td>
              <td>Deposito</td>
              <td>+9000</td>
            </tr>
            <tr>
              <td>14/06/2021</td>
              <td>Deposito</td>
              <td>+4000</td>
            </tr>
          </tbody>
        </table>
      <h4>Saldo actual: 8354.64</h4>  
      </div>
      </div>
</main>
