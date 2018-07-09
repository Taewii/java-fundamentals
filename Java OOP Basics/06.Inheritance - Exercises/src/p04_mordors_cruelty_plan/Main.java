package p04_mordors_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] food = reader.readLine().toLowerCase().split(" ");
        Gandalf gandalf = new Gandalf(food);

        System.out.println(gandalf.calculateHappiness());
        System.out.println(gandalf.calculateMood());
    }
}
