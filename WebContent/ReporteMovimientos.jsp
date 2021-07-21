<jsp:include page="_baseAdministrador.jsp" />
<%@ page import="entidad.Cuenta" %>
<%@ page import="entidad.Movimiento" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="datosImpl.MovimientoDaoImpl" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte de Movimientos</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/jquery-ui.css">
<script type="text/javascript">
$(function() {
    $('.month_year').datepicker({
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        dateFormat: 'yy-mm',
        onClose: function(dateText, inst) { 
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
        }
    }).focus(function () {
        $(".ui-datepicker-calendar").hide();
    });
});
    </script>

</head>
<main style="margin-left:20em;">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"></div>
<h2>Movimientos por Concepto</h2>
<form class="row g-3" method="get" action="ReporteMovimientos">
		<div class="col-md-3">
		    <label for="datepicker" >Desde</label>
		    <input  name="desde"  class="form-control month_year" id="datepicker" placeholder="mm/yyyy" >
		  </div>
		  <div style="margin-left:15px;" class="col-md-3">
		    <label for="datepicker2" >Hasta</label>
		    <input  name="hasta" class="form-control month_year" id="datepicker2" placeholder="mm/yyyy" >
		  </div>
		  <div style="margin-left:25px;" class="col-md-3">
		  	<input type="submit" name="btnFiltrar" value="Filtrar" style="margin-top:1em;" class="btn btn-primary">
		  </div>
	</form>
	
	<hr>
	<% 
	ArrayList<Movimiento> listaMovimientos = null;
	if(request.getAttribute("ReporteM")!=null)
	{
		listaMovimientos = (ArrayList<Movimiento>) request.getAttribute("ReporteM");
	}
	

	 %>
	 
	 <table class="table table-striped table-sm">
		<tr> <th>Año</th>  <th>Mes</th>  <th>Concepto</th>  <th>Importe</th> </tr>
		
		<% 			
		if(listaMovimientos!=null)
			for(Movimiento mov : listaMovimientos) 
			{
		%>
		<tr>  
				<td><%=mov.getFecha().split("-")[0] %></td>
				<td><%=mov.getFecha().split("-")[1] %></td> 
				<td><%=mov.getConcepto() %></td>   
				<td><%=mov.getImporte() %></td>   
		</tr>
		<%  } %>
	</table>

</main>
