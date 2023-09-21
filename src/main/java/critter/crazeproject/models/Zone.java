package critter.crazeproject.models;

public class Zone {
    private char[][] mapLayout;
    public Zone(char[][] tiles) {
        this.mapLayout = tiles;
    }
    public char[][] getMapLayout() {
        return mapLayout;
    }
    public void setMapLayout(char[][] mapLayout) {
        this.mapLayout = mapLayout;
    }
}
