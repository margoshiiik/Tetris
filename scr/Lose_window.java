import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author annet
 */
public class Lose_window extends javax.swing.JFrame {

    private Clip clip;

    /**
     * Creates new form Lose_window
     */
    public Lose_window() {
        initComponents();
        this.setLocationRelativeTo(null);
        BufferedImage victory = null;
        victory = ImageLoader.loadImage("image/lose.png");
        imageNewScore.setIcon(new ImageIcon(victory));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelСloseMouseClicked = new javax.swing.JLabel();
        jLabelMinMouseClicked = new javax.swing.JLabel();
        jLabelTetris = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelCongratulations = new javax.swing.JLabel();
        JLabelNewScore = new javax.swing.JLabel();
        imageNewScore = new javax.swing.JLabel();
        jButtonBackToMenu = new javax.swing.JButton();
        JLabelNewScore1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(10, 10, 74));

        jLabelСloseMouseClicked.setFont(new java.awt.Font("Centaur", 1, 36)); // NOI18N
        jLabelСloseMouseClicked.setForeground(new java.awt.Color(255, 255, 255));
        jLabelСloseMouseClicked.setText("×");
        jLabelСloseMouseClicked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelСloseMouseClickedMouseClicked(evt);
            }
        });

        jLabelMinMouseClicked.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
        jLabelMinMouseClicked.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinMouseClicked.setText("-");
        jLabelMinMouseClicked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClickedMouseClicked(evt);
            }
        });

        jLabelTetris.setFont(new java.awt.Font("Niagara Engraved", 0, 48)); // NOI18N
        jLabelTetris.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTetris.setText("Tetris");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTetris, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jLabelMinMouseClicked)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelСloseMouseClicked)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelСloseMouseClicked, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelMinMouseClicked, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabelTetris))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(10, 10, 74));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(16, 16, 106));

        jLabelCongratulations.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabelCongratulations.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCongratulations.setText("Game Over");

        JLabelNewScore.setFont(new java.awt.Font("Sitka Display", 0, 20)); // NOI18N
        JLabelNewScore.setForeground(new java.awt.Color(255, 255, 255));
        JLabelNewScore.setText("Don't get upset!");

        imageNewScore.setFont(new java.awt.Font("Sitka Display", 0, 24)); // NOI18N
        imageNewScore.setForeground(new java.awt.Color(255, 255, 255));

        jButtonBackToMenu.setBackground(new java.awt.Color(255, 0, 102));
        jButtonBackToMenu.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        jButtonBackToMenu.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBackToMenu.setText("Back to menu");
        jButtonBackToMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackToMenuMouseClicked(evt);
            }
        });
        jButtonBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackToMenuActionPerformed(evt);
            }
        });

        JLabelNewScore1.setFont(new java.awt.Font("Sitka Display", 0, 20)); // NOI18N
        JLabelNewScore1.setForeground(new java.awt.Color(255, 255, 255));
        JLabelNewScore1.setText("Go back to menu and try again!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(JLabelNewScore1)
                                .addGap(0, 80, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imageNewScore, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jButtonBackToMenu)
                                                        .addGap(136, 136, 136))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(JLabelNewScore, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabelCongratulations))
                                                        .addGap(117, 117, 117)))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabelCongratulations, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JLabelNewScore, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLabelNewScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(imageNewScore, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>

    private void jLabelСloseMouseClickedMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void jLabelMinMouseClickedMouseClicked(java.awt.event.MouseEvent evt) {
        this.setState(Main_window.ICONIFIED);
    }

    private void jButtonBackToMenuMouseClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
        clip.close();
        Main_window main_window = new Main_window();
        main_window.setLocationRelativeTo(null);
        main_window.setVisible(true);
        main_window.playMusic();
    }

    private void jButtonBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Lose_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lose_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lose_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lose_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lose_window().setVisible(true);
            }
        });
    }

    public void playMusic() {
        try {
            File soundFile = new File("D:/tetris_info/lose.wav");

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

            clip = AudioSystem.getClip();

            clip.open(ais);

            clip.setFramePosition(0);

            clip.start();

        } catch (IOException exc) {
            exc.printStackTrace();
        } catch (UnsupportedAudioFileException exc) {
            exc.printStackTrace();
        } catch (LineUnavailableException exc) {
            exc.printStackTrace();
        }

    }

    // Variables declaration - do not modify
    private javax.swing.JLabel JLabelNewScore;
    private javax.swing.JLabel JLabelNewScore1;
    private javax.swing.JLabel imageNewScore;
    private javax.swing.JButton jButtonBackToMenu;
    private javax.swing.JLabel jLabelCongratulations;
    private javax.swing.JLabel jLabelMinMouseClicked;
    private javax.swing.JLabel jLabelTetris;
    private javax.swing.JLabel jLabelСloseMouseClicked;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration
}