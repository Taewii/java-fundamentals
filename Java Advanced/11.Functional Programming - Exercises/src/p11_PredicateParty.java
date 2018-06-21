import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.in;

public class p11_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] inputs = reader.readLine().split(" ");
        List<String> names = new ArrayList<>();
        Collections.addAll(names, inputs);

        String input;
        while (!"Party!".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String startsEndsOrLength = tokens[1];
            String stringOrLength = tokens[2];

            switch (command) {
                case "Remove":
                    removeName(names, startsEndsOrLength, stringOrLength);
                    break;
                case "Double":
                    names = doubleName(names, stringOrLength, startsEndsOrLength);
                    break;
            }
        }

        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(names.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
        }
    }

    private static void removeName(List<String> names, String startsEndsOrLength, String stringOrLength) {
        if ("EndsWith".equals(startsEndsOrLength)) {
            names.removeIf(x -> x.endsWith(stringOrLength));
        } else if ("StartsWith".equals(startsEndsOrLength)) {
            names.removeIf(x -> x.startsWith(stringOrLength));
        } else {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (name.length() == Integer.parseInt(stringOrLength)) {
                    names.remove(name);
                    i--;
                }
            }
        }
    }

    private static List<String> doubleName(List<String> names, String stringOrLength, String startsEndsOrLength) {
        List<String> list = new ArrayList<>();

        switch (startsEndsOrLength) {
            case "StartsWith":
                for (String name : names) {
                    if (name.startsWith(stringOrLength)) {
                        list.add(name);
                    }
                    list.add(name);
                }
                break;
            case "EndsWith":
                for (String name : names) {
                    if (name.endsWith(stringOrLength)) {
                        list.add(name);
                    }
                    list.add(name);
                }
                break;
            case "Length":
                for (String name : names) {
                    if (name.length() == Integer.parseInt(stringOrLength)) {
                        list.add(name);
                    }
                    list.add(name);
                }
                break;
        }
        return list;
    }
}
