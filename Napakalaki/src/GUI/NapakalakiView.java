/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.CombatResult;
import NapakalakiGame.Napakalaki;

/**
 *
 * @author Carmen Biedma
 */
public class NapakalakiView extends javax.swing.JFrame {

    /**
     * Creates new form NapakalakiView
     */
    
    private Napakalaki napakalakiModel;
    
    public NapakalakiView() {
        initComponents();
    }
    
    public void setNapakalaki(Napakalaki np ){
        napakalakiModel=np;
        
        
        if(napakalakiModel.getCurrentMonster()!=null) 
            monsterView1.setMonster(np.getCurrentMonster());
        
        playerView1.setPlayer(np.getCurrentPlayer(),this);
        playerView1.setNapakalakiModel(np);
       
        
        botonMeetTheMonster.setEnabled(true);
        
        update();
        
        repaint();
    }

    public void update(){
        if(playerView1.getPBadConsequenceView().getPendingBadConsequence() != null && playerView1.getPBadConsequenceView().getPendingBadConsequence().isEmpty()){
            botonNextTurn.setEnabled(true);
        }
        playerView1.update();
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

        monsterView1 = new GUI.MonsterView();
        botonMeetTheMonster = new javax.swing.JButton();
        botonCombat = new javax.swing.JButton();
        botonNextTurn = new javax.swing.JButton();
        combatResult = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        playerView1 = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        monsterView1.setBackground(new java.awt.Color(255, 255, 255));

        botonMeetTheMonster.setText("Meet the Monster");
        botonMeetTheMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMeetTheMonsterActionPerformed(evt);
            }
        });

        botonCombat.setText("Combat");
        botonCombat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCombatActionPerformed(evt);
            }
        });

        botonNextTurn.setText("Next Turn");
        botonNextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNextTurnActionPerformed(evt);
            }
        });

        jLabel2.setText("Combat Result");

        playerView1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combatResult, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonMeetTheMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(botonCombat, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(botonNextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combatResult, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonCombat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonNextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(botonMeetTheMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMeetTheMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMeetTheMonsterActionPerformed
        monsterView1.setVisible(true);
        botonCombat.setEnabled(true);
        botonMeetTheMonster.setEnabled(false);
    }//GEN-LAST:event_botonMeetTheMonsterActionPerformed

    private void botonCombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCombatActionPerformed
         CombatResult cr = napakalakiModel.developCombat();
        combatResult.setText(cr.toString());
        setNapakalaki(napakalakiModel);
    }//GEN-LAST:event_botonCombatActionPerformed

    private void botonNextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNextTurnActionPerformed
        boolean success = napakalakiModel.nextTurn();
        if(success)
            setNapakalaki(napakalakiModel);
    }//GEN-LAST:event_botonNextTurnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCombat;
    private javax.swing.JButton botonMeetTheMonster;
    private javax.swing.JButton botonNextTurn;
    private javax.swing.JLabel combatResult;
    private javax.swing.JLabel jLabel2;
    private GUI.MonsterView monsterView1;
    private GUI.PlayerView playerView1;
    // End of variables declaration//GEN-END:variables
}
