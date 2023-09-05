package critter.crazeproject.models;

import java.util.Map;

public class GameState {
    private String saveFileName;
    private UnitLocation currentPlayerLocation;
    private BattleRecord battleRecord;
    private Wallet playerWallet;

    public Wallet getWallet() {
        return playerWallet;
    }

}
