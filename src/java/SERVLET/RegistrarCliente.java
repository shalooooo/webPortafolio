/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.Hash;
import DAO.UsuarioDAO;
import BLL.Usuario;

/**
 *
 * @author Gonzalo
 */
public class RegistrarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario u =  new Usuario();        
        u.setNombre(request.getParameter("txtNombre"));
        u.setRut(Integer.parseInt(request.getParameter("txtRut")));
        u.setDv((request.getParameter("txtDv")));        
        u.setApePaterno(request.getParameter("txtApePaterno"));
        u.setApeMaterno(request.getParameter("txtApeMaterno"));
        u.setEmail(request.getParameter("txtEmail"));
        u.setTelefono(request.getParameter("txtTelefono"));
        u.setPassword(Hash.sha1(request.getParameter("txtPassword")));
        u.setRolId(2);
        u.setEstadoUsuarioId(1);
        u.setCuentaId(1);
        u.setTarjetaId(1);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String resultado;
        if (usuarioDAO.insertarUsuario(u)) {
            //response.sendRedirect("../ingreso.jsp");
            resultado = "1";
        } else {
            //response.sendRedirect("../registro.jsp");
            resultado = "0";
        }
        request.setAttribute("resultado", resultado);
        request.getRequestDispatcher("registro.jsp").forward(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
