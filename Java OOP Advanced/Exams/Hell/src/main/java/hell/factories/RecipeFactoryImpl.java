package hell.factories;

import hell.entities.items.RecipeItem;
import hell.interfaces.Recipe;
import hell.interfaces.RecpieFactory;

import java.util.List;

public class RecipeFactoryImpl implements RecpieFactory {

    @Override
    public Recipe create(String name, int strengthBonus, int agilityBonus, int intelligenceBonus,
                         int hitPointsBonus, int damageBonus, List<String> items) {
        return new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus,
                hitPointsBonus, damageBonus, items);
    }
}
