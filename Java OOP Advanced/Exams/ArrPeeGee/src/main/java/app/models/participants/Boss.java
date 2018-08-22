package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;
import app.models.Constants;

public class Boss extends AbstractTargetable {

    public Boss(String name) {
        super(name, Config.BOSS_HEALTH, Config.BOSS_DAMAGE, Config.BOSS_GOLD);
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return String.format(Constants.DEAD_HERO_CAN_NOT_ATTACK, this.getName());
        }

        if (!target.isAlive()){
            return String.format(Constants.DEAD_TARGET_CAN_NOT_BE_ATTACKED, target.getName());
        }

        target.takeDamage(this.getDamage());
        return null;
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(super.getGold());
    }

    @Override
    public void receiveReward(double reward) {
        super.receiveReward(reward * 0.1);
    }

    @Override
    public void levelUp() {
        super.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(String.format(Constants.BOSS_STATS, super.getHealth(), this.getDamage(), super.getGold()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}