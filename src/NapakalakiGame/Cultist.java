/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

public class Cultist implements Card{
    
    private String name;
    private int gainedLevels;
    
    public Cultist(String nam, int gLevels){
        
        name = nam;
        gainedLevels = gLevels;
    }
    
    public String getName() {
        
        return name;
    }
    
    public int gainedLevels() {
        
        return gainedLevels;
    }

    @Override
    public int getBasicValue() {
        
        return gainedLevels;
    }

    @Override
    public int getSpecialValue() {
        
        return getBasicValue() * CultistPlayer.getTotalCultistPlayers();
    }
}
