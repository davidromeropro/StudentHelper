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

    <title>Prototipo</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="home.jsp">
		        <h2 class="form-login-heading">Ingresa ahora</h2>
		        <div class="login-wrap">
		            
                    <input type="text" class="form-control" placeholder="Username" autofocus>
		            <br>
		            <input type="password" class="form-control" placeholder="Password">
		            <label class="checkbox">
                        
		            </label>
		            <button class="btn btn-theme btn-block" href="perfil.jsp" type="submit"><i class="fa fa-lock"></i> SIGN IN</button>
		            <hr>
		      </form>
		            <div class="registration">
		                No tienes cuenta?<br/>
		                <a data-toggle="modal" href="login.jsp#signUp">  Crear una cuenta</a>
		            </div>
		
		        </div>
		
		         
                  <!-- Modal - Signup -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="signUp" class="modal fade">
		              <div class="modal-dialog">
		               	<form action="./crearCuenta" method="post">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h2 class="modal-title">Crear Cuenta</h2>
		                      </div>
		                      
		                      <div class="modal-body">
		                      
		                          <p>Ingresar datos</p>
		                          <input type="text" name="name" placeholder="Nombre" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="text" name="name" placeholder="Apellido" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="email" name="email" placeholder="Correo" autocomplete="off" class="form-control placeholder-no-fix">
                                  <input type="password" name="pssw" placeholder="Password" autocomplete="off" class="form-control placeholder-no-fix">
		                      </div>

                              
		                      <div class="modal-footer">
		                          <button class="btn btn-theme" href="perfil.jsp" type="submit">Crear Cuenta</button>
                                  <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
		                          
		                      </div>
		                  </div>
		                   </form>
		              </div>
		          </div>
		          <!-- modal -->
  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("assets/img/try2.jpg", {speed: 500});
    </script>

</body>
</html>