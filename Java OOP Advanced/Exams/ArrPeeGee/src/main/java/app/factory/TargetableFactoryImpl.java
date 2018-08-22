package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.Constants;

import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {

    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        return (Targetable) Class.forName(Constants.HEROES_PATH + className)
                .getDeclaredConstructor(String.class).newInstance(name);
    }
}
