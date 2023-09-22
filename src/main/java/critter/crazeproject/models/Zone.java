package critter.crazeproject.models;

import java.util.List;

public class Zone {
    private char[][] zoneLayout;
    private List<NPC> npcs;
    public Zone(char[][] tiles, List<NPC> npcs) {
        this.zoneLayout = tiles;
        this.npcs = npcs;
    }
    public char[][] getZoneLayout() {
        return zoneLayout;
    }
    public void setZoneLayout(char[][] zoneLayout) {
        this.zoneLayout = zoneLayout;
    }
}
