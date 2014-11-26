/*
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 */

public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        ArrayList<Monster> monstruos = new ArrayList();
        
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        Prize prize = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",
                1, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList(Arrays.asList(TreasureKind.oneHand)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 1, new ArrayList(Arrays.asList(TreasureKind.armor)),new ArrayList(Arrays.asList(TreasureKind.armor)));
        prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 1, new ArrayList(Arrays.asList(TreasureKind.helmet)),new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 1, new ArrayList(Arrays.asList(TreasureKind.shoe)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 1, 10, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 1, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 1, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());      
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));        
        
        
        System.out.print("Monstruos con lvl superior a 10: \n");
        
        for (int i = 0 ;  i < monstruos.size() ; i++)
            
            if (monstruos.get(i).getCombatLevel() > 10)    
                
                System.out.print(monstruos.get(i).toString() + "\n");
        
        System.out.print("Monstruos que sólo impliquen pérdida de niveles: \n");
        
        for (int i = 0 ;  i < monstruos.size() ; i++)
            
            if (!(monstruos.get(i).getBadConsequence().getDeath()) &&
                    (monstruos.get(i).getBadConsequence().getSpecificHiddenTreasures().isEmpty()) &&
                    (monstruos.get(i).getBadConsequence().getSpecificVisibleTreasures().isEmpty()) &&
                    (monstruos.get(i).getBadConsequence().getnVisibleTreasures() == 0) &&
                    (monstruos.get(i).getBadConsequence().getnHiddenTreasures() == 0))
                
                System.out.print(monstruos.get(i).toString() + "\n");
        
        System.out.print("Monstruos cuyo buen rollo indique ganancia de niveles superior a 1: \n");
        
        for (int i = 0 ;  i < monstruos.size() ; i++)
            
            if(monstruos.get(i).getPrize().getLevel() > 1)
                
                System.out.print(monstruos.get(i).toString() + "\n");
        
        System.out.print("Monstruos cuyo mal rollo suponga la pérdida de tesoros visibles y/o ocultos: \n");
        
        for (int i = 0 ;  i < monstruos.size() ; i++)
            
            if(!(monstruos.get(i).getBadConsequence().getSpecificHiddenTreasures().isEmpty()) ||
                    !(monstruos.get(i).getBadConsequence().getSpecificVisibleTreasures().isEmpty()))
                
                System.out.print(monstruos.get(i).toString() + "\n");
        
        
    }
    
}