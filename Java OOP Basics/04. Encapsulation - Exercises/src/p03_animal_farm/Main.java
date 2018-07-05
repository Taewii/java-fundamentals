package p03_animal_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Chicken chicken = null;

        try {
           chicken =  new Chicken(name, age);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        if (chicken != null) {
            chicken.productPerDay();
            System.out.println(chicken);
        }
    }
}
