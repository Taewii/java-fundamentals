package hell.core;

import hell.Constants;
import hell.entities.miscellaneous.Inject;
import hell.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class EngineImpl implements Engine {

    private InputReader reader;
    private OutputWriter writer;
    private Repository heroes;
    private HeroFactory heroFactory;
    private CommonItemFactory itemFactory;
    private RecipeFactory recipeFactory;
    private String[] data;

    public EngineImpl(InputReader reader, OutputWriter writer, Repository heroes,
                      HeroFactory heroFactory, CommonItemFactory itemFactory, RecipeFactory recipeFactory) {
        this.reader = reader;
        this.writer = writer;
        this.heroes = heroes;
        this.heroFactory = heroFactory;
        this.itemFactory = itemFactory;
        this.recipeFactory = recipeFactory;
    }

    @Override
    public void run() {
        while (true) {
            String input = this.reader.readLine();
            String data[] = input.split("\\s+");
            String commandName = data[0];
            String result = parseCommand(commandName, data);
            this.writer.writeLine(result);

            if (Constants.TERMINATING_COMMAND.equals(input)) {
                break;
            }
        }
    }

    private String parseCommand(String commandName, String[] data) {
        try {
            this.data = data;

            String commandClassName = commandName + Constants.COMMANDS_SUFFIX;
            Class<?> commandClass = Class.forName(Constants.COMMANDS_PATH + commandClassName);

            Constructor<?> commandCtor = commandClass.getDeclaredConstructor();
            Executable command = (Executable) commandCtor.newInstance();
            injectDependencies(command);

            return command.execute();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                | InstantiationException | IllegalAccessException e) {
            this.writer.writeLine("Invalid command!");
        }
        return null;
    }

    private <T> void injectDependencies(T object) throws IllegalAccessException {
        Field[] commandFields = object.getClass().getDeclaredFields();
        Field[] engineFields = this.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field engineField : engineFields) {
                    engineField.setAccessible(true);
                    if (commandField.getType().equals(engineField.getType()) &&
                            commandField.getName().equals(engineField.getName())) {
                        commandField.set(object, engineField.get(this));
                    }
                }
            }
        }
    }
}
