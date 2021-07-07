package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;

/**
 * Servlet implementation class ServletsModificarContrase�a
 */
@WebServlet("/ModificarContrase�a")
public class ServletsModificarContrase�a extends HttpServlet {
	private static final long serialVersionUID = 3L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsModificarContrase�a() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnModificar")!=null) {
			Usuario u = new Usuario();
			u.setIdUsuario(Integer.parseInt((String) request.getSession().getAttribute("idUsuario")));  
			u.setContrase�a(request.getParameter("txtPassword").toString());
			
			UsuarioDaoImpl udao = new UsuarioDaoImpl();
			udao.modificarContrase�a(u.getIdUsuario(),u.getContrase�a());
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");   
	        rd.forward(request, response);
	
		}
	}

}
