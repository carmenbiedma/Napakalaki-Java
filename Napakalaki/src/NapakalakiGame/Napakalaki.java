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
public class Napakalaki {
    
    private static final Napakalaki instance=new Napakalaki();
    private Monster currentMonster;
    private CardDealer dealer= CardDealer.getInstance();
    private Player currentPlayer;
    private ArrayList<Player> players= new ArrayList();
    
    
    public Napakalaki(){    }
    
    private void initPlayers(ArrayList<String> names){
        
        for(int i=0; i<names.size();i++){
            players.add(new Player (names.get(i)));
            
        }
        
    }
    
    private Player nextPlayer(){
        
        int turno;
        
        if(currentPlayer==null )
               turno=0;
        else{
            if(players.indexOf(currentPlayer)== (players.size()-1))
                turno=0;
            else{
                    turno=players.indexOf(currentPlayer);
                    turno++;
            }
        }
        return players.get(turno);
    } 
    
    private boolean nextTurnIsAllowed(){
        if(currentPlayer==null)
            return true;
        else
            return currentPlayer.validState();
    }
    
    private void setEnemies(){
        int jug;
        
        for(int i=0;i<players.size();i++){
            
            
            do {
                jug= (int) (Math.random()* (players.size()));
            }
            while(jug==i);
       
            players.get(i).setEnemy(players.get(jug));
        }
        
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
       CombatResult cr=currentPlayer.combat(currentMonster);       
       dealer.giveMonsterBack(currentMonster);
       if(cr==CombatResult.LOSEANDCONVERT){
           Cultist c= dealer.nextCultist();
           players.remove(currentPlayer);
           currentPlayer= new CultistPlayer(currentPlayer,c);
           players.add(currentPlayer);
       
        }
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
        boolean stateOK=this.nextTurnIsAllowed();
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
