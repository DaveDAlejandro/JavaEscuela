package practica1poonb20;
import java.util.HashMap;

/**
 *David Alejandro Ramírez Dueñas 2223034171
 *Aareck Anelcka Santana Jordan 2222005774
 *Eduardo Badillo Cruz 2213033715
 */
public class Profesor extends Trabajador{
    private String curp;

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Profesor(String curp, String numEconomico, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(numEconomico, nombre, apellidoPaterno, apellidoMaterno);
        this.curp = curp;
    }

    public Profesor(String curp, String numEconomico) {
        super(numEconomico);
        this.curp = curp;
    }

    public Profesor(String curp) {
        this.curp = curp;
    }

    public Profesor() {
    }

    @Override
    public String toString() {
        return "Profesor{" + "curp=" + curp + '}';
    }
    
    //Método para obtener el sexo del profesor
    public String obtenerSexo(Profesor p){
        String sexo="";
        if (p.getCurp().charAt(10)=='H'){
            sexo="Masculino";
        }else if (p.getCurp().charAt(10)=='M'){
            sexo="Femenino";
        } else{
        System.out.println("indefinido");
        }
        System.out.println("Sexo: "+sexo);
        return sexo;
    }
    
    
    //Metodo para obtener el estado de nacimiento del profesor
    public String obtenerEdoNacimiento(Profesor p){
        
        //Creamos Hashmap con las keys o las opciones
        HashMap <String, String> Estados = new HashMap <> ();
    
        Estados.put("AS","Aguascalientes");
        Estados.put("BS","Baja California Sur");
        Estados.put("CL","Coahuila");
        Estados.put("CS","Chiapas");
        Estados.put("DF","Distrito Federal");
    
        Estados.put("GT","Guanajuato ");
        Estados.put("HG","Hidalgo ");
        Estados.put("MC","Mexico ");
        Estados.put("MS","Morelos ");
        Estados.put("NL","Nuevo Leon ");
    
        Estados.put("PL","Puebla ");
        Estados.put("QR","Quintana Roo ");
        Estados.put("SL","Sinaloa ");
        Estados.put("TC","Tabasco ");
        Estados.put("TL","Tlaxcala ");
    
        Estados.put("YN","Yucatan ");
        Estados.put("NE","Nacido en el Extranjero ");
        Estados.put("BC","Baja California ");
        Estados.put("CC","Campeche ");
        Estados.put("CM","Colima ");
    
        Estados.put("CH","Chihuahua ");
        Estados.put("DG","Durango ");
        Estados.put("GR","Guerrero ");
        Estados.put("JC","Jalisco ");
        Estados.put("MN","Michoacan ");
    
        Estados.put("NT","Nayarit");
        Estados.put("OC","Oaxaca");
        Estados.put("QT","Queretaro");
        Estados.put("SP","San Luis Potosi");
        Estados.put("SR","Sonora");
    
        Estados.put("TS","Tamaulipas");
        Estados.put("VZ","Veracruz");
        Estados.put("ZS","Zacatecas");
    
        //Obtenemos la key del curp de la persona, llamamos al Hashmap e imprimimos el estado
    	String estado=p.getCurp().substring(11,13);
    
        
        System.out.println("Estado de Nacimento: "+Estados.get(estado));
        return estado;
    }
            
    public String validarCurp(Profesor p){
        
        char aux = 'z';
        
        if(p.curp.charAt(0) != p.getApellidoPaterno().charAt(0)){
            System.out.println("Salida1");
            return "CURP No valida";
        }
        
        //El OUTER nos ayuda a salir de un ciclo anidado hasta el flujo principal de la clase
        OUTER:
        for (int i = 0; i <= p.getApellidoPaterno().length()-1; i++) {
            for(int j = 0; j <= 4; j++){
                char char1 = p.getApellidoPaterno().toUpperCase().charAt(i);
                String abc = "AEIOU";
                if(char1 == abc.charAt(j)){
                    aux = abc.charAt(j);
                    break OUTER;
                }
            }
        }
        
        if(p.curp.charAt(1) != aux){   
            return "CURP NO es valido";
        }    
         
        if(p.curp.charAt(2) != p.getApellidoMaterno().charAt(0)){
            return "CURP No es valido";
        }
            
        if(p.curp.charAt(3) != p.getNombre().charAt(0)){
            return "CURP No es valido";         
        }
        
        return "CURP Valida";
    }
    
} 

