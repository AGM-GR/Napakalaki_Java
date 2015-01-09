/*
 */
package NapakalakiGame;

import java.util.ArrayList;

/*
 */

public class BadConsequence {
    
    private String text = new String();
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence(String tex, int level, int nVT, int nHT){
        
        text = tex;
        levels = level;
        nVisibleTreasures = nVT;
        nHiddenTreasures = nHT;
        death = false;
        
    }
    
    public BadConsequence(String tex, boolean dth){
    
        text = tex;
        death = dth;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;     
        
    }
    
    public BadConsequence(String tex, int level, ArrayList<TreasureKind> tVisible, ArrayList <TreasureKind> tHidden){
        
        text = tex;
        levels = level;
        death = false;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        
        for (int i = 0; i<tVisible.size(); i++)
            
            specificVisibleTreasures.add(tVisible.get(i));

        for (int i = 0; i<tHidden.size(); i++)
            
            specificHiddenTreasures.add(tHidden.get(i));
        
    }
    
    
    public boolean isEmpty(){
        
        return (nVisibleTreasures == 0 && nHiddenTreasures == 0 
                && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty());
        
    }
    
    public String getText(){
        
        return text;
    }
    
    public int getLevels(){
    
        return levels;
    }
    
    public int getnVisibleTreasures(){
    
        return nVisibleTreasures;
    }
    
    public int getnHiddenTreasures(){
    
        return nHiddenTreasures;
    }
    
    public boolean getDeath(){
    
        return death;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        
        return specificHiddenTreasures;
    }
    
    public void substractVisibleTreasure(Treasure trs){
        
        specificVisibleTreasures.remove(trs.getType());
    }
    
    public void substractHiddenTreasure(Treasure trs){
        
        specificHiddenTreasures.remove(trs.getType());
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        
        ArrayList<Treasure> tvisible = new ArrayList(visible);
        ArrayList<Treasure> thidden = new ArrayList(hidden);
        
        ArrayList<TreasureKind> specificVisible = new ArrayList();
        ArrayList<TreasureKind> specificHidden = new ArrayList();
        boolean encontrado = false;
        
        if (!(specificVisibleTreasures == null) && !specificVisibleTreasures.isEmpty()) {
            
            for (int n = 0; n < specificVisibleTreasures.size(); n++){
                
                encontrado = false;
                
                for (int i = 0; i < tvisible.size() && !encontrado; i++)
                
                    if (tvisible.get(i).getType() == specificVisibleTreasures.get(n)){
                        
                        specificVisible.add(tvisible.get(i).getType());
                        
                        tvisible.remove(i);
                        
                        encontrado = true;
                    }
            }
        
            encontrado = false;
        }
        
        if (!(specificHiddenTreasures == null) && !specificHiddenTreasures.isEmpty()) {
            
            for (int n = 0; n < specificHiddenTreasures.size(); n++){
                
                encontrado = false;
                
                for (int i = 0; i < thidden.size() && !encontrado; i++)

                    if (thidden.get(i).getType() == specificHiddenTreasures.get(n)){
                        
                        specificHidden.add(thidden.get(i).getType());
                        
                        thidden.remove(i);
                        
                        encontrado = true;
                    }
            }
        }
        
        if (nVisibleTreasures > 0){
            
            for (int i = 0; i < visible.size() && i <= nVisibleTreasures; i++)
                
                specificVisible.add(visible.get(i).getType());
        }
         
        if (nHiddenTreasures > 0){
            
            for (int i = 0; i < hidden.size() && i <= nHiddenTreasures; i++)
                
                specificHidden.add(hidden.get(i).getType());
        }
        
        BadConsequence adjustBad = new BadConsequence(text, 0, specificVisible, specificHidden);
        
        return adjustBad;
    }
    
    
    public String toString(){
    
        return text;
    }
    
}
