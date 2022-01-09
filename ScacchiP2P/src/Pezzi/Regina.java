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
    public ArrayList<Moves> getMoves(Punto[][] board, int x, int y) {
        // la Regina si muove in diagonale come l'Alfiere e in riga o colonna come la Torre
        
        ArrayList<Moves> ma = new Alfiere().getMoves(board, x, y);
        ArrayList<Moves> mt =  new Torre().getMoves(board, x, y);        
        ArrayList<Moves> mosse = new ArrayList<>();
        
        ma.clear();
        mt.clear();
        mosse .clear();
        
        mosse.addAll(ma);
        mosse.addAll(mt);
        
        return mosse;        
    }

    @Override
    public ArrayList<Moves> getMoves(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
