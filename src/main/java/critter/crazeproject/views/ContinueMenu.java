package critter.crazeproject.views;

import critter.crazeproject.Game;
import critter.crazeproject.listeners.MouseReader;
import critter.crazeproject.managers.SaveFileManager;
import critter.crazeproject.models.GameState;

import javax.swing.*;

public class ContinueMenu extends JPanel {

    public ContinueMenu() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        JLabel instructionalHeader = new JLabel("Select Save File To Play From");
        add(instructionalHeader);

        for (String saveName : SaveFileManager.manager.getSaves()) {
            JButton button = new JButton(saveName);
            MouseReader reader = new MouseReader( (x,y) ->  continueFromSave(saveName));
            button.addMouseListener(reader);
            add(button);
        }

    }

    public void continueFromSave(String saveName) {
        try {
            GameState state = SaveFileManager.manager.loadGame(saveName);
            Game.getGame().setGameState(state);
            GameWindow.window.changeView(new Overworld());
        }
        catch(Exception e){
            throw new RuntimeException("Unable to perform continue action", e);
        }
    }


}
