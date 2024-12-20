/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.mx.Datos;

/**
 *
 * @author davidramirez
 */
public class Periodo {
    
    private String periodo;
    private String clavePeriodo;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getClavePeriodo() {
        return clavePeriodo;
    }

    public void setClavePeriodo(String clavePeriodo) {
        this.clavePeriodo = clavePeriodo;
    }

    public Periodo(String periodo, String clavePeriodo) {
        this.periodo = periodo;
        this.clavePeriodo = clavePeriodo;
    }

    public Periodo() {
    }

    @Override
    public String toString() {
        return periodo;
    }
    
    
    
}
