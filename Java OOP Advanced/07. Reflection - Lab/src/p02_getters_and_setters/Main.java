package p02_getters_and_setters;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args)  {

        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));


        Method[] methods = Reflection.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("set") && method.getReturnType() == void.class) {
                setters.add(method);
            } else if (method.getName().startsWith("get") && method.getReturnType() != void.class) {
                getters.add(method);
            }
        }

        for (Method getter : getters) {
            System.out.printf("%s will return %s%n", getter.getName(), getter.getReturnType());
        }

        for (Method setter : setters) {
            System.out.printf("%s and will set field of %s%n", setter.getName(), setter.getParameterTypes()[0]);
        }
    }
}
