/*
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 */
public class Dice {
    
    private static final Dice instance = new Dice();
    
    private Dice() {}
    
    public static Dice getInstance() {
        
        return instance;
    }
    
    public int nextNumber(){
    
        Random rand = new Random();
        
        int number = rand.nextInt(6) + 1;
        
        return number;
        
    }

}
