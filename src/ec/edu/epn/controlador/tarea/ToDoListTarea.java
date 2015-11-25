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
 * Servlet implementation class ToDoListTarea
 */
@WebServlet("/Tarea/ToDoList")
public class ToDoListTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoListTarea() {
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
			List<TareaVO> listaTareas = new ArrayList<TareaVO>();
			ServicioTarea st = new ServicioTarea();
			String anio = request.getParameter("year");
			String mes = request.getParameter("month");
			int year;
			int month;
			if(anio==null||anio==""){
				year=0;
			}else{
				year = Integer.parseInt(anio);
			}
			if(mes==null||mes==""){
				month=0;
			}else{
				month = Integer.parseInt(mes);
			}
			System.out.println("LOLOLO"+year+" "+month);
			listaTareas = st.listarTareasByMonthYearUsr(month,year,usrLogeado);
			request.setAttribute("listaToDo", listaTareas);
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/tarea/todolist.jsp").forward(request,
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
