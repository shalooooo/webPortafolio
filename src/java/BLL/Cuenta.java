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
public class Cuenta {
    
    // Variables
    private int idCuenta;
    private String numero;
    private int bancoId;
    private int tipoCuentaId;

    // Constructor sin parametros
    public Cuenta() {
    }    
    
    // Constructor con parametros
    public Cuenta(int idCuenta, String numero, int bancoId, int tipoCuentaId) {
        setIdCuenta(idCuenta);
        setNumero(numero);
        setBancoId(bancoId);
        setTipoCuentaId(tipoCuentaId);
    }
    
    // Accesadores
    public int getIdCuenta() {
        return idCuenta;
    }

    public String getNumero() {
        return numero;
    }

    public int getBancoId() {
        return bancoId;
    }

    public int getTipoCuentaId() {
        return tipoCuentaId;
    }
    
    // Mutadores 
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBancoId(int bancoId) {
        this.bancoId = bancoId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

            
}
