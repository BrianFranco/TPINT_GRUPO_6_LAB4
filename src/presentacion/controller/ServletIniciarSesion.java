package presentacion.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidad.Usuario;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletIniciarSesion
 */
@WebServlet("/ServletIniciarSesion")
public class ServletIniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuarioNeg negUsuario = new UsuarioNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIniciarSesion() {
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
		if(request.getParameter("inputIngresar") != null) {
			
				String redireccion = "";
			if(request.getParameter("txtUsuario") != "" && request.getParameter("txtContraseña")!= "") {
				Usuario u = new Usuario();
				u.setNomUsuario(request.getParameter("txtUsuario"));
				u.setContraseña(request.getParameter("txtContraseña"));
				
				Usuario usuarioBuscado = new Usuario();
				
				usuarioBuscado = negUsuario.buscarUsuario(u);
				if(usuarioBuscado != null) {
					request.getSession().setAttribute("Usuario",usuarioBuscado );
					if(usuarioBuscado.getIdRol() == 1) {
						redireccion = "/DatosPersonales.jsp";
					}else {
						redireccion = "/ABMLClientes.jsp";
					}
					
				}else {
					request.setAttribute("msjError", "Error. El usuario o contraseña ingresado es incorrecto.");
					redireccion = "/IniciarSesion.jsp";
				}
				
				
			}else {
				request.setAttribute("msjError", "Error. Debe completar todos los campos.");
				redireccion = "/IniciarSesion.jsp";
				//Mensaje que deben completar todos los campos.
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(redireccion);
			dispatcher.forward(request, response);
		}
		//doGet(request, response);
	}

}
