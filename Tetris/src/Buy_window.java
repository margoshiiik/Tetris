/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author annet
 */
public class Buy_window extends javax.swing.JFrame {

    private int themePurchased = 1;
    private int price = 0;

    Main_window main;

    /**
     * Creates new form Buy_window
     */
    public Buy_window() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabelCongratulations = new javax.swing.JLabel();
        jLabelCongratulations1 = new javax.swing.JLabel();
        jButtonBuyTheme = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(16, 16, 106));

        jLabelCongratulations.setFont(new java.awt.Font("Sitka Display", 0, 22)); // NOI18N
        jLabelCongratulations.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCongratulations.setText("Are you sure you want");

        jLabelCongratulations1.setFont(new java.awt.Font("Sitka Display", 0, 22)); // NOI18N
        jLabelCongratulations1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCongratulations1.setText(" to buy this theme?");

        jButtonBuyTheme.setBackground(new java.awt.Color(255, 0, 102));
        jButtonBuyTheme.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        jButtonBuyTheme.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuyTheme.setText("OK");
        jButtonBuyTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBuyThemeMouseClicked(evt);
            }
        });
        jButtonBuyTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyThemeActionPerformed(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(255, 0, 102));
        jButtonCancel.setFont(new java.awt.Font("Sitka Display", 0, 18)); // NOI18N
        jButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setText("Cancel");
        jButtonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelMouseClicked(evt);
            }
        });
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jButtonBuyTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelCongratulations1)
                                .addGap(113, 113, 113))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCongratulations)
                                .addGap(91, 91, 91))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabelCongratulations)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCongratulations1)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonBuyTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(143, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(10, 10, 74));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 74, Short.MAX_VALUE)
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

    private void jButtonBuyThemeMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here://
    }


    private void jButtonBuyThemeActionPerformed(java.awt.event.ActionEvent evt) {
        saveTheme();
        File newFile = new File(setFilePath());
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(newFile))) {
            writter.write("true");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int newBalance = getCurrentBalance()-price;
        String stringBalance = String.valueOf(newBalance);
        main.setNewBalance(stringBalance);
        File fileBalance = new File("D:/tetris_info/HowManyCrystals.txt");
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileBalance))) {
            writter.write(stringBalance);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dispose();
        Shop_window shopWindow = new Shop_window();
        shopWindow.setMainWindow(main);
        shopWindow.setVisible(true);
        shopWindow.pack();
        shopWindow.setLocationRelativeTo(null);
    }

    public void setTheme(int theme){
        themePurchased = theme;
    }

    private String setFilePath(){
        String filePath = "";
        if(themePurchased==2){
            filePath = "D:/tetris_info/Cloudy state.txt";
            price = 10;
        }
        if(themePurchased==3){
            filePath = "D:/tetris_info/Flowery state.txt";
            price = 20;
        }
        if(themePurchased==4){
            filePath = "D:/tetris_info/Space state.txt";
            price = 30;
        }
        if(themePurchased==5){
            filePath = "D:/tetris_info/Eden state.txt";
            price = 40;
        }
        return filePath;
    }

    private void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        Shop_window shopWindow = new Shop_window();
        shopWindow.setMainWindow(main);
        shopWindow.setVisible(true);
        shopWindow.pack();
        shopWindow.setLocationRelativeTo(null);
    }

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private int getCurrentBalance(){
        String currentBalance = "";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("D:/tetris_info/HowManyCrystals.txt"))) {
            currentBalance = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int intCurrentBalance = Integer.valueOf(currentBalance);
        return intCurrentBalance;
    }

    public void setMainWindow(Main_window main){
        this.main = main;
    }

    private void saveTheme(){
        File newFile = new File("D:/tetris_info/Current theme.txt");
        String currentTheme = String.valueOf(themePurchased);
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(newFile))) {
            writter.write(currentTheme);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(Buy_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buy_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buy_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buy_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buy_window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonBuyTheme;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabelCongratulations;
    private javax.swing.JLabel jLabelCongratulations1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration
}
