package p09_google.models;

public class Company {

    private String name;
    private String department;
    private double salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        if (this.name == null) {
            return "";
        }
        return String.format("%s %s %.2f%n", this.name, this.department, this.salary);
    }
}
