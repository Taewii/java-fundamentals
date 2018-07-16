package p08_military_elite.models;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier {

    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missions = new ArrayList<>();
    }

    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f%n", getFirstName(), getLastName(), getId(), getSalary()));
        sb.append("Corps: ").append(getCorp()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        this.missions.forEach(sb::append);

        return sb.toString();
    }
}
