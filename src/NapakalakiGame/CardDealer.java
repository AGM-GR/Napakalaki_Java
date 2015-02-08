/*
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class CardDealer {
    
    private static final CardDealer instance = new CardDealer();
    
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();

    
    private CardDealer() {
    }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    private void initTreasureCardDeck(){

        Treasure treasure = new Treasure("¡Sí, mi amo!", 0, 4 ,7, TreasureKind.helmet);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Botas de investigación", 600, 3 ,4, TreasureKind.shoe);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.helmet);
        unusedTreasures.add(treasure);

        treasure = new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.armor);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.shoe);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Casco minero", 400, 2, 4, TreasureKind.helmet);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.bothHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.armor);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Clavo de raíl ferroviario", 400, 3, 6, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.helmet);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.armor);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Gaita", 500, 4, 5, TreasureKind.bothHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Insecticida", 300, 2, 3, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.bothHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Garabato místico", 300, 2, 2, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("La fuerza de Mr.T", 1000, 0, 0, TreasureKind.necklace);
        unusedTreasures.add(treasure);

        treasure = new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.armor);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Necroplayboycón", 300, 3, 5, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.bothHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Necrocomicón", 100, 1, 1, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Necronomicón", 800, 5, 7, TreasureKind.bothHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.bothHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Necrognomicón", 200, 2, 4, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.helmet);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.oneHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Tentáculo de pega", 200, 0, 1, TreasureKind.helmet);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.shoe);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Shogulador", 600, 1, 1, TreasureKind.bothHand);
        unusedTreasures.add(treasure);

        treasure = new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.oneHand);
        unusedTreasures.add(treasure);
        
    }
    
    private void initMonsterCardDeck(){
        
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        Prize prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.",
                1, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList(Arrays.asList(TreasureKind.oneHand)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 1, new ArrayList(Arrays.asList(TreasureKind.armor)),new ArrayList(Arrays.asList(TreasureKind.armor)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobado con el lindo primigenio, te descartas de tu casco visible.", 1, new ArrayList(Arrays.asList(TreasureKind.helmet)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 1, new ArrayList(Arrays.asList(TreasureKind.shoe)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles.", 1, 10, 0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible.", 1, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 1, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());      
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.", true);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierde 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 1, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.", true);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, new ArrayList(Arrays.asList(TreasureKind.bothHand)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 1, new ArrayList(Arrays.asList(TreasureKind.helmet)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espía", 5, badConsequence, prize));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, new ArrayList(Arrays.asList(TreasureKind.oneHand,TreasureKind.oneHand,TreasureKind.bothHand)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes 1 mano visible.", 1, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        badConsequence = new BadConsequence("Pierdes tus tesoros visibles. Jajaja.", 1, 10, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence, prize, 2));
        
        badConsequence = new BadConsequence("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));
        
        badConsequence = new BadConsequence("Tu gobierno te recorta 2 niveles.", 2, 0, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, badConsequence, prize, -2));
        
        badConsequence = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 1, new ArrayList(Arrays.asList(TreasureKind.helmet, TreasureKind.armor)), new ArrayList(Arrays.asList(TreasureKind.bothHand, TreasureKind.oneHand, TreasureKind.oneHand)));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));
        
        badConsequence = new BadConsequence("Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        badConsequence = new BadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
        
    }
    
    private void initCultistsCardDeck(){
        
        Cultist cultist = new Cultist("Sectario", 1);
        unusedCultists.add(cultist);
        
        cultist = new Cultist("Sectario", 2);
        unusedCultists.add(cultist);
        
        cultist = new Cultist("Sectario", 1);
        unusedCultists.add(cultist);
        
        cultist = new Cultist("Sectario", 2);
        unusedCultists.add(cultist);
        
        cultist = new Cultist("Sectario", 1);
        unusedCultists.add(cultist);
        
        cultist = new Cultist("Sectario", 1);
        unusedCultists.add(cultist);
        
    }
    
    private void shuffleTreasures(){
    
         Collections.shuffle(unusedTreasures);
        
    }
    
    private void shuffleMonsters(){
    
        Collections.shuffle(unusedMonsters);
        
    }
    
    private void shuffleCultists(){
    
        Collections.shuffle(unusedCultists);
        
    }
    
    public Treasure nextTreasure(){
        
        if (unusedTreasures.isEmpty()){
            
            while (!usedTreasures.isEmpty()){
                
                unusedTreasures.add(usedTreasures.get(0));
                
                usedTreasures.remove(0);
                
            }
            
            shuffleTreasures();
            
        }
        
        Treasure nextTreasure = unusedTreasures.get(0);
        
        unusedTreasures.remove(0);
        
        return nextTreasure;
        
    }
    
    public Monster nextMonster(){
    
        if (unusedMonsters.isEmpty()){
            
            while (!usedMonsters.isEmpty()){
                
                unusedMonsters.add(usedMonsters.get(0));
                
                usedMonsters.remove(0);
                
            }
            
            shuffleMonsters();
            
        }
        
        Monster nextMonster = unusedMonsters.get(0);
        
        unusedMonsters.remove(0);
        
        return nextMonster;
        
    }
    
    public Cultist nextCultist(){
        
        Cultist nextCultist = unusedCultists.get(0);
        
        unusedCultists.remove(0);
        
        return nextCultist;
        
    }
    
    public void giveTreasureBack(Treasure t){
    
        usedTreasures.add(t);
        
    }
    
    public void giveMonsterBack(Monster m){
        
        usedMonsters.add(m);
        
    }
    
    public void initCards(){
    
        initTreasureCardDeck();
        shuffleTreasures();
        initMonsterCardDeck();
        shuffleMonsters();
        initCultistsCardDeck();
        shuffleCultists();
    }
    
}
