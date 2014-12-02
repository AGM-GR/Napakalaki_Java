/*
 */
package NapakalakiGame;

/*
 */
public class Monster {
    
    private String name = new String();
    private int combatLevel;
    private BadConsequence BadCns;
    private Prize prz;
    
    public Monster(String nam, int level){      
        
        name = nam;
        combatLevel = level;           
        
    }
    
    public Monster(String nam, int level, BadConsequence bc, Prize prize){
        
        name = nam;
        combatLevel = level;
        BadCns = bc;
        prz = prize;
    }
            
    public String getName(){
    
        return name;
    }
    
    public int getCombatLevel(){
    
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
    
        return BadCns;
    }
    
    public Prize getPrize(){
    
        return prz;
    }
    
    
    public String toString(){
    
        return name + ", Nivel = "  + Integer.toString(combatLevel) + ", Mal rollo: " + BadCns.toString();
    }
    
    public int getLevelsGained(){
    
        return prz.getLevel();
        
    }
    
    public int getTreasuresGained(){
    
        return prz.getTreasures();
    }
    
    public boolean kills(){
    
        return BadCns.getDeath();
    }
    
}
