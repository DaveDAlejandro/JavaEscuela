package practica1poonb20;
/**
 *David Alejandro Ramírez Dueñas 2223034171
 *Aareck Anelcka Santana Jordan 2222005774
 *Eduardo Badillo Cruz 2213033715
 */
public class Trabajador extends Persona {
    private String numEconomico;

    public Trabajador(String numEconomico, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(nombre, apellidoPaterno, apellidoMaterno);
        this.numEconomico = numEconomico;
    }

    public Trabajador(String numEconomico) {
        this.numEconomico = numEconomico;
    }

    public Trabajador() {
    }
  
    
}
