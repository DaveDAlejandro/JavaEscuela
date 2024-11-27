/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notasapis;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Ejercicio sencillo para consumir una API. Antes de utilizar objetos JSON se debe de
 * comprender el conceptop de API y ver el funcionamiento de las conexiones realizadas.
 * Para esto se realizará un ejercicio para conectarnos a una API de nuestro agrado.
 * Para esto utilizaré la API de chuckNorris y el objetivo será mostrar una de las bromas
 * de Chuck Norris como salida en consola
 * @author davidramirez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       
        try{
            /*
                Creamos un objeto URL con el endpoint de la API y hacemos un objeto HttpURLConnection
                para poder abrir la conexión
            */
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int respuesta = connection.getResponseCode();
            
            //Comprobamos que no haya ningún error en la petición
            if(respuesta != 200){
                 throw new RuntimeException("Ocurrio un error: " + respuesta);
            }else{
                /*
                    Hacemos un scanner que lea el stream de la URL y luego le vamos dando
                    los valores a nuestro StringBuilder.
                */
                StringBuilder st = new StringBuilder();
                Scanner sc = new Scanner(url.openStream()); 
                
                while(sc.hasNext()){
                    st.append(sc.nextLine());
                }
                sc.close();
                
                /*
                    Creamos un String con el valor toString del StringBuilder y lo dividimos en tokens    
                    para poder imprimir únicamente la parte deseada
                */
                String valorString = st.toString();
                StringTokenizer tokenizer = new StringTokenizer(valorString, ":");
           
                String broma = "";
                
                while (tokenizer.hasMoreTokens()) {
                    broma = tokenizer.nextToken();
                }
                System.out.println(broma);
            }
        }
        catch(Exception e){
            System.out.println("No se pudo jefe");
        }
    }
    
}
