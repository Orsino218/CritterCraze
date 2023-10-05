package critter.crazeproject.models.battle;

import critter.crazeproject.Game;
import critter.crazeproject.managers.CombatUnitManager;
import critter.crazeproject.models.GameState;

import java.util.ArrayList;
import java.util.List;

public class CombatState {
    private BattleParticipant player;
    private BattleParticipant opponent;
    private int selectedLane;


    public CombatState(List<CombatUnit> playerAvailableUnits, List<CombatUnit> opponentAvailableUnits){
        this.player = new BattleParticipant(playerAvailableUnits);
        this.opponent = new BattleParticipant(opponentAvailableUnits);
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
