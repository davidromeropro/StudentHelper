package ec.edu.epn.controlador.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ServicioUsuario;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class VerPerfil
 */
@WebServlet("/Usuario/VerPerfil")
public class VerPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerPerfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = (String) request.getParameter("email");
		UsuarioVO usrLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
		} else {
			List<UsuarioVO> listaUsuariosVO = new ArrayList<UsuarioVO>();
			ServicioUsuario su = new ServicioUsuario();
			if (usrLogeado.isAdministrador()) {
				if (email == null) {
					listaUsuariosVO = su.listarUsuariosAll();
				} else {
					listaUsuariosVO = su.listarUsuariosByMail(email);
				}
				request.setAttribute("listaUsuariosAdministrar", listaUsuariosVO);
				getServletConfig().getServletContext().getRequestDispatcher("/vistas/usuario/administrar.jsp")
						.forward(request, response);
			}else{
				System.out.println(usrLogeado.isAdministrador());
				getServletConfig().getServletContext().getRequestDispatcher("/vistas/usuario/perfil.jsp")
				.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
