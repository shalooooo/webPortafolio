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
import BLL.EstEstacionamiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class EstEstacionamientoDAO {

  Conexion conn;

  public EstEstacionamientoDAO()
  {
      conn = new Conexion();
  }

  public EstEstacionamiento mostrarEstEstacionamiento(int id)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      EstEstacionamiento estEstacionamiento = new EstEstacionamiento();
      try {
          //PROCEDURE SP_MOSTRAR_EST_ESTACIONAMIENTO(P_ID_ESTADO EST_ESTACIONAMIENTO.ID_ESTADO%TYPE, PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call EST_ESTACIONAMIENTO_PKG.SP_MOSTRAR_EST_ESTACIONAMIENTO(?,?)}");
          cs.setInt(1, id);
          cs.registerOutParameter(2, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(2);
          while (rs.next())
          {
              estEstacionamiento.setIdEstEstacionamiento(rs.getInt("ID_ESTADO"));
              estEstacionamiento.setNombre(rs.getString("NOMBRE"));
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(EstEstacionamientoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return estEstacionamiento;
  }

  public List<EstEstacionamiento> todosEstEstacionamiento()
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      EstEstacionamiento estEstacionamiento = new EstEstacionamiento();
      List<EstEstacionamiento> listaEstEstacionamientos = new ArrayList<EstEstacionamiento>();
      try {
          //PROCEDURE SP_TODOS_EST_ESTACIONAMIENTO(PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call EST_ESTACIONAMIENTO_PKG.SP_TODOS_EST_ESTACIONAMIENTO(?)}");
          cs.registerOutParameter(1, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(1);
          while (rs.next())
          {
              estEstacionamiento.setIdEstEstacionamiento(rs.getInt("ID_ESTADO"));
              estEstacionamiento.setNombre(rs.getString("NOMBRE"));
              listaEstEstacionamientos.add(estEstacionamiento);
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(EstEstacionamientoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return listaEstEstacionamientos;
  }

}
