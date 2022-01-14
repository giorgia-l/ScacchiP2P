/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestione;

import scacchip2p.Peer;

/**
 *
 * @author stagno_alberto
 */
public class GestioneGioco {

    Peer play1;

    public GestioneGioco(Peer play1) {
        this.play1 = play1;
    }

    public String creaMessaggioStartGioco() {
        return "ms";
    }

    public String creoMessaggioMossa(String posIniziale, String posFinale, String pezzoSpostato, boolean patta) {
        return "m;" + posIniziale + ";" + posFinale + ";" + pezzoSpostato + ";" + patta;
    }

    public String creoMessaggioResa() {
        return "s";
    }

    public String creoMessaggioFinePartita() {
        return "fp";
    }

    public String creoMessaggioRivincita() {
        return "a";
    }

    public String creoMessaggioAffermativoPatta() {
        return "y;m";
    }

    public String creoMessaggioNegativoPatta() {
        return "n;m";
    }
    public String creoMessaggioCambioPezzo(String posIniziale, String posFinale, String pezzoSpostato, boolean patta,String pezzo){
        return "m;" + posIniziale + ";" + posFinale + ";" + pezzoSpostato + ";" + patta+";"+pezzo;
    }
}
