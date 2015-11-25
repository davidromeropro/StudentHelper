<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, ec.edu.epn.modelo.vo.*, ec.edu.epn.modelo.servicio.*"%>
<jsp:include page="/templates/header.jsp"></jsp:include>

<h2 align="center">TO DO LIST</h2>
    <div class="container" align="center">

      <form id="anioMesForm" class="form-horizontal">
        <div class="form-group">
          <div class="col-xs-12 selectContainer">
                  <label>Año</label>
              <select class="form-control"  data-style="btn-info" name="year">
                <% 
                Date myDate = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(myDate);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONDAY)+1;
                %>
                <option value="<%=year%>"><%=year%></option>
                <%
                for(int i = 2010; i <= year+5; i++){%>
                  <option value="<%=i%>"><%=i%></option>
                <%}%>
              </select>
          </div>
                            <label>Mes</label>
          <div class="col-xs-12 selectContainer">
              <select class="form-control"  data-style="btn-info" name="month">
              	 <%ServicioTarea s = new ServicioTarea();
              	 %>
                  <option value="<%=month%>"><%=s.mesbyInt(month)%></option>
                  <option value="1">Enero</option>
                  <option value="2">Febrero</option>
                  <option value="3">Marzo</option>
                  <option value="4">Abril</option>
                  <option value="5">Mayo</option>
                  <option value="6">Junio</option>
                  <option value="7">Julio</option>
                  <option value="8">Agosto</option>
                  <option value="9">Septiembre</option>
                  <option value="10">Octubre</option>
                  <option value="11">Noviembre</option>
                  <option value="12">Diciembre</option>
              </select>
          </div>
        </div> 
         <span><button class="btn btn-primary btn-lg" type="submit">Buscar</button></span>    
      </form>
      <br>
      
      <div class="row">
        <div class="container" align="center">
          <div class="panel panel-primary" >
            <div class="panel-heading">
              <p>
                <h4>Lista de tareas</h4>
              </p>
            </div>
            <div class="panel-body">
              <table class = "table table-hover">
                <thead>
                  <tr>
                    <th>Fecha</th>
                    <th>Día</th>
                    <th>Tarea</th>
                    <th>Materia</th>
                    
                  </tr>
                </thead>
			    <%
					List<TareaVO> listaTareas = (List<TareaVO>)request.getAttribute("listaToDo");
			    	if (listaTareas == null) {
						listaTareas = new ArrayList<TareaVO>();
					}
					for (TareaVO tar : listaTareas) {
						Calendar calendario = Calendar.getInstance();
						calendario.setTime(tar.getFechaE());
				        int dia =calendario.get(Calendar.DAY_OF_WEEK);
						ServicioMateria sm = new ServicioMateria();
						MateriaVO mat = new MateriaVO();
						mat = sm.buscarMateria(tar.getMateriaId());
				%>
                <tr>
                   <td><%=tar.getFechaEntrega()%></td>
                   <td><%=s.diabyInt(dia)%></td>
                   <td><%=tar.getTitulo()%></td>
                   <td><%=mat.getNombre()%></td>
                   
                </tr>
                <%}%>
             </table>
            </div>
          </div>
			<a type="button" href="${pageContext.request.contextPath}/Tarea/Administrar" class="btn btn-primary btn-lg btn-block">Ver todas las tareas</a>
        </div>
      </div>
    </div>
  <br>
<jsp:include page="/templates/footer.jsp"></jsp:include>