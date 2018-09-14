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
import BLL.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class VehiculoDAO {

	Conexion conn;
    
    public VehiculoDAO()
    {
        conn = new Conexion();
    }

    //PROCEDURE SP_MOSTRAR_VEHICULO(P_ID_VEHICULO VEHICULO.ID_VEHICULO%TYPE, PCURSOR OUT SYS_REFCURSOR);
    public Vehiculo mostrarVehiculo(int id)
    {
    	OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
    	Vehiculo vehiculo = new Vehiculo();
    	try {
    		cs = (OracleCallableStatement) cn.prepareCall("{ call VEHICULO_PKG.SP_MOSTRAR_VEHICULO(?,?)}");
    		cs.setInt(1,id);
    		cs.registerOutParameter(2, OracleTypes.CURSOR);
    		cs.execute();
    		rs = (ResultSet) cs.getObject(2);
    		while(rs.next())
    		{
    			vehiculo.setIdVehiculo(rs.getInt("ID_VEHICULO"));
    			vehiculo.setPatente(rs.getString("PATENTE"));
    		}
    	} catch(Exception mensaje){
    		Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
    	}
    	return vehiculo;
    }

	//PROCEDURE SP_TODOS_VEHICULO(PCURSOR OUT SYS_REFCURSOR);
    public List<Vehiculo> todosVehiculo()
    {
    	OracleCallableStatement cs = null;
        Connection cn = conn.getCnn();
        ResultSet rs = null;
        Vehiculo vehiculo = new Vehiculo();
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        try{
        	cs = (OracleCallableStatement) cn.prepareCall("{ call VEHICULO_PKG.SP_TODOS_VEHICULO(?) }");
        	cs.registerOutParameter(1,OracleTypes.CURSOR);
        	cs.execute();
        	rs = (ResultSet) cs.getObject(1);
        	while(rs.next())
        	{
        		vehiculo.setIdVehiculo(rs.getInt("ID_VEHICULO"));
        		vehiculo.setPatente(rs.getString("PATENTE"));
        	}
        } catch(Exception mensaje){
        	Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, mensaje);
        }
        return listaVehiculos;
    }



	//PROCEDURE SP_INSERTAR_VEHICULO(P_PATENTE VEHICULO.PATENTE%TYPE);

	//PROCEDURE SP_ELIMINAR_VEHICULO(P_ID_VEHICULO VEHICULO.ID_VEHICULO%TYPE);

	//PROCEDURE SP_MODIFICAR_VEHICULO( P_ID_VEHICULO VEHICULO.ID_VEHICULO%TYPE, P_PATENTE VEHICULO.PATENTE%TYPE);

}