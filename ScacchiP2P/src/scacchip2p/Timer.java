/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alber
 */
public class Timer extends Thread {

    Peer play1;

    int tempoPlayerMinuti;
    int tempoPlayerSecondi;

    int tempoAvversarioMinuti;
    int tempoAvversarioSecondi;

    public Timer(Peer play1) {
        this.play1 = play1;
    }

    public void setTempo(int tempo) {
        this.tempoPlayerMinuti = tempo;
        this.tempoAvversarioMinuti = tempo;

        tempoPlayerSecondi = 0;
        tempoAvversarioSecondi = 0;

    }

    public void run() {
        while (play1.dati.isReady) {

            if (play1.dati.isMyTurn) {
                if (tempoPlayerSecondi < 0) {
                    tempoPlayerSecondi = 60;
                    tempoPlayerMinuti--;
                }
                tempoPlayerSecondi--;
            } else if (!play1.dati.isMyTurn) {
                if (tempoAvversarioSecondi < 0) {
                    tempoAvversarioSecondi = 60;
                    tempoAvversarioMinuti--;
                }
                tempoAvversarioSecondi--;
            }
            
            play1.dati.frameBoard.SetTempoGrafico(tempoPlayerMinuti+":"+tempoPlayerSecondi, tempoAvversarioMinuti+":"+tempoAvversarioSecondi);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
