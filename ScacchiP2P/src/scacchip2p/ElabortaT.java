/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import GUI.Board;
import GUI.PaginaIniziale;
import Gestione.Regole;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alber
 */
public class ElabortaT extends Thread {

    Peer play1;
    int contatore = 0;

    public ElabortaT() {
    }

    public ElabortaT(Peer play1) {
        this.play1 = play1;
        contatore = 0;
    }

    public void azzeraTutto() {

        this.play1.dati.frameBoard.SetFinestraFalse();
        this.play1.chiudiTutto();

        PaginaIniziale iniziale = new PaginaIniziale();
        iniziale.setVisible(true);
    }

    public void run() {
        while (true) {
            if (play1.leggoBuffer().size() > contatore) {
                contatore++;
                String campi[] = play1.leggoBuffer().get(play1.leggoBuffer().size() - 1).split(";");
                switch (campi[0]) {
                    case "c":
                        break;
                    case "sc":
                        if (campi[1].equals("bianco")) {
//                    int risultato = JOptionPane.showConfirmDialog(null, "Accetti il " + campi[1] + "?", "Scelta colore?", JOptionPane.OK_CANCEL_OPTION);
//
//                    if (risultato == 1) {
                            play1.getGiocatore().setColore("nero");
                            play1.getDati().getPlayer2().setColore("bianco");
//                    }
                        } else {
                            play1.getGiocatore().setColore("bianco");
                            play1.getDati().getPlayer2().setColore("nero");
                            ///decidere se chiudere, tornare alla paginaIniziale 
                        }

                        play1.dati.frame.SetLabelColore(play1.giocatore.colore);
                        play1.dati.frame.SetLabelColoreAvversario(play1.dati.avversario.colore);
                        break;
                    case "r":
                        Regole r = null;

                        String modalita = "Modalit??: ";
                        String aiuti = "Aiuti: ";
                        String tempo = "Tempo: ";
                        if (campi[1].equals("0")) {//amichevole
                            r = new Regole(true, 0, 100, "Standard");
                            modalita += "Amichevole";
                        } else if (campi[1].equals("1")) {//classificata
                            r = new Regole(false, 10, 100, "Standard");
                            modalita += "Classificata";
                        } else if (campi[1].equals("2")) {//personalizzata
                            r = new Regole(Boolean.parseBoolean(campi[3]), Integer.parseInt(campi[2]), 100, campi[4]);
                            modalita += "Personalizzata";
                        }
                        play1.dati.setRegole(r);
                        if (play1.dati.regole.isAiuti()) {
                            aiuti += "Si";
                        } else {
                            aiuti += "No";
                        }
                        tempo += r.getTempo();

                        play1.dati.frame.SetLabelModalita(modalita, aiuti, tempo, "Tipo scacchi: " + play1.dati.regole.getTipoScacchi());
                        break;
                    case "ms":
                        play1.dati.setIsReady(true);
//                        try{
                        play1.dati.chessBoard.avviaTimer();
//                        }catch(NullPointerException nulla){
//                            
//                            play1.dati.chessBoard.avviaTimer();
//                        }

                        break;
                    case "m":
                        if (campi[4].equals("true")) {
                            //gestisci la patta
                            //deve rispondere
                            int risposta = JOptionPane.showConfirmDialog(null, "Accetti la patta?", "patta", JOptionPane.YES_NO_OPTION);
                            if (risposta == 0) {
                                //accetta
                                play1.client.send("y;m");
                                azzeraTutto();
                            } else {
                                play1.client.send("n;m");
                            }
                        } else if (campi.length == 6) {
                            //cambia il pedone
                            if (!campi[5].equals("")) {
                                play1.dati.setIsChanged(true);
                                play1.dati.pezzoCambiato = campi[5];
                                play1.dati.bufferPosMosseFinali.add(campi[2]);//salvo Pos mossa finale
                                play1.dati.bufferPosMosseIniziali.add(campi[1]);// salvo pos mossa iniziale
                                play1.dati.chessBoard.setPezzoSuScacchiera();
                            }

                        } else {
                            play1.dati.bufferPosMosseFinali.add(campi[2]);//salvo Pos mossa finale
                            play1.dati.bufferPosMosseIniziali.add(campi[1]);// salvo pos mossa iniziale
                            //eseguo la mossa sulla scachiera

                            play1.dati.chessBoard.setPezzoSuScacchiera();
                        }

                        break;
                    case "y":
                        if (campi[1].equals("m")) {
                            azzeraTutto();
                        }
                        break;
                    case "s"://surrender
                        azzeraTutto();
                        break;
                    case "fp"://fine partita
                        azzeraTutto();
                        break;
                    case "a"://rivincita
                        break;
                    case "d"://disconnettiti
                        azzeraTutto();
                        break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ElabortaT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

}
