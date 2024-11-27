package uam.pvoe.repaso.principal;
import java.util.LinkedList;
import uam.pvoe.repaso.datos.UEA;
import uam.pvoe.repaso.operaciones.Operaciones;

/**
 * Esta es la clase Main del proyecto 2223034171P1
 * @author davidramirez
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/?java/util/LinkedList.html"> Linked List Java</a>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
            //En caso de querer comparar funcionalidades individuales, comentar y descomentar cada uno.
            //Pruba final. Ver la comparación no estritcta
        
        Operaciones ops = new Operaciones();
        LinkedList<UEA> lista1 = new LinkedList<UEA>();
        lista1 = ops.leerDatos("uea_horas.csv");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.print(ops.comprobarHorasDepartamento(lista1.get(i), 5, 3));
        }
       
        
        
        //-------------------------------------------------------
        
        /*
            //Funcionamiento de LeerDatos. Ver la lista de UEAs
            
        Operaciones ops = new Operaciones();
        LinkedList<UEA> lista1 = new LinkedList<UEA>();
        lista1 = ops.leerDatos("uea_horas.csv");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.println(lista1.get(i).toString());
        }
        */
        
        //-------------------------------------------------------
        
        /*
            //Funcionamiento de compararHorasDepartamentoEstricto
        
        Operaciones ops = new Operaciones();
        LinkedList<UEA> lista1 = new LinkedList<UEA>();
        lista1 = ops.leerDatos("uea_horas.csv");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.print(ops.comprobarHorasDepartamentoEstricto(lista1.get(i), 5, 3));
        }
        */
    }
    
}
