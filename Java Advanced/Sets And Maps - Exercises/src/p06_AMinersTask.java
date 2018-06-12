import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class p06_AMinersTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Long> resources = new LinkedHashMap<>();

        int counter = 1;
        String resource = "";
        String input;
        while (!"stop".equals(input = reader.readLine())) {
            if (counter % 2 != 0) {
                resource = input;
                resources.putIfAbsent(resource, 0L);
            } else {
                resources.put(resource, resources.get(resource) + Long.parseLong(input));
            }
            counter++;
        }

        for (Map.Entry<String, Long> resourceEntry : resources.entrySet()) {
            System.out.printf("%s -> %s%n", resourceEntry.getKey(), resourceEntry.getValue());
        }
    }
}
