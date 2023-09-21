package critter.crazeproject.models;

import java.util.List;
import java.util.Map;

public class NPC {
    private String name;
    private Reward reward;
    private Map<DialogueType, List<String>> dialogue;
    private UnitLocation location;

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
