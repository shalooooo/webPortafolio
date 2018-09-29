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
 import BLL.EstUsuario;
 import java.util.ArrayList;
 import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class EstUsuarioDAO {
  Conexion conn;

  public EstUsuarioDAO()
  {
      conn = new Conexion();
  }

  public EstUsuario mostrarEstUsuario(int id)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      EstUsuario estUsuario = new EstUsuario();
      try {
          //PROCEDURE SP_MOSTRAR_EST_USUARIO(P_ID_ESTADO EST_USUARIO.ID_ESTADO%TYPE, PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call EST_USUARIO_PKG.SP_MOSTRAR_EST_USUARIO(?,?)}");
          cs.setInt(1, id);
          cs.registerOutParameter(2, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(2);
          while (rs.next())
          {
              estUsuario.setIdEstUsuario(rs.getInt("ID_ESTADO"));
              estUsuario.setNombre(rs.getString("NOMBRE"));
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(EstUsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return estUsuario;
  }

  public List<EstUsuario> todosEstUsuario()
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      EstUsuario estUsuario = new EstUsuario();
      List<EstUsuario> listaEstUsuarios = new ArrayList<EstUsuario>();
      try {
          //PROCEDURE SP_TODOS_EST_USUARIO(PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call EST_USUARIO_PKG.SP_TODOS_EST_USUARIO(?)}");
          cs.registerOutParameter(1, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(1);
          while (rs.next())
          {
              estUsuario.setIdEstUsuario(rs.getInt("ID_ESTADO"));
              estUsuario.setNombre(rs.getString("NOMBRE"));
              listaEstUsuarios.add(estUsuario);
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(EstUsuarioDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return listaEstUsuarios;
  }
}
