/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestione;

import java.net.DatagramPacket;
import scacchip2p.DatiCondivisi;
import scacchip2p.Peer;

/**
 *
 * @author Giorgia
 */
public class GestioneConnessione {

    Peer play1;
    String nome;
    byte[] buffer;
    DatagramPacket packet;

    public GestioneConnessione(Peer play1) {
        buffer = new byte[1500];
        packet = new DatagramPacket(buffer, buffer.length);
        this.play1 = play1;
    }

    public String creoMessaggioConnessione() {
        String messaggio = "c; " + play1.getGiocatore().getNome();
        return messaggio;
    }

    public String creoMessaggioRispostaY() {
        String ris = "y;c;" + play1.getDati().getPlayer2();

        return ris;
    }

    public String creoMessaggioRispostaN() {
        String ris = "n;c";
        return ris;
    }

//    public void controlloConnessione(){
//        
//    }
}
