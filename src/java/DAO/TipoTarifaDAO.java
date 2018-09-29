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
import BLL.TipoTarifa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class TipoTarifaDAO {

    Conexion conn;

    public TipoTarifaDAO()
    {
        conn = new Conexion();
    }

    public TipoTarifa mostrarTipoTarifa(int id)
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        TipoTarifa tipoTarifa = new TipoTarifa();
        try {
            //  PROCEDURE SP_MOSTRAR_TIPO_TARIFA(P_ID_TIPO_TARIFA TIPO_TARIFA.ID_TIPO_TARIFA%TYPE, PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call TIPO_TARIFA_PKG.SP_MOSTRAR_TIPO_TARIFA(?,?)}");
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
            while (rs.next())
            {
                tipoTarifa.setIdTipoTarifa(rs.getInt("ID_TIPO_TARIFA"));
                tipoTarifa.setNombre(rs.getString("NOMBRE"));
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(TipoTarifaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return tipoTarifa;
    }

    public List<TipoTarifa> todosTipoTarifa()
    {
        OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        TipoTarifa tipoTarifa = new TipoTarifa();
        List<TipoTarifa> listaTipoTarifas = new ArrayList<TipoTarifa>();
        try {
            //PROCEDURE SP_TODOS_TIPO_TARIFA(PCURSOR OUT SYS_REFCURSOR);
            cs = (OracleCallableStatement)cn.prepareCall(" { call TIPO_TARIFA_PKG.SP_TODOS_TIPO_TARIFA(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            while (rs.next())
            {
                tipoTarifa.setIdTipoTarifa(rs.getInt("ID_TIPO_TARIFA"));
                tipoTarifa.setNombre(rs.getString("NOMBRE"));
                listaTipoTarifas.add(tipoTarifa);
            }
        } catch (Exception mensaje)
        {
            Logger.getLogger(TipoTarifaDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaTipoTarifas;
    }



}
