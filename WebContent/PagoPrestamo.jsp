<jsp:include page="_base.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.*"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagar Prestamos</title>
</head>
	<%
		Usuario u = new Usuario();
		if(session.getAttribute("Usuario") != null){
			u = (Usuario) session.getAttribute("Usuario");
		}
	
		HttpSession s=request.getSession();
		int id=(Integer)(s.getAttribute("Id"));
		
		//List<Prestamo> listaP = new ArrayList<Prestamo>();
		//if (request.getAttribute("listaPrestamo") != null) {
		//	listaP = (List<Prestamo>) request.getAttribute("listaPrestamo");
		//}
		
	%>

	<div class="main" style="margin-left:20em;">
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"><h1>Pagar cuotas de prestamos</h1></div>
	<% if (request.getParameter("Param") != null){ 
	
	List<Cuenta> listaC = new ArrayList<Cuenta>();
	if (request.getAttribute("listaCuenta") != null) {
		listaC = (List<Cuenta>) request.getAttribute("listaCuenta");
	}
	
	%>
	<form action="servletPagoPestamos" method="post">
		<div class="col-12">
			<label class="form-label" for="cuentaOrigen">Seleccionar cuenta: </label>
			<select class="form-select" aria-label="Default select example" name="cuentaOrigen">
				<option selected>Selecciones una cuenta </option>
				<%
					for (Cuenta c : listaC) {
						if(c.getActivo()==1){
				%>
				<option value="<%=c.getN_Cuenta()%>"><%=c.toStringListaTr()%></option>
				<%
					}
					}
				%>
			</select>
		</div> 
		  <input type="hidden" name="idUsuario" value="<%= u.getIdUsuario() %>" />
		  <div class="col-1 mt-2">
				<input class="form-control btn-success" type="submit" name="btnContinuar" value="Continuar" />
			</div>
		</form>
		<%}else{ 
		
		List<Prestamo> listaP = new ArrayList<Prestamo>();
		if (request.getAttribute("listaPr") != null) {
			listaP = (List<Prestamo>) request.getAttribute("listaPr");
		}
		
		%>
		<div class="col-8">
		<table class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th scope="col">Id del prestamo</th>
						<th scope="col">Monto solicitado</th>
						<th scope="col">Valor de las cuotas</th>
						<th scope="col">Cuotas a pagar</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
				<%
				for (Prestamo p : listaP) {
				if(p.getRestCuotas() != 0 && p.getEstado()==2){
				%>
				<tr>
					<form action="servletPagoPestamos" method="post">
						<td><input type="hidden" name="idPrestamo" value="<%= p.getIdCuenta() %>"><%= p.getIdCuenta() %></td>
						<td><input type="hidden" name="montoSolic" value="<%= p.getMontoSolicitado() %>"><%= p.getMontoSolicitado() %></td>
						<td><input type="hidden" name="valorCuota" value="<%= p.getMontoCuotas() %>"><%= p.getMontoCuotas() %></td>
						<td>
							<select class="form-select" aria-label="Default select example" name="cuotasPagar">
							<option selected>0</option>
							<%
								for (int i=1; i<=p.getRestCuotas() ; i++) {
							%>
								<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
						</select>
						</td>
						<td>
							<input class="btn btn-success" type="submit" name="btnPagar" value="Pagar"></td>
						</td>
					</form>
				</tr>
				<%
				}}
				%>
		</tbody>
		</div> 
		<%}%>
		<br/>
		
			<!--table border="1">
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
			</table-->
			
			<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
		</div>
