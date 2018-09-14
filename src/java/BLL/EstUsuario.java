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
public class EstUsuario {
    
    // Variables
    private int idEstUsuario;
    private String nombre;
    
    // Constructor sin parametros

    public EstUsuario() {
    }
        
    // Constructor con parametros
    public EstUsuario(int idEstUsuario, String nombre) {
        setIdEstUsuario(idEstUsuario);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdEstUsuario() {
        return idEstUsuario;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdEstUsuario(int idEstUsuario) {
        this.idEstUsuario = idEstUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
