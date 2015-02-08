/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Cultist;

/**
 *
 */

public class CultistView extends javax.swing.JPanel {

    
    Cultist cultistModel;
    
    public CultistView() {
        initComponents();
    }

    public void setCultist (Cultist c){
    
        cultistModel = c;
        
        name.setText(cultistModel.getName());
        level.setText(Integer.toString(cultistModel.getBasicValue()));
        
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

        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();

        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setMaximumSize(new java.awt.Dimension(88, 18));
        setMinimumSize(new java.awt.Dimension(88, 18));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(88, 18));
        setLayout(null);

        name.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(204, 204, 204));
        name.setMaximumSize(new java.awt.Dimension(70, 18));
        name.setMinimumSize(new java.awt.Dimension(70, 18));
        name.setPreferredSize(new java.awt.Dimension(70, 18));
        add(name);
        name.setBounds(0, 0, 70, 18);

        level.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        level.setForeground(new java.awt.Color(204, 204, 204));
        level.setMaximumSize(new java.awt.Dimension(18, 18));
        level.setMinimumSize(new java.awt.Dimension(18, 18));
        level.setPreferredSize(new java.awt.Dimension(18, 18));
        add(level);
        level.setBounds(70, 0, 18, 18);
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel level;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}