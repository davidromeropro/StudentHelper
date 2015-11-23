<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Ver Materia</h2>
    <div class="container" align="center">
	<%
		MateriaVO mat = new MateriaVO();
		int idMateria = Integer.parseInt(request.getParameter("idMateriaVer"));
		ServicioMateria sm = new ServicioMateria();
		mat = sm.buscarMateria(idMateria);
		if (mat == null) {
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
                <h4>Información Materia</h4>
              </p>
            </div>
            <div class="panel-body">
              <table class = "table">

                <tr>
                   <td>Nombre:</td>
                   <td><%=mat.getNombre()%></td>
                </tr>

                <tr>
                   <td>Profesor:</td>
                   <td><%=mat.getProfesor()%></td>
                </tr>
                <tr>
                   <td>Aula:</td>
                   <td><%=mat.getAula()%></td>
                </tr>
             </table>
            </div>
            <div class="panel-footer">
					<form method="get"
						action="${pageContext.request.contextPath}/Materia/Modificar">
						<button type="submit" class="btn btn-block btn-primary"
							value="<%=mat.getId()%>" name="idMateriaModificar">Editar
						</button>
					</form>
			</div>
			</div>
          <a class="btn btn-info btn-lg btn-block" type="button" href="${pageContext.request.contextPath}/Materia/Administrar"><i class="glyphicon glyphicon-arrow-left"></i>Regresar a Materias</a>
		</div>
	</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>