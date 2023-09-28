package critter.crazeproject.listeners;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import critter.crazeproject.Game;
import critter.crazeproject.views.GameWindow;
import critter.crazeproject.views.KeyboardUser;

public class KeyboardReader implements NativeKeyListener {


    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (GameWindow.window.currentView instanceof KeyboardUser) {
            String keyPressed = NativeKeyEvent.getKeyText(e.getKeyCode());
            ((KeyboardUser) GameWindow.window.currentView).handleKeyPress(keyPressed);
        }
    }


}