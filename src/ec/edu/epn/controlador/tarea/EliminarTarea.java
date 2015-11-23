package ec.edu.epn.controlador.tarea;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ServicioTarea;
import ec.edu.epn.modelo.vo.TareaVO;

/**
 * Servlet implementation class EliminarTarea
 */
@WebServlet("/Tarea/Eliminar")
public class EliminarTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/Tarea/Administrar").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ServicioTarea st = new ServicioTarea();
			int idTarea = Integer.parseInt(request.getParameter("idTareaEliminar"));
			TareaVO tareaEliminar = st.buscarTarea(idTarea);
			st.eliminarTarea(tareaEliminar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}
}
