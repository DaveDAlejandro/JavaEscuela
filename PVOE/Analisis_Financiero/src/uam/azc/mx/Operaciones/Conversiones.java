/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.mx.Operaciones;

/**
 *
 * @author davidramirez
 */
import java.util.HashMap;
import java.util.Map;

public class Conversiones {
    private Map<String, Double> tasasDeCambio;

    public Conversiones() {
        tasasDeCambio = new HashMap<>();
        
        //Valor de divisa tomados el 8 de Diciembre del 2024. En caso de querer modificar la
        //conversión basta con poner el valor de la divisa actualizado
        tasasDeCambio.put("EUR", 0.94);   
        tasasDeCambio.put("GBP", 0.83);   
        tasasDeCambio.put("JPY", 143.35);  
        tasasDeCambio.put("CAD", 1.36);   
        tasasDeCambio.put("AUD", 1.56);   
        tasasDeCambio.put("MXN", 18.19);   
        tasasDeCambio.put("USD", 1.0);    
    }

    /**
     * 
     * @param claveOrigen
     * @param claveDestino
     * @param cantidad
     * @return 
     */
    public double convertir(String claveOrigen, double cantidad) {
        if (!tasasDeCambio.containsKey(claveOrigen)) {
            throw new IllegalArgumentException("Moneda de origen no válida: " + claveOrigen);
        }
   
        double cantidadEnUSD = cantidad / tasasDeCambio.get(claveOrigen);
        return cantidadEnUSD;
    }

}