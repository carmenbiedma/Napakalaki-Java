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
public abstract class BadConsequence {
   
    static final int MAXTREASURES = 10;
    
    private String text;
    private int levels;
    
    
    public BadConsequence(String txt,int lvls){
        
        text=txt;
        levels=lvls;
    }
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void  substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    public String toString(){
        
        String texto = text;
        texto += "\nNiveles que pierdes: " + levels;
        
        return texto;
    }
}
    