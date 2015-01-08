/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 *
 */
public class PlayerNamesCapture extends javax.swing.JDialog {

    ArrayList<String> names = new ArrayList();
    int numJugador;
    
    
    public PlayerNamesCapture(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        
        numJugador = 1;
        
        this.addWindowListener (new WindowAdapter() {
            
            @Override
            public void windowClosing (WindowEvent e) {
                
                System.exit(0);
            }
        });
        
        TextPlayer.setText("Jugador " + numJugador + ":");
        
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextPlayer1 = new javax.swing.JLabel();
        TextPlayer = new javax.swing.JLabel();
        SetName = new javax.swing.JTextField();
        PlayButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        aniade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TextPlayer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TextPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextPlayer1.setText("NAPAKALAKI");

        TextPlayer.setText("Jugador ");

        SetName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetNameActionPerformed(evt);
            }
        });

        PlayButton.setText("Play");
        PlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        aniade.setText("Añadir Jugador");
        aniade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aniadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PlayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPlayer))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SetName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aniade)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelButton)
                        .addGap(102, 102, 102))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextPlayer1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPlayer)
                    .addComponent(SetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aniade))
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlayButton)
                    .addComponent(CancelButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButtonActionPerformed

        if (names.size() > 0)
            
            this.dispose();

    }//GEN-LAST:event_PlayButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SetNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SetNameActionPerformed

    private void aniadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aniadeActionPerformed
        
        if (SetName.getText().length() > 0) {
            
            names.add (SetName.getText());

            numJugador++;

            TextPlayer.setText("Jugador "+ numJugador + ":");

            SetName.setText("");

            repaint();
        }
    }//GEN-LAST:event_aniadeActionPerformed

    public ArrayList<String> getNames(){
        
        this.setVisible(true);
        return names;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton PlayButton;
    private javax.swing.JTextField SetName;
    private javax.swing.JLabel TextPlayer;
    private javax.swing.JLabel TextPlayer1;
    private javax.swing.JButton aniade;
    // End of variables declaration//GEN-END:variables
}
