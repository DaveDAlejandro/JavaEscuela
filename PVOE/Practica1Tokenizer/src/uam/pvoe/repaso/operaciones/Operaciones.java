

package uam.pvoe.repaso.operaciones;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import uam.pvoe.repaso.datos.UEA;

/**
 * En esta clase se crean las operaciones utilizadas para todo el proyecto.
 * @author davidramirez
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/?java/io/BufferedReader.html"> Buffered Reader</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/?java/io/FileReader.html"> File Reader Java</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/io/IOException.html"> IOException</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/?java/util/LinkedList.html"> Linked List Java</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/?java/util/LinkedList.html"> StringTokenizer Java</a>
 */
public class Operaciones {
    
    
    /**
     * Esta clase permite al usuario comparar, en base a dos parámetros introducidos por el usuario, si una UEA cumple con el número de 
     * horas prácticas necesarias o no.
     * El primer parámetro es el departamento al que quiere dirigirse, y el segundo las horas prácticas mínimas que se le asignan a dicho
     * departamento, de modo que compara el número de la clave de la UEA que referencia al departamento al que pertenece y, en caso de
     * pertenecer al mismo departamenteo, hace la comparación de horas prácticas para ver si cumple con el criterio mínimo o no. En caso
     * de no pertenecer al departamento, omite la comparación y simplemente denota que la UEA no pertenece al departamento a comparar.
     * @param uea un Objeto UEA al que se quiere comparar
     * @param departamento el número de departamento al que se le hará dicha comparación
     * @param horas la cantidad de horas mínimas a cumplir
     * @return regresa un String que indica si la UEA cumple o no con el criterio
     */
    public String comprobarHorasDepartamento(UEA uea, int departamento, double horas){
        
        Operaciones ops = new Operaciones();
        int ueaDepto = Character.getNumericValue(uea.getClaveUEA().charAt(2));
        
        /*
            Para facilitar la lectura, se utiliza el siguiente código visual:
        °°°°: Pertenece al departamento y cumple con el criterio    
        !°°°: Pertenece al departamento pero no cumple con el criterio
        xxxx: No pertenece al departamento
        */
            if((ueaDepto == departamento) && (uea.getHorasP() < horas)){
                System.out.println("-------------------------------------------------------!°°°");
                System.out.println(ops.nombreDepartamento(uea));
                System.out.println("La UEA debería cumplir con: " + horas + " horas prácticas");
                System.out.println("La uea: " + uea.getClaveUEA() + " cuenta con " + uea.getHorasP() + " horas prácticas");
                return ("La UEA " + uea.getClaveUEA() + " No cumple \n");
                
            }else if(ueaDepto != departamento){
                System.out.println("-----------------------------------------------------xxxx");
                return("Esta UEA no entra dentro del departamento de comprobación: \n" + uea.getClaveUEA() + "\n" + ops.nombreDepartamento(uea) + "\n");
            }
            else{
                System.out.println("-------------------------------------------------------°°°°");
                System.out.println(ops.nombreDepartamento(uea));
                System.out.println("La UEA debería cumplir con: " + horas + " horas prácticas");
                System.out.println("La uea: " + uea.getClaveUEA() + " cuenta con " + uea.getHorasP() + " horas prácticas");
                return("La UEA " + uea.getClaveUEA() + " si cumple \n");
                
            }
        }
    
    
    /**
     * Esta clase es el mismo método que comprobarHorasDepartamento pero con su versión estricta, de modo
     * que solamente imprime las UEA que deban ser comparadas e ignora las otras.
     * @param uea un Objeto UEA al que se quiere comparar
     * @param departamento el número de departamento al que se le hará dicha comparación
     * @param horas la cantidad de horas mínimas a cumplir
     * @return regresa un String que indica si la UEA cumple o no con el criterio
     * @see #comprobarHorasDepartamento(uam.pvoe.repaso.datos.UEA, int, double) 
     */
    public String comprobarHorasDepartamentoEstricto(UEA uea, int departamento, double horas){
        
        Operaciones ops = new Operaciones();
        int ueaDepto = Character.getNumericValue(uea.getClaveUEA().charAt(2));
        
        /*
            Para facilitar la lectura, se utiliza el siguiente código visual:
        °°°°: Pertenece al departamento y cumple con el criterio    
        !°°°: Pertenece al departamento pero no cumple con el criterio
        xxxx: No pertenece al departamento
        */
            if((ueaDepto == departamento) && (uea.getHorasP() < horas)){
                System.out.println("-------------------------------------------------------!°°°");
                System.out.println(ops.nombreDepartamento(uea));
                System.out.println("La UEA debería cumplir con: " + horas + " horas prácticas");
                System.out.println("La uea: " + uea.getClaveUEA() + " cuenta con " + uea.getHorasP() + " horas prácticas");
                return ("La UEA " + uea.getClaveUEA() + " No cumple \n");
                
            }else if((ueaDepto == departamento) && (uea.getHorasP() >= horas)){
                System.out.println("-------------------------------------------------------°°°°");
                System.out.println(ops.nombreDepartamento(uea));
                System.out.println("La UEA debería cumplir con: " + horas + " horas prácticas");
                System.out.println("La uea: " + uea.getClaveUEA() + " cuenta con " + uea.getHorasP() + " horas prácticas");
                return("La UEA " + uea.getClaveUEA() + " si cumple \n");
            }
            else{
                return "-";
            }
        }
    
    

