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
public class EstPago {
    
    // Variables
    private int idEstPago;
    private String nombre;
    
    // Constructor sin parametros

    public EstPago() {
    }
        
    // Constructor con parametros
    public EstPago(int idEstPago, String nombre) {
        setIdEstPago(idEstPago);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdEstPago() {
        return idEstPago;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdEstPago(int idEstPago) {
        this.idEstPago = idEstPago;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
