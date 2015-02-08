/*
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 *
 */
public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    private ArrayList<Player> players = new ArrayList();
    private Player currentPlayer;
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
        
        if (currentPlayer == null)
            
            return true;
        
        else
            
            return currentPlayer.validState();
    }
    
    public CombatResult developCombat(){
    
        CombatResult result;
        
        CardDealer dealer = CardDealer.getInstance();
        
        result = currentPlayer.combat(currentMonster);
        
        if(result == CombatResult.LoseAndConvert){
            
            Cultist cultist = dealer.nextCultist();
            
            CultistPlayer cp = new CultistPlayer(currentPlayer, dealer.nextCultist());
            
            currentPlayer = cp;
            
            players.set(indexCurrentPlayer, currentPlayer);
               
        }
        
        dealer.giveMonsterBack(currentMonster);
        
        return result;
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
        CardDealer dealer = CardDealer.getInstance();
        
        for (int i = 0; i<treasures.size(); i++){
        
            currentPlayer.discardVisibleTreasure(treasures.get(i));
            dealer.giveTreasureBack(treasures.get(i));
            
        }
            
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){   
        
        CardDealer dealer = CardDealer.getInstance();
        
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
        
        CardDealer dealer = CardDealer.getInstance();
        
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
        
        CardDealer dealer = CardDealer.getInstance();
        
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
