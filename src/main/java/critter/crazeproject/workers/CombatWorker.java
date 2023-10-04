package critter.crazeproject.workers;

import critter.crazeproject.models.battle.CombatState;

import javax.swing.*;
import java.util.List;

public class CombatWorker extends SwingWorker<Void, Boolean> {
    private CombatState combatState;
    private JComponent combatDisplay;

    public CombatWorker (CombatState combatState, JComponent combatDisplay) {
        this.combatState = combatState;
        this.combatDisplay = combatDisplay;
    }


    @Override
    protected Void doInBackground() throws Exception {

        while (!isCancelled()) {

            //increment resources
            combatState.getPlayer().gainResource();
            combatState.getOpponent().gainResource();

            //handle enemy battle commands
            handleEnemySpawnLogic();

            //move units

            //force combats

            //post combat cleanup

            //evaluate units that reach the end of a lane

            //check if a player is defeated

            //publish if anything happened during this cycle

            //sleep to pace combat


        }
        return null;
    }
    @Override
    protected void process(List<Boolean> results){
        //doStuff here for redrawing the battlefield

    }


    private void handleEnemySpawnLogic() {
        //figure out how to handle AI spawning
    }






}
