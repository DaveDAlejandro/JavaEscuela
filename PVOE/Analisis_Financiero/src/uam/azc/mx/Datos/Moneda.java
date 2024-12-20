/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.mx.Datos;

/**
 *
 * @author davidramirez
 */
public class Moneda {
    
    private String nombreMoneda;
    private String claveMoneda;

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getClaveMoneda() {
        return claveMoneda;
    }

    public void setClaveMoneda(String claveMoneda) {
        this.claveMoneda = claveMoneda;
    }

    public Moneda(String nombreMoneda, String claveMoneda) {
        this.nombreMoneda = nombreMoneda;
        this.claveMoneda = claveMoneda;
    }

    public Moneda() {
    }

    @Override
    public String toString() {
        return nombreMoneda + " (" + claveMoneda + ")";
    }
    
    
    
    
}
