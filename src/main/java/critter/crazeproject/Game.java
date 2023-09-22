package critter.crazeproject;

import critter.crazeproject.models.GameState;
import critter.crazeproject.views.GameWindow;

import java.awt.*;

public class Game {
    private static final Game game = new Game();
    private GameState gameState;
    private Game(){};

    public static Game getGame() {
        return game;
    }

    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> GameWindow.window.setVisible(true));
    }

}
