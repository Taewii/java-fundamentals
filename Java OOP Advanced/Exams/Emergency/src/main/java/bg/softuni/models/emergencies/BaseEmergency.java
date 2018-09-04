package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.Time;

public abstract class BaseEmergency implements Emergency {

    private String description;
    private EmergencyLevel emergencyLevel;
    private Time registrationTime;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel, Time registrationTime) {
        this.description = description;
        this.emergencyLevel = emergencyLevel;
        this.registrationTime = registrationTime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }

    @Override
    public Time getRegistrationTime() {
        return registrationTime;
    }
}
