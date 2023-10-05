package critter.crazeproject.views;

import critter.crazeproject.listeners.MouseReader;
import critter.crazeproject.managers.ImageManager;
import critter.crazeproject.models.battle.ActiveCritter;
import critter.crazeproject.models.battle.BattleParticipant;

import javax.swing.*;

import java.awt.*;

public class LanePanel extends JPanel {
    public BattleView battleView;
    public int laneNumber;
    public final Image CRITTER_SPRITES = ImageManager.manager.getAnImage("AllHumanSprites.png");


    public LanePanel(BattleView battleView, int laneNumber) {
        this.battleView = battleView;
        this.laneNumber = laneNumber;

        MouseReader reader = new MouseReader( (x,y) -> this.battleView.combatState.setSelectedLane(this.laneNumber));
        this.addMouseListener(reader);
    }

    @Override
    public void paint(Graphics g) {
        if (battleView.getCombatState().getSelectedLane() == laneNumber) {
            setBackground(new Color(255,255,255));
        }
        else {
            setBackground(new Color(200,200,200));
        }
        super.paint(g);

        drawCritters(g, battleView.getCombatState().getPlayer());
        drawCritters(g, battleView.getCombatState().getOpponent());


    }

    public void drawCritters(Graphics g, BattleParticipant participant) {
        for (ActiveCritter critter : participant.getActiveCritters()) {
            if (critter.getDistAndLane().getyPosition() == laneNumber) {

                int critterCurrentX = critter.getDistAndLane().getxPosition();

                g.drawImage(
                        ImageManager.manager.getAnImage(critter.getImageName()),
                        critterCurrentX,
                        (int) getSize().getHeight() - 32,
                        critterCurrentX + 32,
                        (int) getSize().getHeight(),
                        0 * 32,
                        0 * 32,
                        (0+1) * 32,
                        (0+1) * 32,
                        null
                );

                g.setColor(Color.red);
                g.fillRect(critterCurrentX,0,32,5);

                g.setColor(Color.green);
                g.fillRect(critterCurrentX,0,32 * (critter.getCurrentHealth() / critter.getMaxHealth()),5);

            }
        }
    }

}
