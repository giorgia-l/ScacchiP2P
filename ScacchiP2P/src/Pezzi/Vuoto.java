/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pezzi;

import java.util.ArrayList;
import scacchip2p.Scacchiera;
import scacchip2p.Moves;

/**
 *
 * @author Alber
 */
public class Vuoto extends Pezzo{

    public Vuoto() {
        super("");
    }

    @Override
    public boolean canMove(Scacchiera board, Punto start, Punto end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Moves> getMoves() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
