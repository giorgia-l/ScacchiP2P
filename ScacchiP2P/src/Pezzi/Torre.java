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
        
        if (Scacchiera.board[xf][yf] != null) {
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

            if (isWhite()) {
                if (Scacchiera.board[xf][yf].getPiece().isWhite() == false) {
                    Scacchiera.board[xf][yf].getPiece().killed = true;
                }
            }
            if (!isWhite()) {
                if (Scacchiera.board[xf][yf].getPiece().isWhite()) {
                    Scacchiera.board[xf][yf].getPiece().killed = true;
                }
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
                if (board[xi][x] != null) {
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
                if (board[x][yi] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public ArrayList<Moves> getMoves(Punto[][] board, int x, int y) {

        int count = 0;

//        ArrayList<Moves> m = new ArrayList<>();
        ArrayList<Moves> mp = new ArrayList<>();
//        m.clear();
        mp.clear();

        for (int i = x + 1; i < 8; i++) { //mi muovo a destra ORIZZONTALE
            if (count == 0) {
                if (board[i][y] != null) { //posizione non vuota
                    if (canMove(board, x, i, y, y) == true) {
                        mp.add(new Moves(i, y));
                    }
                    count++;
                } else if (canMove(board, x, i, y, y) == true) {
                    mp.add(new Moves(i, y));
                }
            }
        }
        count = 0;

        for (int i = x - 1; i >= 0; i--) { //mi muovo a sinistra ORIZZONTALE
            if (count == 0) {
                if (board[i][y] != null) {
                    if (canMove(board, x, i, y, y) == true) {
                        mp.add(new Moves(i, y));
                    }
                    count++;
                } else if (canMove(board, x, i, y, y) == true) {
                    mp.add(new Moves(i, y));
                }
            }
        }
        count = 0;

        for (int i = y + 1; i < 8; i++) { //mi muovo in avanti VERTICALE
            if (count == 0) {
                if (board[x][i] != null) {
                    if (canMove(board, x, x, y, i) == true) {
                        mp.add(new Moves(x, i));
                    }
                    count++;
                } else if (canMove(board, x, x, y, i) == true) {
                    mp.add(new Moves(x, i));
                }
            }
        }
        count = 0;

        for (int i = y - 1; i >= 0; i--) { //im muovo indietro VERTICALE
            if (count == 0) {
                if (board[x][i] != null) {
                    if (canMove(board, x, x, y, i) == true) {
                        mp.add(new Moves(x, i));
                    }
                    count++;
                } else if (canMove(board, x, x, y, i) == true) {
                    mp.add(new Moves(x, i));
                }
            }
        }
        count = 0;

//        for (Moves mossa : m) {
//            if (canMove(Scacchiera.board, x, mossa.x, y, mossa.y) == true);
//            mp.add(mossa);
//        }
        return mp;
    }

    @Override
    public ArrayList<Moves> getMoves(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
