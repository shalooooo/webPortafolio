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
public class Rol {
    
    // Variables
    private int idRol;
    private String nombre;
    
    // Constructor sin parametros

    public Rol() {
    }
        
    // Constructor con parametros
    public Rol(int idRol, String nombre) {
        setIdRol(idRol);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdRol() {
        return idRol;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
