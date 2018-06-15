import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

public class p01_ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Set<String> parkingLot = new HashSet<>();

        while (true) {
            String input = reader.readLine();
            if ("END".equals(input)) {
                break;
            }

            String[] tokens = input.split(", ");

            String command = tokens[0];
            String licensePlate = tokens[1];

            if ("IN".equals(command)) {
                parkingLot.add(licensePlate);
            } else {
                parkingLot.remove(licensePlate);
            }
        }

        if (!parkingLot.isEmpty()) {
            for (String licensePlate : parkingLot) {
                System.out.println(licensePlate);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
