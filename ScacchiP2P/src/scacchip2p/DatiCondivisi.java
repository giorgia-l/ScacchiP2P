/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import GUI.RicevoColoreRegole;
import Gestione.Regole;
import java.util.ArrayList;

/**
 *
 * @author Alber
 */
public class DatiCondivisi {
    
    Player avversario;
    
    Regole regole;
    
    boolean isReady;
    
    public RicevoColoreRegole frame;
    
    ArrayList<String> bufferPosMosseFinali;
    ArrayList<String> bufferPosMosseIniziali;

    public  DatiCondivisi() {
        avversario=new Player();
        isReady=false;
    }

    public Player getPlayer2() {
        return avversario;
    }

    public Regole getRegole() {
        return regole;
    }

    public void setRegole(Regole regole) {
        this.regole = regole;
    }

    public boolean isIsReady() {
        return isReady;
    }

    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }
    
}
