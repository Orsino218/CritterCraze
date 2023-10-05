package critter.crazeproject.models;

import critter.crazeproject.models.battle.CombatUnit;

import java.util.List;
import java.util.Map;

public class GameState {
    private String saveFileName;
    private UnitLocation currentPlayerLocation;
    private int playerFaceDirection;
    private String currentZone;
    private List<CombatUnit> playerAvailableUnits;

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public UnitLocation getCurrentPlayerLocation() {
        return currentPlayerLocation;
    }

    public void setCurrentPlayerLocation(UnitLocation currentPlayerLocation) {
        this.currentPlayerLocation = currentPlayerLocation;
    }

    public int getPlayerFaceDirection() {
        return playerFaceDirection;
    }

    public void setPlayerFaceDirection(int playerFaceDirection) {
        this.playerFaceDirection = playerFaceDirection;
    }

    public String getCurrentZone() {
        return currentZone;
    }

    public void setCurrentZone(String currentZone) {
        this.currentZone = currentZone;
    }

    public List<CombatUnit> getPlayerAvailableUnits() {
        return playerAvailableUnits;
    }

    public void setPlayerAvailableUnits(List<CombatUnit> playerAvailableUnits) {
        this.playerAvailableUnits = playerAvailableUnits;
    }
}
