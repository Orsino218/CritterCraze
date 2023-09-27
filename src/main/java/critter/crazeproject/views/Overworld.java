package critter.crazeproject.views;

import critter.crazeproject.Game;
import critter.crazeproject.managers.ImageManager;
import critter.crazeproject.managers.ZoneManager;
import critter.crazeproject.models.GameState;
import critter.crazeproject.models.UnitLocation;
import critter.crazeproject.models.Zone;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Overworld extends JPanel implements KeyboardUser {
    private int SCALE = 1;
    private Zone currentZone;
    private final Map<Character, UnitLocation> TILES = Map.of(
            '0', new UnitLocation(1, 1),
            '1', new UnitLocation(5, 3)
    );

    public void setCurrentZone(String zoneName) {
        this.currentZone = ZoneManager.manager.loadZone(zoneName);
    }

    @Override
    public void paint(Graphics g) {
        GameState state = Game.getGame().getGameState();
        Dimension size = this.getSize();
        int tileWidth = (int) size.getWidth() / (64 * SCALE) + 1;
        int tileHeight = (int) size.getHeight() / (64 * SCALE) + 1;

        int scrollX = state.getCurrentPlayerLocation().getxPosition() - tileWidth / 2;
        if (scrollX < 0) scrollX = 0;
        if (scrollX > currentZone.getZoneLayout()[0].length - tileWidth)
            scrollX = currentZone.getZoneLayout()[0].length - tileWidth;

        int scrollY = state.getCurrentPlayerLocation().getyPosition() - tileHeight / 2;
        if (scrollY < 0) scrollY = 0;
        if (scrollY > currentZone.getZoneLayout().length - tileHeight)
            scrollY = currentZone.getZoneLayout().length - tileHeight;

        UnitLocation scrollPosition = new UnitLocation(scrollX, scrollY);

        Image atlas = ImageManager.manager.getAnImage("tile_atlas.png");
        for (int x = Math.max(0, scrollX); x < tileWidth + scrollX; x++) {
            for (int y = Math.max(0, scrollY); y < tileHeight + scrollY; y++) {
                UnitLocation atlasTile = TILES.get(currentZone.getZoneLayout()[y][x]);
                draw(g, atlas, new UnitLocation(x, y), scrollPosition, atlasTile, 64);
            }
        }

        Image characterSprite = ImageManager.manager.getAnImage("CharacterSprite.png");
        draw(g, characterSprite, state.getCurrentPlayerLocation(), scrollPosition, new UnitLocation(state.getPlayerFaceDirection(), 0), 16);

    }

    public void draw(Graphics g, Image image, UnitLocation zonePosition, UnitLocation scrollPosition, UnitLocation atlasPosition, int atlasItemSize) {
        g.drawImage(
                image,
                (zonePosition.getxPosition() - scrollPosition.getxPosition()) * 64 * SCALE,
                (zonePosition.getyPosition() - scrollPosition.getyPosition()) * 64 * SCALE,
                (zonePosition.getxPosition() - scrollPosition.getxPosition() + 1) * 64 * SCALE,
                (zonePosition.getyPosition() - scrollPosition.getyPosition() + 1) * 64 * SCALE,
                atlasPosition.getxPosition() * atlasItemSize,
                atlasPosition.getyPosition() * atlasItemSize,
                (atlasPosition.getxPosition() + 1) * atlasItemSize,
                (atlasPosition.getyPosition() + 1) * atlasItemSize,
                null
        );
    }


    @Override
    public void handleKeyPress(String input) {
        switch (input) {
            case "Up", "W" -> movePlayer(0, -1, 2);
            case "Down", "S" -> movePlayer(0, 1, 0);
            case "Left", "A" -> movePlayer(-1, 0, 3);
            case "Right", "D" -> movePlayer(1, 0, 1);
//            case "Escape" -> ;
        }

    }

    private void movePlayer(int xChange, int yChange, int newPlayerFaceDirection) {
        UnitLocation currentLocation = Game.getGame().getGameState().getCurrentPlayerLocation();
        currentLocation.setxPosition(currentLocation.getxPosition() + xChange);
        currentLocation.setyPosition(currentLocation.getyPosition() + yChange);
        if (currentZone.getCollisionMap()[currentLocation.getyPosition()][currentLocation.getxPosition()]) {
            currentLocation.setxPosition(currentLocation.getxPosition() - xChange);
            currentLocation.setyPosition(currentLocation.getyPosition() - yChange);
        }

        Game.getGame().getGameState().setPlayerFaceDirection(newPlayerFaceDirection);
        repaint();
    }

}
