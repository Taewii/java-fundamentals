import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.in;

public class p02_SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Set<String> party = new TreeSet<>();

        String input;
        while (!"PARTY".equals(input = reader.readLine())) {
            party.add(input);
        }

        while (!"END".equals(input = reader.readLine())){
            party.remove(input);
        }

        System.out.println(party.size());
        for (String guest : party) {
            System.out.println(guest);
        }
    }
}
