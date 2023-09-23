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

public class Overworld extends JPanel {
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


        Image atlas = ImageManager.manager.getAnImage("tile_atlas.png");
        for (int x = Math.max(0, scrollX); x < tileWidth + scrollX; x++) {
            for (int y = Math.max(0, scrollY); y < tileHeight + scrollY; y++) {
                UnitLocation atlasTile = TILES.get(currentZone.getZoneLayout()[y][x]);
                g.drawImage(
                        atlas,
                        (x - scrollX) * 64 * SCALE,
                        (y - scrollY)*64*SCALE,
                        (x - scrollX + 1) * 64 * SCALE,
                        (y - scrollY + 1)*64*SCALE,
                        atlasTile.getxPosition()*64,
                        atlasTile.getyPosition()*64,
                        (atlasTile.getxPosition()+1)*64,
                        (atlasTile.getyPosition()+1)*64,
                        null
                        );
            }
        }


    }

}
