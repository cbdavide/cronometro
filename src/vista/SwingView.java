/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import control.Cronometro;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class SwingView extends JFrame implements View,ActionListener{
    
    private int segundos;
    private int minutos;
    private int horas;
    
    private JLabel tiempo;
    
    private JPanel panelBotones;
    private JButton iniciar;
    private JButton detener;
    private JButton retroceder;
    
    private BorderLayout layout;
    
    private Cronometro cronometro;
    
    public SwingView(){
        super("Cronometro");
        layout = new BorderLayout();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
        configurarPanelBotones();
        config();
        listenerBotones();
        addComponentes();
        setSize(200,90);
        setVisible(true);        
    }
    
    public void setCronometro(Cronometro c){
        cronometro = c;
        cronometro.setEstado("pausa");
    }
    
    public void iniciar(){
        cronometro.start();
    }
    
    private void iniciarComponentes(){
        tiempo = new JLabel("--:--:--");
        tiempo.setFont(new Font("Arial", Font.PLAIN, 20));
        iniciar = new JButton(">");
        detener = new JButton("||");
        retroceder = new JButton("<");
        panelBotones = new JPanel();
    }
    
    private void listenerBotones(){
        iniciar.addActionListener(this);
        iniciar.setActionCommand("iniciar");
        detener.addActionListener(this);
        detener.setActionCommand("detener");
        retroceder.addActionListener(this);
        retroceder.setActionCommand("retroceder");
    }
    
    private void config(){
        detener.setEnabled(false);
        retroceder.setEnabled(false);
    }
    
    private void addComponentes(){
        add(tiempo);
        add(panelBotones);
    }
    
    private void configurarPanelBotones(){
        panelBotones.add(retroceder);
        panelBotones.add(detener);
        panelBotones.add(iniciar);
    }
    
    @Override
    public void showTime(){
        StringBuilder horad = new StringBuilder();
        horad.append((this.horas<10)?"0"+Integer.toString(this.horas):
                Integer.toString(this.horas));
        horad.append((this.minutos<10)?":0"+Integer.toString(this.minutos):
                ":"+Integer.toString(this.minutos));
        horad.append((this.segundos<10)?":0"+Integer.toString(this.segundos):
                ":"+Integer.toString(this.segundos));
        tiempo.setText(horad.toString());
    }

    @Override
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public void setMinutos(int minutos) {
        this.minutos = minutos;        
    }

    @Override
    public void setHoras(int horas) {
        this.horas = horas;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "iniciar":
                iniciar.setEnabled(false);
                detener.setEnabled(true);
                retroceder.setEnabled(true);
                cronometro.setEstado("avanzar");
                break;
            case "detener":
                iniciar.setEnabled(true);
                detener.setEnabled(false);
                retroceder.setEnabled(true);
                cronometro.setEstado("pausa");
                break;
            case "retroceder":
                iniciar.setEnabled(true);
                detener.setEnabled(true);
                retroceder.setEnabled(false);
                cronometro.setEstado("retroceder");
                break;
        }
    }
    
}
