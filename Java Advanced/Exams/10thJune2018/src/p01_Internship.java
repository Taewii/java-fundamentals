import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p01_Internship {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int problemCount = Integer.parseInt(reader.readLine());
        int peopleCount = Integer.parseInt(reader.readLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        ArrayDeque<String> people = new ArrayDeque<>();

        while (problemCount-- > 0) {
            problems.push(reader.readLine());
        }

        Pattern pattern = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
        while (peopleCount-- > 0) {
            String person = reader.readLine();
            Matcher matcher = pattern.matcher(person);
            if (matcher.find()) {
                people.add(person);
            }
        }

        while (people.size() > 1 && !problems.isEmpty()) {
            String problem = problems.pop();
            String person = people.pop();

            int problemSum = Arrays.stream(problem.split("")).mapToInt(s -> s.charAt(0)).sum();
            int personSum = Arrays.stream(person.split("")).mapToInt(s -> s.charAt(0)).sum();

            if (personSum > problemSum) {
                people.add(person);
                System.out.printf("%s solved %s.%n", person, problem);
            } else {
                problems.add(problem);
                System.out.printf("%s failed %s.%n", person, problem);
            }
        }

        if (problems.isEmpty()) {
            System.out.println(people.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println(people.pop() + " gets the job!");
        }
    }
}
