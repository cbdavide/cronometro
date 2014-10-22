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
public class ConsolaView implements View{
    
    private int segundos;
    private int minutos;
    private int horas;
    
    @Override
    public void setSegundos(int segundos){
        this.segundos = segundos;
    }
    
    @Override
    public void setMinutos(int minutos){
        this.minutos = minutos;
    }
    
    @Override
    public void setHoras(int horas){
        this.horas = horas;
    }
    
    @Override
    public void showTime(){
        StringBuilder hora = new StringBuilder();
        hora.append((this.horas<10)?"0"+Integer.toString(this.horas):
                Integer.toString(this.horas));
        hora.append((this.minutos<10)?":0"+Integer.toString(this.minutos):
                ":"+Integer.toString(this.minutos));
        hora.append((this.segundos<10)?":0"+Integer.toString(this.segundos):
                ":"+Integer.toString(this.segundos));
        System.out.println(hora.toString());
    }
    
}
