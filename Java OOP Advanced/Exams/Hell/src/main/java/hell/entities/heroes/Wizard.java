package hell.entities.heroes;

import static hell.Constants.*;

public class Wizard extends BaseHero {
    public Wizard(String name) {
        super(name, WIZARD_BASE_STRENGTH, WIZARD_BASE_AGILITY, WIZARD_BASE_INTELLIGENCE,
                WIZARD_BASE_HITPOINTS, WIZARD_BASE_DAMAGE);
    }
}
