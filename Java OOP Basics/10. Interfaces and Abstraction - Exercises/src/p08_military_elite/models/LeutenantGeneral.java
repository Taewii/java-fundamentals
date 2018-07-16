package p08_military_elite.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeutenantGeneral extends Private {

    private List<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public List<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f%n", getFirstName(), getLastName(), getId(), getSalary()));
        sb.append("Privates:").append(System.lineSeparator());
        this.privates.stream().sorted(Comparator.comparing(Private::getId).reversed())
                .forEach(s -> sb.append("  ").append(s));

        return sb.toString();
    }
}
