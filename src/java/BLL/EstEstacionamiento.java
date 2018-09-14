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
public class EstEstacionamiento {
    
    // Variables
    private int idEstEstacionamiento;
    private String nombre;
    
    // Constructor sin parametros

    public EstEstacionamiento() {
    }
        
    // Constructor con parametros
    public EstEstacionamiento(int idEstEstacionamiento, String nombre) {
        setIdEstEstacionamiento(idEstEstacionamiento);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdEstEstacionamiento() {
        return idEstEstacionamiento;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdEstEstacionamiento(int idEstEstacionamiento) {
        this.idEstEstacionamiento = idEstEstacionamiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
