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
public class Comuna {
    
    // Variables
    private int idComuna;
    private String nombre;
    
    // Constructor sin parametros

    public Comuna() {
    }
        
    // Constructor con parametros
    public Comuna(int idComuna, String nombre) {
        setIdComuna(idComuna);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdComuna() {
        return idComuna;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
