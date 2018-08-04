package p04_card_toString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String rank = reader.readLine();
        String suit = reader.readLine();

        System.out.println(new Card(rank, suit));
    }
}
