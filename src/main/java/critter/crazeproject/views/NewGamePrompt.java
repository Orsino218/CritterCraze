package critter.crazeproject.views;

import critter.crazeproject.Game;
import critter.crazeproject.listeners.MouseReader;
import critter.crazeproject.models.GameState;
import critter.crazeproject.models.UnitLocation;

import javax.swing.*;

public class NewGamePrompt extends JPanel {

    public NewGamePrompt() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        JLabel instructionalHeader = new JLabel("Name Your Save File");
        add(instructionalHeader);

        JTextField field = new JTextField();
        add(field);

        JButton startButton = new JButton("Start");
        MouseReader reader = new MouseReader((x,y) -> beginGame(field.getText()));
        startButton.addMouseListener(reader);
        add(startButton);



    }

    public void beginGame(String fieldText) {

        GameState state = new GameState();
        state.setSaveFileName(fieldText);
        state.setCurrentPlayerLocation(new UnitLocation(6, 10));
        state.setPlayerFaceDirection(0);
        state.setCurrentZone("Zone1");

        Game.getGame().setGameState(state);

        GameWindow.window.changeView(new Overworld());
    }

}
