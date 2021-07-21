package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Transferencia;
import negocio.UsuarioNeg;
import negocio.transferenciaNeg;
import negocioImpl.UsuarioNegImpl;
import negocioImpl.transferenciaNegImpl;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class servletTransferencias
 */
@WebServlet("/servletTransferencias")
public class servletTransferencias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioNeg negUsr = new UsuarioNegImpl();  
	
	transferenciaNeg negTransf = new transferenciaNegImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletTransferencias() {
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Transferir.jsp");
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
			Transferencia x = new Transferencia();
			x.setIdCuentaOrigen(Integer.parseInt(request.getParameter("cuentaOrigen")));
			x.setIdCuentaDestino(Integer.parseInt(request.getParameter("txtCuentaDestino")));
			x.setMonto(Float.parseFloat(request.getParameter("txtImporte")));
			//x.setDescripcion(request.getParameter("txtReferencia"));

			negTransf.insertar(x);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DatosPersonales.jsp");
			dispatcher.forward(request, response);
	    }
	}

}
