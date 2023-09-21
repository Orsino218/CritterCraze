package critter.crazeproject.models.battle;

public class Lane {
    private final int[] spaces;
    private final CombatUnit[] summonedUnits;

    public Lane() { //default length for modeling purposes
        this.spaces = new int[10];
        this.summonedUnits = new CombatUnit[10];
    }
    public Lane(int length) {
        this.spaces = new int[length];
        this.summonedUnits = new CombatUnit[length];
    }

    public int[] getSpaces() {
        return spaces;
    }

    public CombatUnit[] getSummonedUnits() {
        return summonedUnits;
    }
}
