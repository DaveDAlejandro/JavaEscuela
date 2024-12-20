/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.mx.Datos;

/**
 *
 * @author davidramirez
 */
public class Gasto {
    
    private String claveMoneda;
    private String clavePeriodo;
    private double totalGastados;

    public String getClaveMoneda() {
        return claveMoneda;
    }

    public void setClaveMoneda(String claveMoneda) {
        this.claveMoneda = claveMoneda;
    }

    public String getClavePeriodo() {
        return clavePeriodo;
    }

    public void setClavePeriodo(String clavePeriodo) {
        this.clavePeriodo = clavePeriodo;
    }

    public double getTotalGastados() {
        return totalGastados;
    }

    public void setTotalGastados(double totalGastados) {
        this.totalGastados = totalGastados;
    }

    public Gasto(String claveMoneda, String clavePeriodo, double totalGastados) {
        this.claveMoneda = claveMoneda;
        this.clavePeriodo = clavePeriodo;
        this.totalGastados = totalGastados;
    }

    public Gasto() {
    }

    @Override
    public String toString() {
        return "Gasto{" + "claveMoneda=" + claveMoneda + ", clavePeriodo=" + clavePeriodo + ", totalGastados=" + totalGastados + '}';
    }
    
    
    
}
