/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestione;

import java.time.LocalTime;

/**
 *
 * @author Giorgia
 */
public class Regole {
    boolean aiuti;
    LocalTime tempo; 
    int punteggio;
    String tipoScacchi;

    public Regole() {
    }

    public Regole(boolean aiuti, LocalTime tempo, int punteggio, String tipoScacchi) {
        this.aiuti = aiuti;
        this.tempo = tempo;
        this.punteggio = punteggio;
        this.tipoScacchi = tipoScacchi;
    }
}
