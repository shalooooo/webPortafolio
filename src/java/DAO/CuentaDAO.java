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
import BLL.Cuenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */



public class CuentaDAO {

    Conexion conn;

    public CuentaDAO()
    {
        conn = new Conexion();
    }

    public Cuenta mostrarCuenta(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Cuenta cuenta = new Cuenta();
        try {
            // PROCEDURE SP_MOSTRAR_CUENTA(P_ID_CUENTA CUENTA.ID_CUENTA%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call CUENTA_PKG.SP_MOSTRAR_CUENTA(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next())
            {
                cuenta.setIdCuenta(rs.getInt("ID_CUENTA"));
                cuenta.setNumero(rs.getString("NUMERO"));
                cuenta.setBancoId(rs.getInt("BANCO_ID_BANCO"));
                cuenta.setTipoCuentaId(rs.getInt("TIPO_CUENTA_ID_TIPO_CUENTA"));
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return cuenta;
    }

    public List<Cuenta> todosCuenta()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Cuenta cuenta = new Cuenta();
        List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
        try {
            // PROCEDURE SP_TODOS_CUENTA(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call CUENTA_PKG.SP_TODOS_CUENTA(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next())
            {
                cuenta.setIdCuenta(rs.getInt("ID_CUENTA"));
                cuenta.setNumero(rs.getString("NUMERO"));
                cuenta.setBancoId(rs.getInt("BANCO_ID_BANCO"));
                cuenta.setTipoCuentaId(rs.getInt("TIPO_CUENTA_ID_TIPO_CUENTA"));
                listaCuentas.add(cuenta);
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaCuentas;
    }

    public boolean insertarCuenta(Cuenta cuenta)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_INSERTAR_CUENTA( P_NUMERO CUENTA.NUMERO%TYPE,
                                            P_BANCO_ID_BANCO CUENTA.BANCO_ID_BANCO%TYPE,
                                            P_TIPO_CUENTA_ID_TIPO_CUENTA CUENTA.TIPO_CUENTA_ID_TIPO_CUENTA%TYPE);
            setIdCuenta(idCuenta);
            setNumero(numero);
            setBancoId(bancoId);
            setTipoCuentaId(tipoCuentaId);*/
            cs = (OracleCallableStatement) cn.prepareCall(" { call CUENTA_PKG.SP_INSERTAR_CUENTA(?,?,?)}");
            cs.setString(1, cuenta.getNumero());
            cs.setInt(2, cuenta.getBancoId());
            cs.setInt(3, cuenta.getTipoCuentaId());
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

    public boolean eliminarCuenta(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            // PROCEDURE SP_ELIMINAR_CUENTA(P_ID_CUENTA CUENTA.ID_CUENTA%TYPE);
            cs = (OracleCallableStatement)cn.prepareCall(" { call CUENTA_PKG.SP_ELIMINAR_CUENTA(?)}");
            cs.setInt(1, id);
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

    public boolean modificarCuenta(Cuenta cuenta)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        try {
            /*PROCEDURE SP_MODIFICAR_CUENTA(P_ID_CUENTA CUENTA.ID_CUENTA%TYPE,
                                            P_NUMERO CUENTA.NUMERO%TYPE,
                                            P_BANCO_ID_BANCO CUENTA.BANCO_ID_BANCO%TYPE,
                                            P_TIPO_CUENTA_ID_TIPO_CUENTA CUENTA.TIPO_CUENTA_ID_TIPO_CUENTA%TYPE);*/
            cs = (OracleCallableStatement)cn.prepareCall(" { call CUENTA_PKG.SP_MODIFICAR_CUENTA(?,?,?,?)}");
            cs.setInt(1,cuenta.getIdCuenta());
            cs.setString(2,cuenta.getNumero());
            cs.setInt(3,cuenta.getBancoId());
            cs.setInt(4,cuenta.getTipoCuentaId());
            cs.execute();
            return true;
        } catch (Exception mensaje) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
            return false;
        }
    }

}
