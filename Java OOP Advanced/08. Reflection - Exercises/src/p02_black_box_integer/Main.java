package p02_black_box_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Class<BlackBoxInt> blackBox = BlackBoxInt.class;
        Constructor<BlackBoxInt> blackBoxCtor = blackBox.getDeclaredConstructor();
        blackBoxCtor.setAccessible(true);
        BlackBoxInt blackBoxInt = blackBoxCtor.newInstance();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            Method method = blackBox.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, number);
            Field field = blackBox.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));
        }
    }
}
