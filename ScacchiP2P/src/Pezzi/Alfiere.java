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

    public Alfiere(boolean white) {
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

        return canMoves(board, xi, xf, yi, yf);
    }

    @Override
    public ArrayList<Moves> getMoves(Punto[][] board, int x, int y) {
        int count = 0;

//        ArrayList<Moves> m = new ArrayList<>();
        ArrayList<Moves> mp = new ArrayList<>();
//        m.clear();
        mp.clear();

        int ix = x + 1;
        int iy = y + 1;

        while (ix < 8 && iy < 8) { //alto a destra
            if (count == 0) {
                if (inBoard(ix, iy) && board[ix][iy] != null) {
                    if (canMoves(board, x, ix, y, iy)) {
                        mp.add(new Moves(ix, iy));
                    }
                    count++;
                } else if (canMoves(board, x, ix, y, iy)) {
                    mp.add(new Moves(ix, iy));
                }
            }
            ix++;
            iy++;
        }
        count = 0;

        ix = x - 1;
        iy = y - 1;

        while (ix > -1 && iy > -1) { //basso a sinistra
            if (count == 0) {
                if (inBoard(ix, iy) && board[ix][iy] != null) {
                    if (canMoves(board, x, ix, y, iy)) {
                        mp.add(new Moves(ix, iy));
                    }
                    count++;
                } else if (canMoves(board, x, ix, y, iy)) {
                    mp.add(new Moves(ix, iy));
                }
            }
            ix--;
            iy--;
        }
        count = 0;

        ix = x - 1;
        iy = y + 1;

        while (ix > -1 && iy < 8) { //alto a sinistra
            if (count == 0) {
                if (inBoard(ix, iy) && board[ix][iy] != null) {
                    if (canMoves(board, x, ix, y, iy)) {
                        mp.add(new Moves(ix, iy));
                    }
                    count++;
                } else if (canMoves(board, x, ix, y, iy)) {
                    mp.add(new Moves(ix, iy));
                }
            }
            ix--;
            iy++;
        }

        count = 0;

        ix = x + 1;
        iy = y - 1;
        while (ix < 8 && iy > -1) { //basso a destra
            if (count == 0) {
                if (inBoard(ix, iy) && board[ix][iy] != null) {
                    if (canMoves(board, x, ix, y, iy)) {
                        mp.add(new Moves(ix, iy));
                    }
                    count++;
                } else if (canMoves(board, x, ix, y, iy)) {
                    mp.add(new Moves(ix, iy));
                }
            }
            ix++;
            iy--;
        }

        count = 0;

//        for (Moves mossa : m) {
//            if (canMove(Scacchiera.board, x, mossa.x, y, mossa.y) == true);
//            mp.add(mossa);
//        }
        return mp;
    }

    @Override
    public ArrayList<Moves> getMoves(int x, int y
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean canMoves(Punto[][] board, int xi, int xf, int yi, int yf) {

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

        return true;
    }

    @Override
    public void setWhite(boolean white) {
        super.setWhite(white); //To change body of generated methods, choose Tools | Templates.
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/alfiere-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/alfiere-n.png");
            piece = ic.getImage();
        }
    }

}
