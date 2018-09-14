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
public class Tarjeta {
    
    // Variables
    private int idTarjeta;
    private float numero;
    private int dv;
    private int mesVenc;
    private int anoVenc;
    
    // Constructores

    public Tarjeta() {
    }

    public Tarjeta(int idTarjeta, float numero, int dv, int mesVenc, int anoVenc) {
        setIdTarjeta(idTarjeta);
        setNumero(numero);
        setDv(dv);
        setMesVenc(mesVenc);
        setAnoVenc(anoVenc);
    }
    
    // Accesadores

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public float getNumero() {
        return numero;
    }

    public int getDv() {
        return dv;
    }

    public int getMesVenc() {
        return mesVenc;
    }

    public int getAnoVenc() {
        return anoVenc;
    }
    
    
    // Mutadores

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public void setDv(int dv) {
        this.dv = dv;
    }

    public void setMesVenc(int mesVenc) {
        this.mesVenc = mesVenc;
    }

    public void setAnoVenc(int anoVenc) {
        this.anoVenc = anoVenc;
    }
    
    
    
}
