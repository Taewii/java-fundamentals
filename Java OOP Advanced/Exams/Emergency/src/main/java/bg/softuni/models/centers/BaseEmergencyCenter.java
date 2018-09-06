package bg.softuni.models.centers;

import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyCenter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEmergencyCenter implements EmergencyCenter {

    private String name;
    private Integer amountOfMaximumEmergencies;
    private List<Emergency> processedEmergencies;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.name = name;
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
        this.processedEmergencies = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    @Override
    public Boolean isForRetirement() {
        return this.processedEmergencies.size() >= this.amountOfMaximumEmergencies;
    }

    public void processEmergency(Emergency emergency) {
        this.processedEmergencies.add(emergency);
    }
}
