/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import Gestione.GestioneGioco;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Giorgia
 */
public class Scacchiera extends JPanel implements MouseListener, MouseMotionListener {

    public static Punto board[][] = new Punto[8][8];

    static Punto pezzoSelezionato = null;

    static Point puntoSelezionato = null;

    int fromCol = -1;
    int fromRow = -1;

    int dimensioneCella = 84;

//    DatiCondivisi dati;
    Peer play1;

    ArrayList<String> alfabeto = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f"));
    ArrayList<Integer> numero = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

    Gestione.GestioneGioco gestioneGioco;
//    private int[] numeri = {1, 2, 3, 4, 5, 6, 7, 8};

    public Scacchiera(Peer play1) {
        this.play1 = play1;
        gestioneGioco = new GestioneGioco(play1);
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
        if (!play1.server.isAlive()) {
            play1.client.send(gestioneGioco.creaMessaggioStartGioco()); //invio messagggio di inizio gioco
            play1.dati.setIsReady(true);
            
            play1.avviaServer();
            play1.avviaElabora();
            
        }

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

    public void muoviPezzi(int fromCol, int fromRow, int toCol, int toRow) {

//        Punto pezzoPuntoIniziale=new Punto(fromCol, fromRow, pezzoSelezionato.getPiece());
//        Punto pezzoPuntoFinale=new Punto(toCol, toRow, pezzoSelezionato.getPiece());
        //controllo se la mossa può essere effettuata
        if (pezzoSelezionato.getPiece().canMove(board, fromCol, toCol, fromRow, toRow)) {
            board[toCol][toRow] = pezzoSelezionato; //muovo il pezzo
            board[fromCol][fromRow] = null;//metto il pezzo vuoto

            //invio la mossa
            String messaggioDaInviare = gestioneGioco.creoMessaggioMossa(convertiMossaInLettere(fromCol, fromRow), convertiMossaInLettere(toCol, toRow), pezzoSelezionato.getPiece().getName(), false);
            play1.client.send(messaggioDaInviare);

            //cambio il turno
        }

    }

    public void creaBoard() {
        //inizializzazione pezzi Avversario sulla scacchiera

        board[0][0] = new Punto(0, 0, new Torre("R", play1.dati.avversario.isWhite()));
        board[1][0] = new Punto(1, 0, new Cavallo("N", play1.dati.avversario.isWhite()));
        board[2][0] = new Punto(2, 0, new Alfiere("B", play1.dati.avversario.isWhite()));
        board[3][0] = new Punto(3, 0, new Regina("Q", play1.dati.avversario.isWhite()));
        board[4][0] = new Punto(4, 0, new Re("K", play1.dati.avversario.isWhite()));
        board[5][0] = new Punto(5, 0, new Alfiere("B", play1.dati.avversario.isWhite()));
        board[6][0] = new Punto(6, 0, new Cavallo("N", play1.dati.avversario.isWhite()));
        board[7][0] = new Punto(7, 0, new Torre("R", play1.dati.avversario.isWhite()));

        board[0][1] = new Punto(0, 1, new Pedone("P", play1.dati.avversario.isWhite()));
        board[1][1] = new Punto(1, 1, new Pedone("P", play1.dati.avversario.isWhite()));
        board[2][1] = new Punto(2, 1, new Pedone("P", play1.dati.avversario.isWhite()));
        board[3][1] = new Punto(3, 1, new Pedone("P", play1.dati.avversario.isWhite()));
        board[4][1] = new Punto(4, 1, new Pedone("P", play1.dati.avversario.isWhite()));
        board[5][1] = new Punto(5, 1, new Pedone("P", play1.dati.avversario.isWhite()));
        board[6][1] = new Punto(6, 1, new Pedone("P", play1.dati.avversario.isWhite()));
        board[7][1] = new Punto(7, 1, new Pedone("P", play1.dati.avversario.isWhite()));

        //inizializzazione pezzi Giocatore sulla scacchiera
        board[0][7] = new Punto(0, 7, new Torre("R", play1.giocatore.isWhite()));
        board[1][7] = new Punto(1, 7, new Cavallo("N", play1.giocatore.isWhite()));
        board[2][7] = new Punto(2, 7, new Alfiere("B", play1.giocatore.isWhite()));
        board[3][7] = new Punto(3, 7, new Regina("Q", play1.giocatore.isWhite()));
        board[4][7] = new Punto(4, 7, new Re("K", play1.giocatore.isWhite()));
        board[5][7] = new Punto(5, 7, new Alfiere("B", play1.giocatore.isWhite()));
        board[6][7] = new Punto(6, 7, new Cavallo("N", play1.giocatore.isWhite()));
        board[7][7] = new Punto(7, 7, new Torre("R", play1.giocatore.isWhite()));

        board[0][6] = new Punto(0, 6, new Pedone("P", play1.giocatore.isWhite()));
        board[1][6] = new Punto(1, 6, new Pedone("P", play1.giocatore.isWhite()));
        board[2][6] = new Punto(2, 6, new Pedone("P", play1.giocatore.isWhite()));
        board[3][6] = new Punto(3, 6, new Pedone("P", play1.giocatore.isWhite()));
        board[4][6] = new Punto(4, 6, new Pedone("P", play1.giocatore.isWhite()));
        board[5][6] = new Punto(5, 6, new Pedone("P", play1.giocatore.isWhite()));
        board[6][6] = new Punto(6, 6, new Pedone("P", play1.giocatore.isWhite()));
        board[7][6] = new Punto(7, 6, new Pedone("P", play1.giocatore.isWhite()));

        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                board[i][j] = null;
            }
        }

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
                if (board[x][y] != null) {
                    g.drawImage(board[x][y].getPiece().getPiece(), x * dimensioneCella, y * dimensioneCella, null);
                }
            }
        }

        if (pezzoSelezionato != null && puntoSelezionato != null) {
            g.drawImage(pezzoSelezionato.getPiece().getPiece(), puntoSelezionato.x - dimensioneCella / 2, puntoSelezionato.y - dimensioneCella / 2, dimensioneCella, dimensioneCella, null);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println(getPezzo(e.getX(), e.getY()).getPiece().getName());
        fromCol = (e.getPoint().x) / dimensioneCella;
        fromRow = (e.getPoint().y) / dimensioneCella;
        pezzoSelezionato = getPezzo(fromCol, fromRow);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = (e.getPoint().x) / dimensioneCella;
        int row = (e.getPoint().y) / dimensioneCella;

        muoviPezzi(fromCol, fromRow, col, row);
        repaint();
        System.out.println("From " + fromCol + "to" + col);
        System.out.println("From " + fromRow + "to" + row);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static Punto getPezzo(int x, int y) {
//        int xp = x / 84;
//        int yp = y / 84;
//        for (int yfor = 0; yfor < 8; yfor++) {
//            for (int xfor = 0; xfor < 8; xfor++) {
//                if (board[xfor][yfor].getX() == xp && board[xfor][yfor].getY() == yp) {
//                    return board[xfor][yfor];
//                }
//            }
//        }
        if (board[x][y] != null) {
            return board[x][y];
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

    public void eseguiMossa() {
        //esegui mossa dell'altro peer
        String posMossaIniziale = play1.dati.bufferPosMosseIniziali.get(play1.dati.bufferPosMosseIniziali.size() - 1);
        String posMossaFinale = play1.dati.bufferPosMosseFinali.get(play1.dati.bufferPosMosseFinali.size() - 1);

        Point puntoIniziale = convertiMossaInNumeri(posMossaIniziale);
        Point puntoFinale = convertiMossaInNumeri(posMossaFinale);

        //controllo se la mossa è valida , altrimenti faccio qualcosa
        board[puntoFinale.x][puntoFinale.y] = getPezzo(puntoIniziale.x, puntoIniziale.y);
        repaint();
    }

    public String convertiMossaInLettere(int posColonna, int posRiga) {
        String lettera = alfabeto.get(posColonna);
        int numeretto = numero.get(posRiga);

        return lettera + numeretto;
    }

    public Point convertiMossaInNumeri(String mossa) {
        int x = alfabeto.indexOf(mossa.charAt(0));
        int y = numero.indexOf(mossa.charAt(1));

        Point p = new Point(x, y);
        return p;
    }
}
