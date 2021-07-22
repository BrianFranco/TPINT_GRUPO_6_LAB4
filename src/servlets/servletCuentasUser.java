package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Movimiento;
import negocio.MovimientoNeg;
import negocio.UsuarioNeg;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class servletCuentasUser
 */
@WebServlet("/servletCuentasUser")
public class servletCuentasUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioNeg negUsr = new UsuarioNegImpl();  
	MovimientoNeg negMov = new MovimientoNegImpl();
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuentasUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
			String opcion = request.getParameter("Param").toString();
			switch (opcion) {
			case "list":
			{
				//System.out.println(request.getParameter("idUsuario"));
				request.setAttribute("listaCuenta", negUsr.listarCuentas(Integer.parseInt(request.getParameter("id"))));	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Cuentas.jsp");
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
			
			ArrayList<Movimiento> lista = negMov.listarMovimientos(Integer.parseInt(request.getParameter("cuentaSeleccionada")));
			
			System.out.println(request.getParameter("cuentaSeleccionada"));
			/*for (Movimiento m : lista) {
				System.out.println(m.toString());
			}*/
			
			request.setAttribute("listaMov", lista);

			RequestDispatcher rd = request.getRequestDispatcher("/Cuentas.jsp");
			rd.forward(request, response);
		}
		/*if(request.getParameter("btnContinuar")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Cuentas.jsp");
			rd.forward(request, response);
		}*/
	}

}
