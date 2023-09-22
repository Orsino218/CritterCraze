package critter.crazeproject.views;

import javax.swing.*;

public class GameWindow extends JFrame {
    public static final JFrame window = new GameWindow();
    public JPanel currentView;

    private GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Critter Craze");
        setSize(1000,1000);

        this.currentView = TitleScreen.titleScreen;
        add(currentView);
    }

    public void changeView(JPanel newView) {
        remove(currentView);
        this.currentView = newView;
        add(currentView);
        revalidate();
    }

}
