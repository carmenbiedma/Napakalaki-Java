/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.BadConsequence;

/**
 *
 * @author Carmen Biedma
 */
public class PendingBadConsequenceView extends javax.swing.JPanel {

    private static BadConsequence pendingBadConsequenceModel;
    /**
     * Creates new form PendingBadConsequenceView
     */
    public PendingBadConsequenceView() {
        initComponents();
        
        
    }
    
    public void setPendingBadConsequence (BadConsequence bc) {
            if( pbc != null){
            pendingBadConsequenceModel = bc;
            this.pbc.setText (pendingBadConsequenceModel.getText());
            }
            
        repaint();
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequenceModel;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pbc = new javax.swing.JLabel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pbc, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pbc, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel pbc;
    // End of variables declaration//GEN-END:variables
}
