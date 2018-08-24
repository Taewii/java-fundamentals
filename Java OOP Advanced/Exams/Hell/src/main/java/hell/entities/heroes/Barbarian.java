package hell.entities.heroes;

import hell.interfaces.Inventory;

import static hell.Constants.*;

public class Barbarian extends BaseHero {
    public Barbarian(String name, Inventory inventory) {
        super(name, BARBARIAN_BASE_STRENGTH, BARBARIAN_BASE_AGILITY, BARBARIAN_BASE_INTELLIGENCE,
                BARBARIAN_BASE_HITPOINTS, BARBARIAN_BASE_DAMAGE, inventory);
    }
}
