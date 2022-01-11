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

    public Alfiere (boolean white) {
        super(white); //richiama la classe Pezzo 
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/alfiere-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/alfiere-n.png");
            piece = ic.getImage();
        }
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

        if (inBoard(xf, yf) && Scacchiera.board[xf][yf] != null) {
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
    public ArrayList<Moves> getMoves(Punto[][] board, int x, int y) {
        int count = 0;

//        ArrayList<Moves> m = new ArrayList<>();
        ArrayList<Moves> mp = new ArrayList<>();
//        m.clear();
        mp.clear();

        int ix = 0;
        int iy = 0;

        while (ix < 8 && iy < 8) { //alto a destra
            ix++;
            iy++;
            if (count == 0) {
                if (board[ix][iy] != null) {
                    if (canMove(board, x, ix, y, iy)) {
                        if (count == 0) {
                            mp.add(new Moves(ix, iy));
                            count++;
                        }
                    } else {
                        count++;
                    }
                } else if (canMove(board, x, ix, y, iy)) {
                    mp.add(new Moves(ix, iy));
                }
            }
        }
        count = 0;

        while (ix > -1 && iy > -1) { //basso a sinistra
            ix--;
            iy--;
            if (count == 0) {
                if (board[ix][iy] != null) {
                    if (canMove(board, x, ix, y, iy)) {
                        if (count == 0) {
                            mp.add(new Moves(ix, iy));
                            count++;
                        }
                    } else {
                        count++;
                    }
                } else if (canMove(board, x, ix, y, iy)) {
                    mp.add(new Moves(ix, iy));
                }
            }
        }
        count = 0;

        while (ix > -1 && iy < 8) { //alto a sinistra
            ix--;
            iy++;
            if (count == 0) {
                if (board[ix][iy] != null) {
                    if (canMove(board, x, ix, y, iy)) {
                        if (count == 0) {
                            mp.add(new Moves(ix, iy));
                            count++;
                        }
                    } else {
                        count++;
                    }
                } else if (canMove(board, x, ix, y, iy)) {
                    mp.add(new Moves(ix, iy));
                }
            }
        }
        count = 0;

        while (ix < 8 && iy > -1) { //basso a destra
            ix++;
            iy--;
            if (count == 0) {
                if (board[ix][iy] != null) {
                    if (canMove(board, x, ix, y, iy)) {
                        if (count == 0) {
                            mp.add(new Moves(ix, iy));
                            count++;
                        }
                    } else {
                        count++;
                    }
                } else if (canMove(board, x, ix, y, iy)) {
                    mp.add(new Moves(ix, iy));
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
