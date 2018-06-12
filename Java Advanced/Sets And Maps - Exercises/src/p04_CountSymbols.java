import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;

public class p04_CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<Character, Integer> symbolCount = new TreeMap<>();

        char[] input = reader.readLine().toCharArray();

        for (char ch : input) {
            symbolCount.putIfAbsent(ch, 0);
            symbolCount.put(ch, symbolCount.get(ch) + 1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : symbolCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
        }
    }
}
