package critter.crazeproject.models;

import java.util.List;

public class Zone {
    private char[][] zoneLayout;
    private List<NPC> npcs;
    private boolean[][] collisionMap;
    public Zone(char[][] tiles, List<NPC> npcs) {
        this.zoneLayout = tiles;
        this.npcs = npcs;

        this.collisionMap = new boolean[zoneLayout.length][zoneLayout[0].length];
        for (int x = 0; x < zoneLayout[0].length; x++) {
            for (int y = 0; y < zoneLayout.length; y++) {
                collisionMap[y][x] = zoneLayout[y][x] == '1';
            }
        }
        for (NPC item: npcs) {
            collisionMap[item.getZoneLocation().getyPosition()][item.getZoneLocation().getxPosition()] = true;
        }

    }
    public char[][] getZoneLayout() {
        return zoneLayout;
    }
    public void setZoneLayout(char[][] zoneLayout) {
        this.zoneLayout = zoneLayout;
    }
    public List<NPC> getNpcs() {
        return npcs;
    }
    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    public boolean[][] getCollisionMap() {
        return collisionMap;
    }
}
