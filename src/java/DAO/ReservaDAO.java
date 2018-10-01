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
import BLL.Reserva;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class ReservaDAO {

      Conexion conn;

      public ReservaDAO()
      {
          conn = new Conexion();
      }

      public Reserva mostrarReserva(int id)
      {
          OracleCallableStatement cs = null;
          Connection cn = conn.getCnn();
          ResultSet rs = null;
          Reserva reserva = new Reserva();
          try {
              // PROCEDURE SP_MOSTRAR_RESERVA(P_ID_RESERVA RESERVA.ID_RESERVA%TYPE, PCURSOR OUT SYS_REFCURSOR);
              cs = (OracleCallableStatement)cn.prepareCall(" { call RESERVA_PKG.SP_MOSTRAR_RESERVA(?,?)}");
              cs.setInt(1, id);
              cs.registerOutParameter(2, OracleTypes.CURSOR);
              cs.execute();
              rs = (ResultSet) cs.getObject(2);
              while (rs.next())
              {
                  reserva.setIdReserva(rs.getInt("ID_RESERVA"));
                  reserva.setTiempoInicio(rs.getDate("TIEMPO_INICIO"));
                  reserva.setTiempoFin(rs.getDate("TIEMPO_FIN"));
                  reserva.setEstacionamientoId(rs.getInt("ESTACIONAMIENTO_ID"));
                  reserva.setUsuarioId(rs.getInt("USUARIO_ID_USUARIO"));
                  reserva.setMontoTarifa(rs.getInt("MONTO_TARIFA"));
                  reserva.setMinutosUsados(rs.getInt("MINUTOS_USADOS"));
                  reserva.setTotal(rs.getInt("TOTAL"));
                  reserva.setEstPagoId(rs.getInt("EST_PAGO_ID_ESTADO"));
                  reserva.setVehiculoId(rs.getInt("VEHICULO_ID"));
              }
          } catch (Exception mensaje)
          {
              Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
          }
          return reserva;
      }



      public List<Reserva> todosReserva()
      {
          OracleCallableStatement cs = null;
          Connection cn = conn.getCnn();
          ResultSet rs = null;
          Reserva reserva = new Reserva();
          List<Reserva> listaReservas = new ArrayList<Reserva>();
          try {
              //PROCEDURE SP_TODOS_RESERVA(PCURSOR OUT SYS_REFCURSOR);
              cs = (OracleCallableStatement)cn.prepareCall(" { call RESERVA_PKG.SP_TODOS_RESERVA(?)}");
              cs.registerOutParameter(1, OracleTypes.CURSOR);
              cs.execute();
              rs = (ResultSet) cs.getObject(1);
              while (rs.next())
              {
                  reserva.setIdReserva(rs.getInt("ID_RESERVA"));
                  reserva.setTiempoInicio(rs.getDate("TIEMPO_INICIO"));
                  reserva.setTiempoFin(rs.getDate("TIEMPO_FIN"));
                  reserva.setEstacionamientoId(rs.getInt("ESTACIONAMIENTO_ID"));
                  reserva.setUsuarioId(rs.getInt("USUARIO_ID_USUARIO"));
                  reserva.setMontoTarifa(rs.getInt("MONTO_TARIFA"));
                  reserva.setMinutosUsados(rs.getInt("MINUTOS_USADOS"));
                  reserva.setTotal(rs.getInt("TOTAL"));
                  reserva.setEstPagoId(rs.getInt("EST_PAGO_ID_ESTADO"));
                  reserva.setVehiculoId(rs.getInt("VEHICULO_ID"));
                  listaReservas.add(reserva);
              }
          } catch (Exception mensaje)
          {
              Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
          }
          return listaReservas;
      }

      public boolean insertarReserva(Reserva reserva)
      {
          OracleCallableStatement cs = null;
          Connection cn = conn.getCnn();
          try {
              /*PROCEDURE SP_INSERTAR_RESERVA(P_TIEMPO_INICIO RESERVA.TIEMPO_INICIO%TYPE,
                                        P_TIEMPO_FIN RESERVA.TIEMPO_FIN%TYPE,
                                        P_ESTACIONAMIENTO_ID RESERVA.ESTACIONAMIENTO_ID%TYPE,
                                        P_USUARIO_ID_USUARIO RESERVA.USUARIO_ID_USUARIO%TYPE,
                                        P_MONTO_TARIFA RESERVA.MONTO_TARIFA%TYPE,
                                        P_MINUTOS_USADOS RESERVA.MINUTOS_USADOS%TYPE,
                                        P_TOTAL RESERVA.TOTAL%TYPE,
                                        P_EST_PAGO_ID_ESTADO RESERVA.EST_PAGO_ID_ESTADO%TYPE,
                                        P_VEHICULO_ID RESERVA.VEHICULO_ID%TYPE);*/
              cs = (OracleCallableStatement) cn.prepareCall(" { call RESERVA_PKG.SP_INSERTAR_RESERVA(?,?,?,?,?,?,?,?,?)}");
              cs.setDate(1, (Date) reserva.getTiempoInicio());
              cs.setDate(2, (Date) reserva.getTiempoFin());
              cs.setInt(3,reserva.getEstacionamientoId());
              cs.setInt(4,reserva.getUsuarioId());
              cs.setInt(5,reserva.getMontoTarifa());
              cs.setInt(6,reserva.getMinutosUsados());
              cs.setInt(7,reserva.getTotal());
              cs.setInt(8,reserva.getEstPagoId());
              cs.setInt(9,reserva.getVehiculoId());
              cs.execute();
              return true;
          } catch (Exception mensaje) {
              Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
              return false;
          }
      }

      public boolean eliminarReserva(int id)
      {
          OracleCallableStatement cs = null;
          Connection cn = conn.getCnn();
          try {
              //PROCEDURE SP_ELIMINAR_RESERVA(P_ID_RESERVA RESERVA.ID_RESERVA%TYPE);
              cs = (OracleCallableStatement)cn.prepareCall(" { call RESERVA_PKG.SP_ELIMINAR_RESERVA(?)}");
              cs.setInt(1, id);
              cs.execute();
              return true;
          } catch (Exception mensaje) {
              Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
              return false;
          }
      }

      public boolean modificarReserva(Reserva reserva)
      {
          OracleCallableStatement cs = null;
          Connection cn = conn.getCnn();
          try {
              /*PROCEDURE SP_MODIFICAR_RESERVA(	P_ID_RESERVA RESERVA.ID_RESERVA%TYPE,
                                                P_TIEMPO_INICIO RESERVA.TIEMPO_INICIO%TYPE,
                                                P_TIEMPO_FIN RESERVA.TIEMPO_FIN%TYPE,
                                                P_ESTACIONAMIENTO_ID RESERVA.ESTACIONAMIENTO_ID%TYPE,
                                                P_USUARIO_ID_USUARIO RESERVA.USUARIO_ID_USUARIO%TYPE,
                                                P_MONTO_TARIFA RESERVA.MONTO_TARIFA%TYPE,
                                                P_MINUTOS_USADOS RESERVA.MINUTOS_USADOS%TYPE,
                                                P_TOTAL RESERVA.TOTAL%TYPE,
                                                P_EST_PAGO_ID_ESTADO RESERVA.EST_PAGO_ID_ESTADO%TYPE,
                                                P_VEHICULO_ID RESERVA.VEHICULO_ID%TYPE);*/
              cs = (OracleCallableStatement)cn.prepareCall(" { call RESERVA_PKG.SP_MODIFICAR_RESERVA(?,?,?,?,?,?,?,?,?,?)}");
              cs.setInt(1,reserva.getIdReserva());
              cs.setDate(2, (Date) reserva.getTiempoInicio());
              cs.setDate(3, (Date) reserva.getTiempoFin());
              cs.setInt(4,reserva.getEstacionamientoId());
              cs.setInt(5,reserva.getUsuarioId());
              cs.setInt(6,reserva.getMontoTarifa());
              cs.setInt(7,reserva.getMinutosUsados());
              cs.setInt(8,reserva.getTotal());
              cs.setInt(9,reserva.getEstPagoId());
              cs.setInt(10,reserva.getVehiculoId());
              cs.execute();
              return true;
          } catch (Exception mensaje) {
              Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
              return false;
          }
      }


}
