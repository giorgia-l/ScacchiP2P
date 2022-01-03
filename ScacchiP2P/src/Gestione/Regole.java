/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestione;

/**
 *
 * @author Giorgia
 */
public class Regole {
    boolean aiuti;
    boolean tempo;
    int punteggio;    
    String tipoScacchi;

    public Regole() {
    }

    public Regole(boolean aiuti, boolean tempo, int punteggio, String tipoScacchi) {
        this.aiuti = aiuti;
        this.tempo = tempo;
        this.punteggio = punteggio;
        this.tipoScacchi = tipoScacchi;
    }
    
    public void amichevole(){
        aiuti = true;
        tempo = false;
        //modifico il tipo del punteggio e sistemo
    }
    
    public void competitiva(){
        aiuti = false;
        tempo = true;
    }
    
    public void personalizzata(){
        //in base alla decisione del giocatore
    }
}
