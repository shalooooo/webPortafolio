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
import BLL.Calificacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */



public class CalificacionDAO {

    Conexion conn;

    public CalificacionDAO()
    {
        conn = new Conexion();
    }

    public Calificacion mostrarCalificacion(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Calificacion calificacion = new Calificacion();
        try {
            // PROCEDURE SP_MOSTRAR_CALIFICACION(P_ID_CALIFICACION CALIFICACION.ID_CALIFICACION%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call CALIFICACION_PKG.SP_MOSTRAR_CALIFICACION(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next())
            {
                calificacion.setIdCalificacion(rs.getInt("ID_CALIFICACION"));
                calificacion.setNota(rs.getInt("NOTA"));
                calificacion.setReservaId(rs.getInt("RESERVA_ID_RESERVA"));
                calificacion.setUsuarioId(rs.getInt("USUARIO_ID_USUARIO"));
                calificacion.setTipoCalificacionId(rs.getInt("TIPO_CALIFICACION_ID"));
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(CalificacionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return calificacion;
    }

    public List<Calificacion> todosCalificacion()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Calificacion calificacion = new Calificacion();
        List<Calificacion> listaCalificaciones = new ArrayList<Calificacion>();
        try {
            // PROCEDURE SP_TODOS_CALIFICACION(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call CALIFICACION_PKG.SP_TODOS_CALIFICACION(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next())
            {
                calificacion.setIdCalificacion(rs.getInt("ID_CALIFICACION"));
                calificacion.setNota(rs.getInt("NOTA"));
                calificacion.setReservaId(rs.getInt("RESERVA_ID_RESERVA"));
                calificacion.setUsuarioId(rs.getInt("USUARIO_ID_USUARIO"));
                calificacion.setTipoCalificacionId(rs.getInt("TIPO_CALIFICACION_ID"));
                listaCalificaciones.add(calificacion);
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(CalificacionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaCalificaciones;
    }

    public boolean insertarCalificacion(Calificacion calificacion)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_INSERTAR_CALIFICACION(   P_NOTA CALIFICACION.NOTA%TYPE,
                                                  P_RESERVA_ID_RESERVA CALIFICACION.RESERVA_ID_RESERVA%TYPE,
                                                  P_USUARIO_ID_USUARIO CALIFICACION.USUARIO_ID_USUARIO%TYPE,
                                                  P_TIPO_CALIFICACION_ID CALIFICACION.TIPO_CALIFICACION_ID%TYPE);*/
            cs = (OracleCallableStatement) cn.prepareCall(" { call CALIFICACION_PKG.SP_INSERTAR_BANCO(?,?,?,?)}");
            cs.setInt(1, calificacion.getNota());
            cs.setInt(2, calificacion.getReservaId());
            cs.setInt(3, calificacion.getUsuarioId());
            cs.setInt(4, calificacion.getTipoCalificacionId());
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(CalificacionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

    public boolean eliminarCalificacion(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            // PROCEDURE SP_ELIMINAR_CALIFICACION(P_ID_CALIFICACION CALIFICACION.ID_CALIFICACION%TYPE);
            cs = (OracleCallableStatement)cn.prepareCall(" { call CALIFICACION_PKG.SP_ELIMINAR_CALIFICACION(?)}");
            cs.setInt(1, id);
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(CalificacionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

    public boolean modificarCalificacion(Calificacion calificacion)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_MODIFICAR_CALIFICACION(  P_ID_CALIFICACION CALIFICACION.ID_CALIFICACION%TYPE,
                                                  P_NOTA CALIFICACION.NOTA%TYPE,
                                                  P_RESERVA_ID_RESERVA CALIFICACION.RESERVA_ID_RESERVA%TYPE,
                                                  P_USUARIO_ID_USUARIO CALIFICACION.USUARIO_ID_USUARIO%TYPE,
                                                  P_TIPO_CALIFICACION_ID CALIFICACION.TIPO_CALIFICACION_ID%TYPE);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call CALIFICACION_PKG.SP_MODIFICAR_CALIFICACION(?,?,?,?,?)}");
            cs.setInt(1,calificacion.getIdCalificacion());
            cs.setInt(2,calificacion.getNota());
            cs.setInt(3,calificacion.getReservaId());
            cs.setInt(4,calificacion.getUsuarioId());
            cs.setInt(5,calificacion.getTipoCalificacionId());
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(CalificacionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }



}
