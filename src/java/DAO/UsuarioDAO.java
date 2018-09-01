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
    
    public Usuario validarUsuario(Usuario usu)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            cs = (OracleCallableStatement)cn.prepareCall(" { call USUARIO_PKG.SP_VALIDAR_USUARIO(?,?,?)}");
            cs.setString(1, usu.getEmail());
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
}
