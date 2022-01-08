/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pezzi;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import scacchip2p.Scacchiera;
import scacchip2p.Moves;

/**
 *
 * @author Giorgia
 */
public class Alfiere extends Pezzo {

    public Alfiere() {
    }

    public Alfiere(String name, boolean white) {
        super(name, white); //richiama la classe Pezzo 
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/alfiere-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/alfiere-n.png");
            piece = ic.getImage();
        }
    }

    @Override
    public boolean canMove(Punto[][] board, int xi, int xf, int yi, int yf) {
        
        if (yi == yf || xi == xf) {//L'alfiere si muove solo in diagonale
            return false;
        }

        if (Math.abs(yf - yi) != Math.abs(xf - xi)) {
            return false;
        }

        int riga, colonna;

        if (yi < yf) {
            riga = 1;
        } else {
            riga = -1;
        }

        if (xi < xf) {
            colonna = 1;
        } else {
            colonna = -1;
        }

        int y = xi + colonna;
        for (int x = yi + riga; x != yf; x += riga) {

            if (Scacchiera.board[x][y] != null) {
                return false;
            }

            y += colonna;
        }
        return true;
    }

    @Override
    public ArrayList<Moves> getMoves(int x, int y) {
        
        ArrayList<Moves> m = new ArrayList<>();
        ArrayList<Moves> mp = new ArrayList<>();
        m.clear();
        /*
        controlli per aggiungere le mosse alla lista delle mosse possibili
        */

        for (Moves mossa : m) {
            if (canMove(Scacchiera.board, x, y, mossa.x, mossa.y) == true);
            mp.add(mossa);
        }
        return mp;
    }

}
