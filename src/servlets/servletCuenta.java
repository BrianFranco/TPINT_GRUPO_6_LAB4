package servlets;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Cuenta;
import entidad.TipoCuenta;
import negocio.cuentaNeg;
import negocioImpl.cuentaNegImpl;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;



/**
 * Servlet implementation class servletCuenta
 */
@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	cuentaNeg negCuenta = new cuentaNegImpl();
	LocalDate today = LocalDate.now();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuenta() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getParameter("btnGenerar")!=null) {
			Cuenta x = new Cuenta();
			x.setCBU(request.getParameter("nroCBU").toString());
			x.setIdUsuario(request.getParameter("idUsuario").toString());
			TipoCuenta tc = new TipoCuenta();
			tc.setIDTipoCuenta(Integer.parseInt(request.getParameter("comboCuenta").toString()));
			x.setSaldo("10000");
			x.setFecha(today.toString());
			x.setActivo(1);
			
			if(negCuenta.insertar(x))
			{
				request.setAttribute("msjGenerar", "Se creo una nueva cuenta exitosamente.");
			}else {
				request.setAttribute("msjGenerar", "Error, no se pudo crear la nueva cuenta.Revise los datos ingresados.");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLCuentas.jsp");
			dispatcher.forward(request, response);
		}
		
			
		if(request.getParameter("btnListar")!=null) {
			String filtros = "";
			
			if(request.getParameter("cuentaOrigen").equals("1") || request.getParameter("cuentaOrigen").equals("2")) {
				filtros+="Where idTipoCuenta="+Integer.parseInt(request.getParameter("cuentaOrigen"));
				if(!request.getParameter("cliente").equals("")) {
					filtros+=" AND IdUsuario="+Integer.parseInt(request.getParameter("cliente"));
				}
			}else if(!request.getParameter("cliente").equals("")){
				filtros+="Where IdUsuario="+Integer.parseInt(request.getParameter("cliente"));
			}
						
			ArrayList<Cuenta> lista = negCuenta.listarCuentasFiltros(filtros);
			request.getSession().setAttribute("listaC", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnEliminar") != null) {
			cuentaNegImpl cNeg = new cuentaNegImpl ();
			if(cNeg.borrar(Integer.parseInt(request.getParameter("n_cuenta")))) {
				request.setAttribute("msjTabla", "Se elimino la cuenta correctamente.");
			}
			
			ArrayList<Cuenta> lista = negCuenta.listarArticulos();
			
			request.getSession().setAttribute("listaC", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnModificar") != null) {
			
			request.setAttribute("N_cuentaModificable", request.getParameter("n_cuenta"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
			rd.forward(request, response);
		}
		
		
		
		if(request.getParameter("btnGuardar")!= null) {
			Cuenta cuenta = new Cuenta();
			cuenta.setN_Cuenta(request.getParameter("n_cuenta"));
			cuenta.setFecha(request.getParameter("fecha"));
			cuenta.setIdUsuario(request.getParameter("id_usuario").toString());
			
			TipoCuenta tc = new TipoCuenta();
			tc.setIDTipoCuenta(Integer.parseInt(request.getParameter("comboCuenta").toString()));
			if(tc.getIDTipoCuenta()==1){
				tc.setDescripcion("Cuenta Corriente");							
			}else {
				tc.setDescripcion("Caja de Ahorro");
			}		
			
			cuenta.setTipoCuenta(tc);
			cuenta.setCBU(request.getParameter("CBU").toString());
			cuenta.setSaldo(request.getParameter("Saldo"));
			cuenta.setActivo(Integer.parseInt(request.getParameter("activo")));

			if(negCuenta.editar(cuenta)) {
				//msj	se guardo bien la modificacion
				request.setAttribute("msjTabla", "Se guardaron los datos correctamente.");
			}else {
				//msj error al guardar la modificacion
				request.setAttribute("msjTabla", "Error no se guardaron los cambios.");
			}
			
			ArrayList<Cuenta> lista = negCuenta.listarArticulos();
			
			request.getSession().setAttribute("listaC", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnCancelar")!=null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/ABMLCuentas.jsp");
			rd.forward(request, response);
		}

	}

}
