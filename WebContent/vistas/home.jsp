<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/templates/header3.jsp"></jsp:include>
  <div id="menu">
    <div class="container" align="center">
              <ul class="col-xs-12">
                <li id="perfil" class="btn span1 btn-xlarge" >
                  <a href="${pageContext.request.contextPath}/Usuario/VerPerfil">
                  <img src="${pageContext.request.contextPath}/images/icons/circle-icons/full-color/png/64px/profle.png" style="display: block; margin: 0 auto">
                  &#173 &#173 &#173 &#173 &#173 Perfil</a></li>
                 <li id="materia" class="btn span1 btn-xlarge">
                  <a href="${pageContext.request.contextPath}/Materia/Administrar">
                  <img src="${pageContext.request.contextPath}/images/icons/freeIcons/PNG/64/free-60-icons-28.png" style="display: block; margin: 0 auto">
                  &#173 Materia</a></li>
                <li id="tareas" class="btn span1 btn-xlarge">
                  <a href="${pageContext.request.contextPath}/Tarea/Administrar">
                  <img src="${pageContext.request.contextPath}/images/icons/freeIcons/PNG/64/free-60-icons-12.png" style="display: block; margin: 0 auto">
                  &#173 &#173 Tareas</a></li>
                <li id="todolist" class="btn span1 btn-xlarge">
                  <a href="${pageContext.request.contextPath}/Tarea/ToDoList">
                  <img src="${pageContext.request.contextPath}/images/icons/freeIcons/PNG/64/free-60-icons-58.png" style="display: block; margin: 0 auto">
                  &#173 &#173 &#173 To Do</a></li>  
                  <!-- <li id="horario" class="btn span1 btn-xlarge">
                  <a href="${pageContext.request.contextPath}/Horario/Administrar">
                  <img src="${pageContext.request.contextPath}/images/icons/freeIcons/PNG/64/free-60-icons-16.png" style="display: block; margin: 0 auto">
                  &#173 Horario</a></li>
                   -->
              </ul>
    </div>
  </div>

	<jsp:include page="/templates/footer.jsp"></jsp:include>