package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletsInicio
 */
@WebServlet("/ServletsInicio")
public class ServletsInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsInicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "previoInsert":
			{
				//Se quiere ir a inserta usuario
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AñadirUsuario.jsp");
				dispatcher.forward(request, response);
				break;}
			
			case "ListUsu":{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarUsuarios.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "Tranferir":{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Transferir.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "Mirar cuenta":{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Cuentas.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "Prestamo":{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Prestamo.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "Inicio":{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Principal.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "Datos":{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/DatosPersonales.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
