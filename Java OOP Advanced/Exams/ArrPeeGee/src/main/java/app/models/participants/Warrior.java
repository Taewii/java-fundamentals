package app.models.participants;

import static app.models.Config.*;

public class Warrior extends AbstractHero {

    public Warrior(String name) {
        super(name, WARRIOR_BASE_HEALTH, WARRIOR_BASE_DAMAGE, HERO_START_GOLD,
                WARRIOR_BASE_STRENGTH, WARRIOR_BASE_DEXTERITY, WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return this.getStrength() * 2 + this.getDexterity();
    }
}
