package hell.entities.heroes;

import hell.interfaces.Inventory;

import static hell.Constants.*;

public class Assassin extends BaseHero {
    public Assassin(String name, Inventory inventory) {
        super(name, ASSASSIN_BASE_STRENGTH, ASSASSIN_BASE_AGILITY, ASSASSIN_BASE_INTELLIGENCE,
                ASSASSIN_BASE_HITPOINTS, ASSASSIN_BASE_DAMAGE, inventory);
    }
}
