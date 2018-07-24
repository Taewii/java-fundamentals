package avatar.core;

import avatar.contracts.core.Logic;
import avatar.entities.Nation;
import avatar.entities.benders.Bender;
import avatar.entities.monuments.Monument;
import avatar.factories.BenderFactory;
import avatar.factories.MonumentFactory;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic implements Logic {

    private Nation nation;
    private List<String> wars;
    private int warCounter;

    public BusinessLogic() {
        this.nation = new Nation();
        this.wars = new ArrayList<>();
        this.warCounter = 0;
    }

    @Override
    public void createBender(String type, String name, int power, double secondaryParameter) {
        Bender bender = BenderFactory.createBender(type, name, power, secondaryParameter);
        this.nation.addBender(bender);
    }

    @Override
    public void createMonument(String type, String name, int affinity) {
        Monument monument = MonumentFactory.createMonument(type, name, affinity);
        this.nation.addMonument(monument);
    }

    @Override
    public String status(String nation) {
        return this.nation.status(nation);
    }

    @Override
    public void war(String nation) {
        this.nation.war();
        this.warCounter++;
        this.wars.add(String.format("War %d issued by %s", this.warCounter, nation));
    }

    @Override
    public String quit() {
        StringBuilder sb = new StringBuilder();
        for (String war : this.wars) {
            sb.append(war).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
