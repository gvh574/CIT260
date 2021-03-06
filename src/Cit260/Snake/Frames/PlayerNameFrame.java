/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cit260.Snake.Frames;

import Cit260.Snake.Controls.highscore.HighScoreManager;


/**
 *
 * @author Kevin
 */
public class PlayerNameFrame extends javax.swing.JFrame {
    private HighScoreManager hm;

    /**
     * Creates new form PlayerNameFrame
     */
    public PlayerNameFrame() {
        initComponents();

    }

    public void setHm(HighScoreManager hm) {
        this.hm = hm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpForm = new javax.swing.JPanel();
        playerName = new javax.swing.JTextField();
        labelPlayerName = new javax.swing.JLabel();
        buttonSubmitPlayer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jpForm.setBackground(new java.awt.Color(0, 0, 0));

        playerName.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        playerName.setForeground(new java.awt.Color(102, 102, 102));
        playerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });

        labelPlayerName.setFont(new java.awt.Font("SnakeStitch", 0, 14)); // NOI18N
        labelPlayerName.setForeground(new java.awt.Color(255, 255, 255));
        labelPlayerName.setLabelFor(playerName);
        labelPlayerName.setText("Enter Your Name");

        buttonSubmitPlayer.setText("Submit");
        buttonSubmitPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jpFormLayout = new org.jdesktop.layout.GroupLayout(jpForm);
        jpForm.setLayout(jpFormLayout);
        jpFormLayout.setHorizontalGroup(
            jpFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpFormLayout.createSequentialGroup()
                .addContainerGap()
                .add(playerName)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpFormLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(buttonSubmitPlayer)
                .add(152, 152, 152))
            .add(jpFormLayout.createSequentialGroup()
                .add(100, 100, 100)
                .add(labelPlayerName)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jpFormLayout.setVerticalGroup(
            jpFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpFormLayout.createSequentialGroup()
                .add(19, 19, 19)
                .add(labelPlayerName)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(playerName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(buttonSubmitPlayer)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpForm, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jpForm, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        hm.newHighScore(this.playerName.getText());
        this.dispose();
    }//GEN-LAST:event_textFieldActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        hm.newHighScore(this.playerName.getText());
        this.dispose();
    }//GEN-LAST:event_submitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSubmitPlayer;
    private javax.swing.JPanel jpForm;
    private javax.swing.JLabel labelPlayerName;
    private javax.swing.JTextField playerName;
    // End of variables declaration//GEN-END:variables
}
