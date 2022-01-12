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
 * @author Giorgia
 */
public class GestioneRegole {

    Peer play1;

    public GestioneRegole(Peer dati) {
        this.play1 = play1;
    }

    public String amichevole() {
        String messaggio = "r;" + 0;
        return messaggio;
    }

    public String competitiva() {
        String messaggio = "r;" + 1;
        return messaggio;
    }

    public String personalizzata() {
        String tempo = "";
        String aiuti = "";
        String tipoScacchi = "";
        String messaggio = "r;" + 2 + tempo + aiuti + tipoScacchi;
        return messaggio;
    }

    public String creoMessaggioRispostaY() {
        String ris = "y;r";
        return ris;
    }

    public String creoMessaggioRispostaN() {
        String ris = "n;r;d";
        return ris;
    }

    public String personalizzata(int tempo, boolean aiuti, String tipoScacchi) {
        String messaggio = "r;" + 2 + ";" + tempo + ";" + aiuti + ";" + tipoScacchi;
        return messaggio;
    }

}
