package bg.softuni.models.centers;

public class FiremanServiceCenter extends BaseEmergencyCenter {
    public FiremanServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
    }

    @Override
    public String managingEmergencyType() {
        return "Property";
    }
}
