/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.lpoo.Objetos;

/**
 * Esta clase crea el blueprint de los objetos cuenta que será una super-clase, por lo que sus
 * atributos serán protegidos. Tiene como atributos: noCuenta en forma de String, que es el
 * número de la cuenta bancaria del usuario. titular en forma de String, que es el nombre del
 * titular de la cuenta. saldo en forma de double, que es el saldo de la cuenta del usuario.
 * @author David Alejandro Ramírez Dueñas - 2223034171
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html"> Librería Math Java </a>
 * @version 1.2
 */
public class Cuenta {
    protected String noCuenta;
    protected String titular;
    protected double saldo;
    
    /**
     * Getter de NoCuenta. Sirve para obtener el valor en fomra de String de NoCuenta
     * @return regresa el valor de getNoCuenta en forma de String
     */
    public String getNoCuenta() {
        return noCuenta;
    }

    /**
     * Setter de noCuenta. Sirve para actualizar el valor inicializado de noCuenta
     * @param noCuenta valor en forma de String al que se actualizará noCuenta
     */
    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    /**
     * Getter de titular. Sirve para obtener el valor en forma de String de titular.
     * @return regresa el titular en forma de String
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Setter de titular. Sirve para actualizar el valor inicializado de titular.
     * @param titular valor en forma de String al que se actualizará el titular.
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Getter de Saldo. Sirve para obtener el valor en forma de double de salro.
     * @return regresa el saldo en forma de double.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Setter de saldo. Sirve para actualiz|r el valor inicializado de titular.
     * @param saldo valor en forma de String al que se actualizará el titular.
     */
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Constructor parametrizado de Cuenta. noCuenta, titular, saldo. En ese órden.
     * @param noCuenta número de cuenta de banco en forma de String
     * @param titular nombre del titular de la cuenta en forma de String
     * @param saldo saldo de la cuenta en forma de double.
     */
    public Cuenta(String noCuenta, String titular, double saldo) {
        this.noCuenta = noCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    /**
     * Constructor de cuenta por omisión.
     */
    public Cuenta() {
    }
    
    
    /**
     * Este método permite al usuario depositar saldo a su cuenta bancaria. Toma en consideración
     * los números negativos. Actualiza el saldo y te muestra agregado
     * @param agregado la cantidad de dinero que se desea agregar en forma de double
     */
    public void depositar(double agregado){
        if(agregado < 0){
            System.out.println("No ingrese cantidades negativas");
            
        }else{
            this.setSaldo(this.getSaldo() + agregado);
            System.out.println("Usted depositó: " + agregado);
        }  
    }
    
    
    /**
     * Este método permite al usuasrio retirar dinero de su cuenta bancaria. Toma en consideración
     * las cantidades negativas y también que el saldo del usuario pueda cubrir la cantidad que 
     * se desea retirar
     * @param retirado la cantidad de dinero que se desea retirar en forma de double
     */
    public void retirar(double retirado){
        if(retirado < 0){
            System.out.println("Ingreso una cantidad negativa. Se tomará como cantidad positiva");
        }
        
        double saldoVA = Math.abs(retirado);
        
        if(this.getSaldo() < retirado){
            System.out.println("NO cuenta con el saldo suficiente");
        }else{
            
            System.out.println("Usted retiró: " + saldoVA);
            this.setSaldo(this.getSaldo() - saldoVA);
        }
    }
 
    
    /**
     * Método que imprime los atributos de la cuenta
     */
    public void imprimirDatos(){
        System.out.println("Titular: " + this.titular);
        System.out.println("Número de cuenta: " + this.noCuenta);
        System.out.println("Saldo en cuenta: " + this.saldo);      
    }

}
