import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;

public class p05_AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, double[]> graduates = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- != 0) {
            String student = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            graduates.put(student, grades);
        }

        for (Map.Entry<String, double[]> studentEntry : graduates.entrySet()) {
            double average = 0;
            for (double grade : studentEntry.getValue()) {
                average += grade;
            }
            average /= studentEntry.getValue().length;

            System.out.printf("%s is graduated with %s%n", studentEntry.getKey(), average);
        }
    }
}
