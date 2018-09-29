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
import BLL.TipoCuenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class TipoCuentaDAO {

    Conexion conn;

    public TipoCuentaDAO()
    {
        conn = new Conexion();
    }

    public TipoCuenta mostrarTipoCuenta(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        TipoCuenta tipoCuenta = new TipoCuenta();
        try {
            //  PROCEDURE SP_MOSTRAR_TIPO_CUENTA(P_ID_TIPO_CUENTA TIPO_CUENTA.ID_TIPO_CUENTA%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call TIPO_CUENTA_PKG.SP_MOSTRAR_TIPO_CUENTA(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next())
            {
                tipoCuenta.setIdTipoCuenta(rs.getInt("ID_TIPO_CUENTA"));
                tipoCuenta.setNombre(rs.getString("NOMBRE"));
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(TipoCuentaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return tipoCuenta;
    }

    public List<TipoCuenta> todosTipoCuenta()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        TipoCuenta tipoCuenta = new TipoCuenta();
        List<TipoCuenta> listaTipoCuentas = new ArrayList<TipoCuenta>();
        try {
            //PROCEDURE SP_TODOS_TIPO_CUENTA(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call TIPO_CUENTA_PKG.SP_TODOS_TIPO_CUENTA(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next())
            {
                tipoCuenta.setIdTipoCuenta(rs.getInt("ID_TIPO_CUENTA"));
                tipoCuenta.setNombre(rs.getString("NOMBRE"));
                listaTipoCuentas.add(tipoCuenta);
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(TipoCuentaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaTipoCuentas;
    }



}
