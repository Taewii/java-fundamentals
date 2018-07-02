package p06_raw_data;

import p06_raw_data.models.Car;
import p06_raw_data.models.Cargo;
import p06_raw_data.models.Engine;
import p06_raw_data.models.Tyre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            List<Tyre> tires = new ArrayList<>();
            for (int i = 5; i < tokens.length - 1; i+=2) {
                double pressure = Double.parseDouble(tokens[i]);
                int age = Integer.parseInt(tokens[i + 1]);

                Tyre tyre = new Tyre(pressure, age);
                tires.add(tyre);
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = reader.readLine();
        if ("fragile".equals(command)) {
            cars.stream().filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getTyre().stream()
                            .filter(tyre -> tyre.getPressure() < 1).collect(Collectors.toList()).size() > 0)
                    .forEach(System.out::println);
        } else {
            cars.stream().filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
