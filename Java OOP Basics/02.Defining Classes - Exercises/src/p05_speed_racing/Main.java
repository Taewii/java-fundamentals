package p05_speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            int fuel = Integer.parseInt(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuel, fuelCost);
            cars.put(model, car);
        }

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String model = tokens[1];
            double amountOfKm = Double.parseDouble(tokens[2]);

            cars.get(model).Drive(amountOfKm);
        }

        cars.values().forEach(System.out::println);
    }
}
