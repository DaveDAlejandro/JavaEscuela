/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.mx.Datos;

/**
 *
 * @author davidramirez
 */
public class TipoCambio {
    private String clave; // "ORIG" o "USD"
    private String texto; // "Moneda país" o "Dólar Americano"
    private double valor; // El valor de la moneda en su tipo de cambio (por ejemplo, 20.0 para 1 USD = 20 MXN)

    // Constructor
    public TipoCambio(String clave, String leyenda, double valor) {
        this.clave = clave;
        this.texto = leyenda;
        this.valor = valor;
    }

    // Getters y Setters
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String leyenda) {
        this.texto = leyenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return texto;
    }
}