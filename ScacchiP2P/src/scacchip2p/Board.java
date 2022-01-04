/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import Pezzi.Alfiere;
import Pezzi.Cavallo;
import Pezzi.Pedone;
import Pezzi.Punto;
import Pezzi.Re;
import Pezzi.Regina;
import Pezzi.Torre;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giorgia
 */
public class Board {

    Punto[][] celle;

    public Board() {
        this.creaBoard();
    }

    public Punto controlloMossa(int x, int y) {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            try {
                throw new Exception("mossa non disponibile!");
            } catch (Exception ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return celle[x][y];
    }

    public void creaBoard() {
        //inizializzazione pezzi bianchi sulla scacchiera
        celle[0][0] = new Punto(0, 0, new Torre(true));
        celle[0][1] = new Punto(0, 1, new Cavallo(true));
        celle[0][2] = new Punto(0, 2, new Alfiere(true));
        celle[0][3] = new Punto(0, 3, new Regina(true));
        celle[0][4] = new Punto(0, 4, new Re(true));
        celle[0][5] = new Punto(0, 5, new Alfiere(true));
        celle[0][6] = new Punto(0, 6, new Cavallo(true));
        celle[0][7] = new Punto(0, 7, new Torre(true));

        celle[1][0] = new Punto(1, 0, new Pedone(true));
        celle[1][1] = new Punto(1, 1, new Pedone(true));
        celle[1][2] = new Punto(1, 2, new Pedone(true));
        celle[1][3] = new Punto(1, 3, new Pedone(true));
        celle[1][4] = new Punto(1, 4, new Pedone(true));
        celle[1][5] = new Punto(1, 5, new Pedone(true));
        celle[1][6] = new Punto(1, 6, new Pedone(true));
        celle[1][7] = new Punto(1, 7, new Pedone(true));

        //inizializzazione pezzi neri sulla scacchiera
        celle[7][0] = new Punto(7, 0, new Torre(false));
        celle[7][1] = new Punto(7, 1, new Cavallo(false));
        celle[7][2] = new Punto(7, 2, new Alfiere(false));
        celle[7][3] = new Punto(7, 3, new Regina(false));
        celle[7][4] = new Punto(7, 4, new Re(false));
        celle[7][5] = new Punto(7, 5, new Alfiere(false));
        celle[7][6] = new Punto(7, 6, new Cavallo(false));
        celle[7][7] = new Punto(7, 7, new Torre(false));

        celle[6][0] = new Punto(6, 0, new Pedone(false));
        celle[6][1] = new Punto(6, 1, new Pedone(false));
        celle[6][2] = new Punto(6, 2, new Pedone(false));
        celle[6][3] = new Punto(6, 3, new Pedone(false));
        celle[6][4] = new Punto(6, 4, new Pedone(false));
        celle[6][5] = new Punto(6, 5, new Pedone(false));
        celle[6][6] = new Punto(6, 6, new Pedone(false));
        celle[6][7] = new Punto(6, 7, new Pedone(false));

        //inizializzazione scacchiera senza pezzi
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                celle[i][j] = new Punto(i, j, null);
            }
        }
    }
}
