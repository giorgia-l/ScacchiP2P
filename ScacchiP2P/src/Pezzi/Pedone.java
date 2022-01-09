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
import static scacchip2p.Scacchiera.board;

/**
 *
 * @author Giorgia
 */
public class Pedone extends Pezzo {

    public Pedone(String name, boolean white) {
        super(name, white); //richiama la classe Pezzo 
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/pedone-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/pedone-n.png");
            piece = ic.getImage();
        }
    }

    public boolean kills(Punto[][] board, int xi, int xf, int yi, int yf) {
        if (isWhite() && inBoard(xf, yf) && Scacchiera.board[xf][yf] != null
                && (Scacchiera.board[xf][yf] == Scacchiera.board[xi + 1][yi + 1]
                || Scacchiera.board[xf][yf] == Scacchiera.board[xi - 1][yi + 1])
                && Scacchiera.board[xf][yf].getPiece().isWhite() == false) { // mangia in diagonale, pedoni in alto
            Scacchiera.board[xf][yf].getPiece().killed = true;
            return true;
        }

        if (!isWhite() && inBoard(xf, yf) && Scacchiera.board[xf][yf] != null
                && (Scacchiera.board[xf][yf] == Scacchiera.board[xi - 1][yi - 1]
                || Scacchiera.board[xf][yf] == Scacchiera.board[xi + 1][yi - 1])
                && Scacchiera.board[xf][yf].getPiece().isWhite()) { // pedoni in basso, mangia in diagonale
            Scacchiera.board[xf][yf].getPiece().killed = true;
            return true;
        }

        return false;
    }

    public ArrayList<Moves> getMovesKills(int x, int y) {
        ArrayList<Moves> m = new ArrayList<>();
        ArrayList<Moves> mk = new ArrayList<>();
        m.clear();
        mk.clear();

        if (this.isWhite()) {
            m.add(new Moves(x + 1, y + 1));
            m.add(new Moves(x - 1, y + 1));
            if (y == 1) {
                m.add(new Moves(x, y + 2));
            }
        } else {
            m.add(new Moves(x + 1, y + 1));
            m.add(new Moves(x + 1, y - 1));
            if (y == 6) {
                m.add(new Moves(x, y - 2));
            }
        }

        for (Moves mossa : m) {
            if (kills(Scacchiera.board, x, mossa.x, y, mossa.y) == true);
            mk.add(mossa);
        }
        return mk;
    }

    @Override
    public boolean canMove(Punto[][] board, int xi, int xf, int yi, int yf) {

        if (isWhite() && inBoard(xf, yf)) {
            if (yi > yf) {
                return false;
            }
        } else if (!isWhite() && inBoard(xf, yf)) {
            if (yf > yi) {
                return false;
            }
        }

        if (Scacchiera.board[xf][yf] != null && inBoard(xf, yf)) {
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
        }

        if (xi == xf && inBoard(xf, yf)) {
            if (isWhite()) {
                if (Scacchiera.board[xi][yi + 1] != null) {
                    return false;
                }
            } else {
                if (Scacchiera.board[xi][yi - 1] != null) {
                    return false;
                }
            }

            if (Math.abs(yf - yi) > 2) {
                return false;
            } else if (Math.abs(yf - yi) == 2) {
                if (yi == 1 || yi == 6) { //I pedoni alla prima mossa possono procedere anche di due
                    if (isWhite()) {
                        if (Scacchiera.board[xi][yi + 2] != null) {
                            return false;
                        }
                    } else {
                        if (Scacchiera.board[xi][yi - 2] != null) {
                            return false;
                        }
                    }

                    return true;
                }

            } else {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Moves> Mosse(int x, int y) {
        ArrayList<Moves> m = new ArrayList<>();
        ArrayList<Moves> mp = new ArrayList<>();
        m.clear();
        mp.clear();

        if (this.isWhite()) {
            m.add(new Moves(x, y + 1));
//            m.add(new Moves(x + 1, y + 1));
//            m.add(new Moves(x - 1, y + 1));
            if (y == 1) {
                m.add(new Moves(x, y + 2));
            }
        } else {
            m.add(new Moves(x, y - 1));
//            m.add(new Moves(x + 1, y + 1));
//            m.add(new Moves(x + 1, y - 1));
            if (y == 6) {
                m.add(new Moves(x, y - 2));
            }
        }

        for (Moves mossa : m) {
            if (canMove(Scacchiera.board, x, mossa.x, y, mossa.y) == true);
            mp.add(mossa);
        }
        return mp;
    }

    @Override
    public ArrayList<Moves> getMoves(int x, int y) {
        ArrayList<Moves> m = getMoves(x, y);
        ArrayList<Moves> mk = getMovesKills(x, y);
        ArrayList<Moves> mosse = new ArrayList<>();

        m.clear();
        mk.clear();
        mosse.clear();

        mosse.addAll(m);
        mosse.addAll(mk);

        return mosse;
    }

    @Override
    public ArrayList<Moves> getMoves(Punto[][] puntos, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
