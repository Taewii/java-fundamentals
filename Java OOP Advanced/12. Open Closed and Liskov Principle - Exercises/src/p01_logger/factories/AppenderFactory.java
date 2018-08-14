package p01_logger.factories;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Layout;
import p01_logger.models.ConsoleAppender;
import p01_logger.models.FileAppender;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AppenderFactory {

    private static final String PATH = "p01_logger.models.";

    public static Appender createAppender(String[] appenderArgs) {
        Appender appender = null;
        String type = appenderArgs[0];
        String layoutType = appenderArgs[1];

        try {
            Class<?> appenderClass = Class.forName(PATH + type);
            Constructor<?> appenderCtor = appenderClass.getDeclaredConstructor(Layout.class);
            appender = (Appender) appenderCtor.newInstance(LayoutFactory.createLayout(layoutType));

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        if (appenderArgs.length == 3) {
            appender.setReportLevel(ReportLevel.valueOf(appenderArgs[2]));
        }

        return appender;
    }
}
