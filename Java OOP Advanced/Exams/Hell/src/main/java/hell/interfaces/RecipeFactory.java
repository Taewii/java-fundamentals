package hell.interfaces;

import java.util.List;

public interface RecipeFactory {

    Item create(String name, int strengthBonus,
                int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, List<String> items);
}
