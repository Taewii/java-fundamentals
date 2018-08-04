package p03_coffee_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            if (tokens.length == 1) {
                coffeeMachine.insertCoin(tokens[0]);
            } else {
                coffeeMachine.buyCoffee(tokens[0], tokens[1]);
            }
        }

        Iterable<Coffee> coffees = coffeeMachine.coffeesSold();
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
    }
}
