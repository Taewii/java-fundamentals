package hell.interfaces;

import java.util.List;

public interface RecpieFactory {

    Item create(String name, int strengthBonus,
                int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, List<String> items);
}
