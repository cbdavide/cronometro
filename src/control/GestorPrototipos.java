/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

/**
 *
 * @author estudiantes
 */
public class GestorPrototipos {
    
    private UnidadDeTiempo unidad;
    
    public GestorPrototipos(){
        
        unidad = new UnidadDeTiempo();
        unidad.setLimite(60);    
        
    }
    
    public UnidadDeTiempo getClone(){
        try {
            return (UnidadDeTiempo)this.unidad.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
            
        }
    }
    
}
