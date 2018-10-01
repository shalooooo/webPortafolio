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
import BLL.TipoApertura;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gonzalo
 */
public class TipoAperturaDAO {

  Conexion conn;

  public TipoAperturaDAO()
  {
      conn = new Conexion();
  }

  public TipoApertura mostrarTipoApertura(int id)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      TipoApertura tipoApertura = new TipoApertura();
      try {
          //  PROCEDURE SP_MOSTRAR_TIPO_APERTURA(P_ID_TIPO_APERTURA TIPO_APERTURA.ID_TIPO_APERTURA%TYPE, PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call TIPO_APERTURA_PKG.SP_MOSTRAR_TIPO_APERTURA(?,?)}");
          cs.setInt(1, id);
          cs.registerOutParameter(2, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(2);
          while (rs.next())
          {
              tipoApertura.setIdTipoApertura(rs.getInt("ID_TIPO_APERTURA"));
              tipoApertura.setNombre(rs.getString("NOMBRE"));
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(TipoAperturaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return tipoApertura;
  }

  public List<TipoApertura> todosTipoApertura()
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      TipoApertura tipoApertura = new TipoApertura();
      List<TipoApertura> listaTipoAperturas = new ArrayList<TipoApertura>();
      try {
          //PROCEDURE SP_TODOS_TIPO_APERTURA(PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call TIPO_APERTURA_PKG.SP_TODOS_TIPO_APERTURA(?)}");
          cs.registerOutParameter(1, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(1);
          while (rs.next())
          {
              tipoApertura.setIdTipoApertura(rs.getInt("ID_TIPO_APERTURA"));
              tipoApertura.setNombre(rs.getString("NOMBRE"));
              listaTipoAperturas.add(tipoApertura);
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(TipoAperturaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return listaTipoAperturas;
  }

}
