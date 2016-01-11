/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Carmen Biedma
 */
public class CardDealer {
    
    private static  final CardDealer instance=new CardDealer();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    
    
    private CardDealer(){}
    
    private void initTreasureCardDeck(){

        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Botas de investigación", 3,TreasureKind.shoes));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.armor));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida",1, TreasureKind.bothhand));
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Ametralladora Thompson",4, TreasureKind.bothhand));
        unusedTreasures.add(new Treasure("Camiseta de la UGR",1,TreasureKind.armor));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.onehand));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.onehand));
        unusedTreasures.add(new Treasure("Fez alópodo",3,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Hacha prehistórica",2, TreasureKind.onehand));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",4, TreasureKind.armor));
        unusedTreasures.add(new Treasure("Gaita",4, TreasureKind.bothhand));
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.onehand));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones",4,TreasureKind.bothhand));
        unusedTreasures.add(new Treasure("Garabato Mistico",2, TreasureKind.onehand)); 
        unusedTreasures.add(new Treasure("La rebeca metálica",2,TreasureKind.armor));
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.bothhand));
        unusedTreasures.add(new Treasure("Necro-comicón",1, TreasureKind.onehand));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.bothhand));      
        unusedTreasures.add(new Treasure("Linterna a 2 manos",3,TreasureKind.bothhand));
        unusedTreasures.add(new Treasure("Necro-gnomicón",2,TreasureKind.onehand));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Mazo de los antiguos",3,TreasureKind.onehand));
        unusedTreasures.add(new Treasure("Necro-playboycon",3, TreasureKind.onehand));      
        unusedTreasures.add(new Treasure("Porra preternatural",2, TreasureKind.onehand));
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.bothhand));
        unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.onehand));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Zapato deja-amigos",1, TreasureKind.shoes));
        
        
        
    }
    
    private void initMonsterCardDeck(){
        BadConsequence badConsequence;
        Prize prize;
        
        //3 Byakhees de bonanza
        badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.onehand)), new ArrayList(Arrays.asList(TreasureKind.onehand)));
        prize = new Prize(2,1);       
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        //Chibithulhu
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.helmet)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
                
        //El sopor de Dunwich
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierder el calzado visible.",0,new ArrayList(Arrays.asList(TreasureKind.shoes)), new ArrayList());
        prize = new Prize(1,1);        
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        //Ángeles de la noche ibicenca
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.",0, new ArrayList(Arrays.asList(TreasureKind.onehand)), new ArrayList(Arrays.asList(TreasureKind.onehand)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        //El gorrón en el umbral
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles.",0,10,0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
                
        //H.P Munchcraft
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.armor)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P Munchcraft", 6, badConsequence, prize));
                
        //Bichgoot
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.armor)),new ArrayList());
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("Bichgoot", 14, badConsequence, prize));
        
        // Rey de la rosa
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        //La que redacta en las tinieblas
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.",2,0,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));       
        
        //Los hondos
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.",true);
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Semillas Cthulhu
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu”", 4, badConsequence, prize));
                
        //Dameargo
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.onehand)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        //Pollipólipo volante
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
                
        //Yskhtihyssg-Goth
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto.", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
                
                
        //Familia feliz
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estas muerto.", true);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
                
        //Roboggoth
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 mano visible.",2,new ArrayList(Arrays.asList(TreasureKind.bothhand)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
                
        //El espia
        badConsequence = new SpecificBadConsequence("Te asustaa en la noche. Pierdes un casco visible.",0,new ArrayList(Arrays.asList(TreasureKind.helmet)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
                
        //El Lenguas
        badConsequence = new SpecificBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,new ArrayList(Arrays.asList(TreasureKind.onehand,TreasureKind.onehand,TreasureKind.bothhand,TreasureKind.armor,TreasureKind.helmet,TreasureKind.shoes)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));
                
        //Bicéfalo
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",3,new ArrayList(Arrays.asList(TreasureKind.onehand,TreasureKind.onehand,TreasureKind.bothhand)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        //MONSTRUOS CON SECTARIOS
        
        //El mal indecible impronunciable
        
        badConsequence = new SpecificBadConsequence("Pierdes 1 mano visibe",0,new ArrayList(Arrays.asList(TreasureKind.onehand)),new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize,-2));
        
        //Testigos oculares
        
        badConsequence = new SpecificBadConsequence("Pierdes tus tesoros visibles. Jajaja",0,new ArrayList(Arrays.asList(TreasureKind.onehand,TreasureKind.onehand,TreasureKind.bothhand,TreasureKind.helmet,TreasureKind.armor,TreasureKind.shoes)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence, prize,2));
        
        //El gran cthulhu
        
        badConsequence = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres",true);
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu",20, badConsequence, prize,4));
        
        //Serpiente politico
        
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.",2,0,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente politico",8, badConsequence, prize,-2));
        
        //Felpuggoth
        
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",0,new ArrayList(Arrays.asList(TreasureKind.helmet,TreasureKind.armor)),new ArrayList(Arrays.asList(TreasureKind.onehand,TreasureKind.onehand,TreasureKind.bothhand)));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth",2, badConsequence, prize,5));
        
        //Shoggoth
        
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles.",2,0,0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth",16, badConsequence, prize,-4));
        
        //Lolitaggoth
        
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.",2,0,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente politico",2, badConsequence, prize,3));
                    
            
    }
    
    private void shuffleTreasures(){
            Collections.shuffle(unusedTreasures);
        
    }
    
    private void shuffleMonsters(){
            Collections.shuffle(unusedMonsters);
        
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    public Treasure nextTreasure(){
        Treasure aux;
        
        if(unusedTreasures.isEmpty()){
            unusedTreasures=usedTreasures;
            usedTreasures=null;
            shuffleTreasures();
        }
        aux=unusedTreasures.get(unusedTreasures.size()-1);
        unusedTreasures.remove(unusedTreasures.size()-1);
        return aux;
    }
    
    public Monster nextMonster(){
        Monster aux;
        
        if(unusedMonsters.isEmpty()){
            unusedMonsters=usedMonsters;
            usedMonsters=null;
            shuffleMonsters();
        }
        aux=unusedMonsters.get(unusedMonsters.size()-1);
        unusedMonsters.remove(unusedMonsters.size()-1);
        return aux;
    }
    
    public void giveTreasureBack(Treasure t){
        
        usedTreasures.add(t);
        
    }
    
    public void giveMonsterBack(Monster m){
     
            usedMonsters.add(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
        shuffleTreasures();
        shuffleMonsters();
        shuffleCultists();
        
    }
    
    //PRACTICA 4
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    private void initCultistCardDeck(){
        
        Cultist c= new Cultist("Sectario",1);
        unusedCultists.add(c);
        
        c= new Cultist("Sectario",2);
        unusedCultists.add(c);
        
        c=new Cultist("Sectario",1);
        unusedCultists.add(c);
        
        c=new Cultist("Sectario",2);
        unusedCultists.add(c);
        
        c=new Cultist("Sectario",1);
        unusedCultists.add(c);
        
        c=new Cultist("Sectario",1);
        unusedCultists.add(c);
        
        
    }   
    
    public Cultist nextCultist(){
        if(unusedCultists.isEmpty()){
                this.initCultistCardDeck();
                this.shuffleCultists();
        }
        Cultist m = this.unusedCultists.get(0);
        this.unusedCultists.remove(m); 
        return m;
    }
       
        
    
}
