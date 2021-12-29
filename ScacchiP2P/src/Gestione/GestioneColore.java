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
    
    DatiCondivisi dati=new DatiCondivisi();
    String colore;
    
    public GestioneColore(DatiCondivisi dati,String colore) {
        this.colore=colore;
        this.dati=dati;
    }
    
    public String gestioneColore(){
        String messaggio="sc;"+colore;
        
        return messaggio;
    } 
    
}
