package ec.edu.epn.controlador.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ServicioUsuario;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class AdministrarUsuario
 */
@WebServlet("/AdministrarUsuario")
public class AdministrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdministrarUsuario() {
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
		String email = request.getParameter("email");
		UsuarioVO usrLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		if (email == null) {
			email = "";
		}
		if (usrLogeado != null) {
			try {
				ServicioUsuario sc = new ServicioUsuario();
				List<UsuarioVO> listaUsuariosVO = sc.listarUsuarios(usrLogeado, email);
				request.setAttribute("listaUsuariosAdministrar", listaUsuariosVO);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		getServletConfig().getServletContext().getRequestDispatcher("/vistas/cuenta/administrar.jsp").forward(request,
				response);
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
