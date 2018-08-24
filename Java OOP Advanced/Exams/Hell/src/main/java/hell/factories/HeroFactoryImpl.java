package hell.factories;

import hell.Constants;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.HeroFactory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;

import java.lang.reflect.InvocationTargetException;

public class HeroFactoryImpl implements HeroFactory {

    @Override
    public Hero create(String name, String type) {
        try {
            Inventory inventory = new HeroInventory();

            return (Hero) Class.forName(Constants.HEROES_PATH + type)
                    .getDeclaredConstructor(String.class, Inventory.class).newInstance(name, inventory);
        } catch (InstantiationException | ClassNotFoundException |
                NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
