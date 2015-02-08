/*
 */
package NapakalakiGame;

/*
 */
public class Monster implements Card{
    
    private String name = new String();
    private int combatLevel;
    private int levelChangeAgainstCultistPlayer;
    private BadConsequence BadCns;
    private Prize prz;
    
    public Monster(String nam, int level){      
        
        name = nam;
        combatLevel = level;
        levelChangeAgainstCultistPlayer = 0;
        
    }
    
    public Monster(String nam, int level, BadConsequence bc, Prize prize){
        
        name = nam;
        combatLevel = level;
        BadCns = bc;
        prz = prize;
        levelChangeAgainstCultistPlayer = 0;
    }
    
    public Monster(String nam, int level, BadConsequence bc, Prize prize, int levelAgainstCultist){
        
        name = nam;
        combatLevel = level;
        BadCns = bc;
        prz = prize;
        levelChangeAgainstCultistPlayer = levelAgainstCultist;
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
    
    public int getLevelChangeAgainstCultistPlayer() {
    
        return levelChangeAgainstCultistPlayer;
    }

    @Override
    public int getBasicValue() {
        
        return combatLevel;
    }

    @Override
    public int getSpecialValue() {
        
        return (combatLevel + levelChangeAgainstCultistPlayer);
    }
    
}
