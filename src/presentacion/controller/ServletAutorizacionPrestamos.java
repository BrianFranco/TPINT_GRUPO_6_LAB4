package presentacion.controller;

import entidad.Cuenta;
import entidad.Movimientos;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import negocio.PrestamosNeg;
import negocioImpl.PrestamosNegImpl;
import negocio.cuentaNeg;
import negocioImpl.cuentaNegImpl;
import negocio.MovimientoNeg;
import negocioImpl.MovimientoNegImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Prestamo;

/**
 * Servlet implementation class ServletAutorizacionPrestamos
 */
@WebServlet("/ServletAutorizacionPrestamos")
public class ServletAutorizacionPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrestamosNeg negPrestamo = new PrestamosNegImpl();
	private MovimientoNeg negMovimiento = new MovimientoNegImpl();
	private cuentaNeg negCuenta = new cuentaNegImpl();
	
	LocalDate today = LocalDate.now();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutorizacionPrestamos() {
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
		
		
		
		if(request.getParameter("btnListar")!= null) {
			ArrayList<Prestamo> lista = negPrestamo.listaPrestamos(request.getParameter("cliente").toString());
			request.getSession().setAttribute("listaPrestamos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnAutorizarPrestamo") != null) {
			String msj="Hubo un error al autorizar el prestamo";
			
			if(negPrestamo.autorizarPrestamo(request.getParameter("n_prestamo"),today.toString(),2)){
				
				Movimientos mov = new Movimientos(Integer.parseInt(request.getParameter("n_cuenta").toString()),2,
						"Alta Prestamo",Float.parseFloat(request.getParameter("saldo").toString()),today.toString());
				
				if(negMovimiento.generarMovimiento(mov)) {
					if(negCuenta.sumarSaldo(mov)) {
						msj="Se autorizo exitosamente el prestamo.";
					}
				}
			}
			request.setAttribute("MsjPrestamo", msj);
			
			
			ArrayList<Prestamo> lista = negPrestamo.listaPrestamos("");
			request.getSession().setAttribute("listaPrestamos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnRechazarPrestamo") != null) {
			String msj="Hubo un error al rechazar el prestamo.";
			
			if(negPrestamo.autorizarPrestamo(request.getParameter("n_prestamo"),today.toString(),3)) {
				msj="Se rechazo prestamo correctamente.";
			}
			
			
			request.setAttribute("MsjPrestamo", msj);
			ArrayList<Prestamo> lista = negPrestamo.listaPrestamos("");
			request.getSession().setAttribute("listaPrestamos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("btnMostrarInformacion") != null) {
			boolean estado=false;
			ArrayList<Prestamo> lista = (ArrayList<Prestamo>)request.getSession().getAttribute("listaPrestamos");
			for (Prestamo prestamo : lista) {
				if(prestamo.getIdUsuario() == Integer.parseInt(request.getParameter("n_usuario"))) {
					if(prestamo.getEstado()==2) {
						estado=true;
					}
				}
			}
			if(estado) {
				request.setAttribute("usuarioHistorial",request.getParameter("n_usuario"));
			}else {
				request.setAttribute("usuarioHistorial","0");
			}
			RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
			rd.forward(request, response);
		}
		
	}

}
