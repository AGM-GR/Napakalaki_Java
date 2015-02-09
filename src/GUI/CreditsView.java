package GUI;

import javax.swing.ImageIcon;

public class CreditsView extends javax.swing.JFrame {

    
    public CreditsView() {
        
        initComponents();
    }
    
    public void setCreditsView(){
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/BlackBackground.jpg"));
        icon.getImage().flush();
        Background.setIcon(icon);
        Background.setVisible(true);
        repaint();
    }
    
    public void showView(){
        
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imp = new javax.swing.JLabel();
        al = new javax.swing.JLabel();
        ja = new javax.swing.JLabel();
        bso = new javax.swing.JLabel();
        lu = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(462, 337));
        setMinimumSize(new java.awt.Dimension(462, 337));
        setPreferredSize(new java.awt.Dimension(462, 337));
        setResizable(false);
        getContentPane().setLayout(null);

        imp.setBackground(new java.awt.Color(0, 0, 0));
        imp.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        imp.setForeground(new java.awt.Color(255, 255, 255));
        imp.setText("Implementación:");
        getContentPane().add(imp);
        imp.setBounds(130, 30, 220, 30);

        al.setBackground(new java.awt.Color(0, 0, 0));
        al.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        al.setForeground(new java.awt.Color(255, 255, 255));
        al.setText("Alejandro Guerrero Martínez");
        getContentPane().add(al);
        al.setBounds(120, 70, 230, 22);

        ja.setBackground(new java.awt.Color(0, 0, 0));
        ja.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ja.setForeground(new java.awt.Color(255, 255, 255));
        ja.setText("Javier León Palomares");
        getContentPane().add(ja);
        ja.setBounds(140, 100, 190, 22);

        bso.setBackground(new java.awt.Color(0, 0, 0));
        bso.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        bso.setForeground(new java.awt.Color(255, 255, 255));
        bso.setText("Banda sonora:");
        getContentPane().add(bso);
        bso.setBounds(140, 160, 190, 30);

        lu.setBackground(new java.awt.Color(0, 0, 0));
        lu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lu.setForeground(new java.awt.Color(255, 255, 255));
        lu.setText("Luis Sánchez Velasco");
        getContentPane().add(lu);
        lu.setBounds(140, 210, 175, 22);

        close.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        close.setText("Salir");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(140, 270, 181, 25);

        Background.setBackground(new java.awt.Color(1, 1, 1));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/BlackBackground.jpg"))); // NOI18N
        Background.setMaximumSize(new java.awt.Dimension(462, 337));
        Background.setMinimumSize(new java.awt.Dimension(462, 337));
        Background.setPreferredSize(new java.awt.Dimension(462, 337));
        getContentPane().add(Background);
        Background.setBounds(0, 0, 460, 340);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_closeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel al;
    private javax.swing.JLabel bso;
    private javax.swing.JButton close;
    private javax.swing.JLabel imp;
    private javax.swing.JLabel ja;
    private javax.swing.JLabel lu;
    // End of variables declaration//GEN-END:variables
}
