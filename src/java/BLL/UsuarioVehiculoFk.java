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
public class UsuarioVehiculoFk {
    
    // Variables
    private int usuarioId;
    private int vehiculoId;
    
    // Constructores

    public UsuarioVehiculoFk() {
    }

    public UsuarioVehiculoFk(int usuarioId, int vehiculoId) {
        this.usuarioId = usuarioId;
        this.vehiculoId = vehiculoId;
    }
    
    // Accesadores

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }
    
    // Mutadores

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }
    
    
}
