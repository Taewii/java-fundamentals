import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p12_VehiclePark { // it can be made a lot simpler but cba doing it
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<String> vehicles = new ArrayList<>();
        Collections.addAll(vehicles, input);

        int vehiclesSold = 0;

        while (true) {
            String command = scanner.nextLine();

            if ("End of customers!".equals(command)) {
                break;
            }

            String[] tokens = command.split(" ");
            String vehicleNeeded = tokens[0];
            int seatsNeeded = Integer.parseInt(tokens[2]);
            boolean vehicleExists = false;

            switch (vehicleNeeded) {
                case "Car":
                    String type = "c" + seatsNeeded;

                    if (vehicles.contains(type)) {
                        System.out.printf("Yes, sold for %d$%n", 'c' * seatsNeeded);
                        vehicles.remove(type);
                        vehiclesSold++;
                        vehicleExists = true;
                    } else {
                        vehicleExists = false;
                    }
                    break;
                case "Bus":
                    type = "b" + seatsNeeded;

                    if (vehicles.contains(type)) {
                        System.out.printf("Yes, sold for %d$%n", 'b' * seatsNeeded);
                        vehicles.remove(type);
                        vehiclesSold++;
                        vehicleExists = true;
                    } else {
                        vehicleExists = false;
                    }
                    break;
                case "Van":
                    type = "v" + seatsNeeded;

                    if (vehicles.contains(type)) {
                        System.out.printf("Yes, sold for %d$%n", 'v' * seatsNeeded);
                        vehicles.remove(type);
                        vehiclesSold++;
                        vehicleExists = true;
                    } else {
                        vehicleExists = false;
                    }
                    break;
            }

            if (!vehicleExists) {
                System.out.println("No");
            }
        }

        String vehiclesLeft = vehicles.toString();
        System.out.println("Vehicles left: " + vehiclesLeft.substring(1, vehiclesLeft.length() - 1));
        System.out.println("Vehicles sold: " + vehiclesSold);
    }
}
