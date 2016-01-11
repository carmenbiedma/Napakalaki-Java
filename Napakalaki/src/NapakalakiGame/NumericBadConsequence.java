/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
/**
 *
 * @author Evelyn
 */
public class NumericBadConsequence extends BadConsequence{
    
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
        public NumericBadConsequence(String txt, int lvs, int nVsbl, int nHddn){
        super(txt,lvs);
        nVisibleTreasures=nVsbl;
        nHiddenTreasures=nHddn;
        }
        
        
        public int getnVisibleTreasures(){
           return nVisibleTreasures;
         }
        
         public int getnHiddenTreasures(){
            return nHiddenTreasures;
         }
        
        @Override
        public boolean isEmpty(){
           boolean empty=false;
           if(nHiddenTreasures==0 && nVisibleTreasures==0){
           empty=true;
           }
          return empty;
        }
        
    @Override
        public void substractVisibleTreasure(Treasure t){
        if (this.nVisibleTreasures > 0){
            nVisibleTreasures--;
        }
    }
        
    @Override
        public void substractHiddenTreasure(Treasure t){
        if (this.nHiddenTreasures > 0){
            nHiddenTreasures--;
        }
    }
        
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
     
        
        BadConsequence resultado;
        
            int visibles,ocultos;
            
            visibles=Math.min(v.size(), this.nVisibleTreasures);
            ocultos=Math.min(h.size(), this.nHiddenTreasures);
            
            resultado=new NumericBadConsequence(this.getText(),this.getLevels(),visibles,ocultos);
        
        
        return resultado;
    }
 
    @Override
    public String toString()
    {
        String texto = super.toString();
        
        texto += "\nNum. de tesoros visibles que pierdes: " + nVisibleTreasures 
                + "\nNum. de tesoros ocultos que pierdes: " + nHiddenTreasures;
        
        return texto;
    }
}
