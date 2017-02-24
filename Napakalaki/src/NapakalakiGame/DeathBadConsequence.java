 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package NapakalakiGame;

/**
 *
 * @author Evelyn
 */
public class DeathBadConsequence extends NumericBadConsequence{
    private boolean death;
    
    public DeathBadConsequence(String txt,boolean dth) {
        super(txt, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
        death=dth;
    }
    
    @Override
    public boolean isEmpty ()
    {
        return false;
    }
    
    @Override
    public String toString()
    {
        String texto=super.toString();
        
        texto += "\nHas muerto";
        
        return texto;
    }
}
