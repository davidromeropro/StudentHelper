<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Ver Tarea</h2>
    <div class="container" align="center">
	<%
		TareaVO tar = new TareaVO();
		int idTarea = Integer.parseInt(request.getParameter("idTareaVer"));
		ServicioTarea st = new ServicioTarea();
		tar = st.buscarTarea(idTarea);
		ServicioMateria sm = new ServicioMateria();
		MateriaVO mat = new MateriaVO();
		mat = sm.buscarMateria(tar.getMateriaId());
		if (tar == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request,
					response);
		}
	%>
      <div class="row">
        <div class="col-md-3 ">
        </div>
        <div class="col-sm-6" align="center">
          <div class="panel panel-primary" >
            <div class="panel-heading">
              <p>
                <h4>Información Tarea</h4>
              </p>
            </div>
            <div class="panel-body">
              <table class = "table">

                <tr>
                   <td>Título:</td>
                   <td><%=tar.getTitulo()%></td>
                </tr>

                <tr>
                   <td>Materia:</td>
                   <td><%=mat.getNombre()%></td>
                </tr>
                <tr>
                   <td>Descripcion:</td>
                   <td><%=tar.getDescripcion()%></td>
                </tr>
                <tr>
                   <td>Fecha de Entrega:</td>
                   <td><%=tar.getFechaEntrega()%></td>
                </tr>
             </table>
            </div>
            <div class="panel-footer">
					<form method="get"
						action="${pageContext.request.contextPath}/Tarea/Modificar">
						<button type="submit" class="btn btn-block btn-primary"
							value="<%=tar.getId()%>" name="idTareaModificar">Editar
						</button>
					</form>
			</div>
			</div>
          <a class="btn btn-info btn-lg btn-block" type="button" href="${pageContext.request.contextPath}/Tarea/Administrar"><i class="glyphicon glyphicon-arrow-left"></i>Regresar a Tarea</a>
		</div>
	</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>