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
public class UnidadDeTiempo implements Cloneable {
    
    private int limite;
    private int posicion;
    
    public UnidadDeTiempo(){
        this.limite = 60;
        this.posicion = 0;
    }
    
    public void setLimite(int limite){
        this.limite = limite;
    }
    
    public int getLimite(){
        return this.limite;
    }
    
    public int getPosicion(){
        return this.posicion;
    }
    
    public void avanzar(){
        
        this.posicion = (this.posicion >= (this.limite-1))? 0 : this.posicion + 1 ;
        //System.out.println(this.limite);
        
    }
    
    public void retroceder (){
        
        this.posicion = (this.posicion <= 0)?limite : this.posicion -1;
        
    }
    
    public Object clone () throws CloneNotSupportedException{
        return super.clone();
    }
    
    
}
