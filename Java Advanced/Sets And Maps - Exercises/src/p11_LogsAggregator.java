import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.System.in;

public class p11_LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, TreeSet<String>> nameAndIp = new TreeMap<>();
        Map<String, Integer> nameAndDuration = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- != 0) {
            String[] tokens = reader.readLine().split(" ");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            nameAndIp.putIfAbsent(user, new TreeSet<>());
            nameAndIp.get(user).add(ip);

            nameAndDuration.putIfAbsent(user, 0);
            nameAndDuration.put(user, nameAndDuration.get(user) + duration);
        }

        for (Map.Entry<String, TreeSet<String>> user : nameAndIp.entrySet()) {
            System.out.println(user.getKey() + ": " + nameAndDuration.get(user.getKey()) + " " + user.getValue());
        }
    }
}
