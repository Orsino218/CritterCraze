package critter.crazeproject.models.battle;

public class CombatState {
    private BattleParticipant player;
    private BattleParticipant opponent;
    private int selectedLane;


    public CombatState(){
        this.player = new BattleParticipant();
        this.opponent = new BattleParticipant();
        this.selectedLane = 1;
    }

    public BattleParticipant getPlayer() {
        return player;
    }

    public void setPlayer(BattleParticipant player) {
        this.player = player;
    }

    public BattleParticipant getOpponent() {
        return opponent;
    }

    public void setOpponent(BattleParticipant opponent) {
        this.opponent = opponent;
    }

    public int getSelectedLane() {
        return selectedLane;
    }

    public void setSelectedLane(int selectedLane) {
        this.selectedLane = selectedLane;
    }
}
