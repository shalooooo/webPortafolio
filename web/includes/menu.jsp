<%@page import="BLL.Usuario"%>
<%
    HttpSession miSesion = request.getSession();
    Usuario usuario = null;
    usuario = (Usuario) miSesion.getAttribute("usuario");
%>
<ul class="sidebar-menu" data-widget="tree">
        <li class="header">Menu</li>
        <!-- Optionally, you can add icons to the links -->
        <li><a href="index.jsp"><i class="fa fa-search"></i> <span>Buscador</span></a></li>
        <%
              if(usuario == null){
        %>
        
        <%
              } else {
        %>
        <li><a href="perfil.jsp"><i class="fa fa-vcard"></i> <span>Mi Perfil</span></a></li>
        <li><a href="#"><i class="fa fa-calendar-check-o"></i> <span>Mis Reservas</span></a></li>
        <li><a href="#"><i class="fa fa-car"></i> <span>Mis Vehiculos</span></a></li>
        <li><a href="#"><i class="fa fa-exchange"></i> <span>Agregar Estacionamiento</span></a></li>
        <li><a href="#"><i class="fa fa-eye"></i> <span>Admin. Estacionamientos</span></a></li>
        <%
              } 
        %>

</ul>