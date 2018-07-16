package p07_food_shortage;

import p07_food_shortage.contracts.Buyer;
import p07_food_shortage.models.Citizen;
import p07_food_shortage.models.Rebel;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Buyer> buyers = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");

            if (tokens.length == 3) {
                buyers.put(tokens[0], new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            } else if (tokens.length == 4) {
                buyers.put(tokens[0], new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]));
            }
        }

        String input;
        while (!"End".equals(input = reader.readLine())) {
            if (buyers.containsKey(input)) {
                buyers.get(input).buyFood();
            }
        }

        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
