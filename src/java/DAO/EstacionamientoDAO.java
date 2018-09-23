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
import BLL.Estacionamiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class EstacionamientoDAO {

	Conexion conn;
    
    public EstacionamientoDAO()
    {
        conn = new Conexion();
    }

    public Estacionamiento mostrarEstacionamiento(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Estacionamiento estacionamiento = new Estacionamiento();
        try {
            // PROCEDURE SP_MOSTRAR_ESTACIONAMIENTO(P_ID_ESTACIONAMIENTO ESTACIONAMIENTO.ID_ESTACIONAMIENTO%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call ESTACIONAMIENTO_PKG.SP_MOSTRAR_ESTACIONAMIENTO(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next()) 
            {   
                estacionamiento.setIdEstacionamiento(rs.getInt("ID_ESTACIONAMIENTO"));
                estacionamiento.setIdentificador(rs.getString("IDENTIFICADOR"));
                estacionamiento.setUsuarioId(rs.getInt("USUARIO_ID_USUARIO"));
                estacionamiento.setDireccionId(rs.getInt("DIRECCION_ID_DIRECCION"));
                estacionamiento.setEstEstacionamientoId(rs.getInt("EST_ESTACIONAMIENTO_ID"));
                estacionamiento.setTipoAperturaId(rs.getInt("TIPO_APERTURA_ID"));
                estacionamiento.setTarifaActivaId(rs.getInt("TARIFA_ACTIVA_ID"));
                estacionamiento.setHorarioInicio(rs.getInt("HORARIO_INICIO"));
                estacionamiento.setHorarioFin(rs.getInt("HORARIO_FIN"));
            }   
        } catch (Exception mensaje) 
        {
            Logger.getLogger(EstacionamientoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return estacionamiento;
    }

    public List<Estacionamiento> todosEstacionamiento()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Estacionamiento estacionamiento = new Estacionamiento();
        List<Estacionamiento> listaEstacionamientos = new ArrayList<Estacionamiento>();
        try {
            // PROCEDURE SP_TODOS_ESTACIONAMIENTO(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call ESTACIONAMIENTO_PKG.SP_TODOS_ESTACIONAMIENTO(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next()) 
            {   
                estacionamiento.setIdEstacionamiento(rs.getInt("ID_ESTACIONAMIENTO"));
                estacionamiento.setIdentificador(rs.getString("IDENTIFICADOR"));
                estacionamiento.setUsuarioId(rs.getInt("USUARIO_ID_USUARIO"));
                estacionamiento.setDireccionId(rs.getInt("DIRECCION_ID_DIRECCION"));
                estacionamiento.setEstEstacionamientoId(rs.getInt("EST_ESTACIONAMIENTO_ID"));
                estacionamiento.setTipoAperturaId(rs.getInt("TIPO_APERTURA_ID"));
                estacionamiento.setTarifaActivaId(rs.getInt("TARIFA_ACTIVA_ID"));
                estacionamiento.setHorarioInicio(rs.getInt("HORARIO_INICIO"));
                estacionamiento.setHorarioFin(rs.getInt("HORARIO_FIN"));
                listaEstacionamientos.add(estacionamiento);
            }   
        } catch (Exception mensaje) 
        {
            Logger.getLogger(EstacionamientoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaEstacionamientos;
    }


    public void insertarEstacionamiento(Estacionamiento e)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_INSERTAR_ESTACIONAMIENTO( 	P_IDENTIFICADOR ESTACIONAMIENTO.IDENTIFICADOR%TYPE,
					                                	P_USUARIO_ID_USUARIO ESTACIONAMIENTO.USUARIO_ID_USUARIO%TYPE,
					                                	P_DIRECCION_ID_DIRECCION ESTACIONAMIENTO.DIRECCION_ID_DIRECCION%TYPE,
					                                	P_EST_ESTACIONAMIENTO_ID ESTACIONAMIENTO.EST_ESTACIONAMIENTO_ID%TYPE,
					                                	P_TIPO_APERTURA_ID ESTACIONAMIENTO.TIPO_APERTURA_ID%TYPE,
					                                	P_TARIFA_ACTIVA_ID ESTACIONAMIENTO.TARIFA_ACTIVA_ID%TYPE,
					                                	P_HORARIO_INICIO ESTACIONAMIENTO.HORARIO_INICIO%TYPE,
					                                	P_HORARIO_FIN ESTACIONAMIENTO.HORARIO_FIN%TYPE);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call ESTACIONAMIENTO_PKG.SP_INSERTAR_ESTACIONAMIENTO(?,?,?,?,?,?,?,?)}");
            cs.setString(1, e.getIdentificador());
            cs.setInt(2, e.getUsuarioId());
            cs.setInt(3, e.getDireccionId());
            cs.setInt(4, e.getEstEstacionamientoId());
            cs.setInt(5, e.getTipoAperturaId());
            cs.setInt(6, e.getTarifaActivaId());
            cs.setInt(7, e.getHorarioInicio());
            cs.setInt(8, e.getHorarioFin());
            cs.execute();
        } catch (Exception mensaje) {
            Logger.getLogger(EstacionamientoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
    }

    public void eliminarEstacionamiento(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            // PROCEDURE SP_ELIMINAR_ESTACIONAMIENTO(P_ID_ESTACIONAMIENTO ESTACIONAMIENTO.ID_ESTACIONAMIENTO%TYPE);
            cs = (OracleCallableStatement)cn.prepareCall(" { call ESTACIONAMIENTO_PKG.SP_ELIMINAR_ESTACIONAMIENTO(?)}");
            cs.setInt(1, id);
            cs.execute();
        } catch (Exception mensaje) {
            Logger.getLogger(EstacionamientoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
    }

    public void modificarEstacionamiento(Estacionamiento e)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_MODIFICAR_ESTACIONAMIENTO(	P_ID_ESTACIONAMIENTO ESTACIONAMIENTO.ID_ESTACIONAMIENTO%TYPE,
					                                	P_IDENTIFICADOR ESTACIONAMIENTO.IDENTIFICADOR%TYPE,
					                                	P_USUARIO_ID_USUARIO ESTACIONAMIENTO.USUARIO_ID_USUARIO%TYPE,
					                                	P_DIRECCION_ID_DIRECCION ESTACIONAMIENTO.DIRECCION_ID_DIRECCION%TYPE,
					                                	P_EST_ESTACIONAMIENTO_ID ESTACIONAMIENTO.EST_ESTACIONAMIENTO_ID%TYPE,
					                                	P_TIPO_APERTURA_ID ESTACIONAMIENTO.TIPO_APERTURA_ID%TYPE,
					                                	P_TARIFA_ACTIVA_ID ESTACIONAMIENTO.TARIFA_ACTIVA_ID%TYPE,
					                                	P_HORARIO_INICIO ESTACIONAMIENTO.HORARIO_INICIO%TYPE,
					                                	P_HORARIO_FIN ESTACIONAMIENTO.HORARIO_FIN%TYPE);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call ESTACIONAMIENTO_PKG.SP_MODIFICAR_ESTACIONAMIENTO(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, e.getIdEstacionamiento());
            cs.setString(2, e.getIdentificador());
            cs.setInt(3, e.getUsuarioId());
            cs.setInt(4, e.getDireccionId());
            cs.setInt(5, e.getEstEstacionamientoId());
            cs.setInt(6, e.getTipoAperturaId());
            cs.setInt(7, e.getTarifaActivaId());
            cs.setInt(8, e.getHorarioInicio());
            cs.setInt(9, e.getHorarioFin());
            cs.execute();
        } catch (Exception mensaje) {
            Logger.getLogger(EstacionamientoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
    }

}
