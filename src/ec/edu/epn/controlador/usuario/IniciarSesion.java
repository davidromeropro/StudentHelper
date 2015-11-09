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
 * Servlet implementation class IniciarSesion
 */
@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioVO usrLogeado=(UsuarioVO)request.getSession().getAttribute("usuarioLogeado");
		if(usrLogeado==null){
		getServletConfig().getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			getServletConfig().getServletContext().getRequestDispatcher("/perfil.jsp").forward(request, response);		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email="";
		String password="";
		ServicioUsuario sc=new ServicioUsuario();
		try{
			email=(String)request.getParameter("email");
			password=(String)request.getParameter("password");
		}catch(Exception e){
			email="";
			password="";
		}
		
		UsuarioVO usr= sc.buscarUsuario(email, password);
		if(usr!=null){
			request.getSession().setAttribute("usuarioLogeado", usr);
			System.out.println(usr.getNombre());
		}else{
			request.setAttribute("errorLogin", true);
		}
		doGet(request, response);
	}

}
