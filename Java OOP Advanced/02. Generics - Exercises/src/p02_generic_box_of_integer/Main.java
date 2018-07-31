package p02_generic_box_of_integer;

import p02_generic_box_of_integer.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            Box<Integer> integer = new Box<>(Integer.parseInt(reader.readLine()));
            System.out.println(integer);
        }
    }
}
