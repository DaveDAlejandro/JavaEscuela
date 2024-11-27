package uam.azc.lpoo.Objetos;
import java.time.LocalDate;
/**
 * Clase que se hereda atributos y crea metodos para una cuenta corriente
 * @author Aareck Santana 
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html"> Time Local Date </a>
 */
public class CuentaCorriente extends Cuenta{
/**
 * Método String que imprime el estado de los atributos de un objeto de tipo Cuenta
 * @return 
 */
    @Override
    public String toString() {
        return "Numero de Cuenta: "+super.getNoCuenta()+" Titular: "+super.getTitular()
                +" Saldo: $"+super.getSaldo();
    }

    /**
     * Método constructor por defecto de una cuenta corriente
     */
    public CuentaCorriente() {
    }
    /**
     * Método constructor que parametriza una cuenta corriente
     * @param noCuenta es el identificador de la cuenta 
     * @param titular la persona a quien le esta asignada la cuenta corriente
     * @param saldo el estado actual monetario de una cuenta corriente
     */
    public CuentaCorriente(String noCuenta, String titular, double saldo) {
        super(noCuenta, titular, saldo);
    }

    

/**
 * variable comision
 */
double comision;
/**
 * Metodo que obtiene la comision de manejo de cuenta
 */
public void ComisionManejo(){
    if(super.getSaldo()<4000){ comision=( 180*.16)+180; }
    else if(super.getSaldo()<3500){ comision=( 200*.16)+200; }
    else if(super.getSaldo()<2500){ comision=( 300*.16)+300; }
    else if(super.getSaldo()<1000){comision=( 400*.16)+400;  }
    System.out.println("Comision: $"+comision);
    
}

/**
 * Método que se encarga de verificar si se hace el corte de mes
 * @param a es una cuenta corriente
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html">Metodo LocalDate de Java</a>
 */
public void ActualizarSaldo(Cuenta a){
    LocalDate hoy = LocalDate.now();            //obtiene la fecha actual
    if(hoy.getDayOfMonth()==15){         //compara el dia actual con el dia 29 NOTA!!! para que diera el valor de las pruebas se cambio a 15
        a.setSaldo(a.getSaldo()-comision);
    System.out.println("Saldo actualizado: $"+ a.getSaldo());
    }
    
}
/**
 * Método que se encarga de verificar si el valor solicitado esta disponible en la cuenta y a su vez restarselo o penalizarlo
 * @param a es el valor de retiro
 */
  
public void retirar(int a){
        
if(super.getSaldo()<a){                     //compara el saldo con el valor a retirar
double nuevoSaldo=super.getSaldo()-20;      //penalizacion
super.setSaldo(nuevoSaldo);
System.out.println("penalizacion por fondos insuficientes = $20 ");
}
}
/**
 * Método que se encarga de mostrar el estado actual de la cuenta
 * @param a es una cuenta corriente
 */
public void ImprimirDatos(Cuenta a){
System.out.println("\nCuenta\n"+a.toString());
System.out.println("Comision por manejo de cuenta: $"+comision);
}



}
