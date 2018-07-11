package p01_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] carTokens = reader.readLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        String[] truckTokens = reader.readLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));
        DecimalFormat df = new DecimalFormat("#.##");

        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] input = reader.readLine().split(" ");
            String vehicle = input[1];

            try {
                if ("Drive".equals(input[0])) {
                    double distance = Double.parseDouble(input[2]);

                    if ("Car".equals(input[1])) {
                        car.drive(distance);
                        System.out.printf("Car travelled %s km%n", df.format(distance));
                    } else {
                        truck.drive(distance);
                        System.out.printf("Truck travelled %s km%n", df.format(distance));
                    }
                } else {
                    double fuel = Double.parseDouble(input[2]);

                    if ("Car".equals(vehicle)) {
                        car.refuel(fuel);
                    } else {
                        truck.refuel(fuel);
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
