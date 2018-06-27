import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;

public class p03_DHARMAInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Map<String, String>> stations = new TreeMap<>();
        stations.put("Hydra", new HashMap<>());
        stations.put("Arrow", new HashMap<>());
        stations.put("Flame", new HashMap<>());
        stations.put("Orchid", new HashMap<>());
        stations.put("Pearl", new HashMap<>());

        String input;
        while (!"Recruit".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            String name = tokens[0];
            String facultyNumber = tokens[1];
            String station = tokens[2];

            if (stations.containsKey(station)) {
                stations.get(station).put(name, facultyNumber);
            }
        }

        String command = reader.readLine();
        if ("DHARMA Initiative".equals(command)) {
            stations.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                    .forEach(a -> System.out.printf("The %s has %d DHARMA recruits in it.%n", a.getKey(), a.getValue().size()));
        } else {
            if (stations.containsKey(command)) {
                if (stations.get(command).size() == 0) {
                    printStationInfo(command);
                    System.out.println("No recruits.");
                    return;
                }
                printStationInfo(command);
                stations.get(command).entrySet().stream()
                        .sorted((a, b) -> Integer.compare(Integer.parseInt(b.getValue()), Integer.parseInt(a.getValue())))
                        .forEach(s -> System.out.printf("###%s - %s%n", s.getKey(), s.getValue()));
            } else {
                System.out.println("DHARMA Initiative does not have such a station!");
            }
        }
    }

    private static void printStationInfo(String command) {
        switch (command) {
            case "Arrow":
                System.out.println("The Arrow station: Development of defensive strategies, and Intelligence gathering.");
                break;
            case "Hydra":
                System.out.println("The Hydra station: Zoological Research.");
                break;
            case "Flame":
                System.out.println("The Flame station: Communication.");
                break;
            case "Pearl":
                System.out.println("The Pearl station: Psychological Research and/or Observation.");
                break;
            case "Orchid":
                System.out.println("The Orchid station: Space-time manipulation research, disguised as a Botanical station.");
                break;
        }
    }
}
