/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import control.Cronometro;
import vista.SwingView;

/**
 *
 * @author david
 */
public class CronometroGrafico {
        
    public static void main(String[]args){
        SwingView view = new SwingView();
        view.setCronometro(new Cronometro(view));
        view.iniciar();
    }
    
}
