/*
 */
package NapakalakiGame;

/**
 *
 */
public class Treasure implements Card{
    
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
    
    public String toString(){
    
        return name + ", Type = "  + Type + ", Max.Bonus = " + maxBonus + ", Min.Bonus = " + minBonus + ", Gold coins = "  + goldCoins;
    }
    
    public String TypetoString(){
    
        return "" + Type;
    }

    @Override
    public int getBasicValue() {
        
        return getMinBonus();
    }

    @Override
    public int getSpecialValue() {

        return getMaxBonus();
    }
}