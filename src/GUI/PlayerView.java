/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 */
public class PlayerView extends javax.swing.JPanel {

    
    Player playerModel;
    Napakalaki napakalakiModel;
    
    public PlayerView() {
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

        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BuyLevels = new javax.swing.JButton();
        MakeVisible = new javax.swing.JButton();
        DiscardTreasures = new javax.swing.JButton();
        ScrollVisible = new javax.swing.JScrollPane();
        visibletreasures = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hiddentreasures = new javax.swing.JPanel();

        jLabel6.setText("jLabel6");

        jButton4.setText("jButton4");

        jLabel1.setText("Name:");

        name.setText(" ");

        jLabel3.setText("Level:");

        level.setText(" ");

        jLabel5.setText("Visible Treasures:");

        jLabel7.setText("Hidden Treasures:");

        BuyLevels.setText("Buy Levels");
        BuyLevels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyLevelsActionPerformed(evt);
            }
        });

        MakeVisible.setText("Make Visible");
        MakeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeVisibleActionPerformed(evt);
            }
        });

        DiscardTreasures.setText("Discard Treasures");
        DiscardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscardTreasuresActionPerformed(evt);
            }
        });

        ScrollVisible.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ScrollVisible.setViewportView(visibletreasures);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(hiddentreasures);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BuyLevels)
                        .addGap(18, 18, 18)
                        .addComponent(MakeVisible)
                        .addGap(18, 18, 18)
                        .addComponent(DiscardTreasures))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(level)
                            .addComponent(name)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(level)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(ScrollVisible))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuyLevels)
                    .addComponent(MakeVisible)
                    .addComponent(DiscardTreasures))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuyLevelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyLevelsActionPerformed
        
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibletreasures);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddentreasures);
        
        napakalakiModel.buyLevels(selVisible,selHidden);
        
        setPlayer (napakalakiModel.getCurrentPlayer());
        
    }//GEN-LAST:event_BuyLevelsActionPerformed

    private void MakeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeVisibleActionPerformed

        
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddentreasures);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer());
        
    }//GEN-LAST:event_MakeVisibleActionPerformed

    private void DiscardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscardTreasuresActionPerformed
        
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibletreasures);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddentreasures);
        
        napakalakiModel.discardVisibleTreasures(selVisible);
        napakalakiModel.discardHiddenTreasures(selHidden);
        
        setPlayer (napakalakiModel.getCurrentPlayer());
        
    }//GEN-LAST:event_DiscardTreasuresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuyLevels;
    private javax.swing.JButton DiscardTreasures;
    private javax.swing.JButton MakeVisible;
    private javax.swing.JScrollPane ScrollVisible;
    private javax.swing.JPanel hiddentreasures;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel level;
    private javax.swing.JLabel name;
    private javax.swing.JPanel visibletreasures;
    // End of variables declaration//GEN-END:variables


    public void setPlayer(Player p){
        
        playerModel = p;
        
        name.setText(playerModel.getName());
        level.setText(Integer.toString(playerModel.getLevels()));
        fillTreasurePanel(visibletreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddentreasures, playerModel.getHiddenTreasures());
        
        repaint();
        revalidate();
    }

    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        
        Color color = new Color(000000);
        LineBorder Border = new LineBorder(color);
            
        for (Treasure t : aList) {
            
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aTreasureView.setBorder(Border);
            aPanel.add (aTreasureView);
        }
        
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    public void setNapakalaki (Napakalaki n) {
        
        napakalakiModel = n;
    }
    
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        
        for (Component c : aPanel.getComponents()) {
            
            tv = (TreasureView) c;
            if (tv.isSelected())
                
                output.add(tv.getTreasure());
        }

        return output;
    }
    
    public void setEnable(boolean enable) {
        
        BuyLevels.setEnabled(enable);
        MakeVisible.setEnabled(enable);
        DiscardTreasures.setEnabled(enable);
        
        repaint();
    }
}
