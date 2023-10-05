package critter.crazeproject.models;

import critter.crazeproject.models.battle.CombatUnit;

import java.util.List;
import java.util.Map;

public class NPC {
    public String name;
    public Map<DialogueType, List<String>> dialogue;
    public UnitLocation zoneLocation;
    public UnitLocation atlasLocation;


    public String getName() { return name; }


    public Map<DialogueType, List<String>> getDialogue() {
        return dialogue;
    }

    public UnitLocation getZoneLocation() {
        return zoneLocation;
    }

    public UnitLocation getAtlasLocation() {
        return atlasLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDialogue(Map<DialogueType, List<String>> dialogue) {
        this.dialogue = dialogue;
    }

    public void setZoneLocation(UnitLocation zoneLocation) {
        this.zoneLocation = zoneLocation;
    }

    public void setAtlasLocation(UnitLocation atlasLocation) {
        this.atlasLocation = atlasLocation;
    }

}
