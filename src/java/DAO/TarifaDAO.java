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
import BLL.Tarifa;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Gonzalo
 */
public class TarifaDAO {
  Conexion conn;

  public TarifaDAO()
  {
      conn = new Conexion();
  }

  public Tarifa mostrarTarifa(int id)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      Tarifa tarifa = new Tarifa();
      try {
          // PROCEDURE SP_MOSTRAR_TARIFA(P_ID_TARIFA TARIFA.ID_TARIFA%TYPE, PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call TARIFA_PKG.SP_MOSTRAR_TARIFA(?,?)}");
          cs.setInt(1, id);
          cs.registerOutParameter(2, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(2);
          while (rs.next())
          {
              tarifa.setIdTarifa(rs.getInt("ID_TARIFA"));
              tarifa.setMonto(rs.getInt("MONTO"));
              tarifa.setTipoTarifaId(rs.getInt("TIPO_TARIFA_ID"));
              tarifa.setEstacionamientoId(rs.getInt("ESTACIONAMIENTO_ID"));
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(TarifaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return tarifa;
  }

  public List<Tarifa> todosTarifa()
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      Tarifa tarifa = new Tarifa();
      List<Tarifa> listaTarifas = new ArrayList<Tarifa>();
      try {
          // PROCEDURE SP_TODOS_TARIFA(PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call TARIFA_PKG.SP_TODOS_TARIFA(?)}");
          cs.registerOutParameter(1, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(1);
          while (rs.next())
          {
              tarifa.setIdTarifa(rs.getInt("ID_TARIFA"));
              tarifa.setMonto(rs.getInt("MONTO"));
              tarifa.setTipoTarifaId(rs.getInt("TIPO_TARIFA_ID"));
              tarifa.setEstacionamientoId(rs.getInt("ESTACIONAMIENTO_ID"));
              listaTarifas.add(tarifa);
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(TarifaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return listaTarifas;
  }

  public boolean insertarTarifa(Tarifa tarifa)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      try {
          /*PROCEDURE SP_INSERTAR_TARIFA( P_MONTO TARIFA.MONTO%TYPE,
                                        P_TIPO_TARIFA_ID TARIFA.TIPO_TARIFA_ID%TYPE,
                                        P_ESTACIONAMIENTO_ID TARIFA.ESTACIONAMIENTO_ID%TYPE);*/
          cs = (OracleCallableStatement) cn.prepareCall(" { call TARIFA_PKG.SP_INSERTAR_TARIFA(?,?,?)}");
          cs.setInt(1,tarifa.getMonto());
          cs.setInt(2,tarifa.getTipoTarifaId());
          cs.setInt(3,tarifa.getEstacionamientoId());
          cs.execute();
          return true;
      } catch (Exception mensaje) {
          Logger.getLogger(TarifaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
          return false;
      }
  }

  public boolean eliminarTarifa(int id)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      try {
          // PROCEDURE SP_ELIMINAR_TARIFA(P_ID_TARIFA TARIFA.ID_TARIFA%TYPE);
          cs = (OracleCallableStatement)cn.prepareCall(" { call TARIFA_PKG.SP_ELIMINAR_TARIFA(?)}");
          cs.setInt(1, id);
          cs.execute();
          return true;
      } catch (Exception mensaje) {
          Logger.getLogger(TarifaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
          return false;
      }
  }

  public boolean modificarTarifa(Tarifa tarifa)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      try {
          /*PROCEDURE SP_MODIFICAR_TARIFA(P_ID_TARIFA TARIFA.ID_TARIFA%TYPE,
                                          P_MONTO TARIFA.MONTO%TYPE,
                                          P_TIPO_TARIFA_ID TARIFA.TIPO_TARIFA_ID%TYPE,
                                          P_ESTACIONAMIENTO_ID TARIFA.ESTACIONAMIENTO_ID%TYPE);*/
          cs = (OracleCallableStatement)cn.prepareCall(" { call TARIFA_PKG.SP_MODIFICAR_TARIFA(?,?)}");
          cs.setInt(1,tarifa.getIdTarifa());
          cs.setInt(2,tarifa.getMonto());
          cs.setInt(3,tarifa.getTipoTarifaId());
          cs.setInt(4,tarifa.getEstacionamientoId());
          cs.execute();
          return true;
      } catch (Exception mensaje) {
          Logger.getLogger(TarifaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
          return false;
      }
  }
}
/*

private int idTarifa;
private int monto;
private int tipoTarifaId;
private int estacionamientoId;

CREATE TABLE tarifa (
    id_tarifa            NUMBER(11) NOT NULL,
    monto                NUMBER(11) NOT NULL,
    tipo_tarifa_id       NUMBER(11) NOT NULL,
    estacionamiento_id   NUMBER(11) NOT NULL
);

setIdTarifa(idTarifa);
setMonto(monto);
setTipoTarifaId(tipoTarifaId);
setEstacionamientoId(estacionamientoId);


*/
