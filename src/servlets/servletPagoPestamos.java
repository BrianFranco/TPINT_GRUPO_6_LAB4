package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(request.getParameter("Param")!=null) {
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
		}
		//prueba
		/*if(request.getParameter("Param2")!=null) {
			String opcion = request.getParameter("Param2").toString();
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
		}*/
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
