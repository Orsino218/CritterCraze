package critter.crazeproject;

import critter.crazeproject.models.GameState;

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

}
