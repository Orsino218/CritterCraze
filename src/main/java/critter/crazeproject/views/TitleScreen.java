package critter.crazeproject.views;

import critter.crazeproject.Game;
import critter.crazeproject.listeners.MouseReader;
import critter.crazeproject.managers.ZoneManager;
import critter.crazeproject.models.GameState;
import critter.crazeproject.models.UnitLocation;

import javax.swing.*;
import java.awt.*;

public class TitleScreen extends JPanel {

    public TitleScreen() {
        GridLayout layout = new GridLayout(4, 1);
        setLayout(layout);

        JLabel title = new JLabel("Critter Craze");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        JButton newGameButton = new JButton("New Game");
        JButton continueGameButton = new JButton("Continue Game");
        JButton exitButton = new JButton("Exit Game");

        add(newGameButton);
        add(continueGameButton);
        add(exitButton);

        MouseReader newGameButtonListener = new MouseReader((x, y) -> startNewGame());
        newGameButton.addMouseListener(newGameButtonListener);

        MouseReader exitButtonListener = new MouseReader((x, y) -> System.exit(0));
        exitButton.addMouseListener(exitButtonListener);


    }

    public static void startNewGame() {
        GameState state = new GameState();
        state.setSaveFileName("test01");
        state.setCurrentPlayerLocation(new UnitLocation(6, 10));
        state.setPlayerFaceDirection(0);
        state.setCurrentZone(ZoneManager.manager.loadZone("Zone1"));

        Game.getGame().setGameState(state);

        GameWindow.window.OVERWORLD.setCurrentZone("Zone1");
        GameWindow.window.changeView(GameWindow.window.OVERWORLD);
    }


}
