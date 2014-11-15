/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Player {
    
    private String name;
    private boolean dead = true;
    private int level;
    private BadConsequence pendingbadConsequence;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;

    public Player(String nam){

        name = nam;
        level = 1;
    }
    
    private void bringToLife(){
        
        dead = false;
        
    }
    
    private int getCombatLevel(){
    
        int lvl = level;
        boolean collarVisible = false;
        
        for(int i = 0 ; i < visibleTreasures.size() ; i++)
            
            if(visibleTreasures.get(i).getType() == TreasureKind.necklace)
                
                collarVisible = true;
        
        if(collarVisible)
            
            for(int i = 0 ; i < visibleTreasures.size() ; i++)
                
                lvl += visibleTreasures.get(i).getMaxBonus();
        
        else
            
            for(int i = 0 ; i < visibleTreasures.size() ; i++)
                
                lvl += visibleTreasures.get(i).getMinBonus();
        
        return lvl;
    }
    
    private void incrementLevels(int l){
    
        if (level+l < 10)
            
            level += l;
        
        else
            
            level = 10;
    }
    
    private void decrementLevels(int l){
    
        if (level-l > 1)
        
            level -= l;
        
        else 
            
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence bc){
        
        if (bc.getDeath())
            
            pendingbadConsequence = new BadConsequence (bc.getText(),true);
        
        else if (bc.getnHiddenTreasures()!= 0 || bc.getnVisibleTreasures() != 0)
            
            pendingbadConsequence = new BadConsequence (bc.getText(),bc.getLevels(),bc.getnVisibleTreasures(),bc.getnHiddenTreasures());
        
        else if (!bc.getSpecificHiddenTreasures().isEmpty() || !bc.getSpecificVisibleTreasures().isEmpty())
            
            pendingbadConsequence = new BadConsequence (bc.getText(), bc.getLevels(), bc.getSpecificVisibleTreasures(), bc.getSpecificHiddenTreasures());

    }
    
    private void dieIfNoTreasures(){
        
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            
            dead = true;
        
    }
    
    private void discardNecklaceIfVisible(){
        
        boolean necklace_found = false;
        CardDealer cardDealer = CardDealer.getInstance();
        
        for (int i = 0 ; i<visibleTreasures.size() && !necklace_found ; i++)
            
            if (visibleTreasures.get(i).getType() == TreasureKind.necklace){
            
                necklace_found = true;
                
                cardDealer.giveTreasureBack(visibleTreasures.get(i));
                
                visibleTreasures.remove(i); 
                
            }
    }
    
    private void die(){
    
        dead = true;
        
    }
    
    private int computeGoldCoinsValue (ArrayList<Treasure> trs){
    
        int gold = 0;
        int lvls = 0;
        
        for (int i = 0; i<trs.size(); i++)
            
            gold += trs.get(i).getGoldCoins();
        
        lvls = gold / 1000;
        
        return lvls;
        
    }
    
    private boolean canIBuyLevels(int l){
    
        if (level+l < 10)
            
            return true;
        
        else
            
            return false;
        
    }
    
    /*private void applyPrize(Monster currentMonster){
    
    }
    
    private void applyBadConsequence(Monster currentMonster){
    
    
    }*/
    
    private boolean canMakeTreasureVisible(Treasure treasure){
        
        if (treasure.getType() == TreasureKind.shoe && howManyVisibleTreasures(TreasureKind.shoe) == 0)
            
            return true;
        
        else if (treasure.getType() == TreasureKind.armor && howManyVisibleTreasures(TreasureKind.armor) == 0)
            
            return true;
        
        else if (treasure.getType() == TreasureKind.necklace && howManyVisibleTreasures(TreasureKind.necklace) == 0)
        
            return true;
        
        else if (treasure.getType() == TreasureKind.helmet && howManyVisibleTreasures(TreasureKind.helmet) == 0)
                     
            return true;
        
        else if (treasure.getType() == TreasureKind.oneHand && 
                howManyVisibleTreasures(TreasureKind.oneHand) < 2 && 
                howManyVisibleTreasures(TreasureKind.bothHand) == 0)
            
            return true;
        
        else if (treasure.getType() == TreasureKind.bothHand && 
                howManyVisibleTreasures(TreasureKind.bothHand) == 0 && 
                howManyVisibleTreasures(TreasureKind.oneHand) == 0)
            
            return true;
        
        else
            
            return false;
            
            
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        
        int cont = 0;
        
        for(int i = 0 ; i < visibleTreasures.size() ; i++)
            
            if(visibleTreasures.get(i).getType() == tKind)
                
                cont++;
    
        return cont;   
    }
    
    public boolean isDead(){
    
        return dead;
    }
    /*
    public ArrayList<Treasure> getVisibleTreasures(){
    
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
    
    
    }
    
    public CombatResult combat(Monster m){
    
        
    }
    
    public void makeTreasureVisible(Treasure t){
    
        
    }*/
    
    public void discardVisibleTreasure(Treasure t){
        
        visibleTreasures.remove(t);
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
        hiddenTreasures.remove(t);
        
    }
    
    /*public boolean buyLevels(ArrayList<Treasure> visible,ArrayList<Treasure> hidden){
    
    
    }
    */
    public boolean validState(){
        
        if(pendingbadConsequence.isEmpty() && hiddenTreasures.size() < 4)
            
            return true;
        
        else
            return false;
    
    }
    /*
    public void initTreasures(){
    
    }
    */
    public boolean hasVisibleTreasures(){
    
        if(visibleTreasures.size() > 0)
            
            return true;
        
        else
            
            return false;
    }
    
    public int getLevels(){
    
        return level;
    }
    
}
