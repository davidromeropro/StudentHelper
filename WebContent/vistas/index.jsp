<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
  <title>StudentHelper</title>
</head>
<body background="${pageContext.request.contextPath}/images/background.jpg">

  <header>
    <nav class="navbar navbar-inverse">

      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>

      </div>

      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <a class="navbar-brand" href="${pageContext.request.contextPath}/Usuario/IniciarSesion">Iniciar Sesión</a>
        </ul>
      </div>

    </nav>
  </header>

    <!-- Page Content -->
    <div class="container">
      <div class="jumbotron">
        <div class="row">
            <div class="col-sm-12">
				<img class="img-responsive" src="${pageContext.request.contextPath}/images/Logo.png"/>
                <h2>Bienvenido!</h2>
                <p>Esta herramienta te ayudará a organizar tus horarios, tareas y exámenes en tu vida académica.</p>
            </div>
        </div>
        <!-- /.row -->
      </div>
    </div>
    <!-- /.container -->


      <!-- Latest compiled and minified JavaScript -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

      <script type="text/javascript" src="js/jquery.backstretch.min.js"></script>
        <script>
            $.backstretch("images/background.jpg", {speed: 500});
        </script>
    </body>
    </html>
				
