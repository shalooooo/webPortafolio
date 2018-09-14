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
public class Vehiculo {
    
    
    // Variables
    
    private int idVehiculo;
    private String patente;
    
    // Constructores

    public Vehiculo() {
    }

    public Vehiculo(int idVehiculo, String patente) {
        setIdVehiculo(idVehiculo);
        setPatente(patente);
    }
    
    // Accesadores

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public String getPatente() {
        return patente;
    }
    
    
    // Mutadores

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    
}
