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
import BLL.Direccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class DireccionDAO {

    Conexion conn;

    public DireccionDAO()
    {
        conn = new Conexion();
    }

    public Direccion mostrarDireccion(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Direccion direccion = new Direccion();
        try {
            // PROCEDURE SP_MOSTRAR_DIRECCION(P_ID_DIRECCION DIRECCION.ID_DIRECCION%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call DIRECCION_PKG.SP_MOSTRAR_DIRECCION(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next())
            {
                direccion.setIdDireccion(rs.getInt("ID_DIRECCION"));
                direccion.setCalle(rs.getString("CALLE"));
                direccion.setNumeracion(rs.getInt("NUMERACION"));
                direccion.setLatitud(rs.getFloat("LATITUD"));
                direccion.setLongitud(rs.getFloat("LONGITUD"));
                direccion.setComunaId(rs.getInt("COMUNA_ID_COMUNA"));
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return direccion;
    }

    public List<Direccion> todosDireccion()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Direccion direccion = new Direccion();
        List<Direccion> listaDirecciones = new ArrayList<Direccion>();
        try {
            // PROCEDURE SP_TODOS_DIRECCION(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call DIRECCION_PKG.SP_TODOS_DIRECCION(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next())
            {
                direccion.setIdDireccion(rs.getInt("ID_DIRECCION"));
                direccion.setCalle(rs.getString("CALLE"));
                direccion.setNumeracion(rs.getInt("NUMERACION"));
                direccion.setLatitud(rs.getFloat("LATITUD"));
                direccion.setLongitud(rs.getFloat("LONGITUD"));
                direccion.setComunaId(rs.getInt("COMUNA_ID_COMUNA"));
                listaDirecciones.add(direccion);
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaDirecciones;
    }

    public boolean insertarDireccion(Direccion direccion)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_INSERTAR_DIRECCION(  P_CALLE DIRECCION.CALLE%TYPE,
                                  P_NUMERACION DIRECCION.NUMERACION%TYPE,
                                  P_LATITUD DIRECCION.LATITUD%TYPE,
                                  P_LONGITUD DIRECCION.LONGITUD%TYPE,
                                  P_COMUNA_ID_COMUNA DIRECCION.COMUNA_ID_COMUNA%TYPE);*/
            cs = (OracleCallableStatement) cn.prepareCall(" { call DIRECCION_PKG.SP_INSERTAR_DIRECCION(?,?,?,?,?)}");
            cs.setString(1, direccion.getCalle());
            cs.setInt(2, direccion.getNumeracion());
            cs.setFloat(3, direccion.getLatitud());
            cs.setFloat(4, direccion.getLongitud());
            cs.setInt(5, direccion.getComunaId());

            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

    public boolean eliminarDireccion(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            //PROCEDURE SP_ELIMINAR_DIRECCION(P_ID_DIRECCION DIRECCION.ID_DIRECCION%TYPE);
            cs = (OracleCallableStatement)cn.prepareCall(" { call DIRECCION_PKG.SP_ELIMINAR_DIRECCION(?)}");
            cs.setInt(1, id);
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

    public boolean modificarDireccion(Direccion direccion)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_MODIFICAR_DIRECCION( P_ID_DIRECCION DIRECCION.ID_DIRECCION%TYPE,
                                  P_CALLE DIRECCION.CALLE%TYPE,
                                  P_NUMERACION DIRECCION.NUMERACION%TYPE,
                                  P_LATITUD DIRECCION.LATITUD%TYPE,
                                  P_LONGITUD DIRECCION.LONGITUD%TYPE,
                                  P_COMUNA_ID_COMUNA DIRECCION.COMUNA_ID_COMUNA%TYPE);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call DIRECCION_PKG.SP_MODIFICAR_DIRECCION(?,?,?,?,?,?)}");
            cs.setInt(1,direccion.getIdDireccion());
            cs.setString(2, direccion.getCalle());
            cs.setInt(3, direccion.getNumeracion());
            cs.setFloat(4, direccion.getLatitud());
            cs.setFloat(5, direccion.getLongitud());
            cs.setInt(6, direccion.getComunaId());
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(DireccionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }



}
