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
 * Servlet implementation class ModificarMateria
 */
@WebServlet("/Materia/Modificar")
public class ModificarMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarMateria() {
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
		int idMateria = Integer.parseInt(request.getParameter("idMateriaModificar"));
		ServicioMateria sm = new ServicioMateria();
		MateriaVO mat = sm.buscarMateria(idMateria);
		request.getSession().setAttribute("materiaModificar", mat);
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);

		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/materia/modificar.jsp").forward(request, response);
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
		MateriaVO materiaVOInicial = (MateriaVO) request.getSession().getAttribute("materiaModificar");
		String nombre = request.getParameter("nombreMat");
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
		} else {
			if (nombre != null) {
				MateriaVO materiaVOFinal = new MateriaVO();
				materiaVOFinal.setNombre(nombre);
				materiaVOFinal.setProfesor(request.getParameter("profesorMat"));
				materiaVOFinal.setAula(request.getParameter("aulaMat"));
				try {
					ServicioMateria sm = new ServicioMateria();
					sm.modificarMateria(materiaVOInicial, materiaVOFinal);
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
