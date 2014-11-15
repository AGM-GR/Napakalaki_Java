/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jaleon
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
    
    /*public CombatResult developCombat(){
        
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        
        
    }
    
    public void initGame(ArrayList<String> nam){
        
        
    }*/
    
    public Player getCurrentPlayer(){
       
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        
        return currentMonster;
    }
    
    /*public boolean nextTurn(){
        
        
    }*/
    
    public boolean endOfGame(CombatResult cr){
        
        if (cr == CombatResult.WinAndWinGame)
            
            return true;
        
        else 
            
            return false;
        
    }
 
}
