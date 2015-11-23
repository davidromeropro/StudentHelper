<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Administrar Cuentas</h2>
<div class="container" align="center">
	<form>
		<div class="input-group">
			<input type="text" data-i-search-input="true" class="form-control"
				name="email" data-autocomplete="true"
				data-autocomplete-url="" placeholder="Buscar por correo"> <span
				class="input-group-btn"><button class="btn btn-primary"
					type="submit">Buscar</button></span>
		</div>
	</form>
	<br>


	<div class="row">
		<div class="container" align="center">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<p>
					<h4>Lista de cuentas</h4>
					</p>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Correo</th>
							</tr>
						</thead>
						<%
							List<UsuarioVO> listaUsuarios = (List<UsuarioVO>)request.getAttribute("listaUsuariosAdministrar");
							if (listaUsuarios == null) {
								listaUsuarios = new ArrayList<UsuarioVO>();
							}
							for (UsuarioVO usr : listaUsuarios) {
						%>
						<tr>
							<td>
								<form method="get"
									action="${pageContext.request.contextPath}/Usuario/Info">
									<button type="submit" class="btn btn-default"
										value="<%=usr.getEmail()%>" name="emailInfo"><%=usr.getEmail()%></button>
								</form>
							</td>
							<td>
								<form method="get"
									action="${pageContext.request.contextPath}/Usuario/Modificar">
									<button type="submit" class="btn btn-primary"
										value="<%=usr.getEmail()%>" name="emailModificar">
										<i class="glyphicon glyphicon-pencil"
											title="Modificar Usuario"></i>
									</button>
								</form>
							</td>
							<td>
								<form method="post"
									action="${pageContext.request.contextPath}/Usuario/Eliminar">
									<button type="submit" class="btn btn-danger"
										value="<%=usr.getEmail()%>" name="emailEliminar">
										<i class="glyphicon glyphicon-remove" title="Eliminar item"></i>
									</button>
								</form>
							</td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container" align="center"></div>

</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>