package p05_card_compareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Card card1 = new Card(reader.readLine(), reader.readLine());
        Card card2 = new Card(reader.readLine(), reader.readLine());

        System.out.println(card1.compareTo(card2) > 0 ? card1 : card2);
    }
}
