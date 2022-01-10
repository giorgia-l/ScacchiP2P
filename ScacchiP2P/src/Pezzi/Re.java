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
public class Re extends Pezzo {

    boolean arroccoFatto;

    public Re() {
        arroccoFatto = false;
    }

    public Re(String name, boolean white) {
        super(name, white); //richiama la classe Pezzo 
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/re-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/re-n.png");
            piece = ic.getImage();
        }
    }

    public boolean isArroccoFatto() {
        return arroccoFatto;
    }

    public void setArroccoFatto(boolean arroccoFatto) {
        this.arroccoFatto = arroccoFatto;
    }

    @Override
    public boolean canMove(Punto[][] board, int xi, int xf, int yi, int yf) {

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

        if (inBoard(xf, yf) && isWhite() && (Scacchiera.board[xf][yf] == null || Scacchiera.board[xf][yf].getPiece().isWhite() == false)) {
            if (Math.abs(yf - yi) > 1 || Math.abs(xf - xi) > 1) {
//                if (yi != 0 || yi != 7) {
                    return false;
//                }
            }
        } else if (inBoard(xf, yf) && !isWhite() && (Scacchiera.board[xf][yf] == null || Scacchiera.board[xf][yf].getPiece().isWhite())){
            if (Math.abs(yf - yi) > 1 || Math.abs(xf - xi) > 1) {
//                if (yi != 0 || yi != 7) {
                    return false;
//                }
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

        if (y - 1 >= 0 && x - 1 >= 0) {
            m.add(new Moves(x - 1, y - 1));
        }
        if (y - 1 >= 0 && x + 1 < 8) {
            m.add(new Moves(x + 1, y - 1));
        }
        if (y + 1 < 8 && x + 1 < 8) {
            m.add(new Moves(x + 1, y + 1));
        }
        if (y + 1 < 8 && x - 1 >= 0) {
            m.add(new Moves(x - 1, y + 1));
        }
        if (y - 1 >= 0) {
            m.add(new Moves(x, y - 1));
        }
        if (y + 1 < 8) {
            m.add(new Moves(x, y + 1));
        }
        if (x + 1 < 8) {
            m.add(new Moves(x + 1, y));
        }
        if (x - 1 >= 0) {
            m.add(new Moves(x - 1, y));
        }

        for (Moves mossa : m) {
            if (canMove(Scacchiera.board, x, mossa.x, y, mossa.y) == true) {
                mp.add(mossa);
            }
        }
        return mp;
    }

    @Override
    public ArrayList<Moves> getMoves(Punto[][] puntos, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
