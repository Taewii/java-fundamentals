package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Time;

public class PublicHealthEmergency extends BaseEmergency {

    private int casualties;

    public PublicHealthEmergency(String description, EmergencyLevel emergencyLevel, Time registrationTime, int casualties) {
        super(description, emergencyLevel, registrationTime);
        this.casualties = casualties;
    }

    public int getCasualties() {
        return this.casualties;
    }

    @Override
    public String emergencyType() {
        return "Health";
    }
}
