package critter.crazeproject.models.battle;

import java.util.ArrayList;
import java.util.List;

public class BattleParticipant {
    private int health;
    private int resource;
    private List<CombatUnit> availableUnits;
    private List<ActiveCritter> activeCritters;

    public BattleParticipant(List<CombatUnit> availableUnits) {
        this.availableUnits = availableUnits;
        this.activeCritters = new ArrayList<>();
        this.health = 100;
        this.resource = 0;
    }

    public void gainResource() {
        this.resource++;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
    public void modifyResource(int amount) { this.resource += amount; }

    public List<CombatUnit> getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(List<CombatUnit> availableUnits) {
        this.availableUnits = availableUnits;
    }

    public List<ActiveCritter> getActiveCritters() {
        return activeCritters;
    }

    public void setActiveCritters(List<ActiveCritter> activeCritters) {
        this.activeCritters = activeCritters;
    }
    public void spawnUnit(ActiveCritter unit) {
        this.activeCritters.add(unit);
    }
}
