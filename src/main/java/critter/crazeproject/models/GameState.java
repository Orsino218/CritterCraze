package critter.crazeproject.models;

import java.util.Map;

public class GameState {
    private String saveFileName;
    private UnitLocation currentPlayerLocation;
    private int playerFaceDirection;
    private BattleRecord battleRecord;
    private Wallet playerWallet;
    private Zone currentZone;

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

    public BattleRecord getBattleRecord() {
        return battleRecord;
    }

    public void setBattleRecord(BattleRecord battleRecord) {
        this.battleRecord = battleRecord;
    }

    public Wallet getPlayerWallet() {
        return playerWallet;
    }

    public void setPlayerWallet(Wallet playerWallet) {
        this.playerWallet = playerWallet;
    }

    public int getPlayerFaceDirection() {
        return playerFaceDirection;
    }

    public void setPlayerFaceDirection(int playerFaceDirection) {
        this.playerFaceDirection = playerFaceDirection;
    }

    public Zone getCurrentZone() {
        return currentZone;
    }

    public void setCurrentZone(Zone currentZone) {
        this.currentZone = currentZone;
    }
}
