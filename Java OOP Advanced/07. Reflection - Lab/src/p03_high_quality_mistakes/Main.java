package p03_high_quality_mistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args)  {

        Field[] fields = Reflection.class.getDeclaredFields();
        Method[] methods = Reflection.class.getDeclaredMethods();

        Arrays.stream(fields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        Arrays.stream(methods).filter(m -> m.getName().startsWith("get") && m.getParameterTypes().length == 0)
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " have to be public!"));

        Arrays.stream(methods).filter(m -> m.getName().startsWith("set") && m.getParameterTypes().length == 1)
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " have to be private!"));
    }
}
