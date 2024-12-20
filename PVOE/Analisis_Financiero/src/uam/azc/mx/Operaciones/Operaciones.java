/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.azc.mx.Operaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import uam.azc.mx.Datos.Gasto;
import uam.azc.mx.Datos.Moneda;
import uam.azc.mx.Datos.Periodo;

/**
 *
 * @author davidramirez
 */
public class Operaciones {

    
    /**
     * 
     * @param archivo
     * @return 
     */
    public ArrayList<Moneda> registrarMonedas(String archivo){
    
        ArrayList<Moneda> listaMonedas = new ArrayList<Moneda>();
        
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String cadenaLeida = br.readLine();
            while(cadenaLeida != null){
                Moneda moneda = new Moneda();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                moneda.setNombreMoneda(st.nextToken());
                moneda.setClaveMoneda(st.nextToken());
                listaMonedas.add(moneda);
                cadenaLeida = br.readLine();
            }
               
        } catch (IOException ex) {
            System.out.println("NO se encontró el archivo de monedas");
        }catch (Exception e2){
            System.out.println("Hubo un error");
        }
        
        return listaMonedas;
    }
    
    
    
    /**
     * 
     * @param archivo
     * @return 
     */
    public LinkedList<Periodo> registrarPeriodo(String archivo){
    
        LinkedList<Periodo> listaPeriodos = new LinkedList<Periodo>();
        
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String cadenaLeida = br.readLine();
            while(cadenaLeida != null){
                Periodo periodo = new Periodo();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                periodo.setClavePeriodo(st.nextToken());
                periodo.setPeriodo(st.nextToken());
                listaPeriodos.add(periodo);
                cadenaLeida = br.readLine();
            }
               
        } catch (IOException ex) {
            System.out.println("NO se encontró el archivo de Periodos");
        }catch (Exception e2){
            System.out.println("Hubo un error");
        }
        
        return listaPeriodos;
        
        
    }
    
    
    /**
     * 
     * @param archivo
     * @return 
     */
    public ArrayList<Gasto> registrarGastos(String archivo){
        
        ArrayList<Gasto> listaGastos = new ArrayList<Gasto>();
        
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String cadenaLeida = br.readLine();
            while(cadenaLeida != null){
                Gasto gasto = new Gasto();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                gasto.setClaveMoneda(st.nextToken());
                gasto.setClavePeriodo(st.nextToken());
                double totalGastado = Double.parseDouble(st.nextToken());
                gasto.setTotalGastados(totalGastado);
                listaGastos.add(gasto);
                cadenaLeida = br.readLine();
            }
               
        } catch (IOException ex) {
            System.out.println("NO se encontró el archivo de gastos");
        }catch (Exception e2){
            System.out.println("Hubo un error");
        }
        
        return listaGastos;
    }
    
    
    
    /**
     * 
     * @param listaGastos
     * @param clave
     * @return 
     */
    public double obtenerMinimo(ArrayList<Gasto> listaGastos, String clavePeriodo, String claveMoneda){
        double minimo = listaGastos.get(0).getTotalGastados();
        for (Gasto x : listaGastos) {
            if (x.getClavePeriodo().equals(clavePeriodo) && x.getClaveMoneda().equals(claveMoneda)){
                if(x.getTotalGastados() < minimo) {
                    minimo = x.getTotalGastados();
                }             
            }
        }
        return minimo;
    }
    
    
    /**
     * 
     * @param listaGastos
     * @param clave
     * @return 
     */
    public double obtenerMaximo(ArrayList<Gasto> listaGastos, String clavePeriodo, String claveMoneda){
        double maximo = listaGastos.get(0).getTotalGastados();
        for (Gasto x : listaGastos) {
            if(x.getClavePeriodo().equals(clavePeriodo) && x.getClaveMoneda().equals(claveMoneda)){
                if (x.getTotalGastados() > maximo ) {
                    maximo = x.getTotalGastados();
                }                
            }
        }
        return maximo;
    }
    
    
    public double obtenerPromedio(ArrayList<Gasto> listaGastos, String clavePeriodo, String clavePromedio){
        double promedio = 0;
        int cantidadGastos = 0;
        for (Gasto x : listaGastos){
            if(x.getClavePeriodo().equals(clavePeriodo) && x.getClaveMoneda().equals(clavePromedio)){
                promedio += x.getTotalGastados();
                cantidadGastos += 1;
            }
        }
        return promedio/cantidadGastos;
    }
    
    
    public double obtenerGasto(ArrayList<Gasto> listaGastos, String clavePeriodo, String claveMoneda) {
        double gasto = 0.0;  // Valor por defecto si no se encuentra el gasto
        for (Gasto g : listaGastos) {
            // Compara el periodo y la moneda del gasto con los proporcionados
            if (g.getClavePeriodo().equals(clavePeriodo) && g.getClaveMoneda().equals(claveMoneda)) {
                gasto = g.getTotalGastados();  // Si coincide, toma el monto del gasto
                break;  // Si encuentras el gasto, puedes salir del bucle
            }
        }

        return gasto;  // Devuelve el monto del gasto encontrado
    }
    
    
    
}
