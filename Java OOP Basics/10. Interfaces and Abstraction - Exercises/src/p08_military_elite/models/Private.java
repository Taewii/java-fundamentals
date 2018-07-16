package p08_military_elite.models;

import p08_military_elite.contracts.PrivateInterface;

public class Private extends Soldier implements PrivateInterface {

    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f%n", getFirstName(), getLastName(), getId(), this.salary);
    }
}
