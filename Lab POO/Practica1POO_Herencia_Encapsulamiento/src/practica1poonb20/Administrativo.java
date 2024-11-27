package practica1poonb20;
import java.util.Random;
/**
 *David Alejandro Ramírez Dueñas 2223034171
 *Aareck Anelcka Santana Jordan 2222005774
 *Eduardo Badillo Cruz 2213033715
 */
public class Administrativo extends Trabajador {
    private String fechaNacimiento;
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Administrativo(String fechaNacimiento, String numEconomico, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(numEconomico, nombre, apellidoPaterno, apellidoMaterno);
        this.fechaNacimiento = fechaNacimiento;
    }

    public Administrativo(String fechaNacimiento, String numEconomico) {
        super(numEconomico);
        this.fechaNacimiento = fechaNacimiento;
    }

    public Administrativo(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Administrativo() {
    }

    public String generarRFC(Administrativo a){
        String regresa = "";
        regresa = regresa + a.getApellidoPaterno().charAt(0) + a.getApellidoPaterno().charAt(1);
        regresa = regresa + a.getApellidoMaterno().charAt(0);
        regresa = regresa + a.getNombre().charAt(0);
        regresa = regresa + a.getFechaNacimiento().charAt(8)+ a.getFechaNacimiento().charAt(9);
        regresa = regresa + a.getFechaNacimiento().charAt(3)+ a.getFechaNacimiento().charAt(4);
        regresa = regresa + a.getFechaNacimiento().charAt(0)+ a.getFechaNacimiento().charAt(1);
        
        //Genera un número aleatorio entre 0 y 25 dentro del rango ASCII deseado 65-90 para luego castearlo como caracter
        //Y obtener así una letra en base al rango random.
        Random rand = new Random();
        int low = 65;
        int high = 91;
        int result = rand.nextInt(high-low) + low;
        regresa = regresa + (char)result;
        result = rand.nextInt(high-low) + low;
        regresa = regresa + (char)result;
        
        //Numero aleatorio entre 0 y  y lo agrega
        low = 0;
        high = 10;
        result = rand.nextInt(high-low);
        regresa = regresa + result;
        
        System.out.println(regresa.toUpperCase());
        return regresa.toUpperCase();
    }
}
