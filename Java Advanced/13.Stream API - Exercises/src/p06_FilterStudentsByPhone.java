import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class p06_FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> students = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            students.add(input);
        }

        students.stream().filter(x -> x.split(" ")[2]
                .startsWith("02") || x.split(" ")[2].startsWith("+3592"))
                .forEach(x -> System.out.println(x.split(" ")[0] + " " + x.split(" ")[1]));
    }
}
