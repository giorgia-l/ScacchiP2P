/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import Pezzi.Pezzo;
import Pezzi.Punto;

/**
 *
 * @author Giorgia
 */
public class Moves {
    Scacchiera board;
    Pezzo piece;
    Punto spot;

    public Moves(Scacchiera board, Pezzo piece, Punto spot) {
        this.board = board;
        this.piece = piece;
        this.spot = spot;
    }
    
    
    
}
