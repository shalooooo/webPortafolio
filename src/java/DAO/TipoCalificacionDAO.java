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
import BLL.TipoCalificacion;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gonzalo
 */
public class TipoCalificacionDAO {
  Conexion conn;

  public TipoCalificacionDAO()
  {
      conn = new Conexion();
  }

  public TipoCalificacion mostrarTipoCalificacion(int id)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      TipoCalificacion tipoCalificacion = new TipoCalificacion();
      try {
          //  PROCEDURE SP_MOSTRAR_TIPO_CALIFICACION(P_ID_TIPO_CALIFICACION TIPO_CALIFICACION.ID_TIPO_CALIFICACION%TYPE, PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call TIPO_CALIFICACION_PKG.SP_MOSTRAR_TIPO_CALIFICACION(?,?)}");
          cs.setInt(1, id);
          cs.registerOutParameter(2, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(2);
          while (rs.next())
          {
              tipoCalificacion.setIdTipoCalificacion(rs.getInt("ID_TIPO_CALIFICACION"));
              tipoCalificacion.setNombre(rs.getString("NOMBRE"));
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(TipoCalificacionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return tipoCalificacion;
  }

  public List<TipoCalificacion> todosTipoCalificacion()
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      TipoCalificacion tipoCalificacion = new TipoCalificacion();
      List<TipoCalificacion> listaTipoCalificaciones = new ArrayList<TipoCalificacion>();
      try {
          //PROCEDURE SP_TODOS_TIPO_CALIFICACION(PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call TIPO_CALIFICACION_PKG.SP_TODOS_TIPO_CALIFICACION(?)}");
          cs.registerOutParameter(1, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(1);
          while (rs.next())
          {
              tipoCalificacion.setIdTipoCalificacion(rs.getInt("ID_TIPO_CALIFICACION"));
              tipoCalificacion.setNombre(rs.getString("NOMBRE"));
              listaTipoCalificaciones.add(tipoCalificacion);
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(TipoCalificacionDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return listaTipoCalificaciones;
  }
}
