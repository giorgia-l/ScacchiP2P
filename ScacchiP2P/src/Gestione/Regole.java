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
    int tempo;
    int punteggio;    
    String tipoScacchi;

    int minuti;
    
    public Regole() {
    }

    public Regole(boolean aiuti, int tempo, int punteggio, String tipoScacchi) {
        this.aiuti = aiuti;
        this.tempo = tempo;
        this.punteggio = punteggio;
        this.tipoScacchi = tipoScacchi;
    }
    
    public void amichevole(){
        aiuti = true;
        tempo = 0;
        //modifico il tipo del punteggio e sistemo
    }
    
    public void competitiva(){
        aiuti = false;
        tempo = 10;
    }
    
    public void personalizzata(){
        //in base alla decisione del giocatore
    }

    public boolean isAiuti() {
        return aiuti;
    }

    public int getTempo() {
        return tempo;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getTipoScacchi() {
        return tipoScacchi;
    }
    
}
