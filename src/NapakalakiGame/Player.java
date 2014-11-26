/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

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
    
    private void setLevel(int lvl){
        
        level = lvl;
    }
    
    private void die(){
        
        setLevel(1);
        
        CardDealer dealer = CardDealer.getInstance();
        
        for (int i = 0; i < visibleTreasures.size(); i++)
            
            dealer.giveTreasureBack(visibleTreasures.get(i));
        
        visibleTreasures.clear();
        
        for (int i = 0; i < hiddenTreasures.size(); i++)
            
            dealer.giveTreasureBack(hiddenTreasures.get(i));
        
        hiddenTreasures.clear();
        
        dieIfNoTreasures();
    }
    
    private float computeGoldCoinsValue (ArrayList<Treasure> trs){
    
        float gold = 0;
        //float lvls = 0;
        
        for (int i = 0; i<trs.size(); i++)
            
            gold += trs.get(i).getGoldCoins();
        
        //lvls = gold / 1000;
        
        return gold;
        
    }
    
    private boolean canIBuyLevels(int l){
    
        return (level+l < 10);
        
    }
    
    private void applyPrize(Monster currentMonster){
        
        int nLevels = currentMonster.getLevelsGained();
        
        incrementLevels(nLevels);
        
        int nTreasures = currentMonster.getTreasuresGained();
        
        if (nTreasures > 0){
            
            CardDealer dealer = CardDealer.getInstance();
            
            Treasure trs;
            
            for (int i = 0; i < nTreasures; i++){
                
                trs = dealer.nextTreasure();
                
                hiddenTreasures.add(trs);
                
            }
        }
    }
    
    private void applyBadConsequence(BadConsequence bad){
        
        int nLevels = bad.getLevels();
        
        decrementLevels(nLevels);
        
        BadConsequence pendingBad = bad.adjustToFitTreasureList(visibleTreasures,hiddenTreasures);
        
        setPendingBadConsequence(pendingBad);
        
    }
    
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
    
    
    }*/
    
    public CombatResult combat(Monster m){
        
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        
        if (myLevel > monsterLevel) {
        
            applyPrize(m);
        
            
            if (getLevels() >= 10)
                
                return CombatResult.WinAndWinGame;
            
            else
                
                return CombatResult.Win;                
            
        }
        
        else{
            
            Dice dice = Dice.getInstance();
            
            int escape = dice.nextNumber();
            
            if (escape < 5) {
                
                boolean amIDead = m.kills();
                
                if (amIDead) {
                    
                    die();
                    
                    return CombatResult.LoseAndDie;
                    
                }
                
                else{
                    
                    BadConsequence bad = m.getBadConsequence();
                    
                    applyBadConsequence(bad);
                    
                    return CombatResult.Lose;
                }
            }
            
            else
                
                return CombatResult.LoseAndEscape;
        }
    }
    
    public void makeTreasureVisible(Treasure t){
    
        boolean canI = canMakeTreasureVisible(t);
        
        if (canI){
            
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        
        visibleTreasures.remove(t);
        
        if (pendingbadConsequence != null && !pendingbadConsequence.isEmpty())
            
            pendingbadConsequence.substractVisibleTreasure(t);
        
        dieIfNoTreasures();
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
        hiddenTreasures.remove(t);
        
        if (pendingbadConsequence != null && !pendingbadConsequence.isEmpty())
            
            pendingbadConsequence.substractHiddenTreasure(t);
        
        dieIfNoTreasures();
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible,ArrayList<Treasure> hidden){
        
        float levelsMayBought = computeGoldCoinsValue(visible);
        levelsMayBought += computeGoldCoinsValue(hidden);
        
        int level = ((int)levelsMayBought)/1000;
        
        boolean canI = canIBuyLevels(level);
        
        if (canI)
            
            incrementLevels(level);
        
        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);
        
        CardDealer dealer = CardDealer.getInstance();
        
        for (int i = 0; i < visible.size(); i++)      
            
            dealer.giveTreasureBack(visible.get(i));
    
        for (int i = 0; i < hidden.size(); i++)      
            
            dealer.giveTreasureBack(hidden.get(i));
        
        return canI;
        
    }
    
    public boolean validState(){
        
        return (pendingbadConsequence.isEmpty() && hiddenTreasures.size() < 4);
    
    }
    
    public void initTreasures(){
        
        CardDealer dealer = CardDealer.getInstance();
        
        Dice dice = Dice.getInstance();
        
        bringToLife();
        
        Treasure trs = dealer.nextTreasure();
        
        hiddenTreasures.add(trs);
        
        int number = dice.nextNumber();
        
        if (number > 1){
            
            trs = dealer.nextTreasure();
        
            hiddenTreasures.add(trs);
        }
        
        if (number == 6){
            
            trs = dealer.nextTreasure();
        
            hiddenTreasures.add(trs);
        }
    }
    
    public boolean hasVisibleTreasures(){
    
        return (visibleTreasures.size() > 0);

    }
    
    public int getLevels(){
    
        return level;
    }
    
}
