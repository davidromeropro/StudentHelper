package ec.edu.epn.controlador.tarea;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ServicioTarea;
import ec.edu.epn.modelo.vo.TareaVO;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class ModificarTarea
 */
@WebServlet("/Tarea/Modificar")
public class ModificarTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioVO usrLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		int idTarea = Integer.parseInt(request.getParameter("idTareaModificar"));
		ServicioTarea sm = new ServicioTarea();
		TareaVO tarVOInicial = sm.buscarTarea(idTarea);
		request.getSession().setAttribute("tareaModificar", tarVOInicial);
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);

		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/materia/modificar.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean errorCreacion = false;
		UsuarioVO usrLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		TareaVO tareaVOInicial = (TareaVO) request.getSession().getAttribute("tareaModificar");
		String titulo = request.getParameter("tituloTar");
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
		} else {
			if (titulo != null) {
				TareaVO tareaVOFinal = new TareaVO();
				tareaVOFinal.setTitulo(titulo);
				tareaVOFinal.setDescripcion(request.getParameter("descripcionTar"));
				String fechaE=request.getParameter("fechaEntregaTar");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega= formatter.parse(fechaE);
					tareaVOFinal.setFechaEntrega(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("errorCreacionTarea", true);
				}
				try {
					ServicioTarea st = new ServicioTarea();
					st.modificarTarea(tareaVOInicial, tareaVOFinal);
				} catch (Exception e) {
					e.printStackTrace();
					errorCreacion = true;
				}
				request.setAttribute("errorCreacionTarea", errorCreacion);
			}
			doGet(request, response);
		}
	}
}
