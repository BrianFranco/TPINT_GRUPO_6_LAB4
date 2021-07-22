package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.MovimientoDaoImpl;
import datosImpl.cuentaDaoImpl;
import entidad.Cuenta;
import entidad.Movimiento;

/**
 * Servlet implementation class ServletsReporteMovimientos
 */
@WebServlet("/ReporteMovimientos")
public class ServletsReporteMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsReporteMovimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnFiltrar") != null) {
			ArrayList<Movimiento> ReporteMFiltrado = new ArrayList<Movimiento>();
			MovimientoDaoImpl dao = new MovimientoDaoImpl();
			String desde = request.getParameter("desde").toString();
			String hasta = request.getParameter("hasta").toString();
			if (!desde.isEmpty() || !hasta.isEmpty()) {
				ReporteMFiltrado = dao.obtenerReporteMovimiento(desde,hasta);
				request.setAttribute("ReporteM", ReporteMFiltrado);
			} else {
				ReporteMFiltrado = dao.obtenerReporteMovimiento();
				request.setAttribute("ReporteM", ReporteMFiltrado);
			}
		}
		else {
			ArrayList<Movimiento> ReporteM = new ArrayList<Movimiento>();
			MovimientoDaoImpl dao = new MovimientoDaoImpl();
			ReporteM = dao.obtenerReporteMovimiento();
			request.setAttribute("ReporteM", ReporteM);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ReporteMovimientos.jsp"); 
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
