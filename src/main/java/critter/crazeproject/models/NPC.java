package critter.crazeproject.models;

import java.util.List;
import java.util.Map;

public class NPC {
    public String name;
    public Reward reward;
    public Map<DialogueType, List<String>> dialogue;
    public UnitLocation location;

    public String getName() { return name; }

    public Reward getReward() {
        return reward;
    }

    public Map<DialogueType, List<String>> getDialogue() {
        return dialogue;
    }

    public UnitLocation getLocation() {
        return location;
    }
}
