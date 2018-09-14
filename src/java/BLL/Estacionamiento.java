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
public class Estacionamiento {
    
    // Variables
    private int idEstacionamiento;
    private String identificador;
    private int usuarioId;
    private int direccionId;
    private int estEstacionamientoId;
    private int tipoAperturaId;
    private int tarifaActivaId;
    private int horarioInicio;
    private int horarioFin;
    
    // Constructores

    public Estacionamiento() {
    }

    public Estacionamiento(int idEstacionamiento, String identificador, int usuarioId, int direccionId, int estEstacionamientoId, int tipoAperturaId, int tarifaActivaId, int horarioInicio, int horarioFin) {
        setIdEstacionamiento(idEstacionamiento);
        setIdentificador(identificador);
        setUsuarioId(usuarioId);
        setDireccionId(direccionId);
        setEstEstacionamientoId(estEstacionamientoId);
        setTipoAperturaId(tipoAperturaId);
        setTarifaActivaId(tarifaActivaId);
        setHorarioInicio(horarioInicio);
        setHorarioFin(horarioFin);
    }
    
    // Accesadores

    public int getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getDireccionId() {
        return direccionId;
    }

    public int getEstEstacionamientoId() {
        return estEstacionamientoId;
    }

    public int getTipoAperturaId() {
        return tipoAperturaId;
    }

    public int getTarifaActivaId() {
        return tarifaActivaId;
    }

    public int getHorarioInicio() {
        return horarioInicio;
    }

    public int getHorarioFin() {
        return horarioFin;
    }
    
    // Mutadores 

    public void setIdEstacionamiento(int idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setDireccionId(int direccionId) {
        this.direccionId = direccionId;
    }

    public void setEstEstacionamientoId(int estEstacionamientoId) {
        this.estEstacionamientoId = estEstacionamientoId;
    }

    public void setTipoAperturaId(int tipoAperturaId) {
        this.tipoAperturaId = tipoAperturaId;
    }

    public void setTarifaActivaId(int tarifaActivaId) {
        this.tarifaActivaId = tarifaActivaId;
    }

    public void setHorarioInicio(int horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFin(int horarioFin) {
        this.horarioFin = horarioFin;
    }
    
    
}
