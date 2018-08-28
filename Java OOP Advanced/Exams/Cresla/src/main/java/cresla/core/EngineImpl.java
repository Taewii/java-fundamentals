package cresla.core;

import cresla.Constants;
import cresla.interfaces.Engine;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineImpl implements Engine {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public EngineImpl(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            String input = this.reader.readLine();
            String[] tokens = input.split("\\s+");
            String command = tokens[0].toLowerCase();
            List<String> arguments = Arrays.stream(tokens).skip(1).collect(Collectors.toList());

            this.writer.writeLine(executeCommand(command, arguments));

            if ("exit".equals(command)) {
                break;
            }
        }
    }

    private String executeCommand(String command, List<String> arguments) {
        String result = null;

        try {
            Method methods = Class.forName(Constants.CRESLA_MANAGER_PATH)
                    .getDeclaredMethod(command + Constants.COMMAND_SUFFIX, List.class);
            result = (String) methods.invoke(this.manager, arguments);
        } catch (ClassNotFoundException | InvocationTargetException |
                 IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return result;
    }
}
