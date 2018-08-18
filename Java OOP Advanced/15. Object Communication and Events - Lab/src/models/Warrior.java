package models;

import abstractions.AbstractHero;
import enums.LogType;
import interfaces.Handler;
import interfaces.Target;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";
    private static final String REWARD_MESSAGE = "%s gained %d damage";

    private Handler logger;

    public Warrior(String id, int dmg, Handler logger) {
        super(id, dmg, logger);
        this.logger = logger;
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        this.logger.handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }

    @Override
    public void update(int value) {
        super.setDmg(super.getDmg() + value);
        this.logger.handle(LogType.EVENT, String.format(REWARD_MESSAGE, this, value));
    }
}
