package p01_logger;

import p01_logger.enums.ReportLevel;
import p01_logger.factories.AppenderFactory;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Logger;
import p01_logger.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());
        Appender[] appenders = new Appender[n];
        for (int i = 0; i < n; i++) {
            Appender appender = AppenderFactory.createAppender(reader.readLine().split("\\s+"));
            appenders[i] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String command;
        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(commandArgs[0]);
            String date = commandArgs[1];
            String time = commandArgs[2];

            switch (reportLevel) {
                case INFO:
                    logger.logInfo(date, time);
                    break;
                case WARNING:
                    logger.logWarning(date, time);
                    break;
                case ERROR:
                    logger.logError(date, time);
                    break;
                case CRITICAL:
                    logger.logCritical(date, time);
                    break;
                case FATAL:
                    logger.logFatal(date, time);
                    break;
            }
        }

        Controller controller = new Controller(logger);
        controller.info();
    }
}
