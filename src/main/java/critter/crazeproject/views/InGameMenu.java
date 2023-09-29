package critter.crazeproject.views;

import critter.crazeproject.listeners.MouseReader;
import critter.crazeproject.managers.SaveFileManager;

import javax.swing.*;
import java.awt.*;

public class InGameMenu extends JSplitPane {


    public InGameMenu() {
        setLeftComponent(createLeftPane());
        setRightComponent(createRightPane());
        setEnabled(false);


    }

    @Override
    public void paint(Graphics g) {
        Dimension currentWindowSize = getSize();
        int mid = currentWindowSize.width / 2;
        setDividerLocation(mid);

        super.paint(g);
    }


    public JPanel createLeftPane() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(4, 1);
        panel.setLayout(layout);

        //1
        JLabel title = new JLabel("Pause Menu");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title);

        //2
        JButton resumeGameButton = new JButton("Resume Game");
        MouseReader resumeGameButtonListener = new MouseReader((x,y) -> GameWindow.window.changeView(new Overworld()));
        resumeGameButton.addMouseListener(resumeGameButtonListener);
        panel.add(resumeGameButton);

        //3
        JButton saveGameButton = new JButton("Save Game");
        MouseReader saveGameButtonListener = new MouseReader((x,y) -> SaveFileManager.manager.saveGame());
        saveGameButton.addMouseListener(saveGameButtonListener);
        panel.add(saveGameButton);

        //4
        JButton exitGameButton = new JButton("Exit Game");
        MouseReader exitButtonListener = new MouseReader((x, y) -> System.exit(0));
        exitGameButton.addMouseListener(exitButtonListener);
        panel.add(exitGameButton);

        return panel;
    }
    public JPanel createRightPane() {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        JLabel title1 = new JLabel("TEST PRINT 01");
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title1);

        JLabel title2 = new JLabel("TEST PRINT 02");
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title2);


        return panel;
    }

}
