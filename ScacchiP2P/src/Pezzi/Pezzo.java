/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pezzi;

import java.util.ArrayList;

/**
 *
 * @author Giorgia
 */
public class Pezzo {
    int x, y;
    boolean vuoto;   
    
    public Pezzo(int x, int y, boolean vuoto) {
        this.x=x;
        this.y=y;
        this.vuoto = vuoto;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }    
}
