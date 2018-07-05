package p04_shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Person> peopleMap = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] people = reader.readLine().split(";");
        for (String token : people) {
            String[] tokens2 = token.split("=");
            String name = tokens2[0];
            int money = Integer.parseInt(tokens2[1]);

            Person person;

            try {
                person = new Person(name, money);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            peopleMap.put(name, person);
        }

        String[] productss = reader.readLine().split(";"); {
            for (String product : productss) {
                String[] tokens = product.split("=");
                String name = tokens[0];
                int price = Integer.parseInt(tokens[1]);

                Product product1;
                try {
                    product1 = new Product(name, price);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }
                products.put(name, product1);
            }
        }

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            String item = tokens[1];

            if (peopleMap.get(name).getMoney() >= products.get(item).getCost()) {
                peopleMap.get(name).setMoney((peopleMap.get(name).getMoney() - products.get(item).getCost()));
                peopleMap.get(name).getProducts().add(products.get(item));
                System.out.println(name + " bought " + item);
            } else {
                System.out.println(name + " can't afford " + item);
            }
        }

        peopleMap.values().forEach(System.out::println);
    }
}
