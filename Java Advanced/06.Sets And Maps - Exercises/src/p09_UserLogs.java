import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;

public class p09_UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        String input;
        while (!"end".equals(input = reader.readLine())) {
            String IP = input.substring(input.indexOf("IP=") + 3, input.indexOf(" message"));
            String user = input.substring(input.indexOf("user=") + 5);

            if (!logs.containsKey(user)) {
                logs.put(user, new LinkedHashMap<>());
                logs.get(user).put(IP, 1);
            } else {
                logs.get(user).putIfAbsent(IP, 0);
                logs.get(user).put(IP, logs.get(user).get(IP) + 1);
            }
        }

        // boyyy this is soo messed up, I don't even know I thought of it out lmao.
        for (Map.Entry<String, LinkedHashMap<String, Integer>> username : logs.entrySet()) {
            System.out.println(username.getKey() + ":");
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Integer> IP : logs.get(username.getKey()).entrySet()) {
                result.append(" ").append(IP.getKey()).append(" => ").append(IP.getValue()).append(",");
            }
            System.out.println(result.substring(0, result.length() - 1) + ".");
        }
    }
}
