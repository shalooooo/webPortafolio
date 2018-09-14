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
public class TipoTarifa {
    
    // Variables
    private int idTipoTarifa;
    private String nombre;
    
    // Constructor sin parametros

    public TipoTarifa() {
    }
        
    // Constructor con parametros
    public TipoTarifa(int idTipoTarifa, String nombre) {
        setIdTipoTarifa(idTipoTarifa);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdTipoTarifa() {
        return idTipoTarifa;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdTipoTarifa(int idTipoTarifa) {
        this.idTipoTarifa = idTipoTarifa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
