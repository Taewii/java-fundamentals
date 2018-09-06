package bg.softuni.core;

import bg.softuni.collection.EmergencyRegister;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyCenter;
import bg.softuni.interfaces.Manager;
import bg.softuni.interfaces.Register;
import bg.softuni.utils.RegistrationTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Deque;

public class EmergencyManagementSystemTest {

    private Manager manager;

    @Before
    public void setUp() {
        Register register = new EmergencyRegister();
        this.manager = new EmergencyManagementSystem(register);
    }

    @Test
    public void registerPropertyEmergency() {
        this.manager.registerPropertyEmergency("test", EmergencyLevel.MINOR,
                new RegistrationTime("12:24 25/02/2016"), 10);

        Assert.assertEquals(1, getEmergenciesCount());
    }

    @Test
    public void registerHealthEmergency() {
        this.manager.registerHealthEmergency("test", EmergencyLevel.MINOR,
                new RegistrationTime("12:24 25/02/2016"), 10);

        Assert.assertEquals(1, getEmergenciesCount());
    }

    @Test
    public void registerOrderEmergency() {
        this.manager.registerOrderEmergency("test", EmergencyLevel.MINOR,
                new RegistrationTime("12:24 25/02/2016"), "Special");

        Assert.assertEquals(1, getEmergenciesCount());
    }

    @Test
    public void registerFireServiceCenter() {
        this.manager.registerFireServiceCenter("test", 2);
        Assert.assertEquals(1, getCentersCount());
    }

    @Test
    public void registerMedicalServiceCenter() {
        this.manager.registerMedicalServiceCenter("test", 2);
        Assert.assertEquals(1, getCentersCount());
    }

    @Test
    public void registerPoliceServiceCenter() {
        this.manager.registerPoliceServiceCenter("test", 2);
        Assert.assertEquals(1, getCentersCount());
    }

    @Test
    public void processEmergencies() {
        this.manager.registerMedicalServiceCenter("test", 1);
        this.manager.registerHealthEmergency("test", EmergencyLevel.MINOR,
                new RegistrationTime("12:24 25/02/2016"), 10);
        this.manager.registerHealthEmergency("test", EmergencyLevel.MINOR,
                new RegistrationTime("12:24 25/02/2016"), 10);
        String actual = this.manager.processEmergencies("Health");
        String expected = "Health Emergencies left to process: 1.";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void emergencyReport() {
        this.manager.registerMedicalServiceCenter("test", 1);
        this.manager.registerHealthEmergency("test", EmergencyLevel.MINOR,
                new RegistrationTime("12:24 25/02/2016"), 10);
        this.manager.registerHealthEmergency("test", EmergencyLevel.MINOR,
                new RegistrationTime("12:24 25/02/2016"), 10);
        this.manager.processEmergencies("Health");
        this.manager.registerMedicalServiceCenter("test", 2);

        String actual = this.manager.emergencyReport();
        String expected =
                "PRRM Services Live Statistics" + System.lineSeparator() +
                        "Fire Service Centers: 0" + System.lineSeparator() +
                        "Medical Service Centers: 1" + System.lineSeparator() +
                        "Police Service Centers: 0" + System.lineSeparator() +
                        "Total Processed Emergencies: 1" + System.lineSeparator() +
                        "Currently Registered Emergencies: 1" + System.lineSeparator() +
                        "Total Property Damage Fixed: 0" + System.lineSeparator() +
                        "Total Health Casualties Saved: 10" + System.lineSeparator() +
                        "Total Special Cases Processed: 0";

        Assert.assertEquals(expected, actual);
    }

    @SuppressWarnings("unchecked")
    private int getCentersCount() {
        try {
            Field field = this.manager.getClass().getDeclaredField("centers");
            field.setAccessible(true);
            Deque<EmergencyCenter> centers = (Deque<EmergencyCenter>) field.get(this.manager);
            return centers.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int getEmergenciesCount() {
        Register register;
        Emergency[] emergencyQueue;

        try {
            Field field = this.manager.getClass().getDeclaredField("emergencies");
            field.setAccessible(true);
            register = (Register) field.get(this.manager);
            Field emergenciesField = register.getClass().getDeclaredField("emergencyQueue");
            emergenciesField.setAccessible(true);
            emergencyQueue = (Emergency[]) emergenciesField.get(register);

            int count = 0;
            for (Emergency emergency : emergencyQueue) {
                if (emergency != null) {
                    count++;
                }
            }
            return count;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }
}