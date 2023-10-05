package critter.crazeproject.workers;

import critter.crazeproject.models.UnitLocation;
import critter.crazeproject.models.battle.ActiveCritter;
import critter.crazeproject.models.battle.BattleParticipant;
import critter.crazeproject.models.battle.CombatState;
import critter.crazeproject.models.battle.CombatUnit;
import critter.crazeproject.views.BattleView;
import critter.crazeproject.views.GameWindow;
import critter.crazeproject.views.Overworld;

import javax.swing.*;
import java.util.Random;
import java.util.function.Predicate;

public class CombatWorker extends SwingWorker<Void, Boolean> {
    private BattleView view;
    private Random random = new Random();

    public CombatWorker(BattleView battleView) {
        this.view = battleView;
    }

    @Override
    protected Void doInBackground() {
        try {
            doTheThing();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void doTheThing() {
        CombatState state = view.getCombatState();
        BattleParticipant player = state.getPlayer();
        BattleParticipant opponent = state.getOpponent();

        while (!isCancelled()) {
            player.gainResource();
            opponent.gainResource();

            spawnOpponentCritters(opponent);

            moveUnits(player, opponent, 5);
            moveUnits(opponent, player, -5);

            attackUnits(player);
            attackUnits(opponent);

            hitOpponent(player, opponent, (critterX) -> critterX >= view.getSize().getWidth());
            hitOpponent(opponent, player, (critterX) -> critterX <= 0);

            state.getPlayer().getActiveCritters().removeIf(this::isCritterDead);
            state.getOpponent().getActiveCritters().removeIf(this::isCritterDead);

            if (player.getHealth() <= 0 || opponent.getHealth() <= 0) {
                System.out.println("Healths: " + player.getHealth() + " / " + opponent.getHealth());
                cancel(false);
                GameWindow.window.changeView(new Overworld());
            } else {
                publish(true);
            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) { /* do nothing */ }
        }
    }

    private boolean isCritterDead(ActiveCritter critter) {
        return critter.getCurrentHealth() <= 0;
    }

    private void moveUnits(BattleParticipant combatant, BattleParticipant opponent, int direction) {
        for (ActiveCritter critter : combatant.getActiveCritters()) {

            ActiveCritter inRange = critter.getAttackTarget();
            if (inRange != null && inRange.getCurrentHealth() <= 0) inRange = null;
            if (inRange == null) inRange = opponent.getActiveCritters().stream()
                    .filter((target) -> isInRange(critter, target))
                    .findFirst()
                    .orElse(null);

            if (inRange == null) {
                critter.getDistAndLane().setxPosition(critter.getDistAndLane().getxPosition() + direction);
            } else {
                critter.setAttackTarget(inRange);
            }
        }
    }

    private void attackUnits(BattleParticipant combatant) {
        for (ActiveCritter critter : combatant.getActiveCritters()) {
            if (critter.getAttackTarget() != null) {
                critter.getAttackTarget().setCurrentHealth(critter.getAttackTarget().getCurrentHealth() - critter.getDamage());
            }
        }
    }

    private void hitOpponent(BattleParticipant combatant, BattleParticipant opponent, Predicate<Integer> condition) {
        for (ActiveCritter critter : combatant.getActiveCritters()) {
            boolean isAtEnd = condition.test(critter.getDistAndLane().getxPosition());
            if (isAtEnd) {
                opponent.setHealth(opponent.getHealth() - critter.getDamage());
                critter.setCurrentHealth(0);
            }
        }
    }

    private void spawnOpponentCritters(BattleParticipant opponent) {
        CombatUnit critter = opponent.getAvailableUnits().get(random.nextInt(opponent.getAvailableUnits().size()));
        System.out.println("made a critter");
        if (opponent.getResource() >= critter.getCost()) {
            int lane = random.nextInt(3) + 1;
            System.out.println("enter if statement");
            opponent.modifyResource(-critter.getCost());
            System.out.println("successfully modify resources");
            opponent.getActiveCritters().add(new ActiveCritter(critter, new UnitLocation((int) view.getSize().getWidth(), lane)));
            System.out.println("added to active units successfully");

        }
    }

    private boolean isInRange(ActiveCritter attacker, ActiveCritter defender) {
        return attacker.getDistAndLane().getyPosition() == defender.getDistAndLane().getyPosition() &&
                Math.abs(attacker.getDistAndLane().getxPosition() - defender.getDistAndLane().getxPosition()) < 100;
    }
}
