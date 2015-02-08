/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        
        super(p);
        totalCultistPlayers++;
        myCultistCard = c;
    }
    
    public static int getTotalCultistPlayers(){
        
        return totalCultistPlayers;
    }
    
    @Override
    protected int getOpponentLevel(Monster m){
        
        return m.getSpecialValue();
    }
    
    @Override
    protected int getCombatLevel(){
        
        return (super.getCombatLevel() + myCultistCard.getSpecialValue());
    }
    
    @Override
    protected boolean shouldConvert(){
        
        return false;
    }
    
    @Override
    protected float computeGoldCoinsValue (ArrayList<Treasure> trs){
    
        return (super.computeGoldCoinsValue(trs) *2);
        
    }
    
    @Override
    public Cultist getMyCultistCard () {
        
        return myCultistCard;        
    }
}
