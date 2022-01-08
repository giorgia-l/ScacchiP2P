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

    @Override
    public boolean canMove(Punto[][] board, int xi, int xf, int yi, int yf) {

        if (isWhite()) {
            if (yi > yf) {
                return false;
            }
        } else {
            if (yf > yi) {
                return false;
            }
        }

        if (xi == xf) {
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
                    return true;
                }

                if (isWhite()) {
                    if (Scacchiera.board[xi][yi + 2] != null) {
                        return false;
                    }
                } else {
                    if (Scacchiera.board[xi][yi - 2] != null) {
                        return false;
                    }
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

        if (!this.isWhite()) {
            if (y < 7) {
                m.add(new Moves(x, y + 1));
            }
            if (y == 0) {
                m.add(new Moves(x, y + 2));
            }
        } else {
            if (y > 0) {
                m.add(new Moves(x, y - 1));
            }
            if (y == 7) {
                m.add(new Moves(x, y - 2));
            }
        }

        for (Moves mossa : m) {
            if (canMove(Scacchiera.board, x, y, mossa.x, mossa.y) == true);
            mp.add(mossa);
        }
        return mp;
    }
}
