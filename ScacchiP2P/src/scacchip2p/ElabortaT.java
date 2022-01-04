/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import Gestione.Regole;
import java.util.ArrayList;

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
                    break;
                case "r":
                    Regole r = null;

                    if (campi[1].equals("0")) {//amichevole
                        r = new Regole(true, true, 100, "Standard");
                    } else if (campi[1].equals("1")) {//classificata
                        r = new Regole(false, true, 100, "Standard");
                    } else if (campi[1].equals("2")) {//personalizzata
                        r = new Regole(Boolean.parseBoolean(campi[2]),Boolean.parseBoolean(campi[3]), Integer.parseInt(campi[4]), "Standard");
                    }
                    play1.dati.setRegole(r);
                    break;
                case "m":
                    break;
            }
        }

    }

}
