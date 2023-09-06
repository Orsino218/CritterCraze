package critter.crazeproject.models.battle;

public class BattleParticipantStatus {
    private int health;
    private int resource;

    public BattleParticipantStatus(int health, int resource) {
        this.health = health;
        this.resource = resource;
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
}
