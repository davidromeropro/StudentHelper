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
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
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
            <a href="index.jsp" class="logo"><b>Student Helper</b></a>
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
                      <a href="materia.jsp">
                          <i class="fa fa-dashboard"></i>
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
                      <a class="sub" href="tarea.jsp">
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
                      <a class="active" href="perfil.jsp">
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
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> Materias</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		<div class="panel-body">
                          <table class="table table-striped table-advance table-hover">
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th>#</th>
                                  <th><i class="fa fa-folder-open"></i> Nombre</th>
                                  <th class="hidden-phone"><i class="fa fa-envelope-o"></i> Profesor</th>
                                  <th><i class=" fa fa-phone"></i> Aula</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td>1</td>
                                  <td class="hidden-phone">Nombre</td>
                                  <td class="hidden-phone">Descripcion</td>
                                  <td class="hidden-phone">9999-9999</td>
                                  <td>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-ban"></i></button>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                          <div class=" add-task-row">
                                  <a class="btn btn-success btn-sm pull-left" data-toggle="modal" href="index.jsp#agregarPersonas">Agregar Personas</a>
                          </div>
                      </div><!-- /content-panel -->
                  </div><!-- /col-md-12 -->
              </div><!-- /row -->


              <!-- Modal - Signup -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="agregarPersonas" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h2 class="modal-title">Agregar Personas</h2>
		                      </div>
		                      <div class="modal-body">
		                          <p>Ingresar datos</p>
		                          <input type="text" name="name" placeholder="Nombre" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="text" name="name" placeholder="Username" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="text" name="email" placeholder="Correo" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="text" name="pssw" placeholder="Password" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="text" name="confirm" placeholder="Confirmar su password" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>  
                              
		                      <div class="modal-footer">
		                          <button class="btn btn-theme" href="index.jsp" type="submit">Agregar</button>
                                  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
          		</div>
          	</div>
			
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2015 - SOFTWARS
              <a href="personas.jsp#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    
  <script>
      //custom select box

      $(function () {
          $('select.styled').customSelect();
      });

  </script>
</body>
</html>