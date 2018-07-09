package p06_animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String input;
        while (!"Beast!".equals(input = reader.readLine())) {
            String[] tokens = reader.readLine().split(" ");
            if (tokens.length != 3) {
                System.out.println("Invalid input!");
                continue;
            }

            try {
                Animal animal = null;
                switch (input) {
                    case "Cat":
                        animal = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        break;
                    case "Dog":
                        animal = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        break;
                    case "Frog":
                        animal = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        break;
                    case "Kitten":
                        animal = new Kitten(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }

                if (animal != null) {
                    System.out.println(animal);
                    animal.produceSound();
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
