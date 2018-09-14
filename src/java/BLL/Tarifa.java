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
public class Tarifa {
    
    // Variables
    private int idTarifa;
    private int monto;
    private int tipoTarifaId;
    private int estacionamientoId;
    
    // Constructores

    public Tarifa() {
    }

    public Tarifa(int idTarifa, int monto, int tipoTarifaId, int estacionamientoId) {
        setIdTarifa(idTarifa);
        setMonto(monto);
        setTipoTarifaId(tipoTarifaId);
        setEstacionamientoId(estacionamientoId);
    }
    
    // Accesadores

    public int getIdTarifa() {
        return idTarifa;
    }

    public int getMonto() {
        return monto;
    }

    public int getTipoTarifaId() {
        return tipoTarifaId;
    }

    public int getEstacionamientoId() {
        return estacionamientoId;
    }
    
    // Mutadores

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setTipoTarifaId(int tipoTarifaId) {
        this.tipoTarifaId = tipoTarifaId;
    }

    public void setEstacionamientoId(int estacionamientoId) {
        this.estacionamientoId = estacionamientoId;
    }
    
    
    
}
