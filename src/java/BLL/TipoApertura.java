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
public class TipoApertura {
    
    // Variables
    private int idTipoApertura;
    private String nombre;
    
    // Constructor sin parametros

    public TipoApertura() {
    }
        
    // Constructor con parametros
    public TipoApertura(int idTipoApertura, String nombre) {
        setIdTipoApertura(idTipoApertura);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdTipoApertura() {
        return idTipoApertura;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdTipoApertura(int idTipoApertura) {
        this.idTipoApertura = idTipoApertura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
