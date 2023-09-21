package critter.crazeproject.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneLoaderTest {

    @Test
    void loadMap() {
        ZoneLoader zoneLoader = new ZoneLoader();
        Zone map = zoneLoader.loadZone("ZoneDesign1");
        assertEquals(map.getMapLayout().length, 25);
        assertEquals(map.getMapLayout()[0].length, 25);
    }
}