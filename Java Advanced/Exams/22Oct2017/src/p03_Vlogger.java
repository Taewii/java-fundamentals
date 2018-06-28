import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class p03_Vlogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Vlogger> vloggers = new HashMap<>();

        String input;
        while (!"Statistics".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            String action = tokens[1];

            if ("joined".equals(action)) {
                vloggers.putIfAbsent(name, new Vlogger(name));
            } else if (vloggers.containsKey(name)) {
                String following = tokens[2];
                if (vloggers.containsKey(following) && !name.equals(following)) {
                    vloggers.get(name).following.add(following);
                    vloggers.get(following).followers.add(name);
                }
            }
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", vloggers.size());
        final int[] counter = {1};
        final String[] mostPopular = new String[1];

        vloggers.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().followers.size(), a.getValue().followers.size());

            if (result == 0) {
                result = Integer.compare(a.getValue().following.size(), b.getValue().following.size());
            }
            return result;
        }).limit(1).forEach(x -> {
            System.out.printf("%d. %s : %d followers, %d following%n", counter[0]++, x.getKey(),
                    x.getValue().followers.size(), x.getValue().following.size());

            x.getValue().followers.forEach(f -> System.out.println("*  " + f));
            mostPopular[0] = x.getKey();
        });

        vloggers.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().followers.size(), a.getValue().followers.size());

            if (result == 0) {
                result = Integer.compare(a.getValue().following.size(), b.getValue().following.size());
            }

            return result;
        }).forEach(v -> {
            if (!v.getKey().equals(mostPopular[0])) {
                System.out.printf("%d. %s : %d followers, %d following%n",
                        counter[0]++, v.getKey(), v.getValue().followers.size(), v.getValue().following.size());
            }
        });
    }
}

class Vlogger {
    String name;
    Set<String> following;
    Set<String> followers;

    Vlogger(String name) {
        this.name = name;
        followers = new TreeSet<>();
        following = new HashSet<>();
    }
}
