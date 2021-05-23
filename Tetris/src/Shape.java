/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author annet
 */
public class Main_window extends javax.swing.JFrame {

    private int maximumScoreInt;

    private Clip clip;

    /**
     * Creates new form Test_JFrame
     */
    public Main_window() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        BufferedImage crystal = null;
        crystal = ImageLoader.loadImage("crystal.png");

        jPanel1 = new javax.swing.JPanel();
        jLabelСloseMouseClicked = new javax.swing.JLabel();
        jLabelMinMouseClicked = new javax.swing.JLabel();
        jLabelTetris = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelMaximumScore = new javax.swing.JLabel();
        maximumScore = new javax.swing.JLabel();
        maximumScore1 = new javax.swing.JLabel(new ImageIcon(crystal));
        maximumScore2 = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jButtonSpeed = new javax.swing.JButton();
        jButtonShop = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 155, 203));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(204, 204, 255));
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

        jPanel2.setBackground(new java.awt.Color(16, 16, 106));

        jLabelMaximumScore.setFont(new java.awt.Font("Sitka Display", 0, 24)); // NOI18N
        jLabelMaximumScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaximumScore.setText("Maximum score : ");

        maximumScore.setFont(new java.awt.Font("Sitka Display", 0, 28)); // NOI18N
        maximumScore.setForeground(new java.awt.Color(255, 255, 255));
        maximumScore.setText(getCurrentMaximumScore());



        maximumScore1.setFont(new java.awt.Font("Sitka Display", 0, 20)); // NOI18N
        maximumScore1.setForeground(new java.awt.Color(255, 255, 255));



        maximumScore2.setFont(new java.awt.Font("Sitka Display", 0, 28)); // NOI18N
        maximumScore2.setForeground(new java.awt.Color(255, 255, 255));
        maximumScore2.setText(getCrystals());

        jButtonStart.setBackground(new java.awt.Color(255, 0, 102));
        jButtonStart.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        jButtonStart.setForeground(new java.awt.Color(255, 255, 255));
        jButtonStart.setText("Start game");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonSpeed.setBackground(new java.awt.Color(255, 0, 102));
        jButtonSpeed.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        jButtonSpeed.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSpeed.setText("Speed");
        jButtonSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSpeedActionPerformed(evt);
            }
        });

        jButtonShop.setBackground(new java.awt.Color(255, 0, 102));
        jButtonShop.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        jButtonShop.setForeground(new java.awt.Color(255, 255, 255));
        jButtonShop.setText("Shop");
        jButtonShop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShopActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Click here to watch instructions");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(178, 178, 178)
                                                .addComponent(maximumScore1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(maximumScore2))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelMaximumScore)
                                                        .addComponent(jButtonSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonShop, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(maximumScore)))
                                .addContainerGap(102, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(81, 81, 81))

        );


        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMaximumScore)
                                        .addComponent(maximumScore))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(maximumScore1)
                                        .addComponent(maximumScore2))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButtonSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonShop, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addContainerGap(27, Short.MAX_VALUE))
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

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {


        JFrame forGame = new JFrame();
        Game_window game = new Game_window(forGame);
        forGame.setSize(520,640);
        game.setSize(445, 629);
        game.setCurrentScore(Integer.valueOf(maximumScore.getText()));
        forGame.addMouseMotionListener(game);
        forGame.setTitle("Play your best!");
        forGame.addMouseListener(game);
        forGame.addKeyListener(game);
        forGame.add(game);
        forGame.isUndecorated();
        forGame.setVisible(true);
        forGame.setLocationRelativeTo(null);
        this.setVisible(false);
        game.setVisible(true);
        game.startGame();


    }

    private void jButtonSpeedActionPerformed(java.awt.event.ActionEvent evt) {
        Speed_window speedWindow = new Speed_window();
        speedWindow.setVisible(true);
        speedWindow.pack();
        speedWindow.setLocationRelativeTo(null);
    }

    private void jButtonShopActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        Instruction_window instructionWindow = new Instruction_window();
        instructionWindow.setVisible(true);
        instructionWindow.pack();
        instructionWindow.setLocationRelativeTo(null);

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
            java.util.logging.Logger.getLogger(Main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_window().setVisible(true);
            }
        });
    }

    public JLabel getMaximumScore() {
        return maximumScore;
    }

    public void setMaximumScore(String s) {
        maximumScore.setText(s);
    }

    private String getCurrentMaximumScore() {
        String maximum = "";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("D:/tetris_info/Score.txt"))) {
            maximum = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maximum;
    }

    private String getCrystals() {
        String cr = "";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("D:/tetris_info/HowManyCrystals.txt"))) {
            cr = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cr;
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButtonShop;
    private javax.swing.JButton jButtonSpeed;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMaximumScore;
    private javax.swing.JLabel jLabelMinMouseClicked;
    private javax.swing.JLabel jLabelTetris;
    private javax.swing.JLabel jLabelСloseMouseClicked;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel maximumScore;
    private javax.swing.JLabel maximumScore1;
    private javax.swing.JLabel maximumScore2;
    // End of variables declaration
}
