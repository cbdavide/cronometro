/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import vista.View;

/**
 *
 * @author estudiantes
 */
public class Cronometro extends Thread {

    private String estado;

    private UnidadDeTiempo segundos;
    private UnidadDeTiempo minutos;
    private UnidadDeTiempo horas;
    
    private View view;

    public Cronometro(View v) {

        GestorPrototipos gestor = new GestorPrototipos();

        segundos = gestor.getClone();
        minutos = gestor.getClone();
        horas = gestor.getClone();
        horas.setLimite(24);
        
        this.view = v;

        estado = "avanzar";

    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UnidadDeTiempo getSegundos() {
        return segundos;
    }

    public UnidadDeTiempo getMinutos() {
        return minutos;
    }

    public UnidadDeTiempo getHoras() {
        return horas;
    }

    @Override
    public void run() {

        while (this.isAlive()) {
            
            switch (this.estado) {
                case "avanzar":
                    this.avanzar();
                    break;
                case "retroceder":
                    this.retroceder();
                    break;
                case "pausa":
                    //DO NOTHING
                    break;
            }
            
            view.setSegundos(this.segundos.getPosicion());
            view.setMinutos(this.minutos.getPosicion());
            view.setHoras(this.horas.getPosicion());
            
            view.showTime();
        }

    }

    public void avanzar() {

        try {
            Thread.sleep(1000);
            this.segundos.avanzar();
            
            if (this.segundos.getPosicion() == 0) {
                this.minutos.avanzar();

                if (this.minutos.getPosicion() == 0) {
                    this.horas.avanzar();

                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    //Esta mal
    public void retroceder() {

        try {
            Thread.sleep(1000);
            this.segundos.retroceder();
            if (this.segundos.getPosicion() == 0) {
                this.minutos.retroceder();
                if (this.minutos.getPosicion() == 0) {
                    this.horas.retroceder();
                }
            }
        } catch (InterruptedException ex) {

        }
    }   

}
