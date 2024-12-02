/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5cliente;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.azc.uam.Consulta;

/**
 *
 * @author josue
 */ 
public class Practica5Cliente {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              
        Socket cliente;
        ObjectOutputStream out; //filtro que permite abrir el canal
        ObjectInputStream in;
        Scanner sc = new Scanner(System.in);
        
        try {
            while(true){
                System.out.print("Escribe tu consulta: ");
                String entradaUsuario = sc.nextLine();
                Consulta consulta = new Consulta(entradaUsuario);

                cliente = new Socket("localhost",12345);
                out= new ObjectOutputStream(cliente.getOutputStream()/*asocia el socket con el filtro*/);//crea el filtro
                out.writeObject(consulta);//hace la serializacion


                System.out.println("Consulta enviada al servidor...");

                //Recibir respuesta
                in= new ObjectInputStream(cliente.getInputStream());
                String respuesta= (String) in.readObject();//deserializa
                System.out.println("Respuesta del servidor:\n" + respuesta);

                System.out.println("--------------------------------------------------------");

                
                out.close();
                cliente.close();//cierra los flujos
                in.close();
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Excepcion: "+ex.getMessage());
        } catch (IOException ex2) {
            System.out.println("Excepcion: "+ex2.getMessage());
        } catch (ClassNotFoundException ex3) {
            System.out.println("Excepcion: "+ex3.getMessage());
        }
        
        
        
        
    }
    
}
