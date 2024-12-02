/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.azc.uam;

import java.time.Duration;
import java.time.LocalTime;

public class MiniBot{

    private Consulta consulta;
    private String[] palabrasVacias = {
        "la", "de", "el", "del", "para", "este", "los", "a", 
        "cuando", "son", "con", "al", "como", "cual", "que", "y"
    };

    public MiniBot(Consulta consulta) {
        this.consulta = consulta;
    }

    /**
     * Este método se encarga de eliminar los signos de puntuación ",.¡!¿?()" de una cadena
     * de texto dentro de un objeto consulta. Regresa solamente la cadena de texto sin 
     * los signos de puntuación.
     * @param consulta Es un objeto de tipo {@link Consulta}, con parametros mensajeDeTexto y horaDeConsulta
     * @return Regresa un String con el valor de mensajeDeTexto sin los signos de puntuación
     */
    
    public String eliminarSignos(Consulta consulta){
        String signos = "[,.¡!¿?()]";

        StringBuilder textoSinSignos = new StringBuilder();
        for (char i : consulta.getMensajeDeTexto().toCharArray()) {
            if (!String.valueOf(i).matches(signos)) {
                textoSinSignos.append(i);
            }
        }
        return textoSinSignos.toString();
    }
    
    
    /**
     * Este método se encarga de contar los signos de puntuación ",.¡!¿?()" de una cadena de
     * texto dentro de un objeto consulta. Regresa únicamente un entero con la cantidad de signos
     * contados en el atributo mensajeDeTexto dentro del objeto Consulta
     * @param consulta Es un objeto de tipo {@link Consulta}, con parametros mensajeDeTexto y horaDeConsulta
     * @return Regresa un Int con la cantidad de signos ",.¡!¿?()" dentro del atributo mensajeDeTexto del
     * objeto Consulta introducido
     */
    public int contarSignos(Consulta consulta){
        String signos = "[,.¡!¿?()]";
        int contador = 0;

        for (char i : consulta.getMensajeDeTexto().toCharArray()) {
            if (String.valueOf(i).matches(signos)) {
                contador++;
            } 
        }
        return contador;
    }
    
    
    /**
     * Este método se encarga de recibir un texto previamente depurado por el método eliminarSignos,
     * de modo que únicamente quedan palabras espaciadas sin signos. El método entonces crea un
     * StringBuilder con el nombre de textoLimpio, que será en donde construiremos nuestra cadena
     * limpia. Posteriormente se crea una variable textoSeparado que se encarga de dividir el texto en 
     * partes a partir de la pauta de espacios en blanco " ". 
     * 
     * Luego se itera por todos los valores de textoSeparado. Inicializamos un booleano palabraVacia
     * dentro del for con el valor falso. Esto para comprobar si la palabra de la iteración actual se
     * considera vacía o no. Para comprobar esa condición, se crea un for loop anidado que itera por
     * todos los valores del Array palabrasVacias y lo compara con el valor actual de la iteración
     * de textoSeparado. En caso de coincidir, se considera que la palabra es vacía y se cambia el 
     * valor de palabraVacía a true.
     * 
     * Finalmente, si la palabra no es vacía, se agrega al stringBuilder textoLimpio con un .append();
     * de no serlo, simplemente se pasa a la siguiente iteración. Terminando el ciclo, se regresa el toString
     * de textoLimpio recortado con .trim()
     * @param texto Es un String que se corresponde a un atributo mensajeDeTexto de una consulta previamente
     * pasado por el método eliminarSignos
     * @return Regresa un String con el valor de entrada sin palabras vacías.
     * @see #eliminarSignos(mx.azc.uam.Consulta) 
     */
    public String eliminarPalabrasVacias(String texto){
        
        StringBuilder textoLimpio = new StringBuilder();
        String textoSeparado[] = texto.toLowerCase().split(" ");
        
        for (String palabra: textoSeparado) {
            boolean palabraVacia = false;
            for (String vacia : palabrasVacias) {
                if (palabra.equals(vacia)) {
                    palabraVacia = true;
                    break;
                }
            }
            if (!palabraVacia) {
                textoLimpio.append(palabra).append(" ");
            }
        }
        return textoLimpio.toString().trim();
    }
    
    
    /**
     * Éste método se encarga de contar las palabras vacías eliminadas de un texto.
     * Para esto recibe como valor de entrada un String que será el texto del cual se contarán
     * las palabras eliminadas siguiendo las pautas del método eliminarPalabrasVacias.
     * 
     * Para esto simplemente se agrega un contador al inicio del programa y se sigue el proceso
     * de iteración del método eliminarPalabrasVacias sin tomar en cuenta el StringBuilder y sumándole
     * un 1 al contador cada que la palara en la iteración de textoSeparado sea igual a alguna
     * de las iteraciones del Array palabrasVacias
     * @param texto Es un texto previamente depurado con el método eliminarSignos
     * @return Regresa un Int con el número de palabras vacías que hay en el texto, que por ende
     * son la cantidad de palabras eliminadas al utilizar el método eliminarPalabrasVacias
     * @see #eliminarPalabrasVacias(java.lang.String) 
     * @see #eliminarSignos(mx.azc.uam.Consulta) 
     */
    public int contarPalabrasEliminadas(String texto){
        
        int total = 0;
        String textoSeparado[] = texto.toLowerCase().split(" ");
        
        for (String palabra: textoSeparado) {
            for (String vacia : palabrasVacias) {
                if (palabra.equals(vacia)) {
                        total++;
                    break;
                }
            }
        }
        return total;
    }
    
    
    /**
     * 
     * @param texto
     * @return 
     */
    public int contarPalabrasClave(String texto) {
    // Limpiar el texto: eliminar espacios extra y dividir
    String[] textoSeparado = texto.toLowerCase().trim().split(" ");
    int totalClaves = 0;

    // Recorrer cada palabra del texto
    for (String palabra : textoSeparado) {
        boolean esPalabraVacia = false;

        // Verificar si la palabra es una palabra vacía
        for (String vacia : palabrasVacias) {
            if (palabra.equals(vacia)) {
                esPalabraVacia = true;
                break; // Si es una palabra vacía, detener la búsqueda
            }
        }

        // Si no es palabra vacía, contarla como clave
        if (!esPalabraVacia) {
            totalClaves++;
        }
    }

    return totalClaves;
}
    
    
    /**
     * 
     * @param mensajeLimpio
     * @return 
     */
    public String encontrarRespuestaAdecuada(String mensajeLimpio) {
        
        String[] palabras = mensajeLimpio.toLowerCase().split(" ");

        boolean contieneUAM = false, 
                contieneAzcapotzalco = false, 
                contieneServicio = false, 
                contieneMedico = false,
                contieneServicios = false, 
                contieneEscolares = false, 
                contieneCovid = false, 
                contieneCoviuam = false;
        
        int palabrasClaveEncontradas = 0;

        // Contar palabras clave y cambiar los comprobadores
        for (String palabra : palabras) {
            switch (palabra) {
                case "uam":
                    contieneUAM = true;
                    palabrasClaveEncontradas++;
                    break;
                case "azcapotzalco":
                    contieneAzcapotzalco = true;
                    palabrasClaveEncontradas++;
                    break;
                case "servicio":
                    contieneServicio = true;
                    palabrasClaveEncontradas++;
                    break;
                case "medico":
                    contieneMedico = true;
                    palabrasClaveEncontradas++;
                    break;
                case "servicios":
                    contieneServicios = true;
                    palabrasClaveEncontradas++;
                    break;
                case "escolares":
                    contieneEscolares = true;
                    palabrasClaveEncontradas++;
                    break;
                case "covid":
                    contieneCovid = true;
                    palabrasClaveEncontradas++;
                    break;
                case "coviuam":
                    contieneCoviuam = true;
                    palabrasClaveEncontradas++;
                    break;
            }
        }
        if (contieneUAM && contieneAzcapotzalco) {
            return "La Universidad Autónoma Metropolitana Unidad Azcapotzalco actualmente cuenta con 17 licenciaturas, divididas en 3 áreas de estudio.\nVisita: https://www.azc.uam.mx/";
        } else if (contieneServicio && contieneMedico) {
            return "Proporcionamos atención médica a los miembros de la comunidad universitaria. Contamos con 5 médicos y 4 consultorios, solo debes presentar tu credencial de la UAM.\nVisita: https://csu.azc.uam.mx/medicos/";
        } else if (contieneServicios && contieneEscolares) {
            return "La Coordinación de Sistemas Escolares, administra los procesos, entre los que se encuentran el registro, seguimiento y control del ingreso, permanencia y egreso de los alumnos de Licenciatura y Posgrado.\nVisita: http://cse.azc.uam.mx/";
        } else if (contieneCovid || contieneCoviuam) {
            return "Es una nueva aplicación para conocer el estado de salud de la comunidad UAM en el regreso presencial.\nVisita: https://coviuam.uam.mx/";
        } else if (contieneUAM) {
            return "Fundada en 1974 y con más de 200 mil personas egresadas, la UAM es una institución pública que ofrece en sus cinco unidades académicas.\nVisita: https://www.uam.mx/";
        }
        int palabrasRelevantes = palabras.length - contarPalabrasEliminadas(mensajeLimpio);
        if (palabrasRelevantes >= 3) {
            return "No tengo información acerca de esa consulta.";
        } else {
            return "No entiendo tu consulta :(";
        }
    }
    
    
    
