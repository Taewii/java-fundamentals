import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class p04_SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> people = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String secondName = tokens[1];

            people.add(firstName + " " + secondName);
        }

       people.stream().sorted((a,b) -> {
           int result = a.split(" ")[1].compareTo(b.split(" ")[1]);

           if (result == 0) {
               result = b.split(" ")[0].compareTo(a.split(" ")[0]);
           }
           return result;
       }).forEach(System.out::println);
    }
}
