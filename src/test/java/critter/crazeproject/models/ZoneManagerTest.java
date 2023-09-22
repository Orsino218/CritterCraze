package critter.crazeproject.models;

import critter.crazeproject.managers.ZoneManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneManagerTest {

    @Test
    void loadMap() {
        Zone map = ZoneManager.manager.loadZone("Zone1");
        assertEquals(map.getZoneLayout().length, 25);
        assertEquals(map.getZoneLayout()[0].length, 25);
    }
}