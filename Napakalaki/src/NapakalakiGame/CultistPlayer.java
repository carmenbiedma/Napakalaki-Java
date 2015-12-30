/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Carmen Biedma
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers=0;
    private Cultist  myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        
        super(p);
        totalCultistPlayers++;
        myCultistCard=c;
    }
    
    @Override
            
    int getCombatLevel(){
        
        int l;
        l=getCombatLevel()+ (getCombatLevel()*20)/100 + myCultistCard.getGainedLevels()*totalCultistPlayers;       
                
        return l;
    }   
    
    @Override
            
    int getOponentLevel(Monster m){
        return m.getcombatLevelAgainstCultistPlayer();
    }
    @Override
    boolean shouldConvert(){
        return false;
    }
    
    @Override
    
    public Treasure giveMeATreasure(){
        return null;
    }
    
    private boolean canYouGiveMeATreasure(){
        return true;
    
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
}
