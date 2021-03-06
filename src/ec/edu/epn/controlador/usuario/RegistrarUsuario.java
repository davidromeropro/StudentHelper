package ec.edu.epn.controlador.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.epn.modelo.servicio.ServicioUsuario;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/Usuario/Registrar")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/vistas/usuario/crearCuentaUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioVO usrVO=new UsuarioVO();
		usrVO.setEstado(true);
		usrVO.setAdministrador(false);
		request.setAttribute("errorCreacionUsuario", false);
		try{
			usrVO.setEmail(request.getParameter("email"));
			usrVO.setNombre(request.getParameter("nombre"));
			usrVO.setApellido(request.getParameter("apellido"));
			usrVO.setPassword(request.getParameter("password"));
			ServicioUsuario sc=new ServicioUsuario();
			sc.registrarUsuario(usrVO);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorCreacionUsuario", true);
		}
		doGet(request, response);
	}

}
