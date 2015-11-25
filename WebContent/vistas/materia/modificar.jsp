<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Editar Materia</h2>

<div class="container" align="center">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-sm-4" align="center">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<p>
					<h4>Editar Datos</h4>
					</p>
				</div>
				<div class="panel-body">
					<%
						MateriaVO mat = new MateriaVO();
						mat = (MateriaVO) request.getSession().getAttribute("materiaModificar");
						if (mat == null) {
							getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request,
									response);
						}
					%>
					<form class="form-horizontal style-form" method="post">
						<input name="nombreMat" type="text" class="form-control"
							value="<%=mat.getNombre()%>"> <br> <input
							name="profesorMat" type="text" class="form-control"
							value="<%=mat.getProfesor()%>"> <br> <input
							name="aulaMat" type="text" class="form-control"
							value="<%=mat.getAula()%>">
						<div class="panel-footer">
							<button class="btn btn-primary" type="submit">Guardar</button>
							<a class="btn btn-default"
								href="${pageContext.request.contextPath}/Materia/Administrar"
								type="button">Cancelar</a>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>

</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>