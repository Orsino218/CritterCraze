package critter.crazeproject.views;

import critter.crazeproject.listeners.MouseReader;
import critter.crazeproject.models.UnitLocation;
import critter.crazeproject.models.battle.ActiveCritter;
import critter.crazeproject.models.battle.CombatState;
import critter.crazeproject.models.battle.CombatUnit;
import critter.crazeproject.workers.CombatWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class BattleView extends JSplitPane {
    public CombatState combatState;
    public JLabel playerHealth;
    public JLabel playerResource;
    public JLabel opponentHealth;
    public JLabel opponentResource;

    public BattleView(CombatState combatState) {
        this.combatState = combatState;

        this.playerHealth = new JLabel("Player Health: " + combatState.getPlayer().getHealth());
        this.playerResource = new JLabel("Player Resource: " + 0);
        this.opponentHealth = new JLabel("Opponent Health: " + combatState.getOpponent().getHealth());
        this.opponentResource = new JLabel("Opponent Resource: " + 0);

        setLeftComponent(createLeftPane());
        setRightComponent(createRightPane());
        setEnabled(false);

        CombatWorker worker = new CombatWorker(combatState, this);
        worker.execute();
    }

    @Override
    public void paint(Graphics g) {
        Dimension currentWindowSize = getSize();
        int splitLocation = currentWindowSize.width / 5;
        setDividerLocation(splitLocation);

        playerHealth.setText(String.valueOf(combatState.getPlayer().getHealth()));
        playerResource.setText(String.valueOf(combatState.getPlayer().getResource()));
        opponentHealth.setText(String.valueOf(combatState.getOpponent().getHealth()));
        opponentResource.setText(String.valueOf(combatState.getOpponent().getResource()));

        super.paint(g);
    }


    public JPanel createLeftPane() {
        JPanel leftPanel = new JPanel();
        for (CombatUnit unit : combatState.getPlayer().getAvailableUnits()) {
            JButton unitButton = new JButton(unit.getName());
            MouseReader reader = new MouseReader(
                    (x, y) -> {
                        if (combatState.getPlayer().getResource() >= unit.getCost()) {
                            combatState.getPlayer().modifyResource(-unit.getCost());
                            ActiveCritter spawnedUnit = new ActiveCritter(unit, new UnitLocation(0, combatState.getSelectedLane()));
                            combatState.getPlayer().spawnUnit(spawnedUnit);
                            this.repaint();
                        }
                    }
            );
            unitButton.addMouseListener(reader);
            leftPanel.add(unitButton);
        }

        return leftPanel;
    }

    public JPanel createRightPane() {
        JPanel rightPanel = new JPanel();
        GridLayout rightPaneLayout = new GridLayout(4, 1);
        rightPanel.setLayout(rightPaneLayout);

        JPanel participantInfoPanel = new JPanel();
        GridLayout infoPanelLayout = new GridLayout(1, 5);
        participantInfoPanel.setLayout(infoPanelLayout);
        JPanel infoBox1 = new JPanel();
        JPanel infoBox2 = new JPanel();
        JPanel infoBox3 = new JPanel();
        JPanel infoBox4 = new JPanel();

        infoBox1.add(playerHealth);
        infoBox2.add(playerResource);
        infoBox3.add(opponentHealth);
        infoBox4.add(opponentResource);
        participantInfoPanel.add(infoBox1);
        participantInfoPanel.add(infoBox2);
        participantInfoPanel.add(Box.createGlue());
        participantInfoPanel.add(infoBox3);
        participantInfoPanel.add(infoBox4);

        JPanel lane1 = new LanePanel(this, 1);
        JPanel lane2 = new LanePanel(this, 2);
        JPanel lane3 = new LanePanel(this, 3);

        rightPanel.add(participantInfoPanel);
        rightPanel.add(lane1);
        rightPanel.add(lane2);
        rightPanel.add(lane3);

        return rightPanel;
    }


    public CombatState getCombatState() {
        return combatState;
    }

    public void setCombatState(CombatState combatState) {
        this.combatState = combatState;
    }


}
