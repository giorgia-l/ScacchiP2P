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
import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Giorgia
 */
public class Scacchiera extends JPanel implements MouseListener, MouseMotionListener {

    public static Punto board[][] = new Punto[8][8];

    static Punto pezzoSelezionato = null;
    static Punto pezzoSelezionatoInMemoria = null;
    static Point nuovoPuntoSelezionato = null;

    static Punto pezzoAvversario = null;

    boolean isSelezionatoPezzo = false;
    static Point puntoSelezionato = null;

    int fromCol = -1;
    int fromRow = -1;

    int dimensioneCella = 84;

    boolean arresa, vittoria, patta;

//    DatiCondivisi dati;
    Peer play1;

    ArrayList<Moves> mosse = new ArrayList<Moves>();

    ArrayList<String> alfabeto = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
    ArrayList<String> alfabetoReverso = new ArrayList<String>(Arrays.asList("h", "g", "f", "e", "d", "c", "b", "a"));
    ArrayList<Integer> numeroReverso = new ArrayList<Integer>(Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1));
    ArrayList<Integer> numero = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

    Gestione.GestioneGioco gestioneGioco;
//    private int[] numeri = {1, 2, 3, 4, 5, 6, 7, 8};

    public Scacchiera(Peer play1) {
        this.play1 = play1;
        play1.getDati().setChessBoard(this);
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

            play1.avviaServer();
            play1.avviaElabora();

        }
        if (play1.giocatore.isWhite()) {
            play1.dati.setIsMyTurn(true);
        }

        play1.client.send(gestioneGioco.creaMessaggioStartGioco()); //invio messagggio di inizio gioco
        play1.dati.setIsReady(true);

        //avvio timer
        Timer timer = new Timer(play1);
        timer.setTempo(play1.dati.regole.getTempo());
        timer.start();

    }

    public void avviaTimer() {
        if (play1.dati.isReady) {
            Timer timer = new Timer(play1);
            timer.setTempo(play1.dati.regole.getTempo());
            timer.start();
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

    public void muoviPedone(int fromCol, int fromRow, int toCol, int toRow) {
        if (play1.dati.isMyTurn) {
            if ((pezzoSelezionato != null)) {
                Pedone pN = (Pedone) pezzoSelezionato.getPiece();
                if (pN.kills(board, fromCol, toCol, fromRow, toRow)) {
                    board[toCol][toRow] = pezzoSelezionato; //muovo il pezzo
                    board[fromCol][fromRow] = null;//metto il pezzo vuoto

                    //invio la mossa
                    String messaggioDaInviare = gestioneGioco.creoMessaggioMossa(convertiMossaInLettere(fromCol, fromRow), convertiMossaInLettere(toCol, toRow), pezzoSelezionato.getPiece().getName(), false);
                    play1.client.send(messaggioDaInviare);

                    //cambio il turno
                    play1.dati.setIsMyTurn(false);
                    mosse.clear();
                }
            }
        }
    }

    public void muoviPezzi(int fromCol, int fromRow, int toCol, int toRow) {

//        Punto pezzoPuntoIniziale=new Punto(fromCol, fromRow, pezzoSelezionato.getPiece());
//        Punto pezzoPuntoFinale=new Punto(toCol, toRow, pezzoSelezionato.getPiece());
        //controllo se la mossa può essere effettuata
        if (play1.dati.isMyTurn) {
            if ((pezzoSelezionato != null)) {
                if (pezzoSelezionato.getPiece().canMove(board, fromCol, toCol, fromRow, toRow)) {
                    board[toCol][toRow] = pezzoSelezionato; //muovo il pezzo
                    board[fromCol][fromRow] = null;//metto il pezzo vuoto

                    //invio la mossa
                    String messaggioDaInviare = gestioneGioco.creoMessaggioMossa(convertiMossaInLettere(fromCol, fromRow), convertiMossaInLettere(toCol, toRow), pezzoSelezionato.getPiece().getName(), false);
                    play1.client.send(messaggioDaInviare);

                    //cambio il turno
                    play1.dati.setIsMyTurn(false);
                    mosse.clear();
                }
            }

            if ((pezzoSelezionato == null && pezzoSelezionatoInMemoria != null)) {
                if (pezzoSelezionatoInMemoria.getPiece().canMove(board, fromCol, toCol, fromRow, toRow)) {
                    board[toCol][toRow] = pezzoSelezionatoInMemoria; //muovo il pezzo
                    board[fromCol][fromRow] = null;//metto il pezzo vuoto
                    pezzoSelezionatoInMemoria.setX(toCol);
                    pezzoSelezionatoInMemoria.setY(toRow);
                    //invio la mossa
                    String messaggioDaInviare = gestioneGioco.creoMessaggioMossa(convertiMossaInLettere(fromCol, fromRow), convertiMossaInLettere(toCol, toRow), pezzoSelezionatoInMemoria.getPiece().getName(), false);
                    play1.client.send(messaggioDaInviare);

                    //cambio il turno
                    play1.dati.setIsMyTurn(false);
                    mosse.clear();
                }
            }

        }

    }

    public void creaBoard() {
        //inizializzazione pezzi Avversario sulla scacchiera
        //sistemare la board
        boolean coloreAvversario = true;//play1.dati.avversario.isWhite();
        boolean colorePlayer = false; //play1.giocatore.isWhite();
        if (play1.dati.regole.getTipoScacchi().equals("Standard")) {
            board[0][0] = new Punto(0, 0, new Torre("R", coloreAvversario));
            board[1][0] = new Punto(1, 0, new Cavallo("N", coloreAvversario));
            board[2][0] = new Punto(2, 0, new Alfiere("B", coloreAvversario));
            board[3][0] = new Punto(3, 0, new Regina("Q", coloreAvversario));
            board[4][0] = new Punto(4, 0, new Re("K", coloreAvversario));
            board[5][0] = new Punto(5, 0, new Alfiere("B", coloreAvversario));
            board[6][0] = new Punto(6, 0, new Cavallo("N", coloreAvversario));
            board[7][0] = new Punto(7, 0, new Torre("R", coloreAvversario));

            board[0][1] = new Punto(0, 1, new Pedone("P", coloreAvversario));
            board[1][1] = new Punto(1, 1, new Pedone("P", coloreAvversario));
            board[2][1] = new Punto(2, 1, new Pedone("P", coloreAvversario));
            board[3][1] = new Punto(3, 1, new Pedone("P", coloreAvversario));
            board[4][1] = new Punto(4, 1, new Pedone("P", coloreAvversario));
            board[5][1] = new Punto(5, 1, new Pedone("P", coloreAvversario));
            board[6][1] = new Punto(6, 1, new Pedone("P", coloreAvversario));
            board[7][1] = new Punto(7, 1, new Pedone("P", coloreAvversario));

            //inizializzazione pezzi Giocatore sulla scacchiera
            board[0][7] = new Punto(0, 7, new Torre("R", colorePlayer));
            board[1][7] = new Punto(1, 7, new Cavallo("N", colorePlayer));
            board[2][7] = new Punto(2, 7, new Alfiere("B", colorePlayer));
            board[3][7] = new Punto(3, 7, new Regina("Q", colorePlayer));
            board[4][7] = new Punto(4, 7, new Re("K", colorePlayer));
            board[5][7] = new Punto(5, 7, new Alfiere("B", colorePlayer));
            board[6][7] = new Punto(6, 7, new Cavallo("N", colorePlayer));
            board[7][7] = new Punto(7, 7, new Torre("R", colorePlayer));

            board[0][6] = new Punto(0, 6, new Pedone("P", colorePlayer));
            board[1][6] = new Punto(1, 6, new Pedone("P", colorePlayer));
            board[2][6] = new Punto(2, 6, new Pedone("P", colorePlayer));
            board[3][6] = new Punto(3, 6, new Pedone("P", colorePlayer));
            board[4][6] = new Punto(4, 6, new Pedone("P", colorePlayer));
            board[5][6] = new Punto(5, 6, new Pedone("P", colorePlayer));
            board[6][6] = new Punto(6, 6, new Pedone("P", colorePlayer));
            board[7][6] = new Punto(7, 6, new Pedone("P", colorePlayer));

            for (int i = 0; i < 8; i++) {
                for (int j = 2; j < 6; j++) {
                    board[i][j] = null;
                }
            }
        }

    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); //To change body of generated methods, choose Tools | Templates.

        Graphics2D g2 = (Graphics2D) g;

        drawBoard(g2);
        drawPezzi(g2);
        drawMosse(g2);

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
        int ix;
        int iy;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (board[x][y] != null) {
                    if (play1.giocatore.isWhite()) {
                        //se bianco
                        ix = x;
                        iy = y - 7;
                        if (iy < 0) {
                            iy *= -1;
                        }
                    } else {
                        iy = y;
                        ix = x - 7;
                        if (ix < 0) {
                            ix *= -1;
                        }
                    }

                    g.drawImage(board[x][y].getPiece().getPiece(), ix * dimensioneCella, iy * dimensioneCella, null);
                }
            }
        }

        if (pezzoSelezionato != null && puntoSelezionato != null) {
            g.drawImage(pezzoSelezionato.getPiece().getPiece(), puntoSelezionato.x - dimensioneCella / 2, puntoSelezionato.y - dimensioneCella / 2, dimensioneCella, dimensioneCella, null);
        }
