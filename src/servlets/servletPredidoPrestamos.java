package servlets;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Prestamo;
import negocio.PrestamosNeg;
import negocio.UsuarioNeg;
import negocioImpl.PrestamosNegImpl;
import negocioImpl.UsuarioNegImpl;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class servletPredidoPrestamos
 */
@WebServlet("/servletPredidoPrestamos")
public class servletPredidoPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrestamosNeg negPrest = new PrestamosNegImpl();
	UsuarioNeg negUsr = new UsuarioNegImpl();
	LocalDate today = LocalDate.now();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPredidoPrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("Param")!=null) {
			String opcion = request.getParameter("Param").toString();
			switch (opcion) {
			case "list":
			{
				request.setAttribute("listaCuenta", negUsr.listarCuentas(Integer.parseInt(request.getParameter("id"))));	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Prestamo.jsp");
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
		if(request.getParameter("btnAceptar")!=null)
	    {
			Prestamo x = new Prestamo();
			x.setIdCuenta(Integer.parseInt(request.getParameter("cuentaOrigen")));
			x.setMontoSolicitado(Float.parseFloat(request.getParameter("txtImporte")));
			x.setMontoFinal((float)(x.getMontoSolicitado()*1.25));
			x.setCantCuotas(Integer.parseInt(request.getParameter("cantCuotas")));
			x.setMontoCuotas((float)(x.getMontoFinal()/x.getCantCuotas()));
			x.setFecha(today.toString());
			x.setEstado(1);
			x.setIdUsuario(Integer.parseInt(request.getParameter("idUser")));
			x.setRestCuotas(x.getCantCuotas());
			
			//System.out.println(x.toString());

			negPrest.insertar(x);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DatosPersonales.jsp");
			dispatcher.forward(request, response);
	    }
	}

}
