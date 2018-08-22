package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.models.Constants;

import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {

    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {

         return (Action) Class.forName(Constants.ACTIONS_PATH + actionName).getDeclaredConstructor().newInstance();
    }
}
