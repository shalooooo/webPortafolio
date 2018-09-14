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
public class TipoCalificacion {
    
    // Variables
    private int idTipoCalificacion;
    private String nombre;
    
    // Constructor sin parametros

    public TipoCalificacion() {
    }
        
    // Constructor con parametros
    public TipoCalificacion(int idTipoCalificacion, String nombre) {
        setIdTipoCalificacion(idTipoCalificacion);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdTipoCalificacion() {
        return idTipoCalificacion;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdTipoCalificacion(int idTipoCalificacion) {
        this.idTipoCalificacion = idTipoCalificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
