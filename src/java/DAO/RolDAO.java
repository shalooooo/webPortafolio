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
import BLL.Rol;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gonzalo
 */
public class RolDAO {

  Conexion conn;

  public RolDAO()
  {
      conn = new Conexion();
  }

  public Rol mostrarRol(int id)
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      Rol rol = new Rol();
      try {
          // PROCEDURE SP_MOSTRAR_ROL(P_ID_ROL ROL.ID_ROL%TYPE, PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call ROL_PKG.SP_MOSTRAR_ROL(?,?)}");
          cs.setInt(1, id);
          cs.registerOutParameter(2, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(2);
          while (rs.next())
          {
              rol.setIdRol(rs.getInt("ID_ROL"));
              rol.setNombre(rs.getString("NOMBRE"));
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return rol;
  }

  public List<Rol> todosRol()
  {
      OracleCallableStatement cs = null;
      Connection cn = conn.getCnn();
      ResultSet rs = null;
      Rol rol = new Rol();
      List<Rol> listaRoles = new ArrayList<Rol>();
      try {
          // PROCEDURE SP_TODOS_ROL(PCURSOR OUT SYS_REFCURSOR);
          cs = (OracleCallableStatement)cn.prepareCall(" { call ROL_PKG.SP_TODOS_ROL(?)}");
          cs.registerOutParameter(1, OracleTypes.CURSOR);
          cs.execute();
          rs = (ResultSet) cs.getObject(1);
          while (rs.next())
          {
              rol.setIdRol(rs.getInt("ID_ROL"));
              rol.setNombre(rs.getString("NOMBRE"));
              listaRoles.add(rol);
          }
      } catch (Exception mensaje)
      {
          Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, mensaje);
      }
      return listaRoles;
  }


}




/*
PROCEDURE SP_MOSTRAR_ROL(P_ID_ROL ROL.ID_ROL%TYPE, PCURSOR OUT SYS_REFCURSOR);

PROCEDURE SP_TODOS_ROL(PCURSOR OUT SYS_REFCURSOR);



CREATE TABLE rol (
    id_rol   NUMBER(11) NOT NULL,
    nombre   VARCHAR2(50) NOT NULL
);



private int idRol;
private String nombre;



setIdRol(idRol);
setNombre(nombre);

*/
