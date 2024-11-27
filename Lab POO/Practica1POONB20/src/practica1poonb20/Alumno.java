package practica1poonb20;
import java.util.Random;
/**
 *David Alejandro Ramírez Dueñas 2223034171
 *Aareck Anelcka Santana Jordan 2222005774
 *Eduardo Badillo Cruz 2213033715
 */
public class Alumno extends Persona{
    private String trimestreIngreso;
    private String unidad;
 
    public Alumno() {
    }

    public String getTrimestreIngreso() {
        return trimestreIngreso;
    }

    public void setTrimestreIngreso(String trimestreIngreso) {
        this.trimestreIngreso = trimestreIngreso;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    public Alumno(String trimestreIngreso, String unidad, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(nombre, apellidoPaterno, apellidoMaterno);
        this.trimestreIngreso = trimestreIngreso;
        this.unidad = unidad.toUpperCase();
    }

    public Alumno(String trimestreIngreso, String unidad) {
        this.trimestreIngreso = trimestreIngreso;
        this.unidad = unidad.toUpperCase();
    }

    //Hacer implementación con un if case para evitar incidencias.
    //Ej. Xalpa en lugar de Xochimilco
    public String generarMatricula(Alumno a){
        String matricula = "";
        Random rand = new Random();
     
       //Corrobora la unidad y agrega el número correspondiente a la matrícula
        if(a.getUnidad().toUpperCase().equalsIgnoreCase("XOCHIMILCO")){
            matricula = matricula + "1";
        }else if(a.getUnidad().toUpperCase().equalsIgnoreCase("AZCAPOTZALCO")){
            matricula = matricula + "2";
        }else if(a.getUnidad().toUpperCase().equalsIgnoreCase("IZTAPALAPA")){
            matricula = matricula + "3";
        }else if(a.getUnidad().toUpperCase().equalsIgnoreCase("CUAKIMALPA")){
            matricula = matricula + "4";
        }else if(a.getUnidad().toUpperCase().equalsIgnoreCase("LERMA")){
            matricula = matricula + "5";
        }else{
            matricula = matricula + "0";
        }
        
       //Se agregan los números correspondientes al año que ya se encuentran en el objeto
        matricula = matricula + a.getTrimestreIngreso().charAt(0) + a.getTrimestreIngreso().charAt(1);
        
        //Dependiendo del periodo del año, se le asigna el número correspondiente
        switch (a.getTrimestreIngreso().charAt(3)) {
            case 'P':
                matricula = matricula + "2";
                break;
            case 'O':
                matricula = matricula + "3";
                break;
            case 'I':
                matricula = matricula + "1";
                break;
            default:
                matricula = matricula + "0";
                break;
        }
        
        //Agregamos números aleatorios según se indica en la práctica
        matricula = matricula + rand.nextInt(2);
        matricula = matricula + rand.nextInt(4);
        
        int low = 5;
        int high = 9;
        int result = rand.nextInt(high-low) + low;
        matricula = matricula + result;
        
        for(int i = 1; i <= 3; i++){
            low = 0;
            high = 9;
            result = rand.nextInt(high-low) + low;
            matricula = matricula + result;
        }
        
        System.out.println(matricula);
        return matricula;
        
    }
    
}
