/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Gonzalo
 */
public class TipoCuenta {
    
    // Variables
    private int idTipoCuenta;
    private String nombre;
    
    // Constructor sin parametros

    public TipoCuenta() {
    }
        
    // Constructor con parametros
    public TipoCuenta(int idTipoCuenta, String nombre) {
        setIdTipoCuenta(idTipoCuenta);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
