package p01_harvesting_fields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Field[] fields = RichSoilLand.class.getDeclaredFields();

        String input;
        while (!"HARVEST".equals(input = reader.readLine())) {
            switch (input) {
                case "private":
                    Arrays.stream(fields).filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(f -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(f.getModifiers()),
                                    f.getType().getSimpleName(),
                                    f.getName()));
                    break;
                case "protected":
                    Arrays.stream(fields).filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(f -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(f.getModifiers()),
                                    f.getType().getSimpleName(),
                                    f.getName()));
                    break;
                case "public":
                    Arrays.stream(fields).filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(f -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(f.getModifiers()),
                                    f.getType().getSimpleName(),
                                    f.getName()));
                    break;
                case "all":
                    Arrays.stream(fields).forEach(f -> System.out.printf("%s %s %s%n",
                            Modifier.toString(f.getModifiers()),
                            f.getType().getSimpleName(),
                            f.getName()));
            }
        }
    }
}
