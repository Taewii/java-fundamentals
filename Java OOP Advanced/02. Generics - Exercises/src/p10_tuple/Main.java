package p10_tuple;

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

        Tuple<String, String> tuple = new Tuple<>(first[0] + " " + first[1], first[2]);
        Tuple<String, Integer> tuple1 = new Tuple<>(second[0], Integer.parseInt(second[1]));
        Tuple<Integer, Double> tuple2 = new Tuple<>(Integer.parseInt(third[0]), Double.parseDouble(third[1]));

        System.out.println(tuple);
        System.out.println(tuple1);
        System.out.println(tuple2);
    }
}
