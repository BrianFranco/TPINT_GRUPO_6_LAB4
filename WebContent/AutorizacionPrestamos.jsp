<jsp:include page="_baseAdministrador.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autorizacion de Prestamos</title>
</head>
<div style="margin-left:20em;">
	<h2>Prestamos pendientes de Autorizacion</h2>
	
	<div class="table-responsive">
		<form>
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">Nombre</th>
              <th scope="col">Apellido</th>
              <th scope="col">Cuenta</th>
              <th scope="col">Monto de Prestamo</th>
              <th scope="col">Cuotas elegidas</th>
              <th scope="col">Prestamos Anteriores</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Ignacio</td>
              <td>Keegan</td>
              <td>10002</td>
              <td>100000</td>
              <td>36</td>
              <td>250000.00</td>
              <td><input type="submit" value="Autorizar" class="btn btn-primary"></td>
            </tr>
            <tr>
              <td>Noel</td>
              <td>Treverton</td>
              <td>10005</td>
              <td>200000</td>
              <td>36</td>
              <td>100000.00</td>
              <td><input type="submit" value="Autorizar" class="btn btn-primary"></td>
            </tr>
          </tbody>
        </table>
        
        </form>
      </div>
</div>