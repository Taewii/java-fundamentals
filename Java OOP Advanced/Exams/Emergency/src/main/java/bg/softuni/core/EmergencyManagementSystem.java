package bg.softuni.core;

import bg.softuni.collection.EmergencyRegister;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.*;
import bg.softuni.models.centers.FiremanServiceCenter;
import bg.softuni.models.centers.MedicalServiceCenter;
import bg.softuni.models.centers.PoliceServiceCenter;
import bg.softuni.models.emergencies.PublicHealthEmergency;
import bg.softuni.models.emergencies.PublicOrderEmergency;
import bg.softuni.models.emergencies.PublicPropertyEmergency;
import bg.softuni.utils.Constants;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class EmergencyManagementSystem implements Manager {

    private Deque<EmergencyCenter> centers;
    private Register emergencies;
    private List<Emergency> processedEmergencies;

    public EmergencyManagementSystem() {
        this.emergencies = new EmergencyRegister();
        this.centers = new ArrayDeque<>();
        this.processedEmergencies = new ArrayList<>();
    }

    @Override
    public String registerPropertyEmergency(String description, EmergencyLevel level,
                                            Time registrationTime, int propertyDamage) {
        Emergency emergency = new PublicPropertyEmergency(description, level, registrationTime, propertyDamage);

        this.emergencies.enqueueEmergency(emergency);
        return String.format(Constants.PROPERTY_CREATION_MESSAGE, level, registrationTime);
    }

    @Override
    public String registerHealthEmergency(String description, EmergencyLevel level,
                                          Time registrationTime, int casualties) {
        Emergency emergency = new PublicHealthEmergency(description, level, registrationTime, casualties);

        this.emergencies.enqueueEmergency(emergency);
        return String.format(Constants.HEALTH_CREATION_MESSAGE, level, registrationTime);
    }

    @Override
    public String registerOrderEmergency(String description, EmergencyLevel level,
                                         Time registrationTime, String status) {
        Emergency emergency = new PublicOrderEmergency(description, level, registrationTime, status);

        this.emergencies.enqueueEmergency(emergency);
        return String.format(Constants.ORDER_CREATION_MESSAGE, level, registrationTime);
    }

    @Override
    public String registerFireServiceCenter(String name, int amountOfEmergencies) {
        EmergencyCenter center = new FiremanServiceCenter(name, amountOfEmergencies);
        this.centers.add(center);
        return String.format(Constants.FIRE_CENTER_CREATION_MESSAGE, name);
    }

    @Override
    public String registerMedicalServiceCenter(String name, int amountOfEmergencies) {
        EmergencyCenter center = new MedicalServiceCenter(name, amountOfEmergencies);
        this.centers.add(center);
        return String.format(Constants.MEDICAL_CENTER_CREATION_MESSAGE, name);
    }

    @Override
    public String registerPoliceServiceCenter(String name, int amountOfEmergencies) {
        EmergencyCenter center = new PoliceServiceCenter(name, amountOfEmergencies);
        this.centers.add(center);
        return String.format(Constants.POLICE_CENTER_CREATION_MESSAGE, name);
    }

    @Override
    public String processEmergencies(String type) {
        while (containsEmergencyCenterType(type) && this.emergencies.containsEmergencyType(type)) {
            if (this.centers.peek().managingEmergencyType().equals(type)) {
                EmergencyCenter center = this.centers.pop();
                Emergency emergency;
                while (!this.emergencies.peekEmergency().emergencyType().equals(type)) {
                    emergency = this.emergencies.dequeueEmergency();
                    this.emergencies.enqueueEmergency(emergency);
                }

                emergency = this.emergencies.dequeueEmergency();
                center.processEmergency(emergency);
                this.processedEmergencies.add(emergency);
                if (!center.isForRetirement()) {
                    this.centers.add(center);
                }
            } else {
                EmergencyCenter center = this.centers.pop();
                this.centers.add(center);
            }
        }

        if (!this.emergencies.containsEmergencyType(type)) {
            return String.format(Constants.SUCCESSFUL_EMERGENCY_PROCESSING, type);
        } else {
            return String.format(Constants.EMERGENCIES_LEFT_TO_PROCESS, type, this.emergencies.amountEmergenciesLeftFromType(type));
        }
    }

    @Override
    public String emergencyReport() {
        int totalFireCenters = 0;
        int totalMedicalCenters = 0;
        int totalPoliceCenters = 0;
        int totalPropertyDamageFixed = 0;
        int totalHealthCasualtiesSaved = 0;
        int totalSpecialCasesProcessed = 0;

        for (EmergencyCenter center : this.centers) {
            if (center instanceof FiremanServiceCenter) {
                totalFireCenters++;
            } else if (center instanceof MedicalServiceCenter) {
                totalMedicalCenters++;
            } else {
                totalPoliceCenters++;
            }
        }

        for (Emergency emergency : this.processedEmergencies) {
            if (emergency instanceof PublicPropertyEmergency) {
                totalPropertyDamageFixed += ((PublicPropertyEmergency) emergency).getPropertyDamage();
            } else if (emergency instanceof PublicHealthEmergency) {
                totalHealthCasualtiesSaved += ((PublicHealthEmergency) emergency).getCasualties();
            } else if (emergency instanceof PublicOrderEmergency) {
                if ("Special".equals(emergency.emergencyType())) {
                    totalSpecialCasesProcessed++;
                }
            }
        }

        int currentlyRegisteredEmergencies = 0;

        try {
            Field emergencies = this.emergencies.getClass().getDeclaredField("emergencyQueue");
            emergencies.setAccessible(true);
            try {
                Emergency[] field = (Emergency[]) emergencies.get(this.emergencies);
                currentlyRegisteredEmergencies = field.length;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("PRRM Services Live Statistics").append(System.lineSeparator());
        sb.append("Fire Service Centers: ").append(totalFireCenters).append(System.lineSeparator());
        sb.append("Medical Service Centers: ").append(totalMedicalCenters).append(System.lineSeparator());
        sb.append("Police Service Centers: ").append(totalPoliceCenters).append(System.lineSeparator());
        sb.append("Total Processed Emergencies: ").append(this.processedEmergencies.size()).append(System.lineSeparator());
        sb.append("Currently Registered Emergencies: ").append(currentlyRegisteredEmergencies).append(System.lineSeparator());
        sb.append("Total Property Damage Fixed: ").append(totalPropertyDamageFixed).append(System.lineSeparator());
        sb.append("Total Health Casualties Saved: ").append(totalHealthCasualtiesSaved).append(System.lineSeparator());
        sb.append("Total Special Cases Processed: ").append(totalSpecialCasesProcessed);

        return sb.toString();
    }

    private boolean containsEmergencyCenterType(String type) {
        for (EmergencyCenter center : this.centers) {
            if (center.managingEmergencyType().equals(type)) {
                return true;
            }
        }
        return false;
    }
}
