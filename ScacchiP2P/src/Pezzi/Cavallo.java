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
public class Cavallo extends Pezzo {

    public Cavallo(String name, boolean white) {
        super(name, white); //richiama la classe Pezzo 
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/cavallo-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/cavallo-n.png");
            piece = ic.getImage();
        }
    }

    @Override
    public boolean canMove(Punto[][] board, int xi, int xf, int yi, int yf) {
        /* il cavallo si muove a L e può "saltare" gli scacchi che si trovano nel percorso 
        prima di arrivare allla cella scelta, controlli: */

        if (Math.abs(yf - yi) == 2 && Math.abs(xf - xi) == 1) {
            return true;
        }

        if (Math.abs(yf - yi) == 1 && Math.abs(xf - xi) == 2) {
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<Moves> getMoves(int x, int y) {

        ArrayList<Moves> m = new ArrayList<>();
        ArrayList<Moves> mp = new ArrayList<>();
        m.clear();
        mp.clear();

        m.add(new Moves(x + 2, y + 1));
        m.add(new Moves(x + 1, y + 2));
        if (y - 1 >= 0) {
            m.add(new Moves(x + 2, y - 1));
            if (x - 2 >= 0) {
                m.add(new Moves(x - 2, y - 1));
                m.add(new Moves(x - 2, y + 1));
            }
        }
        if (y - 2 >= 0) {
            m.add(new Moves(x + 1, y - 2));
            if (x - 1 >= 0) {
                m.add(new Moves(x - 1, y - 2));
            }
        }
        if (x - 1 >= 0) {
            m.add(new Moves(x - 1, y + 2));
        }

        for (Moves mossa : m) {
            if (canMove(Scacchiera.board, x, mossa.x, y, mossa.y) == true);
            mp.add(mossa);
        }
        return mp;
    }

}
