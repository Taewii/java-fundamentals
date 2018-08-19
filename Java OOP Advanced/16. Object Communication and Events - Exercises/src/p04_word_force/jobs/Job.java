package p04_word_force.jobs;

import p04_word_force.employees.BaseEmployee;
import p04_word_force.employees.EmployeeCollection;

public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private String employeeName;
    private BaseEmployee employee;

    public Job(String name, int hoursOfWorkRequired, String employeeName, EmployeeCollection employeeCollection) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employeeName = employeeName;
        this.employee = employeeCollection.getEmployee(employeeName);
    }

    public String getName() {
        return this.name;
    }

    public int getHoursOfWorkRequired() {
        return this.hoursOfWorkRequired;
    }

    public void update() {
        this.hoursOfWorkRequired -= this.employee.getWorkHoursPerWeek();
    }
}
