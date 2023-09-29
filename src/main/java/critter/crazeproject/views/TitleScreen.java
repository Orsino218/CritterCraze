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

        //1
        JLabel title = new JLabel("Critter Craze");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        //2
        JButton newGameButton = new JButton("New Game");
        MouseReader newGameButtonListener = new MouseReader((x, y) -> GameWindow.window.changeView(new NewGamePrompt()));
        newGameButton.addMouseListener(newGameButtonListener);
        add(newGameButton);

        //3
        JButton continueGameButton = new JButton("Continue Game");
        MouseReader continueGameButtonListener = new MouseReader((x, y) -> GameWindow.window.changeView(new ContinueMenu()));
        continueGameButton.addMouseListener(continueGameButtonListener);
        add(continueGameButton);

        //4
        JButton exitButton = new JButton("Exit Game");
        MouseReader exitButtonListener = new MouseReader((x, y) -> System.exit(0));
        exitButton.addMouseListener(exitButtonListener);
        add(exitButton);
    }


}
