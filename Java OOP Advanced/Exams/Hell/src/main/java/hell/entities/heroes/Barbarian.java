package hell.entities.heroes;

import static hell.Constants.*;

public class Barbarian extends BaseHero {
    public Barbarian(String name) {
        super(name, BARBARIAN_BASE_STRENGTH, BARBARIAN_BASE_AGILITY, BARBARIAN_BASE_INTELLIGENCE,
                BARBARIAN_BASE_HITPOINTS, BARBARIAN_BASE_DAMAGE);
    }
}
