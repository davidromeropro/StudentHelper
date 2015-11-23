<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Materias</h2>
<div class="container" align="center">
	<form>
		<div class="input-group">
			<input type="text" data-i-search-input="true" class="form-control"
				name="nombreMat" data-autocomplete="true"
				data-autocomplete-url="" placeholder="Buscar por nombre"> <span
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
					<h4>Lista de materias</h4>
					</p>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nombre</th>
							</tr>
						</thead>
						<%
					List<MateriaVO> listaMaterias = (List<MateriaVO>)request.getAttribute("listaMaterias");
					if (listaMaterias == null) {
						listaMaterias = new ArrayList<MateriaVO>();
					}
					for (MateriaVO mat : listaMaterias) {
				%>
						<tr>
							<td>
								<form method="get"
									action="${pageContext.request.contextPath}/Materia/Info">
									<button type="submit" class="btn btn-default"
										value="<%=mat.getId()%>" name="idMateriaVer"><%=mat.getNombre()%></button>
								</form>
							</td>
							<td>
								<form method="get"
									action="${pageContext.request.contextPath}/Materia/Modificar">
									<button type="submit" class="btn btn-primary"
										value="<%=mat.getId()%>" name="idMateriaModificar">
										<i class="glyphicon glyphicon-pencil"
											title="Modificar Usuario"></i>
									</button>
								</form>
							</td>
							<td>
								<form method="post"
									action="${pageContext.request.contextPath}/Materia/Eliminar">
									<button type="submit" class="btn btn-danger"
										value="<%=mat.getId()%>" name="idMateriaEliminar">
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
			<a type="button" href="${pageContext.request.contextPath}/Materia/Registrar" class="btn btn-primary btn-lg btn-block">Agregar
				materia</a>
		</div>
	</div>

	<div class="container" align="center"></div>

</div>

<jsp:include page="/templates/footer.jsp"></jsp:include>