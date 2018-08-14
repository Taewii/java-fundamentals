package p01_logger.factories;

import p01_logger.interfaces.Layout;
import p01_logger.models.SimpleLayout;
import p01_logger.models.XmlLayout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LayoutFactory {

    private static final String PATH = "p01_logger.models.";

    public static Layout createLayout(String type) {

        Layout layout = null;

        try {
            Class<?> layoutClass = Class.forName(PATH + type);
            Constructor<?> declaredConstructor = layoutClass.getDeclaredConstructor();
            layout = (Layout) declaredConstructor.newInstance();

        } catch (ClassNotFoundException | InvocationTargetException |
                InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.getStackTrace();
        }

        return layout;
    }
}
