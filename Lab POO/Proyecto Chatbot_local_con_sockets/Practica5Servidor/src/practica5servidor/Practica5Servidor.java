/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica5servidor;

import mx.azc.uam.Consulta;
import mx.azc.uam.MiniBot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author davidramirez
 */
public class Practica5Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServerSocket servidor;//crea el server socket atiende las peticiones del cliente
        ObjectInputStream in;
        ObjectOutputStream out;
        Socket s1;//crea un socket, ayuda a repartir las tareas del servidor(concurrencia) 

        try {
            servidor = new ServerSocket(12345/*puerto*/);//crea un servidor
            System.out.println("Servidor iniciado...");
            
            
            while (true) {
                System.out.println("Servidor en espera... ");
                s1 = servidor.accept();//acepta las peticiones
                System.out.println("Conexion aceptada");

                in = new ObjectInputStream(s1.getInputStream()/*esta atendiendo*/);//trae del flujo
                Consulta consulta = (Consulta) in.readObject();//deserializacion

                System.out.println("Consulta recibida");
                
                MiniBot miniBot = new MiniBot(consulta);
                String respuesta = miniBot.prepararRespuesta();
                
                
                //Enviar respuesta
                System.out.println("Enviando respuesta...");
                
                out = new ObjectOutputStream(s1.getOutputStream());
                out.writeObject(respuesta);
                
                System.out.println("--------------------------------------------------------");
                
                in.close();
                out.close();
                s1.close();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Excepcion " + ex.getMessage());
        } catch (IOException ex2) {
            System.out.println("Excepcion " + ex2.getMessage());
        } catch (ClassNotFoundException ex3) {
            System.out.println("Excepcion " + ex3.getMessage());
        }

        
    }
    
}
