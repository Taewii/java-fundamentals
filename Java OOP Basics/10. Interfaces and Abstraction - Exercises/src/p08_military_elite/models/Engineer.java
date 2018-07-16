package p08_military_elite.models;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier {

    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new ArrayList<>();
    }

    public List<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f%n", getFirstName(), getLastName(), getId(), getSalary()));
        sb.append("Corps: ").append(getCorp()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        this.repairs.forEach(sb::append);

        return sb.toString();
    }
}
