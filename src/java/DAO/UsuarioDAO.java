/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import BLL.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class UsuarioDAO {
    
    Conexion conn;
    
    public UsuarioDAO()
    {
        conn = new Conexion();
    }   
    
    public Usuario mostrarUsuario(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            // PROCEDURE SP_MOSTRAR_USUARIO(P_ID_USUARIO USUARIO.ID_USUARIO%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call USUARIO_PKG.SP_MOSTRAR_USUARIO(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) 
            {   
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setRut(rs.getInt("RUT"));
                usuario.setDv(rs.getString("DV"));
                usuario.setApePaterno(rs.getString("APE_PATERNO"));
                usuario.setApeMaterno(rs.getString("APE_MATERNO"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setTelefono(rs.getString("TELEFONO"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setRolId(rs.getInt("ROL_ID_ROL"));
                usuario.setEstadoUsuarioId(rs.getInt("EST_USUARIO_ID_ESTADO"));
                usuario.setCuentaId(rs.getInt("CUENTA_ID_CUENTA"));
                usuario.setTarjetaId(rs.getInt("TARJETA_ID_TARJETA"));
            }   
        } catch (Exception mensaje) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return usuario;
    }

    public List<Usuario> todosUsuario()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            // PROCEDURE SP_TODOS_USUARIO(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call USUARIO_PKG.SP_TODOS_USUARIO(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) 
            {   
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setRut(rs.getInt("RUT"));
                usuario.setDv(rs.getString("DV"));
                usuario.setApePaterno(rs.getString("APE_PATERNO"));
                usuario.setApeMaterno(rs.getString("APE_MATERNO"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setTelefono(rs.getString("TELEFONO"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setRolId(rs.getInt("ROL_ID_ROL"));
                usuario.setEstadoUsuarioId(rs.getInt("EST_USUARIO_ID_ESTADO"));
                usuario.setCuentaId(rs.getInt("CUENTA_ID_CUENTA"));
                usuario.setTarjetaId(rs.getInt("TARJETA_ID_TARJETA"));
                listaUsuarios.add(usuario);
            }   
        } catch (Exception mensaje) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaUsuarios;
    }

    public void insertarUsuario(Usuario usu)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_INSERTAR_USUARIO(  P_NOMBRE USUARIO.NOMBRE%TYPE, 
                                              P_RUT USUARIO.RUT%TYPE,
                                              P_DV USUARIO.DV%TYPE,
                                              P_APE_PATERNO USUARIO.APE_PATERNO%TYPE, 
                                              P_APE_MATERNO USUARIO.APE_MATERNO%TYPE, 
                                              P_EMAIL USUARIO.EMAIL%TYPE, 
                                              P_TELEFONO USUARIO.TELEFONO%TYPE, 
                                              P_PASSWORD USUARIO.PASSWORD%TYPE, 
                                              P_ROL_ID_ROL USUARIO.ROL_ID_ROL%TYPE, 
                                              P_EST_USUARIO_ID_ESTADO USUARIO.EST_USUARIO_ID_ESTADO%TYPE,
                                              P_CUENTA_ID_CUENTA USUARIO.CUENTA_ID_CUENTA%TYPE,
                                              P_TARJETA_ID_TARJETA USUARIO.TARJETA_ID_TARJETA%TYPE);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call USUARIO_PKG.SP_INSERTAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, usu.getNombre());
            cs.setInt(2,usu.getRut());
            cs.setString(3,usu.getDv());
            cs.setString(4,usu.getApePaterno());
            cs.setString(5,usu.getApeMaterno());
            cs.setString(6,usu.getEmail());
            cs.setString(7,usu.getTelefono());
            cs.setString(8,usu.getPassword());
            cs.setInt(9,usu.getRolId());
            cs.setInt(10,usu.getEstadoUsuarioId());
            cs.setInt(11,usu.getCuentaId());
            cs.setInt(12,usu.getTarjetaId());
            cs.execute();
        } catch (Exception mensaje) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
    }

    public void eliminarUsuario(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            // PROCEDURE SP_ELIMINAR_USUARIO(P_ID_USUARIO USUARIO.ID_USUARIO%TYPE);
            cs = (OracleCallableStatement)cn.prepareCall(" { call USUARIO_PKG.SP_ELIMINAR_USUARIO(?)}");
            cs.setInt(1, id);
            cs.execute();
        } catch (Exception mensaje) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
    }


    public void modificarUsuario(Usuario usu)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_MODIFICAR_USUARIO( P_ID_USUARIO USUARIO.ID_USUARIO%TYPE, 
                                              P_NOMBRE USUARIO.NOMBRE%TYPE, 
                                              P_RUT USUARIO.RUT%TYPE,
                                              P_DV USUARIO.DV%TYPE, 
                                              P_APE_PATERNO USUARIO.APE_PATERNO%TYPE, 
                                              P_APE_MATERNO USUARIO.APE_MATERNO%TYPE, 
                                              P_EMAIL USUARIO.EMAIL%TYPE, 
                                              P_TELEFONO USUARIO.TELEFONO%TYPE, 
                                              P_PASSWORD USUARIO.PASSWORD%TYPE, 
                                              P_ROL_ID_ROL USUARIO.ROL_ID_ROL%TYPE, 
                                              P_EST_USUARIO_ID_ESTADO USUARIO.EST_USUARIO_ID_ESTADO%TYPE,
                                              P_CUENTA_ID_CUENTA USUARIO.CUENTA_ID_CUENTA%TYPE,
                                              P_TARJETA_ID_TARJETA USUARIO.TARJETA_ID_TARJETA%TYPE);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call USUARIO_PKG.SP_MODIFICAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1,usu.getIdUsuario());
            cs.setString(2,usu.getNombre());
            cs.setInt(3,usu.getRut());
            cs.setString(4,usu.getDv());
            cs.setString(5,usu.getApePaterno());
            cs.setString(6,usu.getApeMaterno());
            cs.setString(7,usu.getEmail());
            cs.setString(8,usu.getTelefono());
            cs.setString(9,usu.getPassword());
            cs.setInt(10,usu.getRolId());
            cs.setInt(11,usu.getEstadoUsuarioId());
            cs.setInt(12,usu.getCuentaId());
            cs.setInt(13,usu.getTarjetaId());
            cs.execute();
        } catch (Exception mensaje) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
    }
    
    
    public Usuario validarUsuario(Usuario usu)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            cs = (OracleCallableStatement)cn.prepareCall(" { call USUARIO_PKG.SP_VALIDAR_USUARIO(?,?,?)}");
            cs.setString(1, usu.getEmail());
            //cs.setString(2, usu.getPassword());
            cs.setString(2, Hash.sha1(usu.getPassword()));
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(3);
            while (rs.next()) 
            {   
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setRut(rs.getInt("RUT"));
                usuario.setDv(rs.getString("DV"));
                usuario.setApePaterno(rs.getString("APE_PATERNO"));
                usuario.setApeMaterno(rs.getString("APE_MATERNO"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setTelefono(rs.getString("TELEFONO"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setRolId(rs.getInt("ROL_ID_ROL"));
                usuario.setEstadoUsuarioId(rs.getInt("EST_USUARIO_ID_ESTADO"));
                usuario.setCuentaId(rs.getInt("CUENTA_ID_CUENTA"));
                usuario.setTarjetaId(rs.getInt("TARJETA_ID_TARJETA"));
            }   
        } catch (Exception mensaje) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return usuario;
    }
    
    public Usuario validarEmailUsuario(Usuario usu)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            /*PROCEDURE SP_VALIDAR_EMAIL_USUARIO(   P_EMAIL USUARIO.EMAIL%TYPE,
                                                    PCURSOR OUT SYS_REFCURSOR);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call USUARIO_PKG.SP_VALIDAR_EMAIL_USUARIO(?,?)}");
            cs.setString(1, usu.getEmail());
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            
            while (rs.next()) 
            {   
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setRut(rs.getInt("RUT"));
                usuario.setDv(rs.getString("DV"));
                usuario.setApePaterno(rs.getString("APE_PATERNO"));
                usuario.setApeMaterno(rs.getString("APE_MATERNO"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setTelefono(rs.getString("TELEFONO"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setRolId(rs.getInt("ROL_ID_ROL"));
                usuario.setEstadoUsuarioId(rs.getInt("EST_USUARIO_ID_ESTADO"));
                usuario.setCuentaId(rs.getInt("CUENTA_ID_CUENTA"));
                usuario.setTarjetaId(rs.getInt("TARJETA_ID_TARJETA"));
            }   
        } catch (Exception mensaje) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return usuario;
    }
    
    
}
