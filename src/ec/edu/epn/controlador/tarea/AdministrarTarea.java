package ec.edu.epn.controlador.tarea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ServicioTarea;
import ec.edu.epn.modelo.vo.TareaVO;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class AdministrarTarea
 */
@WebServlet("/Tarea/Administrar")
public class AdministrarTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministrarTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioVO usrLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);

		} else {
			List<TareaVO> listaTareas = new ArrayList<TareaVO>();
			ServicioTarea st = new ServicioTarea();
			String nombreMateria = request.getParameter("nombreMat");
			String tituloTarea = request.getParameter("tituloTar");
			if (usrLogeado.isAdministrador()) {
				if (nombreMateria == null && tituloTarea == null) {
					listaTareas = st.listarTareasAll();
				} else {
					if (nombreMateria != null && tituloTarea != null) {
						listaTareas = st.listarTareasLikeTarMat(nombreMateria, tituloTarea);
					} else {
						if (nombreMateria == null) {
							listaTareas = st.listarTareasLikeTar(tituloTarea);
						}
						if (tituloTarea == null) {
							listaTareas = st.listarTareasLikeMat(nombreMateria);
						}
					}
				}
			} else {
				if (nombreMateria == null && tituloTarea == null) {
					listaTareas = st.listarTareasAllByUsr(usrLogeado);
				} else {
					if (nombreMateria != null && tituloTarea != null) {
						listaTareas = st.listarTareasLikeTarMatByUsr(nombreMateria, tituloTarea,usrLogeado);
					} else {
						if (nombreMateria == null) {
							listaTareas = st.listarTareasLikeTarByUsr(tituloTarea,usrLogeado);
						}
						if (tituloTarea == null) {
							listaTareas = st.listarTareasLikeMatByUsr(nombreMateria,usrLogeado);
						}
					}
				}
			}
			request.setAttribute("listaMaterias", listaTareas);
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/materia/administrar.jsp").forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
