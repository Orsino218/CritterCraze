package critter.crazeproject.models;

public class Map {
    private char[][] mapLayout;
    public Map(char[][] tiles) {
        this.mapLayout = tiles;
    }
    public char[][] getMapLayout() {
        return mapLayout;
    }
    public void setMapLayout(char[][] mapLayout) {
        this.mapLayout = mapLayout;
    }
}
