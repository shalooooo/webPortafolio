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
import BLL.Banco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class BancoDAO {

    Conexion conn;

    public BancoDAO()
    {
        conn = new Conexion();
    }

    public Banco mostrarBanco(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Banco banco = new Banco();
        try {
            // PROCEDURE SP_MOSTRAR_BANCO(P_ID_BANCO BANCO.ID_BANCO%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call BANCO_PKG.SP_MOSTRAR_BANCO(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next())
            {
                banco.setIdBanco(rs.getInt("ID_BANCO"));
                banco.setNombre(rs.getString("NOMBRE"));
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return banco;
    }

    public List<Banco> todosBanco()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Banco banco = new Banco();
        List<Banco> listaBancos = new ArrayList<Banco>();
        try {
            // PROCEDURE SP_TODOS_BANCO(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call BANCO_PKG.SP_TODOS_BANCO(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next())
            {
                banco.setIdBanco(rs.getInt("ID_BANCO"));
                banco.setNombre(rs.getString("NOMBRE"));
                listaBancos.add(banco);
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaBancos;
    }

    public boolean insertarBanco(Banco banco)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_INSERTAR_BANCO(P_NOMBRE BANCO.NOMBRE%TYPE);*/
            cs = (OracleCallableStatement) cn.prepareCall(" { call BANCO_PKG.SP_INSERTAR_BANCO(?)}");
            cs.setString(1, banco.getNombre());
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

    public boolean eliminarBanco(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            // PROCEDURE SP_ELIMINAR_BANCO(P_ID_BANCO BANCO.ID_BANCO%TYPE);
            cs = (OracleCallableStatement)cn.prepareCall(" { call BANCO_PKG.SP_ELIMINAR_BANCO(?)}");
            cs.setInt(1, id);
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

    public boolean modificarBanco(Banco banco)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_MODIFICAR_BANCO( P_ID_BANCO BANCO.ID_BANCO%TYPE, P_NOMBRE BANCO.NOMBRE%TYPE);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call BANCO_PKG.SP_MODIFICAR_BANCO(?,?)}");
            cs.setInt(1,banco.getIdBanco());
            cs.setString(2,banco.getNombre());
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }



}
