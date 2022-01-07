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
import Pezzi.Vuoto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Giorgia
 */
public class Scacchiera extends JPanel implements MouseListener, MouseMotionListener {

    static Punto board[][] = new Punto[8][8];

    static Punto pezzoSelezionato = null;

    static Point puntoSelezionato = null;

    int dimensioneCella = 84;

    public Scacchiera() {
//        drawBoard(gp);
        initBoard();

    }

    public void initBoard() {
        addMouseListener(this);
        addMouseMotionListener(this);
        creaBoard();
        setFocusable(true);

        setBackground(Color.red);
        //dimensione finestra
        setSize((dimensioneCella * 8), (dimensioneCella * 8));

        initGame();
    }

    public void initGame() {

    }

    public Punto controlloMossa(int x, int y) {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            try {
                throw new Exception("mossa non disponibile!");
            } catch (Exception ex) {
                Logger.getLogger(Scacchiera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return board[x][y];
    }

    public void creaBoard() {
        //inizializzazione pezzi bianchi sulla scacchiera

        board[0][0] = new Punto(0, 0, new Torre("R", false));
        board[1][0] = new Punto(1, 0, new Cavallo("N", false));
        board[2][0] = new Punto(2, 0, new Alfiere("B", false));
        board[3][0] = new Punto(3, 0, new Regina("Q", false));
        board[4][0] = new Punto(4, 0, new Re("K", false));
        board[5][0] = new Punto(5, 0, new Alfiere("B", false));
        board[6][0] = new Punto(6, 0, new Cavallo("N", false));
        board[7][0] = new Punto(7, 0, new Torre("R", false));

        board[0][1] = new Punto(0, 1, new Pedone("P", false));
        board[1][1] = new Punto(1, 1, new Pedone("P", false));
        board[2][1] = new Punto(2, 1, new Pedone("P", false));
        board[3][1] = new Punto(3, 1, new Pedone("P", false));
        board[4][1] = new Punto(4, 1, new Pedone("P", false));
        board[5][1] = new Punto(5, 1, new Pedone("P", false));
        board[6][1] = new Punto(6, 1, new Pedone("P", false));
        board[7][1] = new Punto(7, 1, new Pedone("P", false));

        //inizializzazione pezzi neri sulla scacchiera
        board[0][7] = new Punto(0, 7, new Torre("R", false));
        board[1][7] = new Punto(1, 7, new Cavallo("N", false));
        board[2][7] = new Punto(2, 7, new Alfiere("B", false));
        board[3][7] = new Punto(3, 7, new Regina("Q", false));
        board[4][7] = new Punto(4, 7, new Re("K", false));
        board[5][7] = new Punto(5, 7, new Alfiere("B", false));
        board[6][7] = new Punto(6, 7, new Cavallo("N", false));
        board[7][7] = new Punto(7, 7, new Torre("R", false));

        board[0][6] = new Punto(0, 6, new Pedone("P", false));
        board[1][6] = new Punto(1, 6, new Pedone("P", false));
        board[2][6] = new Punto(2, 6, new Pedone("P", false));
        board[3][6] = new Punto(3, 6, new Pedone("P", false));
        board[4][6] = new Punto(4, 6, new Pedone("P", false));
        board[5][6] = new Punto(5, 6, new Pedone("P", false));
        board[6][6] = new Punto(6, 6, new Pedone("P", false));
        board[7][6] = new Punto(7, 6, new Pedone("P", false));

        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                board[i][j] = new Punto(i, j, new Vuoto());
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
//        creaBoard();
        drawBoard(g);
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); //To change body of generated methods, choose Tools | Templates.

        Graphics2D g2 = (Graphics2D) g;

        drawBoard(g2);
        drawPezzi(g2);

    }

    public void drawBoard(Graphics g) {
        g.fillRect(dimensioneCella - 1, dimensioneCella - 1, dimensioneCella * 8 + 2, dimensioneCella * 8 + 2);
        boolean white = true;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (white) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.gray);
                }
                g.fillRect(x * dimensioneCella, y * dimensioneCella, dimensioneCella, dimensioneCella);
                white = !white;
            }
            white = !white;
        }

    }

    public void drawPezzi(Graphics2D g) {

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                g.drawImage(board[x][y].getPiece().getPiece(), x * dimensioneCella, y * dimensioneCella, null);
            }
        }

        if (pezzoSelezionato != null && puntoSelezionato!=null) {
            g.drawImage(pezzoSelezionato.getPiece().getPiece(), puntoSelezionato.x-dimensioneCella/2,puntoSelezionato.y-dimensioneCella/2,dimensioneCella,dimensioneCella,null);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println(getPezzo(e.getX(), e.getY()).getPiece().getName());
        pezzoSelezionato = getPezzo(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static Punto getPezzo(int x, int y) {
        int xp = x / 84;
        int yp = y / 84;
        for (int yfor = 0; yfor < 8; yfor++) {
            for (int xfor = 0; xfor < 8; xfor++) {
                if (board[xfor][yfor].getX() == xp && board[xfor][yfor].getY() == yp) {
                    return board[xfor][yfor];
                }
            }
        }
        return null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //        System.out.println(e.getX() + e.getY());
        puntoSelezionato = e.getPoint();
//        if (pezzoSelezionato != null) {
//            pezzoSelezionato.setX(e.getX());
//            pezzoSelezionato.setY(e.getY());
        repaint();
//            g.drawImage(pezzoSelezionato.getPiece().getPiece(), pezzoSelezionato.getX() * dimensioneCella, pezzoSelezionato.getY() * dimensioneCella, null);

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
