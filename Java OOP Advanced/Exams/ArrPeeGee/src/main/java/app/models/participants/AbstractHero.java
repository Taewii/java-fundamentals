package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;
import app.models.Constants;

public abstract class AbstractHero extends AbstractTargetable {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;

    protected AbstractHero(String name, double health, double damage, double gold, int strength, int dexterity, int intelligence) {
        super(name, health, damage, gold);
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.level = 1;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return String.format(Constants.DEAD_HERO_CAN_NOT_ATTACK, this.getName());
        }

        if (!target.isAlive()) {
            return String.format(Constants.DEAD_TARGET_CAN_NOT_BE_ATTACKED, target.getName());
        }

        target.takeDamage(this.getDamage());

        String result = String.format(Constants.HERO_ATTACKED, this.getName());
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(Constants.HERO_HAS_BEEN_SLAIN_BY, target.getName(), this.getName());
        }

        return result;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(super.getGold());
    }

    @Override
    public void levelUp() {
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.level++;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(String.format(Constants.HERO_STATS, this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format(Constants.HERO_STATS2, this.getStrength(), this.getDexterity(), this.getIntelligence(), super.getGold()));

        return sb.toString();
    }
}
