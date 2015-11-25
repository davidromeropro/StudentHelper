<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<h2 align="center">Perfil</h2>
    <div class="container" align="center">
      <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-sm-4" align="center">
          <div class="panel panel-primary" >
            <div class="panel-heading">
              <p>
                <h4>Editar Datos</h4>
              </p>
            </div>
            <div class="panel-body">
<%
	UsuarioVO usr= new UsuarioVO();
	usr=(UsuarioVO)request.getSession().getAttribute("usuarioModificar");
	if(usr==null){
		getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request, response);
	}
%>
              <form class="form-horizontal style-form" method="post" enctype="multipart/form-data">
                  <input type="text" class="form-control" name="nombre" value="<%=usr.getNombre()%>">
                  <br>
                  <input type="text" class="form-control" name="apellido" value="<%=usr.getApellido()%>">
                  <br>
                  <input type="email" class="form-control" name="email" value="<%=usr.getEmail()%>" readonly>
                  <br>
                  <input type="password" class="form-control" name="password" value="<%=usr.getPassword()%>" placeholder="Password">
                  <br>
                  <label for="inputFile">Seleccionar archivo</label> <input
						type="file" id="inputFile" name="inputFile">
				  <br>
              <div class="panel-footer">
              <button class="btn btn-primary" type="submit">Guardar</button>
              <a class="btn btn-default" href="${pageContext.request.contextPath}/Usuario/VerPerfil" type="button">Cancelar</a>
              </div>
              </form>
            </div>
            
          </div>
        </div>
      </div>
    </div>

<jsp:include page="/templates/footer.jsp"></jsp:include>