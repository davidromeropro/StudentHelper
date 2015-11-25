<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Tareas</h2>
<div class="container" align="center">
	<form>
		<div class="input-group">
			<input type="text" data-i-search-input="true" class="form-control"
				name="tituloTar" data-autocomplete="true"
				data-autocomplete-url="" placeholder="Buscar por título"> 
			<input
				type="text" data-i-search-input="true" class="form-control"
				name="nombreMat" value="" data-autocomplete="true"
				data-autocomplete-url="" placeholder="Buscar por materia"> <span
				class="input-group-btn"><button
					class="btn btn-primary btn-lg sharp" type="submit">Buscar</button></span>
		</div>
	</form>
	<br>

	<div class="row">
		<div class="container" align="center">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Lista de tareas</h4>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Título</th>
							</tr>
						</thead>
				<%
					List<TareaVO> listaTareas = (List<TareaVO>)request.getAttribute("listaTareas");
					if (listaTareas == null) {
						listaTareas = new ArrayList<TareaVO>();
					}
					for (TareaVO tar : listaTareas) {
				%>
						<tr>
							<td>
								<form method="get"
									action="${pageContext.request.contextPath}/Tarea/Info">
									<button type="submit" class="btn btn-default"
										value="<%=tar.getId()%>" name="idTareaVer"><%=tar.getTitulo()%></button>
								</form>
							</td>
							<td>
								<form method="get"
									action="${pageContext.request.contextPath}/Tarea/Modificar">
									<button type="submit" class="btn btn-primary"
										value="<%=tar.getId()%>" name="idTareaModificar">
										<i class="glyphicon glyphicon-pencil"
											title="Modificar Usuario"></i>
									</button>
								</form>
							</td>
							<td>
								<form method="post"
									action="${pageContext.request.contextPath}/Tarea/Eliminar">
									<button type="submit" class="btn btn-danger"
										value="<%=tar.getId()%>" name="idTareaEliminar">
										<i class="glyphicon glyphicon-remove" title="Eliminar item"></i>
									</button>
								</form>
							</td>
						</tr>
					<%} %>
					</table>
				</div>
			</div>
			<a type="button" href="${pageContext.request.contextPath}/Tarea/Registrar" class="btn btn-primary btn-lg btn-block">Agregar
				tarea</a>
		</div>
	</div>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>