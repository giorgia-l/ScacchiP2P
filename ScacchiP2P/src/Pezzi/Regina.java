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
public class Regina extends Pezzo {
    
    

    public Regina(String name, boolean white) {
        super(name, white); //richiama la classe Pezzo 
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/regina-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/regina-n.png");
            piece = ic.getImage();
        }
    }

    @Override
    public boolean canMove(Punto[][] board, int xi, int xf, int yi, int yf) {
        // la Regina si muove in diagonale come l'Alfiere e in riga o colonna come la Torre
        return new Torre().canMove(board, yi, xi, yf, xf) || 
               new Alfiere().canMove(board, yi, xi, yf, xf);
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
