/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadServicio;

import entidadServicio.VentanaCronometro;
import javax.swing.JLabel;

/**
 *
 * @author lucas
 */
public class Crono implements Runnable {

    JLabel eti;

    public Crono(JLabel cronometro) {
        this.eti = cronometro;
    }

    public void run() {
        try {
            int x = 0;
            while (VentanaCronometro.iniciaHilo == true) {
                Thread.sleep(1000);
                System.out.println(x);
                ejecutarHiloCronometro(x);
                x++;
            }
        } catch (Exception e) {
            System.out.println("Error en el hilo: " + e.getMessage());
        }
    }

    private void ejecutarHiloCronometro(int x) {
        String textSeg = "", textMin = "", textHora = "";
        VentanaCronometro.segundo++;
        if (VentanaCronometro.segundo > 59) {
            VentanaCronometro.segundo = 0;
            VentanaCronometro.minuto++;
            if(VentanaCronometro.minuto>59){
                VentanaCronometro.minuto=0;
                VentanaCronometro.hora++;
            }
        }
        if (VentanaCronometro.segundo < 10) {
            textSeg = "0" + VentanaCronometro.segundo;
        } else {
            textSeg = "" + VentanaCronometro.segundo;
        }
        if (VentanaCronometro.minuto < 10) {
            textMin = "0" + VentanaCronometro.minuto;
        } else {
            textMin = "" + VentanaCronometro.minuto;
        }
        if(VentanaCronometro.hora<10){
            textHora="0"+VentanaCronometro.hora;
        }else{
            textHora=""+VentanaCronometro.hora;
        }

       
        String reloj = textHora + ":" + textMin + ":" + textSeg;
        eti.setText(reloj);
    }

}
