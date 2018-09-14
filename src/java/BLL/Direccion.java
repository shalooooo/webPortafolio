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
public class Direccion {
    
    // Variables
    private int idDireccion;
    private String calle;
    private int numeracion;
    private float latitud;
    private float longitud;
    private int comunaId;

    // Constructores
    public Direccion() {
    }

    public Direccion(int idDireccion, String calle, int numeracion, float latitud, float longitud, int comunaId) {
        setIdDireccion(idDireccion);
        setCalle(calle);
        setNumeracion(numeracion);
        setLatitud(latitud);
        setLongitud(longitud);
        setComunaId(comunaId);
    }

    // Accesadores
    public int getIdDireccion() {
        return idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public int getComunaId() {
        return comunaId;
    }
    
    // Mutadores
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public void setComunaId(int comunaId) {
        this.comunaId = comunaId;
    }
    
    
}
