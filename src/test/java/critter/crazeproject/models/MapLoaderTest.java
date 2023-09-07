package critter.crazeproject.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapLoaderTest {

    @Test
    void loadMap() {
        MapLoader mapLoader = new MapLoader();
        Map map = mapLoader.loadMap("MapDesign1");
        assertEquals(map.getMapLayout().length, 25);
        assertEquals(map.getMapLayout()[0].length, 25);
    }
}