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
public class Calificacion {
    
    // Variables
    private int idCalificacion;
    private int nota;
    private int reservaId;
    private int usuarioId;
    private int tipoCalificacionId;
    
    // Constructor sin parametros
    public Calificacion() {
    }    
    
    // Constructor con parametros
    public Calificacion(int idCalificacion, int nota, int reservaId, int usuarioId, int tipoCalificacionId) {
        setIdCalificacion(idCalificacion);
        setNota(nota);
        setReservaId(reservaId);
        setUsuarioId(usuarioId);
        setTipoCalificacionId(tipoCalificacionId);
    }
    
    // Accesadores
    public int getIdCalificacion() {
        return idCalificacion;
    }

    public int getNota() {
        return nota;
    }

    public int getReservaId() {
        return reservaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getTipoCalificacionId() {
        return tipoCalificacionId;
    }

    
    // Mutadores 
    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setTipoCalificacionId(int tipoCalificacionId) {
        this.tipoCalificacionId = tipoCalificacionId;
    }
    
            
}
