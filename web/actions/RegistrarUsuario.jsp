<%@page import="DAO.Hash"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="BLL.Usuario"%>
<%@page import="DAO.Conexion"%>
<%
Usuario u =  new Usuario();        
u.setRut(Integer.parseInt(request.getParameter("txtRut")));
u.setNombre(request.getParameter("txtNombre"));
u.setApePaterno(request.getParameter("txtApePaterno"));
u.setApeMaterno(request.getParameter("txtApeMaterno"));
u.setEmail(request.getParameter("txtEmail"));
u.setTelefono(request.getParameter("txtTelefono"));
u.setPassword(Hash.sha1(request.getParameter("txtPassword")));
u.setRolId(2);
u.setEstadoUsuarioId(1);
/*
if (request.getParameter("txtPassword").equals(request.getParameter("txtPassword2"))) {
    u.setPassword(Hash.sha1(request.getParameter("txtPassword")));
}
*/
UsuarioDAO usuarioDAO = new UsuarioDAO();
if (usuarioDAO.insertarUsuario(u)) {
    response.sendRedirect("../ingreso.jsp");
} else {
    response.sendRedirect("../registro.jsp");
}


%>