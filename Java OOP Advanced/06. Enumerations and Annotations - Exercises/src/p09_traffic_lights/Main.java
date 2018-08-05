package p09_traffic_lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        TrafficLights[] lights = TrafficLights.values();
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());
        int count = 1;

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            for (String str : input) {
                TrafficLights light = TrafficLights.valueOf(str);
                sb.append(lights[getIndex(light, count)]).append(" ");
            }
            count++;
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    private static int getIndex(TrafficLights light, int count) {
        int ordinal = light.ordinal();
        if (ordinal + count > 2) {
            return (ordinal + count) % 3;
        }
        return count + ordinal;
    }
}
