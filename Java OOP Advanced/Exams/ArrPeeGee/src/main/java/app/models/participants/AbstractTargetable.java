package app.models.participants;

import app.contracts.Targetable;
import app.models.Constants;

public abstract class AbstractTargetable implements Targetable {

    private String name;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    protected AbstractTargetable(String name, double health, double damage, double gold) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.gold = gold;
        this.isAlive = true;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() <= 0) {
            this.isAlive = false;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(Constants.NAME_AND_CLASS, this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
