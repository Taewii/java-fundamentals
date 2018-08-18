package abstractions;

import enums.LogType;
import interfaces.Attacker;
import interfaces.Handler;
import interfaces.Target;

public abstract class AbstractHero implements Attacker {

    private static final String TARGET_NULL_MESSAGE = "interfaces.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";

    private String id;
    private int dmg;
    private Target target;
    private Handler logger;

    protected AbstractHero(String id, int dmg, Handler logger) {
        this.id = id;
        this.dmg = dmg;
        this.logger = logger;
    }

    protected int getDmg() {
        return this.dmg;
    }

    protected void setDmg(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public void setTarget(Target target) {
        if (target == null) {
            this.logger.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            this.logger.handle(LogType.EVENT, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    @Override
    public final void attack() {
        if (this.target == null) {
            this.logger.handle(LogType.TARGET, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.logger.handle(LogType.TARGET, String.format(TARGET_DEAD_MESSAGE, this.target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg);
}
