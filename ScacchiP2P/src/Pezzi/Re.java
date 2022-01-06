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

    public Re(String name,boolean white) {
        super(name,white); //richiama la classe Pezzo 
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
    public boolean canMove(Scacchiera board, Punto start, Punto end) {
        // we can't move the piece to a Spot that 
        // has a piece of the same color
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1) {
            // check if this move will not result in the king
            // being attacked if so return true
            return true;
        }

        return this.arroccoValido(board, start, end);
    }

    private boolean arroccoValido(Scacchiera board, Punto start, Punto end) {

        if (this.isArroccoFatto()) {
            return false;
        }

        // Logic for returning true or false
        return false;
    }

    public boolean isCastlingMove(Punto start, Punto end) {
        // check if the starting and 
        // ending position are correct
        return false;
    }

    @Override
    public ArrayList<Moves> getMoves(Board board, Punto punto, Punto punto1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
