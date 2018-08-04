package p06_coding_tracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    public static Map<String, List<String>> methodsByAuthor = new LinkedHashMap<>();

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Author.class)){
                Author author = method.getAnnotation(Author.class);
                String authorName = author.name();
                methodsByAuthor.putIfAbsent(authorName, new ArrayList<>());
                methodsByAuthor.get(authorName).add(method.getName());
            }
        }

        for (var entry : methodsByAuthor.entrySet()) {
            System.out.println(String.format("%s: %s", entry.getKey(), String.join(", ", entry.getValue())));
        }
    }

    @Author(name = "Pesho")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
