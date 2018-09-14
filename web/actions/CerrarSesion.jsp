<%@page import="DAO.Conexion"%>
<%
Conexion conn = new Conexion();
HttpSession miSesion = request.getSession();
miSesion.invalidate();
response.sendRedirect("../index.jsp");
%>