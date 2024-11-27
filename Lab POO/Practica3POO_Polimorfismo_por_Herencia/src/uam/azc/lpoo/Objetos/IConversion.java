/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uam.azc.lpoo.Objetos;

/**
 * Interfaz con las constantes de las conversiones de las divisas. La conversión inicial es
 * de divisa MXN a las otras respectivas. Las demás constantes son conversiones entre las otras divisas.
 * Se tienen 2 métodos abstractos para conversiones dedivisas. Uno de ellos parametrizado para lograr
 * convertir divisas extranjeras entre sí mismas, suponiendo que el saldo se adapte a la divisa del
 * usuario; y otro sin parametros, que simplemente hace la conversión de divisa mexicana a otras
 * divisas.
 * @author davidramirez
 * @version 1.2
 */
public interface IConversion {
    
    double DOLAR = 16.78;
    double EURO = 18.18;
    double LIBRA = 21.18;
    double EURO_A_DOLAR_EXRATE = EURO/DOLAR;
    double EURO_A_LIBRA_EXRATE = EURO/LIBRA;
    double DOLAR_A_EURO_EXRATE = DOLAR/EURO;
    double DOLAR_A_LIBRA_EXRATE = DOLAR/LIBRA;
    double LIBRA_A_EURO_EXRATE = LIBRA/EURO;
    double LIBRA_A_DOLAR_EXRATE = LIBRA/DOLAR;
    
    /**
     * Método abstracto para convertir una divisa en base a dos parámetros. Un string de entrada
     * que sería la Divisa desde la que se convierta y otro String de entrada que sería el tipo
     * de Divisa al que se pasará a convertir
     * @param a Divisa original
     * @param b Divisa a la que se hará la conversión
     */
    public void convertirDivisa(String a, String b);
    
    /**
     * Método abstracto para convertir una divisa
     */
    public void convertirDivisa();
}
