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
public class SpecificBadConsequence extends BadConsequence{
    
     private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
     private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
     
     public SpecificBadConsequence (String txt, int lvls, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(txt,lvls);
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
    }
     
    public ArrayList<TreasureKind> getSpecificVisibleTreasures (){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures (){
        return specificHiddenTreasures;
    }
    
    @Override
    public void substractVisibleTreasure (Treasure t){
        TreasureKind trk = t.getType();
        specificVisibleTreasures.remove(trk);
    }
    
    @Override
    public void substractHiddenTreasure (Treasure t){
        TreasureKind trk = t.getType();
        specificHiddenTreasures.remove(trk);
    }
    
    @Override
    public boolean isEmpty (){
        boolean res = false;
        
        if ((specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty()))
            res = true;
        
        return res;
    }
      @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
        BadConsequence speBadCon;
        
        ArrayList<Treasure> copiaV = new ArrayList(v);
        ArrayList<TreasureKind> newSpecificVisible = new ArrayList();

        for (TreasureKind tK : specificVisibleTreasures)
        {
            int i = 0;
            boolean encontrado = false;

            while ((i < copiaV.size()) && !(encontrado))
            {
                if (copiaV.get(i).getType() == tK)
                {
                    encontrado = true;
                    newSpecificVisible.add(tK);
                    copiaV.remove(i);
                }

                i++;
            }
        }
        ArrayList<Treasure> copiaH = new ArrayList(h);
        ArrayList<TreasureKind> newSpecificHidden = new ArrayList();

        for (TreasureKind tK : specificHiddenTreasures)
        {
            int i = 0;
            boolean encontrado = false;

            while ((i < copiaH.size()) && !(encontrado))
            {
                if (copiaH.get(i).getType() == tK)
                {
                    encontrado = true;
                    newSpecificHidden.add(tK);
                    copiaH.remove(i);
                }

                i++;
            }
        }

        speBadCon = new SpecificBadConsequence(this.getText(),this.getLevels(),newSpecificVisible,newSpecificHidden);
        
        return speBadCon;
    }
    
}
