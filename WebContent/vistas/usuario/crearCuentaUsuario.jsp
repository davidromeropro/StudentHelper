<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<jsp:include page="/templates/header2.jsp"></jsp:include>
	<div class="container">
		<%
			Boolean errorCreacionUsuario = (Boolean) request.getAttribute("errorCreacionUsuario");
			if (errorCreacionUsuario == null)
				errorCreacionUsuario = false;
			if (errorCreacionUsuario == true) {
		%>		<script type="text/javascript">
			alert("error en la creacion del usuario")
		</script>
		<%
			}
		%>
		<form class="form-login" method="post">
			<h2 class="form-login-heading">Crear cuenta</h2>
			<div class="login-wrap">

				<p>Ingresar datos</p>
				<input id="textfield3" type="email" name="email"
					placeholder="Correo" autocomplete="off"
					class="form-control placeholder-no-fix" required title="Email es requerido"> <br> <input
					id="textfield1" type="text" name="nombre" placeholder="Nombre"
					autocomplete="off" class="form-control placeholder-no-fix">
				<br> <input id="textfield2" type="text" name="apellido"
					placeholder="Apellido" autocomplete="off"
					class="form-control placeholder-no-fix"> <br> <input
					id="textfield4" type="password" name="password"
					placeholder="Password" autocomplete="off"
					class="form-control placeholder-no-fix" required title="Password es requerido">
				<hr>
                <button class="btn btn-primary" type="submit">Crear Cuenta</button>
                <a class="btn btn-default" href="${pageContext.request.contextPath}/Usuario/CerrarSesion" type="button">Cancelar</a>
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/Usuario/IniciarSesion" type="button">Login</a>
                
			</div>
		</form>

	</div>

	<jsp:include page="/templates/footer.jsp"></jsp:include>