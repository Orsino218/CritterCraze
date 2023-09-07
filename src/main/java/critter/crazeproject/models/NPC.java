package critter.crazeproject.models;

import java.util.ArrayList;
import java.util.List;

public class NPC {
private List<DialogueLines> characterScript;
private UnitLocation location;
private Reward payout;
public NPC(List<DialogueLines> characterScript) {
    this.characterScript = characterScript;
}

    public List<DialogueLines> getCharacterScript() {
        return characterScript;
    }

    public UnitLocation getLocation() {
        return location;
    }

    public void setLocation(UnitLocation location) {
        this.location = location;
    }
}
