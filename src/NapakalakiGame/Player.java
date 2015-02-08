/*
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 */
public class Player {
    
    private String name;
    private boolean dead = true;
    private int level;
    private BadConsequence pendingbadConsequence;
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();

    public Player(String nam){

        name = nam;
        level = 1;
    }
    
    public Player(Player p){
        
        this.name = p.name;
        this.dead = p.dead;
        this.level = p.level;
        this.pendingbadConsequence = p.pendingbadConsequence;
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
    }
    
    public String getName(){
        
        return name;
    }
    
    private void bringToLife(){
        
        dead = false;
        
    }
    
    protected int getCombatLevel(){
    
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
    
    private void incrementLevels(int levels){
    
        if (level+levels < 10)
            
            level += levels;
        
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
        
        pendingbadConsequence = bc;
    }
    
    private void dieIfNoTreasures(){
        
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty()) {
            
            setLevel(1);
            dead = true;
        }
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
        
        CardDealer dealer = CardDealer.getInstance();
        
        for (int i = 0; i < visibleTreasures.size(); i++)
            
            dealer.giveTreasureBack(visibleTreasures.get(i));
        
        visibleTreasures.clear();
        
        for (int i = 0; i < hiddenTreasures.size(); i++)
            
            dealer.giveTreasureBack(hiddenTreasures.get(i));
        
        hiddenTreasures.clear();
        
        dieIfNoTreasures();
    }
    
    protected float computeGoldCoinsValue (ArrayList<Treasure> trs){
    
        float gold = 0;
        
        for (int i = 0; i<trs.size(); i++)
            
            gold += trs.get(i).getGoldCoins();
        
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
        
        boolean encontrado;
        
        while (!pendingbadConsequence.getSpecificVisibleTreasures().isEmpty()) {
            
            encontrado = false;
            
            for(int i = 0; i<visibleTreasures.size() && !encontrado; i++)
                
                if (visibleTreasures.get(i).getType() == pendingbadConsequence.getSpecificVisibleTreasures().get(0)) {

                    discardVisibleTreasure(visibleTreasures.get(i));
                    encontrado = true;
                }
        }
        
        while (!pendingbadConsequence.getSpecificHiddenTreasures().isEmpty()) {
            
            encontrado = false;
            
            for(int i = 0; i<hiddenTreasures.size() && !encontrado; i++)

                if (hiddenTreasures.get(i).getType() == pendingbadConsequence.getSpecificHiddenTreasures().get(0)) {

                    discardHiddenTreasure(hiddenTreasures.get(i));
                    encontrado = true;
                }
        }
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
    
    protected boolean shouldConvert(){
        
        Dice dice = Dice.getInstance();
        
        int number = dice.nextNumber(name + ": Has perdido.", "Tira el dado para convertirte en Sectario");
        
        return (number == 6);
    }
    
    protected int getOpponentLevel(Monster m){
        
        return m.getBasicValue();
    }
    
    public boolean isDead(){
    
        return dead;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
    
        return visibleTreasures;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
    
        return hiddenTreasures;
    }
    
    public CombatResult combat(Monster m){
        
        int myLevel = getCombatLevel();
        int monsterLevel = getOpponentLevel(m);
        CombatResult result;
        
        if (myLevel > monsterLevel) {
        
            applyPrize(m);
        
            
            if (getLevels() >= 10)
                
                result = CombatResult.WinAndWinGame;
            
            else
                
                result = CombatResult.Win;                
            
        }
        
        else{
            
            Dice dice = Dice.getInstance();
            
            int escape = dice.nextNumber(name + ": Has perdido.", "Tira el dado para intentar escapar ileso");
            
            if (escape < 5) {
                
                boolean amIDead = m.kills();
                
                if (amIDead) {
                    
                    die();
                    
                    result = CombatResult.LoseAndDie;
                    
                }
                
                else{
                    
                    BadConsequence bad = m.getBadConsequence();
                    
                    applyBadConsequence(bad);
                    
                    if(shouldConvert())
                        
                        result = CombatResult.LoseAndConvert;
                    
                    else
                    
                        result = CombatResult.Lose;
                    
                }
            }
            
            else
                
                result = CombatResult.LoseAndEscape;
            
        }
        
        discardNecklaceIfVisible();
        
        return result;
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
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
        hiddenTreasures.remove(t);
        
        if (pendingbadConsequence != null && !pendingbadConsequence.isEmpty())
            
            pendingbadConsequence.substractHiddenTreasure(t);
        
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
        
        dieIfNoTreasures();
        
        if (pendingbadConsequence == null || pendingbadConsequence.isEmpty())
            
            if (hiddenTreasures.size() < 4)
        
                return true;
            
            else
                
                return false;
        else
            
            return false;
    
    }
    
    public void initTreasures(){
        
        CardDealer dealer = CardDealer.getInstance();
        
        Dice dice = Dice.getInstance();
        
        bringToLife();
        
        Treasure trs = dealer.nextTreasure();
        
        hiddenTreasures.add(trs);
        
        int number = dice.nextNumber(name + " :","Tira el dado para asignar nuevos tesoros");
        
        if (number > 1){
            
            trs = dealer.nextTreasure();
        
            hiddenTreasures.add(trs);
        }
        
        if (number == 6){
            
            trs = dealer.nextTreasure();
        
            hiddenTreasures.add(trs);
        }
    }
    
    public int getCombatLevelGUI(){
        
        return getCombatLevel();
    }
    
    public boolean hasVisibleTreasures(){
    
        return (visibleTreasures.size() > 0);

    }
    
    public int getLevels(){
    
        return level;
    }
    
    public String toString(){
    
        return name + ", Nivel " + level;
    }
    
    public Cultist getMyCultistCard () {
        
        return null;        
    }

}