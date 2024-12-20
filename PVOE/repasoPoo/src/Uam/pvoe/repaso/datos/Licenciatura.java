package Uam.pvoe.repaso.datos;
import java.util.Scanner;

public class Licenciatura {
    private int clave;
    private String nombre;
    private float promedio;

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Licenciatura{" + "clave=" + clave + ", nombre=" + nombre + ", promedio=" + promedio + '}';
    }

    public Licenciatura(int clave, String nombre, float promedio) {
        this.clave = clave;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public Licenciatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la clave de la UEA");
        this.setClave(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese el nombre de la UEA");
        this.setNombre(sc.nextLine());
        System.out.println("Ingrese el promedio general de la UEA");
        this.setPromedio(sc.nextFloat());
        System.out.println("");
    }
    
    
    
    
}

