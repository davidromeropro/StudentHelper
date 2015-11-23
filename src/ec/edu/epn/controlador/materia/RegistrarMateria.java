package ec.edu.epn.controlador.materia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ServicioMateria;
import ec.edu.epn.modelo.vo.MateriaVO;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class RegistrarMateria
 */
@WebServlet("/Materia/Registrar")
public class RegistrarMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrarMateria() {
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
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/materia/registrar.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean errorCreacion = false;
		UsuarioVO usrLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
		} else {
			String materia = request.getParameter("nombreMat");
			if (materia != null) {
				ServicioMateria sm = new ServicioMateria();
				MateriaVO matVO = new MateriaVO();
				matVO.setNombre(materia);
				matVO.setProfesor(request.getParameter("profesorMat"));
				matVO.setAula(request.getParameter("aulaMat"));
				matVO.setUsuarioEmail(usrLogeado.getEmail());
				try {
					sm.registrarMateria(matVO);
				} catch (Exception e) {
					e.printStackTrace();
					errorCreacion = true;
				}
				request.setAttribute("errorCreacionMateria", errorCreacion);
			}
			doGet(request, response);
		}

	}
}
