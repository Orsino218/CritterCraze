package critter.crazeproject;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import critter.crazeproject.listeners.KeyboardReader;
import critter.crazeproject.models.GameState;
import critter.crazeproject.models.UnitLocation;
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


    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> GameWindow.window.setVisible(true));

        GlobalScreen.registerNativeHook();
        KeyboardReader keyboardReader = new KeyboardReader();
        GlobalScreen.addNativeKeyListener(keyboardReader);



    }

}
