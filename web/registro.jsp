<!DOCTYPE html>
<html>
<head>
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
    <section class="content-header"><center>    
      <h1>
        Registro
      </h1></center>
    </section>
    <%  
        
        String resultado = (String) request.getAttribute("resultado");
        //resultado = "0";
        if (resultado != null) {
                if (resultado.equals("1")) {
                    %>
                        <div id="mensaje-verde" class="alert alert-success alert-dismissible" >
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <h4><i class="icon fa fa-check"></i> Registro Exitoso!</h4>
                            Ahora puedes iniciar tu sesion y reservar los mejores estacionamientos de santiago.
                        </div> 
                    <%
                } else {
                    if(resultado.equals("0")){
                    %>
                        <div id="mensaje-rojo" class="alert alert-danger alert-dismissible" >
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <h4><i class="icon fa fa-ban"></i> Registro Fallido!</h4>
                            Favor intentalo nuevamente.
                        </div>
                    <%
                    }  
                }
            }
        
        
    %>
    <!-- Main content -->
    <section class="content container-fluid">
            
            
              


  <div class="login-box-body">
    <p class="login-box-msg">Ingresa tus datos y crea tu cuenta personal</p>
    <form action="RegistrarCliente" method="post">
      <div class="form-group has-feedback">
          <input type="text" class="form-control" placeholder="RUT" name="txtRut">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="text" class="form-control" placeholder="Digito Verificador del RUT" name="txtDv">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="text" class="form-control" placeholder="Nombre" name="txtNombre">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Apellido Paterno" name="txtApePaterno">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Apellido Materno" name="txtApeMaterno">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" class="form-control" placeholder="Email" name="txtEmail">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Telefono" name="txtTelefono">
        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="password" class="form-control" placeholder="Contraseña" name="txtPassword">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="password" class="form-control" placeholder="Repita Contraseña" name="txtPassword2">
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