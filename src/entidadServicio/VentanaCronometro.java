/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadServicio;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author lucas
 */
public class VentanaCronometro extends JFrame implements ActionListener{
    
    private JLabel label;
    private JButton btnIniciar;
    private JButton btnDetener;
    
    //Variables que van a simular lo que se va a mostrar en la etiqueta de texto
    static int hora=0, minuto=0, segundo=0; 
    
    //Para parar y volver a iniciar el cronómetro
    static boolean iniciaHilo=true;
    boolean corriendo=false;

    public VentanaCronometro() {
        initialize();
        setSize(228,120);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
    }
    private void initialize(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label=new JLabel("00:00:00");
        label.setFont(new Font("Roboto", Font.PLAIN, 30));
        label.setBounds(47, 11, 137, 45);
        getContentPane().add(label);
        
        btnIniciar=new JButton("Iniciar");
        btnIniciar.setBounds(119, 54, 89, 23);
        btnIniciar.addActionListener(this);
        getContentPane().add(btnIniciar);
        
        btnDetener=new JButton("Parar");
        btnDetener.setBounds(10,54,89,23);
        btnDetener.addActionListener(this);
        getContentPane().add(btnDetener);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnIniciar) {
            if(corriendo==false){
                iniciaHilo=true;
                corriendo=true;
                iniciaHiloCronometro();
            }
            
        }
        if(e.getSource()==btnDetener){
            corriendo=false;
            iniciaHilo=false;
        }
        
    }

    private void iniciaHiloCronometro() {
        if (iniciaHilo==true) {
            //usando Runnable
            Crono miCrono=new Crono(label);
            Thread hilo=new Thread(miCrono);
            hilo.start();
            
        }
    }
    
}
    
    

