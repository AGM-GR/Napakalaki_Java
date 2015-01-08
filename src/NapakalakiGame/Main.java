
package NapakalakiGame;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        napakalakiView.setNapakalaki(napakalakiModel);
      
        ArrayList<String> names = new ArrayList();
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
        names = namesCapture.getNames();
        napakalakiModel.initGame(names);
        napakalakiView.showView();
        
    }
}
