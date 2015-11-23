<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Agregar Materia</h2>
		<%
			Boolean errorCreacionMateria = (Boolean) request.getAttribute("errorCreacionMateria");
			if (errorCreacionMateria == null)
				errorCreacionMateria = false;
			if (errorCreacionMateria == true) {
		%>		<script type="text/javascript">
			alert("error en la creacion del usuario")
		</script>
		<%
			}
		%>
    <div class="container" align="center">
      <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-sm-4" align="center">
          <div class="panel panel-primary" >
            <div class="panel-heading">
              <p>
                <h4>Ingresar Datos</h4>
              </p>
            </div>
            <div class="panel-body">
              <form class="form-horizontal style-form" method="post">
                <input name="nombreMat" type="text" class="form-control" placeholder="Nombre">
                <br>
                <input name="profesorMat" type="text" class="form-control" placeholder="Profesor">
                <br>
                <input name="aulaMat" type="text" class="form-control" placeholder="Aula">
              <div class="panel-footer">
              <button class="btn btn-primary" type="submit">Guardar</button>
              <a class="btn btn-default" href="${pageContext.request.contextPath}/Materia/Administrar" type="button">Cancelar</a>
             </div>
              </form>
            </div> 
          </div>
          <a class="btn btn-info btn-lg btn-block" type="button" href="${pageContext.request.contextPath}/Materia/Administrar"><i class="glyphicon glyphicon-arrow-left"></i>Regresar a Materias</a>
        </div>
      </div>

    </div>
<jsp:include page="/templates/footer.jsp"></jsp:include>