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
public class BadConsequence {
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    
    
    public BadConsequence(String txt,int lvls,int nvt,int nht){
        
        text=txt;
        levels=lvls;
        nVisibleTreasures=nvt;
        nHiddenTreasures=nht;
    }
    
    public BadConsequence(String txt,boolean dth){
        text=txt;
        death=dth;
    }
    
    public BadConsequence(String txt, int lvls, ArrayList<TreasureKind> tVisible,ArrayList<TreasureKind> tHidden){
        text=txt;
        levels=lvls;
        specificVisibleTreasures=tVisible;
        specificHiddenTreasures=tHidden;
    }
    
    public boolean isEmpty(){
         
        boolean empty = false;

        if (levels == 0 && death == false && nHiddenTreasures == 0 && nVisibleTreasures == 0 && specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty()) {

            empty = true;
        }

        return empty;
    }
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getNVsisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t){
        
        boolean eliminado=false;
        
        for(int i=0;i<nVisibleTreasures && !eliminado;i++){
            if(specificVisibleTreasures.get(i)== t.getType()){
                specificVisibleTreasures.remove(i);
                nVisibleTreasures--;
                eliminado=true;
            }
                
        }
        
    }
    
    public void  substractHiddenTreasure(Treasure t){
        
        boolean eliminado=false;
        
        for(int i=0;i<nHiddenTreasures && !eliminado;i++){
            if(specificHiddenTreasures.get(i)== t.getType()){
                specificHiddenTreasures.remove(i);
                nHiddenTreasures--;
                eliminado=true;
            }
                
        }
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        
      BadConsequence bc;
        
        ArrayList<TreasureKind> visible = new ArrayList();
        ArrayList<TreasureKind> oculto = new ArrayList();        
        
        if(specificHiddenTreasures.size()>0){
            for(int i=0; i<specificHiddenTreasures.size(); i++){
                for(int j=0; j<h.size(); j++){
                    if(specificHiddenTreasures.get(i) == h.get(j).getType())
                        oculto.add(specificHiddenTreasures.get(i));
                }          
            }        
        }
        
        if (specificVisibleTreasures.size()>0){       
            for(int i=0; i<specificVisibleTreasures.size(); i++){
                for(int j=0; j<v.size(); j++){
                    if(specificVisibleTreasures.get(i)==v.get(j).getType())
                        visible.add(specificVisibleTreasures.get(i));
                }          
            }
        }
        
        if(specificVisibleTreasures.size()==0 && specificHiddenTreasures.size()==0){     
            for(int i=0; i<specificHiddenTreasures.size() && i<nVisibleTreasures;i++)
                oculto.add(v.get(i).getType());
            for(int i=0; i<specificVisibleTreasures.size() && i<nHiddenTreasures; i++)
                visible.add(h.get(i).getType());
        }
        
        bc = new BadConsequence("",0,visible,oculto);
        
        return bc;
    }
    
    public String toString(){
        return "Mal rollo: = " + text + " ,niveles que pierde = " + Integer.toString(levels) + " ,num tesoros visibles que pierdes: " +  Integer.toString(nVisibleTreasures) + " ,num tesoros escondidos que pierdes: " + Integer.toString(nHiddenTreasures);
    }
}
    