package p11_threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] first = reader.readLine().split(" ");
        String[] second = reader.readLine().split(" ");
        String[] third = reader.readLine().split(" ");

        boolean isDrunk = "drunk".equals(second[2]);

        Threeuple<String, String, String> threeuple = new Threeuple<>(first[0] + " " + first[1], first[2], first[3]);
        Threeuple<String, Integer, Boolean> threeuple1 = new Threeuple<>(second[0], Integer.parseInt(second[1]), isDrunk);
        Threeuple<String, Double, String> threeuple2 = new Threeuple<>(third[0], Double.parseDouble(third[1]), third[2]);

        System.out.println(threeuple);
        System.out.println(threeuple1);
        System.out.println(threeuple2);
    }
}
