package bg.softuni.models.centers;

import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyCenter;
import bg.softuni.models.emergencies.BaseEmergency;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEmergencyCenter implements EmergencyCenter {

    private String name;
    private Integer amountOfMaximumEmergencies;
    private List<Emergency> processedEmergenices;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.name = name;
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
        this.processedEmergenices = new ArrayList<>();
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
        return this.processedEmergenices.size() >= this.amountOfMaximumEmergencies;
    }
}
