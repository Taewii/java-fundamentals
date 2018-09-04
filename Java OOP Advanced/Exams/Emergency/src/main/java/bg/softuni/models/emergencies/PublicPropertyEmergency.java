package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Time;

public class PublicPropertyEmergency extends BaseEmergency {

    private int propertyDamage;

    public PublicPropertyEmergency(String description, EmergencyLevel emergencyLevel, Time registrationTime, int propertyDamage) {
        super(description, emergencyLevel, registrationTime);
        this.propertyDamage = propertyDamage;
    }

    public int getPropertyDamage() {
        return this.propertyDamage;
    }
}
