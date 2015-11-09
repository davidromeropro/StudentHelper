<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Student Helper</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/to-do.css">
    <link href="assets\css\bootstrap-datetimepicker.min.css" rel="stylesheet" />
    
    
</head>
<body>
<section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
           <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a class="logo"><b>Student Helper</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
            </div>
            <div class="top-menu">
                <ul class="nav pull-right top-menu">

                    <li><a class="logout" href="principal.jsp">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
	      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><img src="assets/img/SOFTWARS-logo.png" class="img-square" width="100"></a></p>
              	  <h5 class="centered">MOVILES</h5>
              	  	
                  <li class="mt">
                      <a class="sub" href="materia.jsp">
                          <i class="fa fa-book"></i>
                          <span>Materias</span>
                      </a>
                  </li>
                  
                  <li class="mt">
                      <a class="sub" href="horario.jsp">
                          <i class="fa fa-calendar"></i>
                          <span>Horarios</span>
                      </a>
                  </li>

                  <li class="mt">
                      <a class="active" href="tarea.jsp">
                          <i class="fa fa-check-square"></i>
                          <span>Tareas</span>
                      </a>
                  </li>

                    <li class="mt">
                      <a class="sub" href="examen.jsp">
                          <i class="fa fa-pencil-square-o"></i>
                          <span>Exámenes</span>
                      </a>
                  </li>

                    <li class="mt">
                      <a class="sub" href="perfil.jsp">
                          <i class="fa fa-users"></i>
                          <span>Perfil</span>
                      </a>
                  </li>

              </ul>
              
              
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> Tareas</h3>

			<!-- SORTABLE TO DO LIST -->
			
              <div class="row mt mb">
                  <div class="col-md-12">
                      <section class="task-panel tasks-widget">
	                	<div class="panel-heading">
	                        <div class="pull-left"><h5><i class="fa fa-tasks"></i> Lista de tareas</h5></div>
	                        <br>
	                 	</div>
                          <div class="panel-body">
                              <div class="task-content">
                                  <ul id="sortable" class="task-list">
                                      <li class="list-primary">
                                          <i class=" fa fa-ellipsis-v"></i>
                                          <div class="task-checkbox">
                                              <input type="checkbox" class="list-child" value=""  />
                                          </div>
                                          <div class="task-title">
                                              <span class="task-title-sp">Presentar proyecto</span>
                                              <span class="badge bg-theme">Done</span>
                                              <div class="pull-right hidden-large">
                                                  <button class="btn btn-primary btn-xs fa fa-pencil" data-toggle="modal" href="tarea.jsp#editarTarea"></button>
                                                  <button class="btn btn-danger btn-xs fa fa-trash-o" data-toggle="modal" href="tarea.jsp#eliminarTarea"></button>
                                              </div>
                                          </div>
                                      </li>
                              </div>
                              <div class=" add-task-row">
                                  <a href="tarea.jsp#agregarTarea" class="btn btn-success btn-sm pull-left" data-toggle="modal">Agregar Nuevas Tareas</a>
                              </div>
                          </div>
                      </section>
                  </div><!--/col-md-12 -->
              </div><!-- /row -->

			

              <!-- Modal - Agregar tarea -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="agregarTarea" class="modal fade">
		              <div class="modal-dialog">
		              <form action="" method="post">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h2 class="modal-title">Agregar Tarea</h2>
		                      </div>
		                      <div class="modal-body">
		                          <p>Ingresar datos</p>
		                          <div class="modal-body">
		                          <input type="text" name="name" placeholder="Titulo" autocomplete="off" class="form-control placeholder-no-fix">
		                          </div>
		                          <div class="modal-body">
		                          <div class="well">
									  <div id="datetimepicker4" class="input-append">
									    <input data-format="yyyy-MM-dd" type="text"></input>
									    <span class="add-on">
									      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
									      </i>
									    </span>
									  </div>
									</div>
		                          </div>		                          
		                          <div class="modal-body">
			                          <p>Descripción</p>
	                                  <textarea class="form-control" rows="3" placeholder="Descripci"> </textarea>
			                      </div>
			                      
                                  		
		                      </div>
		              </form>  
                              
		                      <div class="modal-footer">
		                          <button class="btn btn-theme" href="materia.jsp" type="submit">Agregar</button>
                                  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		          
		          <!-- Modal - Editar tareas -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="editarTarea" class="modal fade">
		              <div class="modal-dialog">
		              <form action="" method="post">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h2 class="modal-title">Editar Tarea</h2>
		                      </div>
		                      <div class="modal-body">
		                          <p>Editar datos</p>
		                          <input type="text" name="name" placeholder="Nombre" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="text" name="name" placeholder="Profesor" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="text" name="email" placeholder="Aula" autocomplete="off" class="form-control placeholder-no-fix">
		                      </div>  
                              
		                      <div class="modal-footer">
		                          <button class="btn btn-theme" href="materia.jsp" type="submit">Guardar</button>
                                  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          
		                      </div>
		                  </div>
		                  </form>
		              </div>
		          </div>
		          <!-- modal -->
		          
		          <!-- Modal - Eliminar tareas -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="eliminarTarea" class="modal fade">
		              <div class="modal-dialog">
		              <form action="" method="post">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h2 class="modal-title">Eliminar Tarea</h2>
		                      </div>
		                      <div class="modal-body">
		                          <p>Seguro que desea eliminar la tarea?</p>
		                      </div>  
                              
		                      <div class="modal-footer">
		                          <button class="btn btn-theme" href="materia.jsp" type="submit">Aceptar</button>
                                  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          
		                      </div>
		                  </div>
		                  </form>
		              </div>
		          </div>
		          <!-- modal -->
			
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
          
			
          	
       <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2015 - MÓVILES
              <a href="materia.jsp#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>    
    <script src="assets/js/tasks.js" type="text/javascript"></script>
    <script src="assets\js\bootstrap-datetimepicker.min.js" type="text/javascript"></script>

    <script>
        jQuery(document).ready(function () {
            TaskList.initTaskWidget();

        $(function () {
            $("#sortable").sortable();
            $("#sortable").disableSelection();
            $('#datetimepicker4').datetimepicker({
                pickTime: false
              });
        });
        
});
    </script>
    
    
  <script>
      //custom select box

      $(function () {
          $('select.styled').customSelect();
      });

  </script>
</body>
</html>