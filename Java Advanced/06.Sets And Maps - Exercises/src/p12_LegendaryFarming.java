import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;

public class p12_LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Integer> materials = new HashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();
        boolean materialsReached = false;

        do {
            String[] input = reader.readLine().split(" ");
            for (int i = 0; i < input.length - 1; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                switch (material) {
                    case "motes":
                    case "fragments":
                    case "shards":
                        materials.putIfAbsent(material, 0);
                        materials.put(material, materials.get(material) + quantity);
                        break;
                    default:
                        junk.putIfAbsent(material, 0);
                        junk.put(material, junk.get(material) + quantity);
                        break;
                }

                if (materials.get("motes") >= 250 || materials.get("shards") >= 250 || materials.get("fragments") >= 250) {
                    materialsReached = true;
                    break;
                }
            }

        } while (!materialsReached);

        for (Map.Entry<String, Integer> materialEntry : materials.entrySet()) {
            if (materialEntry.getValue() >= 250) {
                switch (materialEntry.getKey()) {
                    case "motes":
                        System.out.println("Dragonwrath obtained!");
                        break;
                    case "shards":
                        System.out.println("Shadowmourne obtained!");
                        break;
                    case "fragments":
                        System.out.println("Valanyr obtained!");
                        break;
                }
                materials.put(materialEntry.getKey(), materials.get(materialEntry.getKey()) - 250);
            }
        }

        materials.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue(), a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        })
                .forEach(a -> System.out.printf("%s: %d%n", a.getKey(), a.getValue()));
        for (Map.Entry<String, Integer> junkEntry : junk.entrySet()) {
            System.out.printf("%s: %d%n", junkEntry.getKey(), junkEntry.getValue());
        }
    }
}