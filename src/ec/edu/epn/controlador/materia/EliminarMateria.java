package ec.edu.epn.controlador.materia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ServicioMateria;
import ec.edu.epn.modelo.vo.MateriaVO;

/**
 * Servlet implementation class EliminarMateria
 */
@WebServlet("/Materia/Eliminar")
public class EliminarMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarMateria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/Materia/Administrar").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ServicioMateria sm = new ServicioMateria();
			int idMateria = Integer.parseInt(request.getParameter("idMateriaEliminar"));
			MateriaVO materiaEliminar = sm.buscarMateria(idMateria);
			sm.eliminarMateria(materiaEliminar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
