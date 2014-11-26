package NapakalakiGame;

/*
 */

public class Prize {
    
    private int treasures;
    
    private int levels;
    
    
    public Prize(int treasur, int level){
        
        treasures = treasur;
        levels = level;
        
    }
            
    public int getTreasures(){
    
        return treasures;
    }
    
    public int getLevel(){
    
        return levels;
    
    }

    public String toString(){
    
        return "Treasures = " + Integer.toString(treasures) + " levels = "  + Integer.toString(levels);
    }
    
}
