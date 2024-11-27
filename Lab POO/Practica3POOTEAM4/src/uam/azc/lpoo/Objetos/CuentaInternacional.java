/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.lpoo.Objetos;

/**
 * Esta clase crea el blueprint de los objetos CuentaInternacional. Con los atributos y métodos
 * heredados de la super-clase Cuenta. Como atributos propios tiene noTransacciones en forma de int,
 * que representa el número de transacciones que se han hecho en el día; divisa en forma de String,
 * que representa el tipo de divisa que se maneja en la cuenta.
 * @author David Alejandro Ramírez Dueñas - 2223034171
 * @version 1.2
 */
public class CuentaInternacional extends Cuenta implements IConversion{
    private int noTransacciones;
    private String divisa;
    
    /**
     * Método getter de noTransacciones. Obtiene el valor inicializado del atributo
     * @return regresa un entero con el número de transacciones
     */
    public int getNoTransacciones() {
        return noTransacciones;
    }

    /**
     * Método setter de noTransacciones. Actualiza el valor inicializado del atributo
     * por uno nuevo
     * @param noTransacciones es el nuevo valor al que se desea actualizar
     */
    public void setNoTransacciones(int noTransacciones) {
        this.noTransacciones = noTransacciones;
    }

    /**
     * Método getter de divisa. Obtiene el valot inicializado del atributo
     * @return regresa un Strung con el tipo de Divisa
     */
    public String getDivisa() {
        return divisa;
    }

    /**
     * Método setter de Divisa. Actualiza el valor inicializado del atributo
     * por uno nuevo
     * @param divisa 
     */
    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

 
    /**
     * Constructor parametrizado de CuentaInternacional
     * @param divisa la divisa que utilizará la cuenta
     * @param noCuenta número de regristro de la cuenta
     * @param titular Nombre del titular de la cuenta
     * @param saldo el saldo que tiene la cuenta
     */
    public CuentaInternacional(String divisa, String noCuenta, String titular, double saldo) {
        super(noCuenta, titular, saldo);
        this.noTransacciones = 0;
        this.divisa = divisa;
    }

    /**
     * Constructor por omisión de CuentaInternacional
     */
    public CuentaInternacional() {
        this.noTransacciones = 0;
        this.divisa = "europea";
    }
    
    /**
     * Override del método retirar. Se toma la misma funcionalidad que en la clase padre
     * y se le agregan las funcionalidades necesarias para éste tipo de cuenta: No hacer la
     * transacción si ya se han realizado en la cuenta y agregar una transacción cuando se realice
     * @param retirado dato de tipo double que es la cantidad a retirar de la cuenta
     */
    @Override
    public void retirar(double retirado){
        if(this.noTransacciones < 5){
            super.retirar(retirado);
            this.setNoTransacciones(this.getNoTransacciones() + 1);
            System.out.println("Transacciones realizadas: " + this.getNoTransacciones());
            System.out.println("");
        }else{
            System.out.println("Transacciones excedidas");
            System.out.println("");
        }
    }
    
    
    /**
     * Override del método depositar. Se toma la misma funcionalidad que en la clase padre
     * y se le agregan las funcionalidades necesarias para éste tipo de cuenta: No hacer la
     * transacción si ya se han realizado en la cuenta y agregar una transacción cuando se realice
     * @param depositar dato tipo double que es la cantidad a depositar en la cuenta
     */
    @Override
    public void depositar(double depositar){
        if(this.noTransacciones < 5){
            super.depositar(depositar);
            this.setNoTransacciones(this.getNoTransacciones() + 1);
            System.out.println("Transacciones realizadas: " + this.getNoTransacciones());
            System.out.println("");
        }else{
            System.out.println("Transacciones excedidas");
            System.out.println("");
        }
    }
    