    /**
     * Este método recibe un archivo de tipo texto o cualquiera legible separado por comas que contenga
     * la información de la UEA en órden: clave de UEA, horas teóricas, horas prácticas.
     * Crea los readers y buffers necesarios para leer cada línea por completo.
     * Entra en un ciclo que termina cuando ya no haya más líneas de texto en el archivo, y lo que hace es crear una UEA
     * en cada iteración, separar la línea actual leída en tokens que son utilizados para darle los valores correctos 
     * a la UEA; posteriormente añade la UEA a la lista de UEAs y pasa de línea para entrar en otra iteración.
     * Una vez terminado el ciclo, se regresa la lista de UEAs
     * @param archivo un archivo de tupo texto o cualquiera legible separado por comas
     * @return una lista de objetos UEA con los objetos creados a partir del archivo
     */
    public LinkedList<UEA> leerDatos(String archivo){
        LinkedList<UEA> lista = new LinkedList<UEA>();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String cadenaLeida = br.readLine();
            while(cadenaLeida != null){
                UEA uea = new UEA();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                uea.setClaveUEA(st.nextToken());
                uea.setHorasT(Float.parseFloat(st.nextToken()));
                uea.setHorasP(Float.parseFloat(st.nextToken()));
                lista.add(uea);
                cadenaLeida = br.readLine();
            }
               
        } catch (IOException ex) {
            System.out.println("NO se encontró el archivo");
        }catch (Exception e2){
            System.out.println("Hubo un error");
        }
        
        return lista;
    }
    
    /**
     * Este método recibe una UEA, checa el dígito correspondiente a su departamenteo y
     * regresa el nombre del departamento en forma de String
     * @param a es la UEA de la cual se quiere conocer su departamento
     * @return el nombre del departamento en forma de String
     */
    public String nombreDepartamento(UEA a){
        switch(a.getClaveUEA().charAt(2)){
            case '1' -> {
                return "Departamento de Ciencias Básicas";
            }
            case '2' -> {
                return "Departamenteo de Electrónica";
            }
            case '3' -> {
                return "Departamenteo de Energía";
            }
            case '4' -> {
                return "Departamento de Materiales";
            }
            case '5' -> {                
                return "Departamento de Sistemas";
            }
            case '0' -> {
                return "UEA Divisional";
            }
        }
        return "El departamento es incorrecto";
    }
    
}
