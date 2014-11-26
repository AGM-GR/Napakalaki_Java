/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author
 */
public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    private ArrayList<Player> players;
    private Player currentPlayer;
    private CardDealer dealer = CardDealer.getInstance();
    private Monster currentMonster;
    private int indexCurrentPlayer = -1;
    
    private Napakalaki() {}
    
    public static Napakalaki getInstance() {
        
        return instance;
    }
    
    private void initPlayers(ArrayList<String> nam){
        
        for(int i=0; i<nam.size() ; i++)
            
            players.add(new Player(nam.get(i)));
        
    }
    
    private Player nextPlayer(){
        
        if (indexCurrentPlayer == -1){
            
            Random rand = new Random();
            
            indexCurrentPlayer = rand.nextInt(players.size());            
        }
        else
        
            indexCurrentPlayer = (indexCurrentPlayer + 1) % players.size();
            
        currentPlayer = players.get(indexCurrentPlayer);   
        
        return currentPlayer;
        
    }
    
    private boolean nextTurnAllowed(){
        
        return currentPlayer.validState();
    }
    
    public CombatResult developCombat(){
    
        CombatResult result;
        
        result = currentPlayer.combat(currentMonster);
        
        dealer.giveMonsterBack(currentMonster);
        
        return result;
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
        for (int i = 0; i<treasures.size(); i++){
        
            currentPlayer.discardVisibleTreasure(treasures.get(i));
            dealer.giveTreasureBack(treasures.get(i));
            
        }
            
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){   
        
        for (int i = 0; i<treasures.size(); i++){
        
            currentPlayer.discardHiddenTreasure(treasures.get(i));
            dealer.giveTreasureBack(treasures.get(i));
            
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
        for (int i = 0; i < treasures.size(); i++)
            
            currentPlayer.makeTreasureVisible(treasures.get(i));
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        
        return currentPlayer.buyLevels(visible,hidden);
    }
    
    public void initGame(ArrayList<String> nam){
        
        dealer.initCards();
        initPlayers(nam);
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
       
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        
        return currentMonster;
    }
    
    public boolean nextTurn(){
        
        if (nextTurnAllowed()){
            
            nextPlayer();
            
            currentMonster = dealer.nextMonster();
            
            if (currentPlayer.isDead())
                
                currentPlayer.initTreasures();
            
            return true;
        }
        
        else
            
            return false;
        
    }
    
    public boolean endOfGame(CombatResult cr){
        
        return (cr == CombatResult.WinAndWinGame);
        
    }
 
}
