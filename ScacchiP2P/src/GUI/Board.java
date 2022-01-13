/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import scacchip2p.Peer;
import scacchip2p.Scacchiera;
import scacchip2p.Timer;

/**
 *
 * @author Giorgia
 */
public class Board extends javax.swing.JFrame {

//    static Punto board[][] = new Punto[8][8];
//
//    int dimensioneCella = 84;
    static Peer play1;
    static Scacchiera b;

    /**
     * Creates new form Board
     */
    public Board(Peer play1) {
        initComponents();
        this.play1 = play1;
        play1.getDati().frameBoard = this;
        jLabelNomeGiocatore.setText(play1.getGiocatore().getNome());
        getContentPane().setBackground(Color.black);
        b = new Scacchiera(play1);
        b.setLocation(84, 84);
        add(b);
//        addMouseListener(new Mouse());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeGiocatore = new javax.swing.JLabel();
        btnPatta = new javax.swing.JButton();
        btnArresa = new javax.swing.JButton();
        jTxtGiocatore = new javax.swing.JLabel();
        jTxtAvversario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jLabelNomeGiocatore.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeGiocatore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNomeGiocatore.setForeground(new java.awt.Color(255, 255, 255));

        btnPatta.setText("Patta");
        btnPatta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPattaActionPerformed(evt);
            }
        });

        btnArresa.setText("Arresa");
        btnArresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArresaActionPerformed(evt);
            }
        });

        jTxtGiocatore.setBackground(new java.awt.Color(255, 255, 255));
        jTxtGiocatore.setForeground(new java.awt.Color(255, 255, 255));

        jTxtAvversario.setBackground(new java.awt.Color(255, 255, 255));
        jTxtAvversario.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelNomeGiocatore, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 866, Short.MAX_VALUE)
                        .addComponent(btnPatta))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnArresa)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtGiocatore, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAvversario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(268, 268, 268))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPatta)
                    .addComponent(jLabelNomeGiocatore, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArresa)
                .addGap(31, 31, 31)
                .addComponent(jTxtAvversario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 569, Short.MAX_VALUE)
                .addComponent(jTxtGiocatore, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPattaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPattaActionPerformed
        // TODO add your handling code here:
        int risposta = JOptionPane.showConfirmDialog(null, "Partita patta?", "patta", JOptionPane.YES_NO_OPTION);
        if (risposta == 0) {
            play1.getClient().send("m;a0;a0;R;true");
        }
    }//GEN-LAST:event_btnPattaActionPerformed

    private void btnArresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArresaActionPerformed
        // TODO add your handling code here:
        int risposta = JOptionPane.showConfirmDialog(null, "Arresa", "Arresa", JOptionPane.YES_NO_OPTION);
        if (risposta == 0) {
            b.arresa(false);
            play1.getClient().send("s;");
        }
    }//GEN-LAST:event_btnArresaActionPerformed
    public void SetTempoGrafico(String tempoMio, String tempoAvversario) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Codice da eseguire nel Thread grafico
                jTxtGiocatore.setText(tempoMio);
                jTxtAvversario.setText(tempoAvversario);
            }
        });
    }
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
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board(play1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArresa;
    private javax.swing.JButton btnPatta;
    private javax.swing.JLabel jLabelNomeGiocatore;
    private javax.swing.JLabel jTxtAvversario;
    private javax.swing.JLabel jTxtGiocatore;
    // End of variables declaration//GEN-END:variables
}
