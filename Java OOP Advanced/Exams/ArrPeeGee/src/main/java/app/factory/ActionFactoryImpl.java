package app.factory;


import app.contracts.Action;
import app.contracts.ActionFactory;

import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {

    private static final String PATH = "app.models.actions.";

    @Override
    public Action create(String actionName) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        return (Action) Class.forName(PATH + actionName).getDeclaredConstructor().newInstance();
    }
}
