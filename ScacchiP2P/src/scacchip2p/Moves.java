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
    //Scacchiera board;

    //Board board;
    Pezzo piece;
    Punto start;
    Punto end;
    Pezzo capturedPiece = null;
    Punto coordinateC = null;

    public Moves(Punto start, Punto end, Pezzo piece) {
        this.start = start;
        this.end = end;
        this.piece = piece;
    }

//    public Moves(Scacchiera board, Pezzo piece, Punto spot) {
//        this.board = board;
//    }

    public Moves(Punto start, Punto end, Pezzo piece, Punto captureSquare) {
        this.start = start;
        this.end = end;
        this.piece = piece;
        if (captureSquare != null) {
            this.capturedPiece = captureSquare.getPiece();
            this.coordinateC = captureSquare.getCoordinate();
        }
    }

    public Punto getStart() {
        return start;
    }

    public Punto getEnd() {
        return end;
    }

    public Pezzo getPiece() {
        return piece;
    }

    public Pezzo getCapturedPiece() {
        return capturedPiece;
    }

    public boolean isCapture() {
        if (capturedPiece == null) {
            return false;
        }
        return true;
    }

    public Punto getCoordinateC() {
        return coordinateC;
    }
}
