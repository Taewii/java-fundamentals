package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {

    private static final String PATH = "app.models.participants.";

    @Override
    public Targetable create(String name, String className) throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        return (Targetable) Class.forName(PATH + className).getDeclaredConstructor(String.class).newInstance(name);
    }
}
