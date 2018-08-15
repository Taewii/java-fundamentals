package p03_employee_info;

import p03_employee_info.models.ConsoleClient;
import p03_employee_info.models.ConsoleFormatter;
import p03_employee_info.models.EmployeeDatabase;
import p03_employee_info.models.EmployeeInfoProvider;

public class Main {
    public static void main(String[] args) {
        ConsoleClient console = new ConsoleClient(new EmployeeInfoProvider(new EmployeeDatabase()), new ConsoleFormatter());

        String output = console.getInfo();
        System.out.println(output);
    }
}
