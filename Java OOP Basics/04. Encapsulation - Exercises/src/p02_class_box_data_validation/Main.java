package p02_class_box_data_validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Box box = null;

        try {
            box = new Box(length, width, height);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        if (box != null) {
            System.out.println(box);
        }
    }
}
