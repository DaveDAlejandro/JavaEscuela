/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uam.azc.lpoo.Principal;
import java.time.LocalDate;
import java.time.Month;
import uam.azc.lpoo.Objetos.CuentaAhorros;
import uam.azc.lpoo.Objetos.CuentaCorriente;
import uam.azc.lpoo.Objetos.CuentaInternacional;

/**
 * Método main del programa Practica3POOTEAM4
 * @author David Alejandro Ramírez Dueñas - 2223034171
 * Aareck Anelcka Santana Jordan - 2222005774
 *Eduardo Badillo Cruz - 2213033715
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Prueba de cuenta internacional: Implementada por David
        System.out.println("--------------------------------");
        System.out.println("Prueba: Cuenta Internacional");
        System.out.println("--------------------------------");
        
        CuentaInternacional cuenta1 = new CuentaInternacional();
        cuenta1.setNoCuenta("36985");
        cuenta1.setTitular("Pedro García");
        cuenta1.setSaldo(10000);
        cuenta1.setDivisa("europea");
        
        cuenta1.depositar(100);
        cuenta1.retirar(2000);
        cuenta1.depositar(100);
        cuenta1.depositar(100);
        cuenta1.depositar(100);
        cuenta1.depositar(15000);
                
        cuenta1.imprimirDatos();
        
        //Prueba de cuenta corriente: Implementada por Aareck
         System.out.println("--------------------------------");
         System.out.println("Prueba: Cuenta corriente");
         System.out.println("--------------------------------");
        
        CuentaCorriente cuenta = new CuentaCorriente("56987","Arturo Cardenas",2400.00);
        System.out.println(cuenta.getSaldo());
        
        
        cuenta.depositar(100);
        cuenta.retirar(3000);
        cuenta.ComisionManejo();
        cuenta.ActualizarSaldo(cuenta); 
        cuenta.ImprimirDatos(cuenta);
        
        System.out.println("--------------------------------");
        System.out.println("Prueba: Cuenta de ahorro");
        System.out.println("--------------------------------");
        
        //prueba de cuenta de ahorro: Implementada por Eduardo
        CuentaAhorros cuentaAhorro1 = new CuentaAhorros();
        cuentaAhorro1.setSaldo(5000);
        cuentaAhorro1.setPorcentajeTasaMensual(3.0);
        cuentaAhorro1.setTitular("Laura Rodriguez");
        cuentaAhorro1.setNoCuenta("6985");
        LocalDate fecha1 = LocalDate.of(2023, 01, 30);
        cuentaAhorro1.setFechaInicioAhorro(fecha1);
        
        cuentaAhorro1.depositar(1000);
        System.out.println("saldo: " + cuentaAhorro1.getSaldo());
        cuentaAhorro1.retirar(3000);
        System.out.println("saldo: " + cuentaAhorro1.getSaldo());
        
        System.out.println("");
        
        cuentaAhorro1.imprimirDatos();
        
        

    }
    
}
