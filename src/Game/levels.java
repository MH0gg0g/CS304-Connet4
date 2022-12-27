/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import Textures.*;

/**
 *
 * @author Mohammed
 */
public class levels extends javax.swing.JFrame {

    int WIDTH = 1280;
    int HEIGHT = 720;

    public levels() {
        initComponents();

        EXIT_BTN.setOpaque(false);
        EXIT_BTN.setContentAreaFilled(false);
        EXIT_BTN.setBorderPainted(false);
        
        BACK_BTN.setOpaque(false);
        BACK_BTN.setContentAreaFilled(false);
        BACK_BTN.setBorderPainted(false);
        
        EASY_BTN.setOpaque(false);
        EASY_BTN.setContentAreaFilled(false);
        EASY_BTN.setBorderPainted(false);

        setSize(WIDTH, HEIGHT);
        jLabel1.setSize(WIDTH, HEIGHT);
        jPanel1.setSize(WIDTH, HEIGHT);

        
        
        setTitle("Connect4 - LEVELS");

        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BACK_BTN = new javax.swing.JButton();
        EASY_BTN = new javax.swing.JButton();
        EXIT_BTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/levels.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        BACK_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACK_BTNActionPerformed(evt);
            }
        });
        jPanel1.add(BACK_BTN);
        BACK_BTN.setBounds(20, 20, 80, 70);

        EASY_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EASY_BTNActionPerformed(evt);
            }
        });
        jPanel1.add(EASY_BTN);
        EASY_BTN.setBounds(520, 140, 230, 70);

        EXIT_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXIT_BTNActionPerformed(evt);
            }
        });
        jPanel1.add(EXIT_BTN);
        EXIT_BTN.setBounds(520, 350, 310, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BACK_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACK_BTNActionPerformed
        // TODO add your handling code here:
        try {
            System.out.println("FROM MENU TO INSTRUCTIONS");
            levels.this.setVisible(false);
            play play_page = new play();
//            play_page.isBack = true;
            play_page.setVisible(true);
        } catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_BACK_BTNActionPerformed

    private void EASY_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EASY_BTNActionPerformed
        // TODO add your handling code here:
        try {
            System.out.println("FROM LEVELS TO EASY");
            levels.this.setVisible(false);
            Anim easy_page = new Anim();
            easy_page.setVisible(true);
        } catch (Exception e) {
            
        }
        
        
    }//GEN-LAST:event_EASY_BTNActionPerformed

    private void EXIT_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXIT_BTNActionPerformed
        // TODO add your handling code here
        
        try {
            System.out.println("HOOOOOOOOOOOOOOOOOOOOOOOOOME");
//            clip.stop();
            System.exit(0);
            } catch (Exception e) {
            
        }
        
        
    }//GEN-LAST:event_EXIT_BTNActionPerformed

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
            java.util.logging.Logger.getLogger(levels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(levels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(levels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(levels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new levels().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK_BTN;
    private javax.swing.JButton EASY_BTN;
    private javax.swing.JButton EXIT_BTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
