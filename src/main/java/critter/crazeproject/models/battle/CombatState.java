package critter.crazeproject.models.battle;

public class CombatState {
    private BattleStatus playerStatus;
    private BattleStatus opponentStatus;
    private Battlefield battlefield;


    public CombatState(int playerHP, int enemyHP){
        this.playerStatus = new BattleStatus(playerHP, 0);
        this.opponentStatus = new BattleStatus(enemyHP, 0);
        this.battlefield = new Battlefield();
    }

    public BattleStatus getPlayerStatus() {
        return playerStatus;
    }

    public BattleStatus getOpponentStatus() {
        return opponentStatus;
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }
}
