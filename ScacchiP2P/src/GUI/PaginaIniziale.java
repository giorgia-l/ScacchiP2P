/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Gestione.GestioneConnessione;
import javax.swing.JOptionPane;
import scacchip2p.DatiCondivisi;

/**
 *
 * @author Alber
 */
public class PaginaIniziale extends javax.swing.JFrame {

    /**
     * Creates new form PaginaIniziale
     */
    public PaginaIniziale() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtPorta = new javax.swing.JTextField();
        jBtnGiocaMandaRichiesta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jBtnGiocaRiceviRichiesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Nome:");

        jBtnGiocaMandaRichiesta.setText("Gioca manda richiesta");
        jBtnGiocaMandaRichiesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGiocaMandaRichiestaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Porta:");

        jBtnGiocaRiceviRichiesta.setText("Gioca ricevi richiesta");
        jBtnGiocaRiceviRichiesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGiocaRiceviRichiestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtnGiocaRiceviRichiesta, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jBtnGiocaMandaRichiesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtPorta)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnGiocaMandaRichiesta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnGiocaRiceviRichiesta, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGiocaMandaRichiestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGiocaMandaRichiestaActionPerformed
        // TODO add your handling code here:
        DatiCondivisi dati = new DatiCondivisi();
//        dati.getServer().start();

        //salvo nome player1
        dati.getPlayer1().setNome(jTxtNome.getText());
        dati.getPlayer1().setPorta(Integer.parseInt(jTxtPorta.getText()));

        //mando messaggio
//        GestioneConnessione gestioneConnessione=GestioneConnessione(dati);
//        String messaggioDaInviare=gestioneConnessione.creoMessaggio();
//        dati.getClient().send(messaggioDaInviare);
        //riceve risposta
        String messaggio = dati.getServer().ascolta();

        String campi[] = messaggio.split(";");

        //se risposta == "y" vado avanti
        if (campi[0] == "y") {
            dati.getPlayer2().setNome(campi[2]);

            this.setVisible(false);
            this.dispose();
            SceltaColore paginaDue = new SceltaColore();
            paginaDue.setVisible(true);
        }
    }//GEN-LAST:event_jBtnGiocaMandaRichiestaActionPerformed

    private void jBtnGiocaRiceviRichiestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGiocaRiceviRichiestaActionPerformed
        // TODO add your handling code here:

        DatiCondivisi dati = new DatiCondivisi();
//        dati.getServer().start();

        dati.getPlayer1().setNome(jTxtNome.getText());
        dati.getPlayer1().setPorta(Integer.parseInt(jTxtPorta.getText()));

        //ascolto se c'è qualche richiesta
        String messaggio = dati.getServer().ascolta();

        String campi[] = messaggio.split(";");

        if (campi[0] == "c") {
            //invio y o n
            dati.getPlayer2().setNome(campi[2]);

            int risultato = JOptionPane.showConfirmDialog(null, "Vuoi giocare?", "Vuoi giocare?", JOptionPane.OK_CANCEL_OPTION);
            GestioneConnessione gestioneConnessione = new GestioneConnessione(dati);
            if (risultato == 1) {

                String messaggioDaInviare = gestioneConnessione.creoMessaggioRispostaY();
                dati.getClient().send(messaggioDaInviare);
                this.setVisible(false);
                this.dispose();

                SceltaColore paginaDue = new SceltaColore();
                paginaDue.setVisible(true);
            } else {
                String messaggioDaInviare = gestioneConnessione.creoMessaggioRispostaN();
                dati.getClient().send(messaggioDaInviare);
            }

        }

    }//GEN-LAST:event_jBtnGiocaRiceviRichiestaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaIniziale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaIniziale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaIniziale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaIniziale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaIniziale().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnGiocaMandaRichiesta;
    private javax.swing.JButton jBtnGiocaRiceviRichiesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtPorta;
    // End of variables declaration//GEN-END:variables
}
