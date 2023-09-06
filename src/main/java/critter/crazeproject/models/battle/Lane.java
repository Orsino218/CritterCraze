package critter.crazeproject.models.battle;

public class Lane {
    private final int[] spaces;
    private final CombatUnit[] summonedUnits;

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
