package ec.edu.epn.controlador.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.epn.modelo.servicio.ServicioUsuario;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/Usuario/Modificar")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = (String) request.getParameter("emailModificar");
		if (email == null) {
			email = "";
		}
		ServicioUsuario sc = new ServicioUsuario();
		UsuarioVO usr = sc.buscarUsuarioByEmail(email);
		if (usr == null) {
			request.setAttribute("errorActualizacionUsuario", true);
		}
		request.getSession().setAttribute("usuarioModificar", usr);
		getServletConfig().getServletContext().getRequestDispatcher("/vistas/usuario/modificar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioVO usuarioLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		boolean error = false;
		boolean existe = true;
		UsuarioVO usrInicial = (UsuarioVO) request.getSession().getAttribute("usuarioModificar");
		UsuarioVO usrFinal = new UsuarioVO();
		if (usrFinal.getEmail() == null) {
			existe = false;
		}
		if (existe == true) {
			usrFinal.setApellido((String) request.getParameter("apellido"));
			usrFinal.setNombre((String) request.getParameter("nombre"));
			usrFinal.setPassword((String) request.getParameter("password"));
			boolean permisos = true;
			if ((usuarioLogeado.isAdministrador() == false)
					&& (usuarioLogeado.getEmail().equals(usrInicial.getEmail()) == false))
				permisos = false;
			try {
				ServicioUsuario sc = new ServicioUsuario();
				if (permisos == true)
					sc.modificarUsuario(usrInicial, usrFinal);
			} catch (Exception e) {
				e.printStackTrace();
				error = true;
				request.setAttribute("errorActualizacionUsuario", error);
			}
		} else {
			request.setAttribute("errorActualizacionUsuario", error);
		}
		doGet(request, response);
	}

}
