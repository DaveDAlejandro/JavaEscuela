package uam.pvoe.repaso.datos;

/**
 * En esta clase se crea el blueprint de los objetos UEA, que son entendidas como materias en
 * la UAM, con atributos claveUEA de tipo String que es la clave asociada a la UEA, horasT de tipo double, 
 * que son las horas teóricas semanales de la UEA y horasP de tipo double, que son las horas prácticas de la UEA
 * @author davidramirez
 */
public class UEA {
    private String claveUEA;
    private double horasT;
    private double horasP;

    /**
     * getter de claveUEA
     * @return un String con la clave de la UEA
     */
    public String getClaveUEA() {
        return claveUEA;
    }

    /**
     * Setter de claveUEA
     * @param claveUEA un String que actualizará el valor inicial o anterior de claveUEA
     */
    public void setClaveUEA(String claveUEA) {
        this.claveUEA = claveUEA;
    }

    /**
     * getter de horasT
     * @return regresa un double con el valor de horasT
     */
    public double getHorasT() {
        return horasT;
    }
    
    /**
     * Setter de horasT
     * @param horasT un valor de tipo double que actualiza el valor inicial o anterior de horasT
     */
    public void setHorasT(double horasT) {
        this.horasT = horasT;
    }
    
    /**
     * getter de horasP
     * @return un valor de tipo double con el valor de horasP
     */
    public double getHorasP() {
        return horasP;
    }
 
    /**
     * Setter de horasP
     * @param horasP un valor de tipo double que actualiza el valor inicial o anterior de horasP
     */
    public void setHorasP(double horasP) {
        this.horasP = horasP;
    }

    /**
     * Constructor de UEA parametrizado
     * @param claveUEA valor inicial de claveUEA en forma de String
     * @param horasT valor inicial de horasT en forma de double
     * @param horasP valor inicial de horasP en forma de double
     */
    public UEA(String claveUEA, double horasT, double horasP) {
        this.claveUEA = claveUEA;
        this.horasT = horasT;
        this.horasP = horasP;
    }

    /**
     * Constructor de UEA por omisión
     */
    public UEA() {
    }

    /**
     * método toString de UEA
     * @return regresa un valor de tipo String con la concatenación de atributos de UEA
     */
    @Override
    public String toString() {
        return "UEA: " + "|claveUEA = " + claveUEA + ", |horasT = " + horasT + ", |horasP = " + horasP;
    }
    
}


