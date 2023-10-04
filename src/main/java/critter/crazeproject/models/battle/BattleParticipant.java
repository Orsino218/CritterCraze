package critter.crazeproject.models.battle;

import java.util.List;

public class BattleParticipant {
    private int health;
    private int resource;
    private List<CombatUnit> availableUnits;
    private List<ActiveCritter> activeUnits;

    public BattleParticipant() {
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

    public List<ActiveCritter> getActiveUnits() {
        return activeUnits;
    }

    public void setActiveUnits(List<ActiveCritter> activeUnits) {
        this.activeUnits = activeUnits;
    }
    public void spawnUnit(ActiveCritter unit) {
        this.activeUnits.add(unit);
    }
}
