/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestione;

import scacchip2p.DatiCondivisi;
import scacchip2p.Peer;

/**
 *
 * @author stagno_alberto
 */
public class GestioneColore {

    Peer play1;

    public GestioneColore(Peer play1) {
        this.play1 = play1;
    }

    public String creoMessaggioColore() {
        String messaggio = "sc;" + play1.getGiocatore().getColore();

        return messaggio;
    }

    public String creoMessaggioRispostaAffermativa() {
        String messaggio = "y;sc";

        return messaggio;
    }

    public String creoMessaggioRispostaNegativa() {
        String messaggio = "n;sc";

        return messaggio;
    }

}
