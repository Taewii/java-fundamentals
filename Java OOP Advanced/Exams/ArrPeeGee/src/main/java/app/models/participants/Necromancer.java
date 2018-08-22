package app.models.participants;

import static app.models.Config.*;

public class Necromancer extends AbstractHero {

    public Necromancer(String name) {
        super(name, NECROMANCER_BASE_HEALTH, NECROMANCER_BASE_DAMAGE, HERO_START_GOLD, NECROMANCER_BASE_STRENGTH,
                NECROMANCER_BASE_DEXTERITY, NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (this.getDexterity() + this.getIntelligence() + this.getStrength() * 2);
    }
}
