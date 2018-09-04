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

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class EmergencyManagementSystem implements Manager {

    private List<Emergency> propertyEmergencies;
    private List<Emergency> healthEmergencies;
    private List<Emergency> orderEmergencies;

    private Register propertyEmergenciess;
    private Register healthEmergenciess;
    private Register orderEmergenciess;

    public EmergencyManagementSystem() {
        this.propertyEmergencies = new ArrayList<>();
        this.healthEmergencies = new ArrayList<>();
        this.orderEmergencies = new ArrayList<>();
        this.propertyEmergenciess = new EmergencyRegister();
        this.healthEmergenciess = new EmergencyRegister();
        this.orderEmergenciess = new EmergencyRegister();
    }

    @Override
    public String registerPropertyEmergency(String description, EmergencyLevel level,
                                            Time registrationTime, int propertyDamage) {
        Emergency emergency = new PublicPropertyEmergency(description, level, registrationTime, propertyDamage);

        this.propertyEmergenciess.enqueueEmergency(emergency);
        this.propertyEmergencies.add(emergency);
        return String.format(Constants.PROPERTY_CREATION_MESSAGE, level, registrationTime);
    }

    @Override
    public String registerHealthEmergency(String description, EmergencyLevel level,
                                          Time registrationTime, int casualties) {
        Emergency emergency = new PublicHealthEmergency(description, level, registrationTime, casualties);

        this.healthEmergenciess.enqueueEmergency(emergency);
        this.healthEmergencies.add(emergency);
        return String.format(Constants.HEALTH_CREATION_MESSAGE, level, registrationTime);
    }

    @Override
    public String registerOrderEmergency(String description, EmergencyLevel level,
                                         Time registrationTime, String status) {
        Emergency emergency = new PublicOrderEmergency(description, level, registrationTime, status);

        this.orderEmergenciess.enqueueEmergency(emergency);
        this.orderEmergencies.add(emergency);
        return String.format(Constants.ORDER_CREATION_MESSAGE, level, registrationTime);
    }

    @Override
    public String registerFireServiceCenter(String name, int amountOfEmergencies) {
        EmergencyCenter center = new FiremanServiceCenter(name, amountOfEmergencies);

        return String.format(Constants.FIRE_CENTER_CREATION_MESSAGE, name);
    }

    @Override
    public String registerMedicalServiceCenter(String name, int amountOfEmergencies) {
        EmergencyCenter center = new MedicalServiceCenter(name, amountOfEmergencies);

        return String.format(Constants.MEDICAL_CENTER_CREATION_MESSAGE, name);
    }

    @Override
    public String registerPoliceServiceCenter(String name, int amountOfEmergencies) {
        EmergencyCenter center = new PoliceServiceCenter(name, amountOfEmergencies);

        return String.format(Constants.POLICE_CENTER_CREATION_MESSAGE, name);
    }

    @Override
    public String processEmergencies(String type) {
        return null;
    }

    @Override
    public String emergencyReport() {
        return null;
    }
}