    public String prepararRespuesta() {
        
        LocalTime inicio = LocalTime.now();

        String mensajeOriginal = consulta.getMensajeDeTexto();

        String mensajeSinSignos = eliminarSignos(consulta);
        int numeroDeSignos = contarSignos(consulta);

        // Limpieza completa del texto
        String textoLimpio = eliminarPalabrasVacias(mensajeSinSignos);
        int palabrasEliminadas = contarPalabrasEliminadas(mensajeSinSignos);

        // Contar palabras clave del texto limpio
        int numeroDePalabrasClave = contarPalabrasClave(textoLimpio);

        // Buscar respuesta adecuada
        String respuestaAdecuada = encontrarRespuestaAdecuada(textoLimpio);

        LocalTime fin = LocalTime.now();
        long tiempoDeRespuesta = Duration.between(inicio, fin).toMillis();

        return "Consulta recibida: " + mensajeOriginal + "\n" +
               "Palabras vacías eliminadas: " + palabrasEliminadas + "\n" +
               "Palabras clave encontradas: " + numeroDePalabrasClave + "\n" +
               "Signos de puntuación eliminados: " + numeroDeSignos + "\n" +
               "Respuesta del Mini Bot: " + respuestaAdecuada + "\n" +
               "Tiempo de respuesta: " + tiempoDeRespuesta + " ms\n" +
               "Hora de consulta: " + consulta.getHoraDeConsulta();
    } 
}
