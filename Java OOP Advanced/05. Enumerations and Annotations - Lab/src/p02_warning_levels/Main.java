package p02_warning_levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Importance level = Importance.valueOf(reader.readLine());
        Logger logger = new Logger(level);

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(": ");

            logger.addMessage(new Message(Importance.valueOf(tokens[0]), tokens[1]));
        }

        Iterable<Message> messages = logger.getMessages();
        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
