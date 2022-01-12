/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Pezzi.Alfiere;
import Pezzi.Cavallo;
import Pezzi.Pedone;
import Pezzi.Pezzo;
import Pezzi.Punto;
import Pezzi.Re;
import Pezzi.Regina;
import Pezzi.Torre;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import scacchip2p.Peer;
import scacchip2p.Scacchiera;

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
        jLabelNomeGiocatore.setText(play1.getGiocatore().getNome());
        getContentPane().setBackground(Color.black);
        b = new Scacchiera(play1);
        b.setLocation(84, 84);
        add(b);
//        addMouseListener(new Mouse());
    }

    public void creaBoard() {
//        board[0][0] = new Punto(0, 0, new Torre("torre",false));
//        board[1][0] = new Punto(1, 0, new Cavallo(false));
//        board[2][0] = new Punto(2, 0, new Alfiere(false));
//        board[3][0] = new Punto(3, 0, new Regina(false));
//        board[4][0] = new Punto(4, 0, new Re(false));
//        board[5][0] = new Punto(5, 0, new Alfiere(false));
//        board[6][0] = new Punto(6, 0, new Cavallo(false));
//        board[7][0] = new Punto(7, 0, new Torre("torre",false));
//
//        board[0][1] = new Punto(0, 1, new Pedone(false));
//        board[1][1] = new Punto(1, 1, new Pedone(false));
//        board[2][1] = new Punto(2, 1, new Pedone(false));
//        board[3][1] = new Punto(3, 1, new Pedone(false));
//        board[4][1] = new Punto(4, 1, new Pedone(false));
//        board[5][1] = new Punto(5, 1, new Pedone(false));
//        board[6][1] = new Punto(6, 1, new Pedone(false));
//        board[7][1] = new Punto(7, 1, new Pedone(false));
//
//        //inizializzazione pezzi neri sulla scacchiera
//        board[0][7] = new Punto(0, 7, new Torre("torre",false));
//        board[1][7] = new Punto(1, 7, new Cavallo(false));
//        board[2][7] = new Punto(2, 7, new Alfiere(false));
//        board[3][7] = new Punto(3, 7, new Regina(false));
//        board[4][7] = new Punto(4, 7, new Re(false));
//        board[5][7] = new Punto(5, 7, new Alfiere(false));
//        board[6][7] = new Punto(6, 7, new Cavallo(false));
//        board[7][7] = new Punto(7, 7, new Torre("torre",false));
//
//        board[0][6] = new Punto(0, 6, new Pedone(false));
//        board[1][6] = new Punto(1, 6, new Pedone(false));
//        board[2][6] = new Punto(2, 6, new Pedone(false));
//        board[3][6] = new Punto(3, 6, new Pedone(false));
//        board[4][6] = new Punto(4, 6, new Pedone(false));
//        board[5][6] = new Punto(5, 6, new Pedone(false));
//        board[6][6] = new Punto(6, 6, new Pedone(false));
//        board[7][6] = new Punto(7, 6, new Pedone(false));
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 2; j < 6; j++) {
//                board[i][j] = new Punto(i, j, new Vuoto());
//            }
//        }
    }

//    public void paint(Graphics gp) {
//        gp.fillRect(dimensioneCella - 1, dimensioneCella - 1, dimensioneCella * 8 + 2, dimensioneCella * 8 + 2);
//        creaBoard();
//        boolean white = true;
//
//        for (int y = 0; y < 8; y++) {
//            for (int x = 0; x < 8; x++) {
//                if (white) {
//                    gp.setColor(Color.white);
//                } else {
//                    gp.setColor(Color.gray);
//                }
//                gp.fillRect((x + 1) * dimensioneCella, (y + 1) * dimensioneCella, dimensioneCella, dimensioneCella);
//                white = !white;
//            }
//            white = !white;
//        }
//
//        for (int y = 0; y < 8; y++) {
//            for (int x = 0; x < 8; x++) {
//                gp.drawImage(board[x][y].getPiece().getPiece(), (x + 1) * dimensioneCella, (y + 1) * dimensioneCella, this);
//            }
//        }
//    }
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
                .addContainerGap(758, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPattaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPattaActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Partita patta?", "patta", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            play1.getClient().send("m;a0;a0;R;true");
        }
    }//GEN-LAST:event_btnPattaActionPerformed

    private void btnArresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArresaActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Arresa", "Arresa", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            b.arresa(false);
            play1.getClient().send("s;");
        }
    }//GEN-LAST:event_btnArresaActionPerformed

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

//    public static Punto getPezzo(int x, int y) {
//        int xp = x / 84;
//        int yp = y / 84;
//        for (int yfor = 0; yfor < 8; yfor++) {
//            for (int xfor = 0; xfor < 8; xfor++) {
//                if(board[xfor][yfor].getX()==xp && board[xfor][yfor].getY()==yp)
//                    return board[xfor][yfor];
//            }
//        }
//        return null;
//    }
//
//    public class Mouse extends MouseAdapter{
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//            System.out.println(getPezzo(e.getX(), e.getY()).getPiece().getName());
//        }
//        
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArresa;
    private javax.swing.JButton btnPatta;
    private javax.swing.JLabel jLabelNomeGiocatore;
    // End of variables declaration//GEN-END:variables
}
