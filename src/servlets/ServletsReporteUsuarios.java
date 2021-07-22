package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datosImpl.UsuarioDaoImpl;
import datosImpl.cuentaDaoImpl;
import entidad.Cuenta;
import entidad.Usuario;

/**
 * Servlet implementation class ServletsReporteUsuarios
 */
@WebServlet("/ReporteUsuarios")
public class ServletsReporteUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsReporteUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnFiltrar") != null) {
			ArrayList<Usuario> ReporteUFiltrado = new ArrayList<Usuario>();
			UsuarioDaoImpl dao = new UsuarioDaoImpl();
			String nombre = request.getParameter("nombre").toString().toLowerCase();
			String apellido = request.getParameter("apellido").toString().toLowerCase();
			if (!nombre.isEmpty() || !apellido.isEmpty()) {
				ReporteUFiltrado = dao.obtenerUsuariosPorNombre(nombre,apellido);
				request.setAttribute("ReporteU", ReporteUFiltrado);
			} else {
				ReporteUFiltrado = dao.obtenerUsuarios();
				request.setAttribute("ReporteU", ReporteUFiltrado);
			}


		} else {
			ArrayList<Usuario> ReporteU = new ArrayList<Usuario>();
			UsuarioDaoImpl dao = new UsuarioDaoImpl();
			ReporteU = dao.obtenerUsuarios();
			request.setAttribute("ReporteU", ReporteU);

		}
		
		if (request.getParameter("btnMostrar")!=null) {
			Usuario u = new Usuario();
			String id = request.getParameter("idUsuario").toString();
			ArrayList<Cuenta> listaC = new ArrayList<Cuenta>();
			cuentaDaoImpl dao = new cuentaDaoImpl();
			u.setIdUsuario(Integer.parseInt(id));
			listaC = dao.obtenerCuentasUsuario(u.getIdUsuario());
			request.setAttribute("ReporteC", listaC);

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarUsuarios.jsp"); 
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
