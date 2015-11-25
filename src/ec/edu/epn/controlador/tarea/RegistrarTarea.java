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
 * Servlet implementation class RegistrarTarea
 */
@WebServlet("/Tarea/Registrar")
public class RegistrarTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarTarea() {
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
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/tarea/registrar.jsp")
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
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
		} else {
			String tarea = request.getParameter("tituloTar");
			if (tarea != null) {
				ServicioTarea st = new ServicioTarea();
				TareaVO tarVO = new TareaVO();
				tarVO.setTitulo(tarea);;
				tarVO.setDescripcion(request.getParameter("descripcionTar"));
				tarVO.setMateriaId(Integer.parseInt(request.getParameter("idMat")));
				
				String fechaE=request.getParameter("fechaEntregaTar");
				tarVO.setFechaEntrega(fechaE);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega= formatter.parse(fechaE);
					tarVO.setFechaE(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("errorCreacionTarea", true);
				}

				try {
					st.registrarTarea(tarVO);
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
