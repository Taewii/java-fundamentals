package p07_car_salesman;

import p07_car_salesman.models.Car;
import p07_car_salesman.models.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine = null;
            switch (tokens.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    if (Character.isDigit(tokens[2].charAt(0))) {
                        int displacement = Integer.parseInt(tokens[2]);
                        engine = new Engine(model, power, displacement);
                    } else {
                        String efficiency = tokens[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;
                case 4:
                    engine = new Engine(model, power, Integer.parseInt(tokens[2]), tokens[3]);
                    break;
            }
            engines.put(model, engine);
        }

        n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            String engine = tokens[1];

            Car car = null;
            switch (tokens.length) {
                case 2:
                    car = new Car(model, engines.get(engine));
                    break;
                case 3:
                    if (Character.isDigit(tokens[2].charAt(0))) {
                        int weight = Integer.parseInt(tokens[2]);
                        car = new Car(model, engines.get(engine), weight);
                    } else {
                        String color = tokens[2];
                        car = new Car(model, engines.get(engine), color);
                    }
                    break;
                case 4:
                    int weight = Integer.parseInt(tokens[2]);
                    String color = tokens[3];
                    car = new Car(model, engines.get(engine), weight, color);
                    break;
            }
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
