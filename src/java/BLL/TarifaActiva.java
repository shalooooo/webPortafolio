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
public class TarifaActiva {
    // Variables
    private int idTarifaActiva;
    private int tipoTarifaId;
    
    // Constructores
    public TarifaActiva() {
    }
    
    public TarifaActiva(int idTarifaActiva, int tipoTarifaId) {
        setIdTarifaActiva(idTarifaActiva);
        setTipoTarifaId(tipoTarifaId);
    }

    // Accesadores

    public int getIdTarifaActiva() {
        return idTarifaActiva;
    }

    public int getTipoTarifaId() {
        return tipoTarifaId;
    }
    
    // Mutadores

    public void setIdTarifaActiva(int idTarifaActiva) {
        this.idTarifaActiva = idTarifaActiva;
    }

    public void setTipoTarifaId(int tipoTarifaId) {
        this.tipoTarifaId = tipoTarifaId;
    }
    

    
    
}
