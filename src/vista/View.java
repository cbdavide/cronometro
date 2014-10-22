/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

/**
 *
 * @author estudiantes
 */
public interface View {
    
    /**
     * Método para cambiar los segundos en la vista 
     * @param segundos segundos en la vista
     */
    public void setSegundos(int segundos);
     
    /**
     * Método para cambiar los minutos en la vista 
     * @param minutos minutos en la vista
     */
    public void setMinutos(int minutos);
    
    /**
     * Método para cambiar las horas en la vista
     * @param horas horas en la vista
     */    
    public void setHoras(int horas);
    
    /**
     * Método en el que se define como se va a imprimir o actualizar la vista
     */    
    public void showTime();
        
}
