package Uam.pvoe.repaso.principal;
import Uam.pvoe.repaso.datos.Licenciatura;
import Uam.pvoe.repaso.operaciones.OperacionesConcurso;

/**
 *
 * @author Alumno30
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Licenciatura licA = new Licenciatura();
        Licenciatura licB = new Licenciatura();        

        OperacionesConcurso a = new OperacionesConcurso();
        System.out.println("El ganador es: " + a.determinarGanador(licA, licB));
    }
    
}
