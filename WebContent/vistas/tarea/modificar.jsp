<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Modificar Tarea</h2>
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
						TareaVO tar = new TareaVO();
						tar = (TareaVO) request.getSession().getAttribute("tareaModificar");
						ServicioMateria sm = new ServicioMateria();
						MateriaVO mat = new MateriaVO();
						mat = sm.buscarMateria(tar.getMateriaId());
						if (tar == null) {
							getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request,
									response);
						}
					%>
					<form class="form-horizontal style-form" method="post">
						<input id="textfield1" name="tituloTar" value="<%=tar.getTitulo()%>" type="text"
							class="form-control" placeholder="Título"> <br> 
						<select
							id="textfield2" name="idMat" class="form-control" id="materia" disabled>
							<option value="<%=mat.getId()%>"><%=mat.getNombre()%></option>							
						</select> <br> <label for="">Descripción</label>
						<textarea id="textfield3" name="descripcionTar"
							class="form-control" placeholder="Descripción" rows="3"><%=tar.getDescripcion()%></textarea>
						<br> <label for="">Fecha de entrega</label> <input
							id="textfield4" name="fechaEntregaTar" type="Date" value="<%=tar.getFechaEntrega()%>" class="form-control">
						<div class="panel-footer">
							<button class="btn btn-primary" type="submit">Guardar</button>
							<a class="btn btn-default"
								href="${pageContext.request.contextPath}/Tarea/Administrar"
								type="button">Cancelar</a>
						</div>
					</form>
				</div>
			</div>
			<a class="btn btn-info btn-lg btn-block" type="button"
				href="${pageContext.request.contextPath}/Tarea/Administrar"><i
				class="glyphicon glyphicon-arrow-left"></i>Regresar a Tareas</a>
		</div>
	</div>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>