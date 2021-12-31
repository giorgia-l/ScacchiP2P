/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestione;

import scacchip2p.DatiCondivisi;

/**
 *
 * @author Giorgia
 */
public class GestioneRegole {
    
    DatiCondivisi dati=new DatiCondivisi();
    int count = 0; //contatore che parte da 0 e quando arriva a 5 si chiude la connessione
    
    
    public GestioneRegole(DatiCondivisi dati) {
        this.dati=dati;
    }
    
    public String amichevole(){
        String messaggio = "r;" + count + 0;
        return messaggio;
    }
    
    public String competitiva(){
        String messaggio = "r;" + count + 1;
        return messaggio;      
    }
    
    public String personalizzata(){
        String tempo = "";
        String aiuti = "";
        String tipoScacchi = "";
        String messaggio = "r;" + count + 2 + tempo + aiuti + tipoScacchi;
        return messaggio;
    } 
    
    public String creoMessaggioRispostaY(){
        String ris = "y;r";        
        return ris;        
    }
    
    public String creoMessaggioRispostaN(){
       String ris = "n;r;l";
       return ris;
    }
        
}
