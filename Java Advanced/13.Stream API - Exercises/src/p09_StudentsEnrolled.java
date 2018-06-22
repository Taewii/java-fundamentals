import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class p09_StudentsEnrolled {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> students = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            students.add(input);
        }

        students.stream().filter(x -> x.split(" ")[0].endsWith("14") || x.split(" ")[0].endsWith("15"))
                .forEach(x -> System.out.println(x.split("[0-9]{3} ")[1]));
    }
}
