<%@page import="BLL.Usuario"%>
<header class="main-header">
<%
    HttpSession miSesion = request.getSession();
    Usuario usuario = null;
    usuario = (Usuario) miSesion.getAttribute("usuario");
%>
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>PTE</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">Pide<b>Tu</b>Estacionamiento</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Navegación</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">


          <!-- Control Sidebar Toggle Button -->
          
          <%
              if(usuario != null){
          %>
          <li>
            <a href="actions/CerrarSesion.jsp" ><i class="fa fa-sign-out"></i>   Salir</a>
          </li>
          <%
              } else {
          %>
          <li>
            <a href="ingresar.jsp" ><i class="fa fa-sign-in"></i>   Iniciar Sesion</a>
          </li>
          <li>
            <a href="registro.jsp" ><i class="fa fa-user"></i>   Registrarse</a>
          </li>
          <%
              } 
          %>
        </ul>
      </div>
    </nav>
</header>