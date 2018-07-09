package p03_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHours;


    Worker(String firstName, String lastName, double weekSalary, double workHours) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHours(workHours);
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private double getWorkHours() {
        return workHours;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary > 10) {
            this.weekSalary = weekSalary;
        } else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
    }

    private void setWorkHours(double workHours) {
        if (workHours > 0 && workHours < 13) {
            this.workHours = workHours;
        } else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
    }

    private double salaryPerHour() {
        return this.getWeekSalary() / 7 / this.getWorkHours();
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("First Name: ").append(super.getFirstName()).append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName()).append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f", this.getWeekSalary())).append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.getWorkHours())).append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", this.salaryPerHour())).append(System.lineSeparator());

        return sb.toString();
    }
}