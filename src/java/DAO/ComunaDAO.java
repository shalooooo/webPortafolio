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
import BLL.Comuna;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class ComunaDAO {

    Conexion conn;

    public ComunaDAO()
    {
        conn = new Conexion();
    }

    public Comuna mostrarComuna(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Comuna comuna = new Comuna();
        try {
            // PROCEDURE SP_MOSTRAR_COMUNA(P_ID_COMUNA COMUNA.ID_COMUNA%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call COMUNA_PKG.SP_MOSTRAR_COMUNA(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next())
            {
                comuna.setIdComuna(rs.getInt("ID_COMUNA"));
                comuna.setNombre(rs.getString("NOMBRE"));
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return comuna;
    }

    public List<Comuna> todosComuna()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Comuna comuna = new Comuna();
        List<Comuna> listaComunas = new ArrayList<Comuna>();
        try {
            // PROCEDURE SP_TODOS_COMUNA(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call COMUNA_PKG.SP_TODOS_COMUNA(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next())
            {
                comuna.setIdComuna(rs.getInt("ID_COMUNA"));
                comuna.setNombre(rs.getString("NOMBRE"));
                listaComunas.add(comuna);
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaComunas;
    }


}
