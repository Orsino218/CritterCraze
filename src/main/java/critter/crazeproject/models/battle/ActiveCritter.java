package critter.crazeproject.models.battle;

import critter.crazeproject.models.UnitLocation;

public class ActiveCritter {

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int damage;
    private double attackRate;
    private String imageName;
    private UnitLocation distAndLane;

    public ActiveCritter(CombatUnit combatUnit, UnitLocation location) {
        this.name = combatUnit.getName();
        this.maxHealth = combatUnit.getHealth();
        this.currentHealth = combatUnit.getHealth();
        this.damage = combatUnit.getDamage();
        this.attackRate = combatUnit.getAttackRate();
        this.imageName = combatUnit.getImageName();
        this.distAndLane = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(double attackRate) {
        this.attackRate = attackRate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public UnitLocation getDistAndLane() {
        return distAndLane;
    }

    public void setDistAndLane(UnitLocation distAndLane) {
        this.distAndLane = distAndLane;
    }
}
