import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class p13_OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> store = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" - ");
            String companyName = input[0].substring(1, input[0].length());
            int amount = Integer.valueOf(input[1]);
            String product = input[2].substring(0, input[2].length() - 1);

            if (store.containsKey(companyName)) {
                if (store.get(companyName).containsKey(product)) {
                    store.get(companyName).put(product, store.get(companyName).get(product) + amount);
                } else {
                    store.get(companyName).put(product, amount);
                }
            } else {
                Map<String, Integer> temp = new LinkedHashMap<>();
                temp.put(product, amount);
                store.put(companyName, temp);
            }
        }

        for (String s : store.keySet()) {
            StringBuilder output = new StringBuilder();
            output.append(s).append(": ");
            for (String s1 : store.get(s).keySet()) {
                output.append(s1).append("-").append(store.get(s).get(s1)).append(", ");
            }
            System.out.println(output.substring(0, output.length() - 2));
        }
    }
}
