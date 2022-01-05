/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pezzi;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import scacchip2p.Board;
import scacchip2p.Moves;

/**
 *
 * @author Giorgia
 */
public class Pedone extends Pezzo {

    public Pedone(boolean white) {
        super(white); //richiama la classe Pezzo 
        if (isWhite() == true) {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/pedone-b.png");
            piece = ic.getImage();
        } else {
            ImageIcon ic = new ImageIcon("src/Pezzi/assets/pedone-n.png");
            piece = ic.getImage();
        }
    }

    @Override
    public boolean canMove(Board board, Punto start, Punto end) {
        if (end.getPiece().isWhite() == this.isWhite()) { //controllo che non ci sia un pezzo dello stesso colore nella cella 
            return false;
        }
        
        return true;
    }

    @Override
    public ArrayList<Moves> getMoves() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
