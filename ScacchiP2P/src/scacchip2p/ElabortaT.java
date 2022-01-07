/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import Gestione.Regole;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alber
 */
public class ElabortaT extends Thread {

    Peer play1;

    public ElabortaT() {
    }

    public ElabortaT(Peer play1) {
        this.play1 = play1;
    }

    public void run() {
        while (true) {
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
                    
                    String modalita="Modalità: ";
                    String aiuti="Aiuti: ";
                    String tempo="Tempo: ";
                    if (campi[1].equals("0")) {//amichevole
                        r = new Regole(true, true, 100, "Standard");
                        modalita+="Amichevole";
                    } else if (campi[1].equals("1")) {//classificata
                        r = new Regole(false, true, 100, "Standard");
                        modalita+="Classificata";
                    } else if (campi[1].equals("2")) {//personalizzata
                        r = new Regole(Boolean.parseBoolean(campi[3]), Boolean.parseBoolean(campi[2]),100,campi[4]);
                        modalita+="Personalizzata";
                    }
                    play1.dati.setRegole(r);
                    if(play1.dati.regole.isAiuti())
                        aiuti+="Si";
                    else 
                        aiuti+="No";
                    
                    if(play1.dati.regole.isTempo())
                        tempo+="Si";
                    else
                        tempo+="No";
                    
                    play1.dati.frame.SetLabelModalita(modalita,aiuti,tempo,"Tipo scacchi: "+play1.dati.regole.getTipoScacchi());
                    break;
                case "ms":
                    play1.dati.setIsReady(true);
                    break;
                case "m":
                    if(campi[4].equals("true")){
                        //gestisci la patta
                    }
                    play1.dati.bufferPosMosseFinali.add(campi[2]);//salvo Pos mossa finale
                    play1.dati.bufferPosMosseIniziali.add(campi[1]);// salvo pos mossa iniziale
                    //eseguo la mossa sulla scachiera
                    
                    
                    break;
                case "d":
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
