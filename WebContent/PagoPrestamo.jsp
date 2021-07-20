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
		
		List<Prestamo> listaP = new ArrayList<Prestamo>();
		if (request.getAttribute("listaPrestamo") != null) {
			listaP = (List<Prestamo>) request.getAttribute("listaPrestamo");
		}
	%>

	<div class="main" style="margin-left:20em;">
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
	<h1>Pagar cuotas de prestamos</h1>
	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
	<form action="servletPagoPestamos" method="post">
		<div class="col-12">
		<label class="form-label">Elija el prestamo a pagar</label>
		    <select class="form-select" aria-label="Default select example" name="prestamoSelec">
				<option selected>Seleccione un prestamo </option>
				<%
					for (Prestamo p : listaP) {
				%>
				<option value="<%=p.getIdCuenta()%>"><%=p.toStringList()%></option>
				<%
					}
				%>
			</select>
		  </div>
		  <a href="servletPagoPestamos?Param=list2&cu=<%=request.getParameter("prestamoSelec")%>&id=<%=u.getIdUsuario() %>" class="btn btn-success">Continuar</a>
		</form>
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