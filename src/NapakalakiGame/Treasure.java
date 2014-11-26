/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author alex
 */
public class Treasure {
    
    private String name = new String();
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind Type;
    
    public Treasure(String nam, int gold, int min, int max, TreasureKind tk){
        
        name = nam;
        goldCoins = gold;
        minBonus = min;
        maxBonus = max;
        Type = tk;
    }
    
    
    public String getName(){
        
        return name;
    }
    
    public int getGoldCoins(){
    
        return goldCoins;
    }
    
    public int getMinBonus(){
    
        return minBonus;
    }
    
    public int getMaxBonus(){
    
        return maxBonus;
    }
    
    public TreasureKind getType(){
    
        return Type;
    }
    
}