    /**
     * Override del método imprimirDatos. Se toma la misma funcionalidad que en la clase padre
     * y se le agregan las funcionalidades necesarias para éste tipo de cuenta: imprimir los
     * atributos de la cuenta y realizar la conversión de divisa.
     */
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        System.out.println("Número de transacciones: " + this.getNoTransacciones());
        System.out.println("Divisa: " + this.getDivisa());
        convertirDivisa();
        
    }
    
    
   
    

    /**
     * Esta implementación convierte un tipo de divisa en otra. Suponiendo que la cuenta de banco
     * adapta el saldo al tipo de divisa que utiliza el usuario y no la maneja como moneda Mexicana,
     * entonces se debería de hacer una conversión propia para cada divisa.
     * @param divisa el tipo de divisa que utiliza la cuenta
     * @param convertir el tipo de divisa al que se desea convertir el saldo de la cuenta
     */
    
    @Override
    public void convertirDivisa(String divisa, String convertir){
        
        if(divisa.equalsIgnoreCase(convertir)){
            
            System.out.println("La cuenta ya maneja este tipo de divisa: ");
            System.out.println("Su saldo es: " + this.getSaldo() + " DIVISA " + this.getDivisa());
            
        }else if(divisa.equalsIgnoreCase("EUROPEA") && convertir.equalsIgnoreCase("ESTADOUNIDENSE")){
            
            double conversion = this.getSaldo()* EURO_A_DOLAR_EXRATE;           
            System.out.println("Conversión realizada: EURO A DOLAR" );
            System.out.println("Su saldo es: " + conversion + " DIVISA " + convertir);
            
        }else if(divisa.equalsIgnoreCase("EUROPEA") && convertir.equalsIgnoreCase("INGLESA")){
        
            double conversion = this.getSaldo() * EURO_A_LIBRA_EXRATE;
            System.out.println("Conversión realizada: EURO A DOLAR" );
            System.out.println("Su saldo es: " + conversion + " DIVISA " + convertir);
            
        }else if(divisa.equalsIgnoreCase("ESTADOUNIDENSE") && convertir.equalsIgnoreCase("EUROPEA")){
        
            double conversion = this.getSaldo() * DOLAR_A_EURO_EXRATE;
            System.out.println("Conversión realizada: EURO A DOLAR" );
            System.out.println("Su saldo es: " + conversion + " DIVISA " + convertir);
            
        }else if(divisa.equalsIgnoreCase("ESTADOUNIDENSE") && convertir.equalsIgnoreCase("INGLESA")){
        
            double conversion = this.getSaldo() * DOLAR_A_LIBRA_EXRATE;
            System.out.println("Conversión realizada: EURO A DOLAR" );
            System.out.println("Su saldo es: " + conversion + " DIVISA " + convertir);
         
        }else if(divisa.equalsIgnoreCase("INGLESA") && convertir.equalsIgnoreCase("ESTADOUNIDENSE")){
        
            double conversion = this.getSaldo() * LIBRA_A_DOLAR_EXRATE;
            System.out.println("Conversión realizada: EURO A DOLAR" );
            System.out.println("Su saldo es: " + conversion + " DIVISA " + convertir);
            
            
        }else if(divisa.equalsIgnoreCase("INGLESA") && convertir.equalsIgnoreCase("EUROPEA")){
        
            double conversion = this.getSaldo() * LIBRA_A_EURO_EXRATE;
            System.out.println("Conversión realizada: EURO A DOLAR" );
            System.out.println("Su saldo es: " + conversion + " DIVISA " + convertir);
        
        }else{
            System.out.println("No se pudo hacer la conversión. Ingresa correctamente los datos");
        }
        
    }
    
    
    /**
     * Suponiendo que la cuenta manjea divisa Mexicana y únicamente se desea hacer la conversión desde
     * la divisa mexicana 
     */
    @Override
    public void convertirDivisa(){
        if(this.getDivisa().equalsIgnoreCase("ESTADOUNIDENSE")){
            double conversion = this.getSaldo() / DOLAR;
            System.out.println("Saldo en divisa extranjera: " + conversion);
        }else if(this.getDivisa().equalsIgnoreCase("EUROPEA")){
            double conversion = this.getSaldo() / EURO;
            System.out.println("Saldo en divisa extranjera: " + conversion);
        }else if(this.getDivisa().equalsIgnoreCase("INGLESA")){
            double conversion = this.getSaldo() / LIBRA;
            System.out.println("Saldo en divisa extranjera: " + conversion);
        }
    }

   
    

    
    
    
}
