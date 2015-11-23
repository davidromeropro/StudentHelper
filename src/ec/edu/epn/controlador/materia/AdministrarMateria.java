package ec.edu.epn.controlador.materia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ServicioMateria;
import ec.edu.epn.modelo.vo.MateriaVO;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class AdministrarMateria
 */
@WebServlet("/Materia/Administrar")
public class AdministrarMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdministrarMateria() {
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
		UsuarioVO usrLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);

		} else {
			List<MateriaVO> listaMaterias = new ArrayList<MateriaVO>();
			ServicioMateria sm = new ServicioMateria();
			String nombreMateria = request.getParameter("nombreMat");
			if (usrLogeado.isAdministrador()) {
				if (nombreMateria == null) {
					listaMaterias = sm.listarMateriasAll();
				} else {
					listaMaterias = sm.listarMateriasLikeMat(nombreMateria);
				}
			} else {
				if (nombreMateria == null) {
					listaMaterias = sm.listarMateriasAllByUsr(usrLogeado);
				} else {
					listaMaterias = sm.listarMateriasLikeMatByUsr(nombreMateria,usrLogeado);
				}
			}
			request.setAttribute("listaMaterias", listaMaterias);
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/materia/administrar.jsp").forward(request,
					response);
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
