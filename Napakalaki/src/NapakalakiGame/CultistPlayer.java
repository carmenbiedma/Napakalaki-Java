/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

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
            
    protected int getCombatLevel(){
        
        int l;
        l=super.getCombatLevel()+ (super.getCombatLevel()*20)/100 + myCultistCard.getGainedLevels()*totalCultistPlayers;       
                
        return l;
    }   
    
    @Override
            
    protected int getOponentLevel(Monster m){
        return m.getcombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    
    protected Treasure giveMeATreasure(){
        Random r = new Random();
        ArrayList<Treasure> vt = super.getVisibleTreasures();
        int index = r.nextInt()*vt.size();
        return vt.get(index);
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return !super.getEnemy().getVisibleTreasures().isEmpty();
    
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
}
