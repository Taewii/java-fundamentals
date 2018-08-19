package p01_event_implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener handler = new Handler();

        dispatcher.addNameChangeListener(handler);

        String input;
        while (!"End".equals(input = reader.readLine())) {
            dispatcher.setName(input);
        }
    }
}
