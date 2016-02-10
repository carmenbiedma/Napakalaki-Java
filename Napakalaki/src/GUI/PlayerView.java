/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Evelyn
 */
public class PlayerView extends javax.swing.JPanel {
    
    Player playerModel;
    private Napakalaki napakalakiModel;
    NapakalakiView napakalakiView;

    

    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
    // Se elimina la información antigua, si la hubiera
    aPanel.removeAll();
    // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
    // al panel
    for (Treasure t : aList) {
        TreasureView aTreasureView = new TreasureView();
        aTreasureView.setTreasure (t);
        aTreasureView.setVisible (true);
        aPanel.add (aTreasureView);
    }
    // Se fuerza la actualización visual del panel
    aPanel.repaint();
    aPanel.revalidate();
    }
    
    
    
       public void setPlayer (Player p, NapakalakiView npView) {
            napakalakiView = npView;
            if(p!=null){
                playerModel = p;
                this.name2.setText ("Nombre: " + p.getName());
                this.enemy.setText ("Enemigo: " +p.getEnemy().toString());
                this.level.setText ("Nivel: " +Integer.toString(p.getLevels()));
                this.combatLevel.setText ("Nivel de combate: " +Integer.toString(p.getCombatLevel()));

                if (p instanceof CultistPlayer)
                    sectario.setText("Este jugador es un sectario");
                else 
                    sectario.setText("");

                if(p.getBadConsequence()!=null){
                    pendingBadConsequenceView1.setPendingBadConsequence(playerModel.getBadConsequence());
                    pendingBadConsequenceView1.setVisible(true);
                }
                else
                    pendingBadConsequenceView1.setVisible(false);




                this.fillTreasurePanel(visibleTreasures,playerModel.getVisibleTreasures());
                this.fillTreasurePanel(hiddenTreasures,playerModel.getHiddenTreasures());

                 if(playerModel.getHiddenTreasures().isEmpty() && playerModel.getVisibleTreasures().isEmpty()){
                    discardTreasures.setEnabled(false);
                    discardAllTreasure.setEnabled(false);
                } else{
                    discardTreasures.setEnabled(true);
                    discardAllTreasure.setEnabled(true);
                }

                makeVisible.setEnabled(!playerModel.getHiddenTreasures().isEmpty());

                stealTreasure.setEnabled(playerModel.canISteal());


                repaint();
                revalidate();
            }
       
       }
       
       public void setNapakalakiModel(Napakalaki n){
           napakalakiModel=n;
       }
       
       public void update(){
        setPlayer(playerModel, napakalakiView);
        repaint();
       }
    
       public GUI.PendingBadConsequenceView getPBadConsequenceView() {
        return pendingBadConsequenceView1;
       }
    
        public void setBotonRobar(boolean estado){
            if(estado == true && playerModel.canISteal())
               stealTreasure.setEnabled(true);
            else
                stealTreasure.setEnabled(false);
        }

        public void setBotonesDescartar(boolean estado){
            discardTreasures.setEnabled(estado);
            discardAllTreasure.setEnabled(estado);
        }

        public void setBotonMakeVisible(boolean estado){
            makeVisible.setEnabled(estado);
        }

       private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {

        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
        }
        return output;
    }
       
       private ArrayList<Treasure> getAllTreasures(JPanel aPanel){
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            output.add(tv.getTreasure());
        }
        return output;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        makeVisible = new javax.swing.JButton();
        discardTreasures = new javax.swing.JButton();
        discardAllTreasure = new javax.swing.JButton();
        pendingBadConsequenceView1 = new GUI.PendingBadConsequenceView();
        sectario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        stealTreasure = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        visibleTreasures.setBackground(new java.awt.Color(255, 255, 255));
        visibleTreasures.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 255), 3, true));

        hiddenTreasures.setBackground(new java.awt.Color(255, 255, 255));
        hiddenTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 3));

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setForeground(new java.awt.Color(255, 255, 255));

        level.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        enemy.setBackground(new java.awt.Color(255, 255, 255));
        enemy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        makeVisible.setText("Make Visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discardTreasures.setText("Discard Treasures");
        discardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresActionPerformed(evt);
            }
        });

        discardAllTreasure.setText("Discard all treasures");
        discardAllTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllTreasureActionPerformed(evt);
            }
        });

        pendingBadConsequenceView1.setBackground(new java.awt.Color(255, 255, 255));
        pendingBadConsequenceView1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pending Bad Consequence");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("PLAYER");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Hidden Treasures");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Visible Treasures");

        stealTreasure.setText("Steal Treasure");
        stealTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealTreasureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(combatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enemy, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(68, 68, 68)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(stealTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(discardTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(discardAllTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sectario))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(name2)
                            .addGap(291, 291, 291)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(241, 241, 241))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sectario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(combatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(name2)))
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enemy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stealTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discardTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discardAllTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        napakalakiModel.makeTreasuresVisible (selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer(),napakalakiView);
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void discardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        napakalakiModel.discardHiddenTreasures(selHidden);
        napakalakiModel.discardVisibleTreasures(selVisible);
        setPlayer(napakalakiModel.getCurrentPlayer(), napakalakiView);
        napakalakiView.update();
        pendingBadConsequenceView1.setPendingBadConsequence(playerModel.getBadConsequence());
    }//GEN-LAST:event_discardTreasuresActionPerformed

    private void stealTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealTreasureActionPerformed
        Treasure aTreasure = napakalakiModel.getCurrentPlayer().stealTreasure();
        if(aTreasure == null){
            JOptionPane.showMessageDialog(null, "No has podido robar nada!");
        } else{
            JOptionPane.showMessageDialog(null, "Has robado un tesoro!");
        }
        setPlayer(napakalakiModel.getCurrentPlayer(), napakalakiView);
        stealTreasure.setEnabled(false);
    }//GEN-LAST:event_stealTreasureActionPerformed

    private void discardAllTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllTreasureActionPerformed
         ArrayList<Treasure> selHidden = getAllTreasures(hiddenTreasures);
         ArrayList<Treasure> selVisible = getAllTreasures(visibleTreasures);
        napakalakiModel.discardHiddenTreasures(selHidden);
        napakalakiModel.discardVisibleTreasures(selVisible);
        setPlayer(napakalakiModel.getCurrentPlayer(),napakalakiView);
        pendingBadConsequenceView1.setPendingBadConsequence(playerModel.getBadConsequence());
    }//GEN-LAST:event_discardAllTreasureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel combatLevel;
    private javax.swing.JButton discardAllTreasure;
    private javax.swing.JButton discardTreasures;
    private javax.swing.JLabel enemy;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel level;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name2;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView1;
    private javax.swing.JLabel sectario;
    private javax.swing.JButton stealTreasure;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
