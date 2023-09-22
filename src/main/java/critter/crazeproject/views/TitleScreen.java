package critter.crazeproject.views;

import critter.crazeproject.MouseReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class TitleScreen extends JPanel {
    public static final TitleScreen titleScreen = new TitleScreen();

    private TitleScreen() {
        GridLayout layout = new GridLayout(4,1);
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

        MouseReader exitButtonListener = new MouseReader((x,y) -> System.exit(0));
        exitButton.addMouseListener(exitButtonListener);


    }


}
