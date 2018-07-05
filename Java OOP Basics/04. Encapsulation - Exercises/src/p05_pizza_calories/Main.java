package p05_pizza_calories;

import p05_pizza_calories.models.Dough;
import p05_pizza_calories.models.Pizza;
import p05_pizza_calories.models.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String[] pizzaNameAndCount = reader.readLine().split(" ");
            Pizza pizza = new Pizza(pizzaNameAndCount[1], Integer.parseInt(pizzaNameAndCount[2]));

            String[] doughAndTechniqueAndWeight = reader.readLine().split(" ");
            Dough dough = new Dough(doughAndTechniqueAndWeight[1],
                    doughAndTechniqueAndWeight[2], Integer.parseInt(doughAndTechniqueAndWeight[3]));
            pizza.addDough(dough);

            String toppings;
            while (!"END".equals(toppings = reader.readLine())) {
                String[] toppingTypeAndWeight = toppings.split(" ");
                Topping topping = new Topping(toppingTypeAndWeight[1], Integer.parseInt(toppingTypeAndWeight[2]));
                pizza.addTopping(topping);
            }

            System.out.println(pizza);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
