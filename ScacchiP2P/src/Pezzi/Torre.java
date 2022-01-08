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
public class Torre extends Pezzo {

    boolean arroccoFatto = false;

    public Torre() {
    }

    public Torre(String name, boolean white) {
        super(name, white); //richiama la classe Pezzo 
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/torre-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/torre-n.png");
            piece = ic.getImage();
        }
    }

    @Override
    public boolean canMove(Punto[][] board, int xi, int xf, int yi, int yf) {

        if (yi != yf && xi != xf) { //la torre si muove solo in riga o in colonna
            return false;
        }

        if (isWhite()) {
            if (Scacchiera.board[xf][yf].getPiece().isWhite()) {
                return false;
            }
        }

        if (!isWhite()) {
            if (Scacchiera.board[xf][yf].getPiece().isWhite() == false) {
                return false;
            }
        }

        // controllo le mosse considerando che si sta muovendo in verticale rispetto la board
        int diff;

        if (yi != yf) {
            if (yi < yf) {
                diff = 1;
            } else {
                diff = -1;
            }

            for (int x = yi + diff; x != yf; x += diff) { //si muove in verticale e controllo gli spazi
                if (board[x][xi] != null) {
                    return false;
                }
            }
        }

        // controllo le mosse considerando che si sta muovendo in orizzontale rispetto la board
        if (xi != xf) {
            if (xi < xf) {
                diff = 1;
            } else {
                diff = -1;
            }

            for (int x = xi + diff; x != xf; x += diff) { // si muove in orizzontale e controllo gli spazi
                if (board[yi][x] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public ArrayList<Moves> getMoves(int x, int y) {

        ArrayList<Moves> m = new ArrayList<>();
        ArrayList<Moves> mp = new ArrayList<>();
        m.clear();
        mp.clear();

        /*
        controlli per aggiungere le mosse alla lista delle mosse possibili
         */
        for (Moves mossa : m) {
            if (canMove(Scacchiera.board, x, mossa.x, y, mossa.y) == true);
            mp.add(mossa);
        }
        return mp;
    }

}
