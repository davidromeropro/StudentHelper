package ec.edu.epn.controlador.usuario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ec.edu.epn.modelo.servicio.ServicioUsuario;
import ec.edu.epn.modelo.vo.UsuarioVO;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/Usuario/Modificar")
@MultipartConfig
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarUsuario() {
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
		String email = (String) request.getParameter("emailModificar");
		ServicioUsuario sc = new ServicioUsuario();
		UsuarioVO usr = sc.buscarUsuario(email);
		request.getSession().setAttribute("usuarioModificar", usr);
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);

		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/usuario/modificar.jsp")
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
		UsuarioVO usrInicial = (UsuarioVO) request.getSession().getAttribute("usuarioModificar");
		if (usrLogeado == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
		} else {
			UsuarioVO usrFinal = new UsuarioVO();
			usrFinal.setApellido((String) request.getParameter("apellido"));
			usrFinal.setNombre((String) request.getParameter("nombre"));
			usrFinal.setPassword((String) request.getParameter("password"));
			try {
				System.out.println(request.getContextPath());
				String path = "/Users/davidromero/Documents/workspace/StudentHelper/WebContent/images/";
				File directorio = new File(path + usrInicial.getNombre());
				directorio.mkdir();
				Part filePart = request.getPart("inputFile");
				final String fileName = getFileName(filePart);
				if (fileName != null && fileName.equals("") == false) {
					System.out.println("imprimiendo archivo");
					System.out.println(fileName);
					usrFinal.setFotoPerfil("/StudentHelper/images/" + usrInicial.getNombre() + "/" + fileName);
					OutputStream out = null;
					InputStream filecontent = null;
					try {
						out = new FileOutputStream(
								new File(path + usrInicial.getNombre() + "/" + File.separator + fileName));
						filecontent = filePart.getInputStream();

						int read = 0;
						final byte[] bytes = new byte[1024];

						while ((read = filecontent.read(bytes)) != -1) {
							out.write(bytes, 0, read);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
						if (filecontent != null) {
							filecontent.close();
						}
					}

				}
				ServicioUsuario su = new ServicioUsuario();
				su.modificarUsuario(usrInicial, usrFinal);
			} catch (Exception e) {
				e.printStackTrace();
				errorCreacion = true;
				request.setAttribute("errorCreacionUsuario", errorCreacion);
			}
			
			doGet(request, response);
		}
	}

	private String getFileName(final Part part) {
		//final String partHeader = part.getHeader("content-disposition");
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
