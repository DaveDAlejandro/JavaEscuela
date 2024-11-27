package practica1poonb20;
/**
 *David Alejandro Ramírez Dueñas 2223034171
 *Aareck Anelcka Santana Jordan 2222005774
 *Eduardo Badillo Cruz 2213033715
 */
public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public Persona() {
    }
    
    
}
