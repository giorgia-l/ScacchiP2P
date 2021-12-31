/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestione;

import scacchip2p.DatiCondivisi;

/**
 *
 * @author stagno_alberto
 */
public class GestioneColore {

    DatiCondivisi dati = new DatiCondivisi();

    public GestioneColore(DatiCondivisi dati) {
        this.dati = dati;
    }

    public String creoMessaggioColore() {
        String messaggio = "sc;" + dati.getPlayer1().getColore();

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
