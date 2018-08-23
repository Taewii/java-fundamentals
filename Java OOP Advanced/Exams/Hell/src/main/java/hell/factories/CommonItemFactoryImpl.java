package hell.factories;

import hell.entities.items.CommonItem;
import hell.interfaces.CommonItemFactory;
import hell.interfaces.Item;

public class CommonItemFactoryImpl implements CommonItemFactory {

    @Override
    public Item create(String name, int strengthBonus, int agilityBonus,
                       int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        return new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }
}
