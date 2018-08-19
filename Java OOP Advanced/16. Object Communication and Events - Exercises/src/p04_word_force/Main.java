package p04_word_force;

import p04_word_force.employees.BaseEmployee;
import p04_word_force.employees.EmployeeCollection;
import p04_word_force.employees.PartTimeEmployee;
import p04_word_force.employees.StandardEmployee;
import p04_word_force.jobs.Job;
import p04_word_force.jobs.JobCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        JobCollection jobCollection = new JobCollection();
        EmployeeCollection employeeCollection = new EmployeeCollection();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Job":
                    Job job = new Job(tokens[1], Integer.parseInt(tokens[2]), tokens[3], employeeCollection);
                    jobCollection.addJob(job);
                    break;
                case "StandartEmployee":
                    BaseEmployee standardEmployee = new StandardEmployee(tokens[1]);
                    employeeCollection.add(standardEmployee);
                    break;
                case "PartTimeEmployee":
                    BaseEmployee partTimeEmployee = new PartTimeEmployee(tokens[1]);
                    employeeCollection.add(partTimeEmployee);
                    break;
                case "Pass":
                    jobCollection.weekPassed();
                    break;
                case "Status":
                    System.out.println(jobCollection.status());
                    break;

            }
        }
    }
}
