/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pezzi;

import java.awt.Image;
import java.util.ArrayList;
import scacchip2p.Board;
import scacchip2p.Moves;

/**
 *
 * @author Giorgia
 */
public abstract class Pezzo {

    Image piece;
    boolean killed;
    boolean white;

    public Pezzo() {
        killed = false;
        white = false;
    }

    public Pezzo(boolean white) {
        this.setWhite(white);
    }

    public boolean isWhite() {
        return this.white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public Image getPiece() {
        return piece;
    }

    public abstract boolean canMove(Board board, Punto start, Punto end);
    
    public abstract ArrayList<Moves> getMoves(Board board, Punto start, Punto end);
}
