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
public class Banco {
    
    // Variables
    private int idBanco;
    private String nombre;
    
    // Constructor sin parametros

    public Banco() {
    }
        
    // Constructor con parametros
    public Banco(int idBanco, String nombre) {
        setIdBanco(idBanco);
        setNombre(nombre);
    }
    
    // Accesadores

    public int getIdBanco() {
        return idBanco;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Mutadores 

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
            
}
