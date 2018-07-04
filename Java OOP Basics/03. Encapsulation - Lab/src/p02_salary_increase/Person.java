package p02_salary_increase;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void calculateRaise(int percent) {
        if (this.getAge() > 30) {
            setSalary(getSalary() + ((getSalary() * percent) / 100));
        } else {
            setSalary(getSalary() + ((getSalary() * percent) / 200));
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, this.salary);
    }
}
