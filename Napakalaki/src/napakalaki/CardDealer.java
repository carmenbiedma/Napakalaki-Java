/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
    
    
    private CardDealer(){}
    
    private void initTreasureCardDeck(){

        unusedTreasures.add(new Treasure("¡Śı mi amo!", 4, TreasureKind.helmet));
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
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.onehand)), new ArrayList(Arrays.asList(TreasureKind.onehand)));
        prize = new Prize(2,1);       
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        //Chibithulhu
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.helmet)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
                
        //El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierder el calzado visible.",0,new ArrayList(Arrays.asList(TreasureKind.shoes)), new ArrayList());
        prize = new Prize(1,1);        
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        //Ángeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.",0, new ArrayList(Arrays.asList(TreasureKind.onehand)), new ArrayList(Arrays.asList(TreasureKind.onehand)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        //El gorrón en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles.",0,new ArrayList(Arrays.asList(TreasureKind.onehand,TreasureKind.shoes,TreasureKind.armor,TreasureKind.bothhand,TreasureKind.helmet)),new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
                
        //H.P Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.armor)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P Munchcraft", 6, badConsequence, prize));
                
        //Bichgoot
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.armor)),new ArrayList());
        prize = new Prize(1,1); 
        unusedMonsters.add(new Monster("Bichgoot", 14, badConsequence, prize));
        
        // Rey de la rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        //La que redacta en las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles.",2,0,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));       
        
        //Los hondos
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.",true);
        prize = new Prize(2,1); 
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu”", 4, badConsequence, prize));
                
        //Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.onehand)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        //Pollipólipo volante
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
                
        //Yskhtihyssg-Goth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto.", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
                
                
        //Familia feliz
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto.", true);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
                
        //Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 mano visible.",2,new ArrayList(Arrays.asList(TreasureKind.bothhand)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
                
        //El espia
        badConsequence = new BadConsequence("Te asustaa en la noche. Pierdes un casco visible.",0,new ArrayList(Arrays.asList(TreasureKind.helmet)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
                
        //El Lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,new ArrayList(Arrays.asList(TreasureKind.onehand,TreasureKind.onehand,TreasureKind.bothhand,TreasureKind.armor,TreasureKind.helmet,TreasureKind.shoes)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));
                
        //Bicéfalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",3,new ArrayList(Arrays.asList(TreasureKind.onehand,TreasureKind.onehand,TreasureKind.bothhand)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
    
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
        
    }
       
        
    
}
