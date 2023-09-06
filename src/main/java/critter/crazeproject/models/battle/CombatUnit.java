package critter.crazeproject.models.battle;

public class CombatUnit {
    private String name;
    private int cost;
    private int health;
    private int damage;
    private double attackRate;
    private String imageName;

    public CombatUnit(String name, int cost, int health, int damage, double attackRate, String imageName) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.damage = damage;
        this.attackRate = attackRate;
        this.imageName = imageName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
}
