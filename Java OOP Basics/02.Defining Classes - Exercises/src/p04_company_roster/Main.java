package p04_company_roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Employee> employees = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (Character.isDigit(tokens[4].charAt(0))) {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            employees.add(employee);
        }

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    double aAvg = a.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    double bAvg = b.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    return Double.compare(bAvg, aAvg);
                })
                .limit(1)
                .forEach(e -> {
                    StringBuilder result = new StringBuilder();
                    result.append("Highest Average Salary: ").append(e.getKey()).append(System.lineSeparator());

                    e.getValue().stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                            .forEach(employee -> result.append(employee.toString()).append(System.lineSeparator()));
                    System.out.print(result);
                });
    }
}
