/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.azc.uam;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Esta clase es el blueprint de los objetos de tipo Consulta, que tienen como atributos
 * un String privado de tipo consulta, que será un input de un usuario cliente, y como
 * segundo atributo una hora específica de tipo LocalTime inicializada automáticamente
 * con el método LocalTime.now()
 * @author David Alejandro Ramírez Dueñas
 */
public class Consulta implements Serializable{
    
    private String mensajeDeTexto;
    private LocalTime horaDeConsulta;

    /**
     * Método getter de mensajeDeTexto. Se encarga de obtener el valor de
     * getMensajeDeTexto
     * @return Regresa el valor de mensajeDeTexto en forma de String
     */
    public String getMensajeDeTexto() {
        return mensajeDeTexto;
    }

    /**
     * Método setter de mensajeDeTexto. Se encarga de actualizar el valor de
     * mensajeDeTexto
     * @param mensajeDeTexto Es el nuevo valor en forma de String que se le quiere
     * dar al atributo mensajeDeTexto del objeto
     */
    public void setMensajeDeTexto(String mensajeDeTexto) {
        this.mensajeDeTexto = mensajeDeTexto;
    }

    /**
     * Método horaDeConsulta de mensajeDeTexto. Se encarga de obtener el valor de
     * horaDeConsulta
     * @return Regresa el valor de horaDeConsulta en forma de LocalTime
     */
    public LocalTime getHoraDeConsulta() {
        return horaDeConsulta;
    }

 
    /**
     * Constructor parametrizado de Consulta. Solamente se pide un String que inicializa
     * el valor de mensajeDeTexto. El valor de horaDeConsulta se inicializa automáticamente
     * por el método LocalTime.now()
     * @param mensajeDeTexto Es el valor de inicialización de mensajeDeTexto
     */
    public Consulta(String mensajeDeTexto) {
        this.mensajeDeTexto = mensajeDeTexto;
        this.horaDeConsulta = LocalTime.now();
    }
    
}
