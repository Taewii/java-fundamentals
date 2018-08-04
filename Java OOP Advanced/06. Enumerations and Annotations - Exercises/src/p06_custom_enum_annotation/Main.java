package p06_custom_enum_annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String type = reader.readLine();

        if (type.equals("Rank")) {
            Class<Rank> rankClass = Rank.class;
            if (rankClass.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = rankClass.getAnnotation(CustomAnnotation.class);
                System.out.printf("Type = %s, Description = %s", annotation.type(), annotation.description());
            }
        } else {
            Class<Suit> suitClass = Suit.class;
            if (suitClass.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = suitClass.getAnnotation(CustomAnnotation.class);
                System.out.printf("Type = %s, Description = %s", annotation.type(), annotation.description());
            }
        }
    }
}
