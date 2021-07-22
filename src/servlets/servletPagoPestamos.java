package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cuenta;
import entidad.Prestamo;
import entidad.PrestamoP;
import negocio.PrestamosNeg;
import negocio.UsuarioNeg;
import negocioImpl.PrestamosNegImpl;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class servletPagoPestamos
 */
@WebServlet("/servletPagoPestamos")
public class servletPagoPestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrestamosNeg negPrest = new PrestamosNegImpl();
	UsuarioNeg negUsr = new UsuarioNegImpl();
       
	
	private int cuentaAUsar;
	private int idUsuarioCobro;
	LocalDate today = LocalDate.now();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPagoPestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				/*if(request.getParameter("Param")!=null) {
					String opcion = request.getParameter("Param").toString();
					switch (opcion) {
					case "list":
					{
						request.setAttribute("listaPrestamo", negPrest.listarPrestamos(Integer.parseInt(request.getParameter("id"))));	
						RequestDispatcher dispatcher = request.getRequestDispatcher("/PagoPrestamo.jsp");
						dispatcher.forward(request, response);
						break;
					}
					default:
						break;
					}
				}*/
				//prueba
				//<% if (request.getParameter("Param") != null){ %><% } %>
				if(request.getParameter("Param")!=null) {
					String opcion = request.getParameter("Param").toString();
					switch (opcion) {
					case "list":
					{
						request.setAttribute("listaCuenta", negUsr.listarCuentas(Integer.parseInt(request.getParameter("id"))));	
						RequestDispatcher dispatcher = request.getRequestDispatcher("/PagoPrestamo.jsp");
						dispatcher.forward(request, response);
						break;
					}
					default:
						break;
					}
				}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnContinuar")!=null) {
			
			cuentaAUsar = Integer.parseInt(request.getParameter("idUsuario"));
			idUsuarioCobro = Integer.parseInt(request.getParameter("cuentaOrigen"));
			
			ArrayList<Prestamo> lista = negPrest.listarPrestamos(Integer.parseInt(request.getParameter("idUsuario")));
			/*for (Prestamo p : lista) {
				System.out.println(p.toStringList());
			}*/
			
			request.setAttribute("listaPr", lista);

			RequestDispatcher rd = request.getRequestDispatcher("/PagoPrestamo.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnPagar")!=null) {
			
			PrestamoP p = new PrestamoP();
			
			p.setIdUsuario(idUsuarioCobro);
			p.setCuentaUsar(cuentaAUsar);
			p.setIdCuenta(Integer.parseInt(request.getParameter("idPrestamo")));
			p.setMontoCuotas(Float.parseFloat(request.getParameter("valorCuota")));
			p.setCantCuotas(Integer.parseInt(request.getParameter("cuotasPagar")));
			p.setFecha(today.toString());
			p.setMontoPago((float)(p.getCantCuotas()*p.getMontoCuotas()));
			
			negPrest.insertarP(p);

			RequestDispatcher rd = request.getRequestDispatcher("/DatosPersonales.jsp");
			rd.forward(request, response);
		}
	}

}
