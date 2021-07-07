package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;

/**
 * Servlet implementation class ServletsUsuario
 */
@WebServlet("/ABMLClientes")
public class ServletsUsuario extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("Param")!=null) {
			UsuarioDaoImpl udao = new UsuarioDaoImpl();
			ArrayList<Usuario> lista= udao.obtenerUsuarios();
			
			if (lista == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");  
			}		
			
			request.setAttribute("listaU", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");   
	        rd.forward(request, response);
		} 
		
		if(request.getParameter("btnEliminar")!=null)
		{
			String aux = request.getParameter("idUsuario").toString();
			int id = Integer.parseInt(request.getParameter("idUsuario").toString());
			UsuarioDaoImpl udao = new UsuarioDaoImpl();
			udao.eliminarUsuario(id);
			
            ArrayList<Usuario> lista= udao.obtenerUsuarios();
			request.setAttribute("listaU", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");   
	        rd.forward(request, response);
		}
		
		if (request.getParameter("btnModificar")!=null) {
			
			UsuarioDaoImpl udao = new UsuarioDaoImpl();
			String id = request.getParameter("idUsuario").toString() ;
			Usuario u = udao.obtenerUnUsuario(Integer.parseInt(id));
			String passAnterior = u.getContraseña();  
			request.getSession().setAttribute("passAnterior", passAnterior);
			request.getSession().setAttribute("idUsuario", id);
			RequestDispatcher rd = request.getRequestDispatcher("/ModificarContraseña.jsp");
			rd.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnRegistrar")!=null) {
			
			Usuario u = new Usuario();
			u.setNombre(request.getParameter("txtNombre").toString());
			u.setApellido(request.getParameter("txtApellido").toString());
			u.setFechaNac(request.getParameter("txtFechaNac").toString());
			u.setDni(Integer.parseInt(request.getParameter("txtDni").toString()));
			u.setCuil(request.getParameter("txtCuil").toString());
			u.setGenero(request.getParameter("txtGenero").toString());
			u.setNacionalidad(request.getParameter("txtNacionalidad").toString());
			u.setDireccion(request.getParameter("txtDireccion").toString());
			u.setLocalidad(request.getParameter("txtLocalidad").toString());
			u.setProvincia(request.getParameter("txtProvincia").toString());
			u.setEmail(request.getParameter("txtEmail").toString());
			u.setTelefono(request.getParameter("txtTelefono").toString());
			u.setNomUsuario(request.getParameter("txtNombreUsuario").toString());
			u.setContraseña(request.getParameter("txtPassword").toString());
			
			
			UsuarioDaoImpl udao = new UsuarioDaoImpl();
			udao.agregarUsuario(u);
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLClientes.jsp");   
	        rd.forward(request, response);
			
			
		} else {

		}
		
		
		
	}

}




