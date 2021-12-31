/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Gestione.GestioneRegole;
import scacchip2p.DatiCondivisi;

/**
 *
 * @author Giorgia
 */
public class SceltaRegole extends javax.swing.JFrame {
    
    int regole = 0; //amichevole=0, competitiva=1, personalizzata=2
    DatiCondivisi dati = new DatiCondivisi();
    /**
     * Creates new form SceltaRegole
     */
    public SceltaRegole() {
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

        btnAmichevole = new javax.swing.JButton();
        btnCompetitiva = new javax.swing.JButton();
        btnPersonalizzata = new javax.swing.JButton();
        btnConferma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scelta regole");

        btnAmichevole.setText("Amichevole ");
        btnAmichevole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmichevoleActionPerformed(evt);
            }
        });

        btnCompetitiva.setText("Competitiva");
        btnCompetitiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompetitivaActionPerformed(evt);
            }
        });

        btnPersonalizzata.setText("Personalizzata");
        btnPersonalizzata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalizzataActionPerformed(evt);
            }
        });

        btnConferma.setText("Conferma");
        btnConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfermaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAmichevole, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConferma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCompetitiva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPersonalizzata)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAmichevole, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPersonalizzata, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnConferma)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonalizzataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalizzataActionPerformed
        // TODO add your handling code here:
        regole = 2;
    }//GEN-LAST:event_btnPersonalizzataActionPerformed

    private void btnAmichevoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmichevoleActionPerformed
        // TODO add your handling code here:
        regole = 0;
    }//GEN-LAST:event_btnAmichevoleActionPerformed

    private void btnCompetitivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompetitivaActionPerformed
        // TODO add your handling code here:
        regole = 1;
    }//GEN-LAST:event_btnCompetitivaActionPerformed

    private void btnConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfermaActionPerformed
        // TODO add your handling code here:
        GestioneRegole gr = new GestioneRegole(dati);
        
        this.setVisible(false);
        this.dispose();//libera memoria dalle cose create
        
        Board board = new Board();
        board.setVisible(true);
    }//GEN-LAST:event_btnConfermaActionPerformed

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
            java.util.logging.Logger.getLogger(SceltaRegole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SceltaRegole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SceltaRegole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SceltaRegole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SceltaRegole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmichevole;
    private javax.swing.JButton btnCompetitiva;
    private javax.swing.JButton btnConferma;
    private javax.swing.JButton btnPersonalizzata;
    // End of variables declaration//GEN-END:variables
}
