/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pezzi;

/**
 *
 * @author Giorgia
 */
public class Punto {
    Pezzo piece;
    Punto punto;
    int x,y;

    public Punto() {
    }
    
    public Punto(int x, int y, Pezzo piece) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Pezzo getPiece() {
        return piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Punto getCoordinate(){
        return punto; 
    }

    public void setPiece(Pezzo piece) {
        this.piece = piece;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }   
}
