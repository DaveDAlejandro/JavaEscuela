package practica1poonb20;
/**
 *David Alejandro Ramírez Dueñas 2223034171
 *Aareck Anelcka Santana Jordan 2222005774
 *Eduardo Badillo Cruz 2213033715
 */
public class Practica1POONB20 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
        //Prueba #1
        System.out.println("Prueba 1 ----------------------------------");
        
        Alumno alumno1 = new Alumno("17-I", "Azcapotzalco", "Mauricio", "Sanchez", "Lopez");
        alumno1.generarMatricula(alumno1);
        
        Profesor profe1 = new Profesor("FURJ860423HBCNCR08", "235689", "Jorge", "Fuentes", "Rocha");
        profe1.obtenerSexo(profe1);
        profe1.obtenerEdoNacimiento(profe1);
        System.out.println(profe1.validarCurp(profe1));
        
        Administrativo admin1 = new Administrativo("15/05/1989", "123489", "Sofia", "Martinez", "Rodriguez");
        admin1.generarRFC(admin1);
        
        System.out.println("-----------------------------------------");
        
        
        //Prueba#2
        System.out.println("Prueba 2 ----------------------------------");
        
        Alumno alumno2 = new Alumno("23-P", "Lerma", "Carla", "Trujillo", "Sandoval");
        alumno2.generarMatricula(alumno2);
        
        Profesor profe2 = new Profesor("TRFJ910819HMSRLL07", "889658", "Julio", "Trujillo", "Flores");
        profe2.obtenerSexo(profe2);
        profe2.obtenerEdoNacimiento(profe2);
        System.out.println(profe2.validarCurp(profe2));
        
        Administrativo admin2 = new Administrativo("29/02/1995", "30301", "Regina", "Diaz", "Medina");
        admin2.generarRFC(admin2);
        
        
        System.out.println("-----------------------------------------");
        
        
        //Prueba #3
        System.out.println("Prueba 3 ----------------------------------");
       
        Profesor profe3 = new Profesor("CRCC850623MNERLE04", "758965", "Cecilia", "Cruz", "Colorado");
        profe3.obtenerSexo(profe3);
        profe3.obtenerEdoNacimiento(profe3);
        System.out.println(profe2.validarCurp(profe3));
        
        Administrativo admin3 = new Administrativo("01/08/1962", "54321", "Maricela", "Romero", "Huerta");
        admin3.generarRFC(admin3);
        
        Alumno alumno3 = new Alumno("21-O", "Iztapalapa", "Diego", "Martinez", "Negrete");
        alumno3.generarMatricula(alumno3);
                
        System.out.println("-----------------------------------------");
         
         
    }
    
    
 
}
