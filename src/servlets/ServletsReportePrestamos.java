package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.cuentaDaoImpl;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.Prestamo;
import entidad.Usuario;

/**
 * Servlet implementation class ServletsReportePrestamos
 */
@WebServlet("/ReportePrestamos")
public class ServletsReportePrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsReportePrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnFiltrar") != null) {
			ArrayList<Cuenta> ReporteUFiltrado = new ArrayList<Cuenta>();
			cuentaDaoImpl dao = new cuentaDaoImpl();
			String desde = request.getParameter("desde").toString();
			String hasta = request.getParameter("hasta").toString();
			if (!desde.isEmpty() || !hasta.isEmpty()) {
				ReporteUFiltrado = dao.obtenerTodosConPrestamos(desde,hasta);
				request.setAttribute("ReporteC", ReporteUFiltrado);
			} else {
				ReporteUFiltrado = dao.obtenerTodosConPrestamos();
				request.setAttribute("ReporteC", ReporteUFiltrado);
			}


		} else {
			ArrayList<Cuenta> ReporteC = new ArrayList<Cuenta>();
			cuentaDaoImpl dao = new cuentaDaoImpl();
			ReporteC = dao.obtenerTodosConPrestamos();
			request.setAttribute("ReporteC", ReporteC);

		}
		if (request.getParameter("btnMostrar")!=null) {
			Cuenta c = new Cuenta();
			String id = request.getParameter("idCuenta").toString();
			ArrayList<Prestamo> listaP = new ArrayList<Prestamo>();
			cuentaDaoImpl dao = new cuentaDaoImpl();
			c.setN_Cuenta(id);
			listaP = dao.obtenerTodosPrestamos(c.getN_Cuenta());
			request.setAttribute("ReporteP", listaP);

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportePrestamos.jsp"); 
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
