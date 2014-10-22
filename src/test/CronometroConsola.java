/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import control.Cronometro;
import vista.ConsolaView;

/**
 *
 * @author david
 */
public class CronometroConsola {
        public static void main(String[]args){
        
        Cronometro c = new Cronometro(new ConsolaView());
        c.start();
        
    }
}
