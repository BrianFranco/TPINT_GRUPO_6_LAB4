package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.cuentaDao;
import datosImpl.cuentaDaoImpl;
import entidad.Cuenta;
import negocio.cuentaNeg;
import negocioImpl.cuentaNegImpl;
import javax.servlet.RequestDispatcher;
//import presentacion.controller.RequestDispatcher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Servlet implementation class servletCuenta
 */
@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	cuentaNeg negCuenta = new cuentaNegImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnGenerar")!=null) {
			Cuenta x = new Cuenta();
			x.setCBU(request.getParameter("nroCBU"));
			x.setTipoCuenta(request.getParameter("comboCuenta"));
			x.setActivo(true);
			x.setSaldo(request.getParameter("saldo"));
			x.setFecha(request.getParameter("fecha"));
			
			negCuenta.insertar(x);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLCuentas.jsp");
			dispatcher.forward(request, response);
			
			if(request.getParameter("btnListar")!=null) {
			
				cuentaDaoImpl cdao = new cuentaDaoImpl();
				ArrayList<Cuenta> lista = cdao.obtenerTodos();
				
				request.setAttribute("listaC", lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
				rd.forward(request, response);
			}
		}
	}

}
