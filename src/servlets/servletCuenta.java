package servlets;

import java.io.IOException;
import java.time.LocalDate;
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
	LocalDate today = LocalDate.now();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnGenerar")!=null) {
			Cuenta x = new Cuenta();
			x.setCBU(request.getParameter("nroCBU").toString());
			x.setIdUsuario(request.getParameter("idUsuario").toString());
			x.setTipoCuenta(request.getParameter("comboCuenta").toString());
			x.setSaldo("10000");
			x.setFecha(today.toString());
			x.setActivo(1);
			
			negCuenta.insertar(x);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLCuentas.jsp");
			dispatcher.forward(request, response);
		}
			
		if(request.getParameter("btnListar")!=null) {

			ArrayList<Cuenta> lista = negCuenta.listarArticulos();

			request.setAttribute("listaC", lista);

			RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnEliminar") != null) {
			cuentaNegImpl cNeg = new cuentaNegImpl ();
			if(cNeg.borrar(Integer.parseInt(request.getParameter("n_cuenta")))) {
				//msj se borro correctamente
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnModificar") != null) {
			Cuenta cuenta = new Cuenta();
			//cuenta.set
			if(negCuenta.editar(cuenta)) {
				//msj se edito correctamente
			}
		}
	}

}
