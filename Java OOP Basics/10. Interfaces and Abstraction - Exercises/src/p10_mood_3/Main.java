package p10_mood_3;

import p10_mood_3.models.Archangel;
import p10_mood_3.models.Demon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] input = reader.readLine().split(" \\| ");

        if ("Demon".equals(input[1])) {
            System.out.println(new Demon(input[0], input[1], Integer.parseInt(input[3]), Double.parseDouble(input[2])));
        } else {
            System.out.println(new Archangel(input[0], input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3])));
        }
    }
}
