package critter.crazeproject.views;

import critter.crazeproject.Game;
import critter.crazeproject.managers.ImageManager;
import critter.crazeproject.managers.ZoneManager;
import critter.crazeproject.models.GameState;
import critter.crazeproject.models.UnitLocation;
import critter.crazeproject.models.Zone;
import critter.crazeproject.models.NPC;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Overworld extends JPanel implements KeyboardUser {
    private final int SCALE = 64;
    private Zone currentZone;
    private final Map<Character, UnitLocation> TILES = Map.of(
            '0', new UnitLocation(1, 1),
            '1', new UnitLocation(5, 3)
    );

    public Overworld() {
        this.setCurrentZone("Zone1");
    }

    public void setCurrentZone(String zoneName) {
        this.currentZone = ZoneManager.manager.loadZone(zoneName);
    }

    @Override
    public void paint(Graphics g) {
        GameState state = Game.getGame().getGameState();
        Dimension windowSize = this.getSize();
        int windowTileWidth = (int) Math.ceil(windowSize.getWidth() / SCALE);
        int windowTileHeight = (int) Math.ceil(windowSize.getHeight() / SCALE);

        double scrollX = (state.getCurrentPlayerLocation().getxPosition() + 0.5) * SCALE - windowSize.getWidth() / 2;
        if (scrollX < 0) scrollX = 0;
        if (scrollX > currentZone.getZoneLayout()[0].length * SCALE - windowSize.getWidth())
            scrollX = currentZone.getZoneLayout()[0].length * SCALE - windowSize.getWidth();

        double scrollY = (state.getCurrentPlayerLocation().getyPosition() + 0.5) * SCALE - windowSize.getHeight() / 2;
        if (scrollY < 0) scrollY = 0;
        if (scrollY > currentZone.getZoneLayout().length * SCALE - windowSize.getHeight())
            scrollY = currentZone.getZoneLayout().length * SCALE - windowSize.getHeight();

        //scroll position in tiles (top left tile) --This: What is the tile to start drawing out of
        UnitLocation firstTile = new UnitLocation((int) scrollX / SCALE, (int) scrollY / SCALE);

        //bottom right tile of current view
        UnitLocation lastTile = new UnitLocation((int) (scrollX + windowSize.getWidth() - 1) / SCALE, (int) (scrollY + windowSize.getHeight() - 1) / SCALE);

        //scroll position in pixels (pixel position you're drawing to the top left of screen) --This: Where to actually start drawing
        UnitLocation scrollPositionPixels = new UnitLocation((int) scrollX, (int) scrollY);

        Image atlas = ImageManager.manager.getAnImage("tile_atlas.png");

        for (int x = firstTile.getxPosition(); x <= lastTile.getxPosition(); x++) {
            for (int y = firstTile.getyPosition(); y <= lastTile.getyPosition(); y++) {
                UnitLocation atlasTile = TILES.get(currentZone.getZoneLayout()[y][x]);
                draw(g, atlas, new UnitLocation(x, y), scrollPositionPixels, atlasTile, 64, 64);
            }
        }

        Image characterSprite = ImageManager.manager.getAnImage("CharacterSprite.png");
        draw(g, characterSprite, state.getCurrentPlayerLocation(), scrollPositionPixels, new UnitLocation(state.getPlayerFaceDirection(), 0), 16, 17);

        Image humanSprites = ImageManager.manager.getAnImage("AllHumanSprites.png");
        for (NPC npc : currentZone.getNpcs()) {
            draw(g, humanSprites, npc.getZoneLocation(), scrollPositionPixels, npc.getAtlasLocation(), 48, 51);
        }


    }

    public void draw(Graphics g, Image image, UnitLocation zonePosition, UnitLocation scrollPosition, UnitLocation atlasPosition, int atlasItemXSize, int atlasItemYSize) {
        g.drawImage(
                image,
                (zonePosition.getxPosition()) * SCALE - scrollPosition.getxPosition(),
                (zonePosition.getyPosition()) * SCALE - scrollPosition.getyPosition(),
                (zonePosition.getxPosition() + 1) * SCALE - scrollPosition.getxPosition(),
                (zonePosition.getyPosition() + 1) * SCALE - scrollPosition.getyPosition(),
                atlasPosition.getxPosition() * atlasItemXSize,
                atlasPosition.getyPosition() * atlasItemYSize,
                (atlasPosition.getxPosition() + 1) * atlasItemXSize,
                (atlasPosition.getyPosition() + 1) * atlasItemYSize,
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
