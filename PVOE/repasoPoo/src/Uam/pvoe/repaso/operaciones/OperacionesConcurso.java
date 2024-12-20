package Uam.pvoe.repaso.operaciones;
import Uam.pvoe.repaso.datos.Licenciatura;

/**
 *
 * @author Alumno30
 */
public class OperacionesConcurso {
    
    public Object determinarGanador(Licenciatura licA, Licenciatura licB){
        if(licA.getPromedio() < licB.getPromedio()){
            return licB;
        }else{
            return licA;
        }
    }
}
