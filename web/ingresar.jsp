<%@page import="DAO.Conexion"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="BLL.Usuario"%>
<%@ page import="   java.sql.*, 
                    java.util.*, 
                    java.net.*, 
                    oracle.jdbc.*, 
                    oracle.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<!-- Head -->
<jsp:include page="includes/head.jsp"></jsp:include>

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Header -->
      <jsp:include page="includes/header.jsp"></jsp:include>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar Menu -->
      <jsp:include page="includes/menu.jsp"></jsp:include>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <center>    
      <h1>
        Inicio de Sesion
      </h1>
      </center>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->

        <div class="login-box-body">
    <p class="login-box-msg">Ingresa tus credenciales para iniciar tu sesion</p>
    <form action="actions/ValidarUsuario.jsp">
      <div class="form-group has-feedback">
        <input type="email" class="form-control" placeholder="Email" name="txtEmail">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Password" name="txtPassword">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
        </div>
        <!-- /.col -->
      </div>
    </form>


  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
    <jsp:include page="includes/footer.jsp"></jsp:include>

</div>
<!-- ./wrapper -->

 <!-- Scripts JS Requeridos -->
    <jsp:include page="includes/scripts.jsp"></jsp:include>
</body>
</html>