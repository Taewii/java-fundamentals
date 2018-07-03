package p10_cat_lady;

import p10_cat_lady.models.Cat;
import p10_cat_lady.models.Cymric;
import p10_cat_lady.models.Siamese;
import p10_cat_lady.models.StreetExtraordinaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, Cat> cats = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String breed = tokens[0];
            String name = tokens[1];
            double description = Double.parseDouble(tokens[2]);

            Cat cat = null;
            switch (breed) {
                case "Cymric":
                    cat = new Cymric(breed, name, description);
                    break;
                case "Siamese":
                    cat = new Siamese(breed, name, description);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(breed, name, description);
                    break;
            }

            cats.put(name, cat);
        }

        String catToPrint = reader.readLine();
        System.out.println(cats.get(catToPrint));
    }
}
