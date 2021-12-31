/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestione;

import java.net.DatagramPacket;
import scacchip2p.DatiCondivisi;

/**
 *
 * @author Giorgia
 */
public class GestioneConnessione {
    DatiCondivisi dati = new DatiCondivisi();
    String nome;
    byte[] buffer;
    DatagramPacket packet;
    
    public GestioneConnessione(DatiCondivisi dati){
        buffer = new byte[1500];
        packet = new DatagramPacket(buffer, buffer.length);
        this.dati = dati;
    }
    
    public String creoMessaggioConnessione(){
        String messaggio = "c; " + nome;        
        return messaggio;
    }
    
    public String creoMessaggioRispostaY(){
        String ris = "y;c;" + dati.getPlayer2();
        
        return ris;        
    }
    
    public String creoMessaggioRispostaN(){
       String ris = "n;c";
       return ris;
    }
    
//    public void controlloConnessione(){
//        
//    }
}
