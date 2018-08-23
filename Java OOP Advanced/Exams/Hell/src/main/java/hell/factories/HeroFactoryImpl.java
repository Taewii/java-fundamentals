package hell.factories;

import hell.Constants;
import hell.interfaces.HeroFactory;
import hell.interfaces.Hero;

import java.lang.reflect.InvocationTargetException;

public class HeroFactoryImpl implements HeroFactory {

    @Override
    public Hero create(String name, String type) {
        try {
            return (Hero) Class.forName(Constants.HEROES_PATH + type).getDeclaredConstructor(String.class).newInstance(name);
        } catch (InstantiationException | ClassNotFoundException |
                NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
