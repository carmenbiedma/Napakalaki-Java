/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Carmen Biedma
 */
public class Napakalaki {
    
    private static final Napakalaki instance=new Napakalaki();
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    private ArrayList<Player> players= new ArrayList();
    
    
    private Napakalaki(){    }
    
    private void initPlayers(ArrayList<String> names){
        
        for(int i=0; i<players.size();i++){
            players.add(new Player (names.get(i)));
            
        }
        
    }
    
    private Player nextPlayer(){
        
        int turno,i=0;
        
        if(currentPlayer==null)
               turno=0;
        else
            if(currentPlayer==players.get(players.size()-1))
                turno=0;
            else
                    while(i<players.size()-1 && players.get(i)!=currentPlayer)
                        i++;
                    turno=i+1;
        return players.get(turno);
    } 
    
    private boolean nextTurnIsAllowed(){
        return currentPlayer.validState();
    }
    
    private void setEnemies(){
        int jug;
        for(int i=0;i<players.size();i++){
            jug= (int) (Math.random()* (players.size()-1));
            if(jug==i)
                i--;
            else 
                players.get(i).setEnemy(players.get(jug));
        }
        
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
       CombatResult cr=currentPlayer.combat(currentMonster);       
       dealer.giveMonsterBack(currentMonster);
        return cr;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
            
        }
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
            for(Treasure t: treasures){
                currentPlayer.discardHiddenTreasure(t);
                dealer.giveTreasureBack(t);
            
        }
        
    }   
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
            
            Treasure t;
            
            for(int i=0;i<treasures.size();i++){
                t=treasures.get(i+1);
                currentPlayer.makeTreasureVisible(t);                     
                
            }
        
    }
    
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        setEnemies();
        dealer.initCards();    
        nextTurn();
        
        
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
        
    }
    
    public boolean nextTurn(){
        boolean stateOK=nextTurnIsAllowed();
        boolean dead;
        if(stateOK){
            currentMonster=dealer.nextMonster();
            currentPlayer=nextPlayer();
            dead=currentPlayer.isDead();
            if(dead)
                currentPlayer.initTreasures();
        }
        
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        
        boolean end=false;
        if(result != CombatResult.WINGAME)
            end=true;
        return end;
                
    }
          
    
}
