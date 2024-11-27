/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.lpoo.Objetos;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Eduardo Badillo
 */
public class CuentaAhorros extends Cuenta{
    private LocalDate fechaInicioAhorro;
    private double porcentajeTasaMensual;

    public LocalDate getFechaInicioAhorro() {
        return fechaInicioAhorro;
    }

    public void setFechaInicioAhorro(LocalDate fechaInicioAhorro) {
        this.fechaInicioAhorro = fechaInicioAhorro;
    }

    public double getPorcentajeTasaMensual() {
        return porcentajeTasaMensual;
    }

    public void setPorcentajeTasaMensual(double porcentajeTasaMensual) {
        this.porcentajeTasaMensual = porcentajeTasaMensual;
    }

    public CuentaAhorros(double porcentajeTasaMensual) {
        this.fechaInicioAhorro = LocalDate.now();
        this.porcentajeTasaMensual = porcentajeTasaMensual;
    }
    
    public CuentaAhorros() {
        this.fechaInicioAhorro = LocalDate.now();
    }
    
    @Override
    public void retirar(double retirado){
        if(this.getSaldo() < retirado || retirado > this.getSaldo()*0.3){
            System.out.println("No se puede retirar esa cantidad");
        }else{
            super.retirar(retirado);
        }
    }
    
    /**
     * Éste método calcula las ganancias totales en un periodo de tiempo tomando en cuenta el interés
     * compuesto de la cuenta.
     * @param months
     * @return 
     */
    public double calcularGananciasTotalesPeriodoIC(int months){
        double ganancias = 0;
        double saldoFinal = this.getSaldo();
        LocalDate fecha;
        fecha = this.getFechaInicioAhorro().plusMonths(months);
        
        System.out.println("Fecha de inicio: " + this.getFechaInicioAhorro());
        System.out.println("Fecha estimada: " + fecha);
        for (int i = 1; i <= months; i++) {
            saldoFinal = saldoFinal + (this.getPorcentajeTasaMensual()/100)*saldoFinal;
        }
        ganancias = saldoFinal - this.getSaldo();
        

        return ganancias;
    }
    
    /**
     * Éste método calcula las ganancias totales desde la fecha de inicio de la cuenta hasta la
     * fecha actual tomando en cuenta el interés compuesto
     * @return 
     */
    public double calcularGananciasTotalesTranscurridoIC(){
        double ganancias;
        double saldoFinal = this.getSaldo();
        LocalDate fecha = LocalDate.now();
        Period periodoAhorro = Period.between(this.getFechaInicioAhorro(), fecha);
        
        System.out.println("Fecha de inicio: " + this.getFechaInicioAhorro());
        System.out.println("Fecha estimada: " + fecha);
        int tiempo = (periodoAhorro.getMonths() + periodoAhorro.getYears()*12);
        System.out.println(tiempo + " Meses");
        for (int i = 1; i < tiempo; i++) {
            saldoFinal = saldoFinal + (this.getPorcentajeTasaMensual()/100)*saldoFinal;
        }
        ganancias = saldoFinal - this.getSaldo();
        return ganancias;
    }
    
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        System.out.println(this.calcularGananciasTotalesTranscurridoIC());
    }
    
    
}
