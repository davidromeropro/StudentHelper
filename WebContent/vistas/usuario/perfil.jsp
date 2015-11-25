<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Mi Perfil</h2>
<section class="container">
	<%  UsuarioVO usrLogeado = (UsuarioVO) request.getSession().getAttribute("usuarioLogeado");
		UsuarioVO usr = new UsuarioVO();
		String emailInfo = usrLogeado.getEmail();
		ServicioUsuario su = new ServicioUsuario();
		usr = su.buscarUsuario(emailInfo);
		if (usr == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request,
					response);
		}
	%>
	
	<div
		style="display: flex; justify-content: center; align-items: center;">
		<div class="col-sm-3" align="center">
			<div class="profile-avatar">
				<img class="img-thumbnail" src="<%=usr.getFotoPerfil()%>"
					alt="profile picture" />
			</div>

		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-3 "></div>
		<div class="col-sm-6" align="center">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Datos Personales</h4>
				</div>
				<div class="panel-body">
					<table class="table">

						<tr>
							<td>Nombre:</td>
							<td><%=usr.getNombre()%></td>
						</tr>

						<tr>
							<td>Apellido:</td>
							<td><%=usr.getApellido()%></td>
						</tr>
						<tr>
							<td>Correo:</td>
							<td><%=usr.getEmail() %></td>
						</tr>

						<tr>
							<td>Password:</td>
							<td><%=usr.getPassword()%></td>
						</tr>
					</table>
				</div>
				<div class="panel-footer">
					<form method="get"
						action="${pageContext.request.contextPath}/Usuario/Modificar">
						<button type="submit" class="btn btn-block btn-primary"
							value="<%=usr.getEmail()%>" name="emailModificar">Editar
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>


</section>
<jsp:include page="/templates/footer.jsp"></jsp:include>