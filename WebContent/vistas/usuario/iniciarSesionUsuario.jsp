<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<body background="${pageContext.request.contextPath}/images/background.jpg">
<div id="login-page">
	<div class="container">
		<%
			Boolean errorLogin = (Boolean) request.getAttribute("errorLogin");
			if (errorLogin == null)
				errorLogin = false;
			if (errorLogin == true) {
		%>
		<script type="text/javascript">
			alert("credenciales inválidas")
		</script>
		<%
			}
		%>
		<form class="form-login" method="post">
			<h2 class="form-login-heading">Ingresa ahora</h2>
			<div class="login-wrap">

				<input type="text" class="form-control" placeholder="Email"
					autofocus name="email" required="true"> <br> <input
					type="password" class="form-control" placeholder="Password"
					name="password" required="true">
					<br>
				<button class="btn btn-theme btn-block" href="" type="submit">
					<i class="fa fa-lock"></i> SIGN IN
				</button>

				<div class="registration">
					No tienes cuenta?<br>
					<p>
						<a href="${pageContext.request.contextPath}/Usuario/Registrar">
							Crear una cuenta</a>
					</p>

				</div>

			</div>
		</form>		
	</div>
</div>

<jsp:include page="/templates/footer.jsp"></jsp:include>