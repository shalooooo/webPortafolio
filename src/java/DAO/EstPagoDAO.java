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
import BLL.EstPago;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gonzalo
 */
public class EstPagoDAO {

  Conexion conn;

  public EstPagoDAO()
  {
      conn = new Conexion();
  }

  public EstPago mostrarEstPago(int id)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      EstPago estPago = new EstPago();
      try {
          //PROCEDURE SP_MOSTRAR_EST_PAGO(P_ID_ESTADO EST_PAGO.ID_ESTADO%TYPE, PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call EST_PAGO_PKG.SP_MOSTRAR_EST_PAGO(?,?)}");
          cs.setInt(1, id);
          cs.registerOutParameter(2, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(2);
          while (rs.next())
          {
              estPago.setIdEstPago(rs.getInt("ID_ESTADO"));
              estPago.setNombre(rs.getString("NOMBRE"));
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(EstPagoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return estPago;
  }

  public List<EstPago> todosEstPago()
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      EstPago estPago = new EstPago();
      List<EstPago> listaEstPagos = new ArrayList<EstPago>();
      try {
          //PROCEDURE SP_TODOS_EST_PAGO(PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call EST_PAGO_PKG.SP_TODOS_EST_PAGO(?)}");
          cs.registerOutParameter(1, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(1);
          while (rs.next())
          {
              estPago.setIdEstPago(rs.getInt("ID_ESTADO"));
              estPago.setNombre(rs.getString("NOMBRE"));
              listaEstPagos.add(estPago);
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(EstPagoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return listaEstPagos;
  }
}
