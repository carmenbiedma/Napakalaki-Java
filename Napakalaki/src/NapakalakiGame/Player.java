/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Carmen Biedma
 */
public class Player {
    
    static final int MAXLEVEL=10;
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private  Player enemy;
    private ArrayList<Treasure> visibleTreasures= new ArrayList();
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures=new ArrayList();
    
    
    public Player(String nombre){
        name=nombre;
        dead=true; 
        canISteal=true;
    }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        dead=false;
    }
    
    private int getCombatLevel(){
        int v=0,h=0,nivel_total=0;
        for(int i=0;i<visibleTreasures.size();i++){
            v=v+visibleTreasures.get(i).getBonus();
            h=h+hiddenTreasures.get(i).getBonus();
        }
        
        nivel_total=level+v+h;
        return nivel_total;
        
    }
    
    private void incrementLevels(int i){
        
        level=level+i;
        
    }
    
    private void decrementLevels(int i){
        
        level=level-i;
        
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence=b;
    }
    
    private void applyPrize(Monster m){
        
        CardDealer dealer;
        int nlevels=m.getLevelsGained();
        this.incrementLevels(nlevels);
        int ntreasures=m.getTreasuresGained();
        
        if(ntreasures>0){
            dealer=CardDealer.getInstance();
        }
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean puede=true;
        int j=0;
        
        for(int i=0;i<hiddenTreasures.size() && puede==true ;i++){
            if(hiddenTreasures.get(i).getType()==t.getType() )
                if(t.getType()==TreasureKind.onehand)
                    j++;
                else
                    puede=false;
            if(j==2)
                puede=false;
        }
        
        return puede;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int vtt=0;
        
        for(int i=0;i<visibleTreasures.size();i++){
            if(visibleTreasures.get(i).getType()==tKind)    
                vtt++;
        }
        
        return vtt;
        
    }
    
    private void dieIfNoTreasures(){
        
        if(visibleTreasures.size()==0 && hiddenTreasures.size()==0)
            dead=true;
        
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        CombatResult cr;
        int myLevel=getCombatLevel();
        int monsterLevel=m.getCombatLevel();
        
        if(myLevel>monsterLevel){
            this.applyPrize(m);
            if(level>=MAXLEVEL)
                cr=CombatResult.WINGAME;
            else
                cr=CombatResult.WIN;
                
        }
        else{
            this.applyBadConsequence(m);
            cr=CombatResult.LOSE;
        }
        return cr;
    }
    
    public void makeTreasureVisible(Treasure t){
        
            boolean canI=canMakeTreasureVisible(t);
            
            if(canI){
                visibleTreasures.add(t);
                hiddenTreasures.remove(t);
            }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        
        dieIfNoTreasures();
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
        hiddenTreasures.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        
        dieIfNoTreasures();
        
    }
    
    public boolean validState(){
        boolean state=false;
        
        if(pendingBadConsequence==null || pendingBadConsequence.isEmpty() && hiddenTreasures.size()<=4 )
               state=true;
        
        return state;
    }
    
    public void initTreasures(){
        CardDealer dealer=CardDealer.getInstance();
        Dice dice=Dice.getInstance();
        Treasure treasure;
        int number;
        
        this.bringToLife();
        treasure=dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        number=dice.nextNumber();
        
        if(number>1){
            treasure=dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if(number==6){
            treasure=dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
       Treasure treasure=null;   
       boolean canYou;
       boolean canI=this.canISteal;
       
       if(canI){
           canYou=enemy.canYouGiveMeATreasure();
           if(canYou){
               treasure=enemy.giveMeATreasure();
               hiddenTreasures.add(treasure);
               this.haveStolen();
                
           }
       }
        return treasure;
    }
    
    public void setEnemy(Player enem){
        enemy=enem;
        
    }
    
    private Treasure giveMeATreasure(){
        int i=(int) (Math.random()*hiddenTreasures.size())-1;
        return hiddenTreasures.get(i);
    }
    
    public boolean canISteal(){
        if(this.canISteal==true){
            return true;
        }else
            return false;
    }
    
    private boolean canYouGiveMeATreasure(){
        if(this.visibleTreasures.size()>0){
            return true;
        } else 
            return false;
    }
    
    private void haveStolen(){
        this.canISteal=false;
    }
    
    public void discardAllTreasures(){
        Treasure treasure;
        
        for(Treasure t: visibleTreasures ){
            this.discardVisibleTreasure(t);
        }
        
        for(Treasure t: hiddenTreasures){
            this.discardHiddenTreasure(t);
            
        }
        
    }
    
     public String toString(){
        return "Jugador = " + name;
    }
        
}
