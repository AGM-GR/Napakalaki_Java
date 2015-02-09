/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicPlayer;

import java.util.ArrayList;
import java.util.Random;
import javazoom.jl.player.*;

public class MusicPlayer extends Thread{
    
    private ArrayList<Player> Reproductores = new ArrayList();
    private ArrayList<String> Files = new ArrayList();
    private boolean Reproducir;
    private Random generator = new Random();
    private int cancion;
    
    public MusicPlayer (ArrayList<String> FileNames) {
        
        super();
        
        Reproducir = true;
        
        try {
            
            Files = (ArrayList<String>)FileNames.clone();
            
            for (int i = 0; i < Files.size(); i++)
                
                Reproductores.add( new Player(getClass().getResourceAsStream(Files.get(i))) );
            
        } catch(Exception e) {}
        
    }
    
    public void run() {
        
        try {
            
            while (Reproducir) {
                
                cancion = generator.nextInt(Files.size());
                Reproductores.set(cancion, new Player(getClass().getResourceAsStream(Files.get(cancion))));
                Reproductores.get(cancion).play();
            }
                
        } catch(Exception e) {}
    }
    
    public void Stop() {
    
        Reproductores.get(cancion).close();
        Reproducir = false;
    }
}
