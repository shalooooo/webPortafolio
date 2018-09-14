<%@page import="DAO.UsuarioDAO"%>
<%@page import="BLL.Usuario"%>
<%@page import="DAO.Conexion"%>
<%
//Conexion conn = new Conexion();
Usuario u =  new Usuario();            
u.setEmail(request.getParameter("txtEmail"));
u.setPassword(request.getParameter("txtPassword"));
UsuarioDAO usuarioDAO = new UsuarioDAO();
Usuario usuario = usuarioDAO.validarUsuario(u);
//out.println("NOMBRE:" + usuario.getNombre());
if (usuario == null) {
    response.sendRedirect("ingreso.jsp");
} else {
    HttpSession miSesion = request.getSession();
    miSesion.setAttribute("usuario",usuario);
    response.sendRedirect("../perfil.jsp");    
}
//conn.desonectarBD();
%>