//        if (pezzoSelezionato == null && nuovoPuntoSelezionato != null) {
//            g.drawImage(pezzoSelezionatoInMemoria.getPiece().getPiece(), nuovoPuntoSelezionato.x * dimensioneCella, nuovoPuntoSelezionato.y * dimensioneCella, dimensioneCella, dimensioneCella, null);
//
//        }
    }

    public void drawMosse(Graphics2D g) {
        if (pezzoSelezionato != null) {
            for (Moves mossa : mosse) {
                Point pG = ottieniCordinateGrafica(mossa.x, mossa.y);
                g.drawImage(new ImageIcon("src/PngColori/cerchio.png").getImage(), pG.x * dimensioneCella, pG.y * dimensioneCella, dimensioneCella, dimensioneCella, null);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //
//        fromCol = (e.getPoint().x) / dimensioneCella;
//        fromRow = (e.getPoint().y) / dimensioneCella;
//        pezzoSelezionato = getPezzo(fromCol, fromRow);
//
//        if (pezzoSelezionato != null) {
//            isSelezionatoPezzo = true;
//            mosse = pezzoSelezionato.getPiece().getMoves(fromCol, fromRow);
//            repaint();
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println(getPezzo(e.getX(), e.getY()).getPiece().getName());
        fromCol = (e.getPoint().x) / dimensioneCella;       //salvo la colonna
        fromRow = (e.getPoint().y) / dimensioneCella;       //salvo la riga

        Point pG = ottieniCordinateGrafica(fromCol, fromRow);

        if (getPezzo(pG.x, pG.y) != null) {
            if (play1.giocatore.isWhite() == getPezzo(pG.x, pG.y).getPiece().isWhite()) {
                pezzoSelezionato = getPezzo(pG.x, pG.y);      //ritorno il pezzo
                isSelezionatoPezzo = true;
                pezzoSelezionatoInMemoria = pezzoSelezionato;
                if (pezzoSelezionato.getPiece().getName().equals("R") || pezzoSelezionato.getPiece().getName().equals("Q") || pezzoSelezionato.getPiece().getName().equals("B")) {
                    mosse = pezzoSelezionato.getPiece().getMoves(board, pG.x, pG.y); //dammi le mosse che può fare
                } else {
                    mosse = pezzoSelezionato.getPiece().getMoves(pG.x, pG.y); //dammi le mosse che può fare
                }//                    repaint();
            } else {
                //uccidi il pezzo
                pezzoAvversario = getPezzo(pG.x, pG.y);
                if (play1.giocatore.isWhite() != pezzoAvversario.getPiece().isWhite()) {
                    try {
                        if (pezzoSelezionato.getPiece().getName().equals("P")) {
                            muoviPedone(pezzoSelezionato.getX(), pezzoSelezionato.getY(), pG.x, pG.y);
                        } else {
                            muoviPezzi(pezzoSelezionato.getX(), pezzoSelezionato.getY(), pG.x, pG.y);
                        }
                    } catch (NullPointerException nulla) {
                        nulla = null;
                    }

                }
            }
        } else {
            if (pezzoSelezionatoInMemoria != null) {
                pezzoSelezionato = null;
                isSelezionatoPezzo = false;
                int col = (e.getPoint().x) / dimensioneCella;
                int row = (e.getPoint().y) / dimensioneCella;
                pG = ottieniCordinateGrafica(col, row);
                nuovoPuntoSelezionato = new Point(pG.x, pG.y);
                muoviPezzi(pezzoSelezionatoInMemoria.getX(), pezzoSelezionatoInMemoria.getY(), pG.x, pG.y);
//                        repaint();
            }

        }
//        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        int col = (e.getPoint().x) / dimensioneCella;
        int row = (e.getPoint().y) / dimensioneCella;

        Point pG = ottieniCordinateGrafica(col, row);

        puntoSelezionato = null;
        if (getPezzo(pG.x, pG.y) == null) {
            try {
                muoviPezzi(pezzoSelezionatoInMemoria.getX(), pezzoSelezionatoInMemoria.getY(), pG.x, pG.y);
                repaint();
                pezzoSelezionato = null;
                pezzoSelezionatoInMemoria = null;
            } catch (NullPointerException nulla) {
                nulla = null;
            }

        }
        repaint();  //se da problemi il drag o click controllare questo repaint

//        if (!isSelezionatoPezzo) {
//            System.out.println("From " + fromCol + "to" + col);
//            System.out.println("From " + fromRow + "to" + row);
//        }
//        if (!isSelezionatoPezzo) {
//            muoviPezzi(fromCol, fromRow, col, row);
//            repaint();
//            System.out.println("From " + fromCol + "to" + col);
//            System.out.println("From " + fromRow + "to" + row);
//        }
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
//
//        //        System.out.println(e.getX() + e.getY());
        puntoSelezionato = e.getPoint();
////        if (pezzoSelezionato != null) {
////            pezzoSelezionato.setX(e.getX());
////            pezzoSelezionato.setY(e.getY());
        repaint();
//            g.drawImage(pezzoSelezionato.getPiece().getPiece(), pezzoSelezionato.getX() * dimensioneCella, pezzoSelezionato.getY() * dimensioneCella, null);

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void eseguiMossa() {
        //esegui mossa dell'altro peer
//        if(!play1.dati.isMyTurn){
//            
//        }
        String posMossaIniziale = play1.dati.bufferPosMosseIniziali.get(play1.dati.bufferPosMosseIniziali.size() - 1);
        String posMossaFinale = play1.dati.bufferPosMosseFinali.get(play1.dati.bufferPosMosseFinali.size() - 1);

        Point puntoIniziale = convertiMossaInNumeri(posMossaIniziale);
        Point puntoFinale = convertiMossaInNumeri(posMossaFinale);

        Point puntoInizialeGrafico;
        Point puntoFinaleGrafico;
        if (play1.dati.avversario.isWhite()) {
            puntoInizialeGrafico = ottieniCordinateGraficaAvversario(puntoIniziale.x, puntoIniziale.y);
            puntoFinaleGrafico = ottieniCordinateGraficaAvversario(puntoFinale.x, puntoFinale.y);
        } else {
            puntoInizialeGrafico = ottieniCordinateGrafica(puntoIniziale.x, puntoIniziale.y);
            puntoFinaleGrafico = ottieniCordinateGrafica(puntoFinale.x, puntoFinale.y);
        }

        //controllo se la mossa è valida , altrimenti faccio qualcosa
        board[puntoFinaleGrafico.x][puntoFinaleGrafico.y] = getPezzo(puntoInizialeGrafico.x, puntoInizialeGrafico.y);
        board[puntoInizialeGrafico.x][puntoInizialeGrafico.y] = null;
        repaint();
        play1.dati.setIsMyTurn(true);

    }

    public String convertiMossaInLettere(int posColonna, int posRiga) {
        String lettera = alfabeto.get(posColonna);
        int numeretto = numeroReverso.get(posRiga);

        return lettera + numeretto;
    }

    public Point convertiMossaInNumeri(String mossa) {
        int x = alfabeto.indexOf(String.valueOf(mossa.charAt(0)));
        int y = numero.indexOf(Integer.parseInt(String.valueOf(mossa.charAt(1))));

        Point p = new Point(x, y);
        return p;
    }

    public void setPezzoSuScacchiera() {

        //Codice da eseguire nel Thread grafico
//                jTxtAvversarioColore.setText(s);
        eseguiMossa();
    }

    public Point ottieniCordinateGraficaAvversario(int xG, int yG) {
        int ix;
        int iy;
        if (play1.dati.avversario.isWhite()) {
            //se bianco
            ix = xG;
            iy = yG - 7;
            if (iy < 0) {
                iy *= -1;
            }
        } else {
            iy = yG;
            ix = xG - 7;
            if (ix < 0) {
                ix *= -1;
            }
        }

        Point pG = new Point(ix, iy);
        return pG;
    }

    public Point ottieniCordinateGrafica(int xG, int yG) {
        int ix;
        int iy;
        if (play1.giocatore.isWhite()) {
            //se bianco
            ix = xG;
            iy = yG - 7;
            if (iy < 0) {
                iy *= -1;
            }
        } else {
            iy = yG;
            ix = xG - 7;
            if (ix < 0) {
                ix *= -1;
            }
        }

        Point pG = new Point(ix, iy);
        return pG;
    }

    public void arresa(boolean arresaOK) {
        if (arresaOK == false) {
            arresa = true;
            vittoria = true;
        } else {
            arresa = false;
            vittoria = false;
        }
        finePartita();
    }

    public void patta() {
        patta = true;
        finePartita();
    }

    public boolean Scacco(boolean white) { // controllo che il mio re sia sotto scacco
        int[] kingPos = posizioneRe(white);
        int riga = kingPos[1];
        int colonna = kingPos[0];

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (board[x][y] != null) {
                    if (board[x][y].getPiece().canMove(board, x, colonna, y, riga) && !board[x][y].getPiece().isWhite() == white) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[] posizioneRe(boolean white) { // ritorna le posizioni del Re
        int riga = 0, colonna = 0;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (board[x][y] != null) {
                    if (board[x][y].getClass().isInstance(new Re(white)) && board[x][y].getPiece().isWhite() == white) {
                        colonna = x;
                        riga = y;
                    }
                }
            }
        }
        int[] posR = new int[2];
        posR[1] = riga;
        posR[0] = colonna;

        return posR;

    }

    public void finePartita() {

    }

    public void controlloVittoria(Punto[][] board) {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {

            }
        }
    }
}
