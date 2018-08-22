package app.models.participants;

import static app.models.Config.*;

public class Wizard extends AbstractHero {

    public Wizard(String name) {
        super(name, WIZARD_BASE_HEALTH, WIZARD_BASE_DAMAGE, HERO_START_GOLD,
                WIZARD_BASE_STRENGTH, WIZARD_BASE_DEXTERITY, WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return this.getIntelligence() * 5 + this.getDexterity();
    }

}
