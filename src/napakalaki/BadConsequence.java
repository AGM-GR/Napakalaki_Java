/*
 */
package napakalaki;

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
        
        if(text.length() == 0 && levels == 0 && 
                nVisibleTreasures == 0 && 
                nHiddenTreasures == 0 && 
                specificVisibleTreasures.isEmpty() && 
                specificHiddenTreasures.isEmpty())
            
            return true;
        
        else
            
            return false;
        
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
        
        if (!specificVisibleTreasures.isEmpty())
            
            specificVisibleTreasures.remove(trs.getType());
        
        else if (nVisibleTreasures != 0)
            
            nVisibleTreasures--;
        
    }
    
    public void substractHiddenTreasure(Treasure trs){
        
        if (!specificHiddenTreasures.isEmpty())
            
            specificHiddenTreasures.remove(trs.getType());
        
        else if (nHiddenTreasures != 0)
            
            nHiddenTreasures--;
        
    }
    
    public String toString(){
    
        return "Text = " + text + " levels = "  + Integer.toString(levels) + " VisibleTreasures = "  + Integer.toString(nVisibleTreasures) + " HiddenTreasures = "  + Integer.toString(nHiddenTreasures) + " Death = "  + Boolean.toString(death);
    }
    
}
