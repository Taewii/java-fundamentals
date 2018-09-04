package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Time;

public class PublicOrderEmergency extends BaseEmergency {

    private String caseStatus;

    public PublicOrderEmergency(String description, EmergencyLevel emergencyLevel, Time registrationTime, String caseStatus) {
        super(description, emergencyLevel, registrationTime);
        this.caseStatus = caseStatus;
    }

    public String getCaseStatus() {
        return this.caseStatus;
    }
}
