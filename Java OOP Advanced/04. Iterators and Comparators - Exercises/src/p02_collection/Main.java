package p02_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        ListyIterator listyIterator = null;
        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Create":
                    listyIterator = new ListyIterator<>(Arrays.stream(tokens).skip(1).toArray(String[]::new));
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                   try {
                       listyIterator.print();
                   } catch (IllegalArgumentException ex) {
                       System.out.println(ex.getMessage());
                   }
                    break;
                case "PrintAll":
                    try {
                        listyIterator.printAll();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
            }
        }
    }
}
