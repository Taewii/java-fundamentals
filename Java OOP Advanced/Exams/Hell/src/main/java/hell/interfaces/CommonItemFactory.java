package hell.interfaces;

public interface CommonItemFactory {

    Item create(String name, int strengthBonus,
                int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus);
}
