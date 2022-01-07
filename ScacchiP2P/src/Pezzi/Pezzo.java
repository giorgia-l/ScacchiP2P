/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pezzi;

import java.awt.Image;
import java.util.ArrayList;
import scacchip2p.Scacchiera;
import scacchip2p.Moves;

/**
 *
 * @author Giorgia
 */
public abstract class Pezzo {

    String name;
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

    public Pezzo(String name,boolean white) {
        this.setWhite(white);
        this.setName(name);
    }
    public Pezzo(String name){
        this.setName(name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean canMove(Punto[][] board, int xi, int xf, int yi, int yf); //se si può spostare

    public abstract ArrayList<Moves> getMoves(int x, int y); //le mosse che può fare

}
