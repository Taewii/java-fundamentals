package p05_border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Identifiable> ids = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            if (tokens.length == 3) {
                ids.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            } else {
                ids.add(new Robot(tokens[0], tokens[1]));
            }
        }

        String fakeId = reader.readLine();

        for (Identifiable id : ids) {
            if (id.getId().endsWith(fakeId)) {
                System.out.println(id.getId());
            }
        }
    }
}
