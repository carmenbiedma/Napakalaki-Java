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
public class Monster {
    
    private String name;
    private int combatLevel;
    private Prize buenRollo;
    private BadConsequence malRollo;
    private int levelChangeAgainstCultistplayer;
    
    public Monster(String nombre, int lvl, BadConsequence bc, Prize price){
        name=nombre;
        combatLevel=lvl;
        buenRollo=price;
        malRollo=bc;
        levelChangeAgainstCultistplayer=0;
    }
    
    public Monster(String nombre, int lvl, BadConsequence bc, Prize price, int IC){
        name=nombre;
        combatLevel=lvl;
        buenRollo=price;
        malRollo=bc;
        levelChangeAgainstCultistplayer=IC;
    }
      
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public Prize getbuenRollo(){
        return buenRollo;
    }
    
    public BadConsequence getmalRollo(){
        return malRollo;
    }
    
    public int getLevelsGained(){
        return buenRollo.getLevel();
    }
    
    public int getTreasuresGained(){
        return buenRollo.getLevel();
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return getCombatLevel()+levelChangeAgainstCultistplayer;
    }
     public String toString(){
        return "Nombre = " + name + " ,nivel de combate = " + Integer.toString(combatLevel) + " , buen rollo: " + buenRollo + " , mal rollo: " + malRollo;
    }
    
}
