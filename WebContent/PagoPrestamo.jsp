<jsp:include page="_base.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagar Prestamos</title>
</head>
	<div class="main" style="margin-left:20em;">
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
	<h1>Pagar cuotas de prestamos</h1>
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		<div class="col-12">
		<label class="form-label">Cuenta a debitar</label>
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Seleccione la cuenta</option>
			  <option value="1">Cta:Nro. 0001 - Disponible: 0000$</option>
			  <option value="2">Cta:Nro. 0002 - Disponible: 0000$</option>
			  <option value="3">Cta:Nro. 0003 - Disponible: 0000$</option>
			</select>
		  </div>
		  <div class="col-12">
		<label class="form-label">Prestamos a pagar</label>
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Seleccione la cuenta</option>
			  <option value="1">Prestamo: Nro. 0001</option>
			  <option value="2">Prestamo: Nro. 0002</option>
			  <option value="3">Prestamo: Nro. 0003</option>
			</select>
		  </div>
			<br/>
			<table border="1">
				<tr >
					<th>
						<label>Nro de Cuota</label>
					</th>
					<th>
						<label>Valor</label>
					</th>
					<th>
						Pagar
					</th>
				</tr>
				<tr>
					<td>
						<label>1</label>
					</td>
					<td>
						<label>1000</label>
					</td>
					<td>
						<input type="submit" class="btn btn-primary"value="Pagar" name="btnPagar"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>2</label>
					</td>
					<td>
						<label>1000</label>
					</td>
					<td>
						<input type="submit" class="btn btn-danger"value="Pagar" name="btnPagar"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>3</label>
					</td>
					<td>
						<label>1000</label>
					</td>
					<td>
						<input type="submit" class="btn btn-danger"value="Pagar" name="btnPagar"/>
					</td>
				</tr>
			</table>
			
			<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		</div>