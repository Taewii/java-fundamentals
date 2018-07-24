package avatar.entities;

import avatar.contracts.core.NationInterface;
import avatar.entities.benders.*;
import avatar.entities.monuments.*;

import java.util.ArrayList;
import java.util.List;

public class Nation implements NationInterface {

    private List<AirBender> airBenders;
    private List<WaterBender> waterBenders;
    private List<FireBender> fireBenders;
    private List<EarthBender> earthBenders;
    private List<AirMonument> airMonuments;
    private List<WaterMonument> waterMonuments;
    private List<FireMonument> fireMonuments;
    private List<EarthMonument> earthMonuments;

    public Nation() {
        this.airBenders = new ArrayList<>();
        this.waterBenders = new ArrayList<>();
        this.fireBenders = new ArrayList<>();
        this.earthBenders = new ArrayList<>();
        this.airMonuments = new ArrayList<>();
        this.waterMonuments = new ArrayList<>();
        this.fireMonuments = new ArrayList<>();
        this.earthMonuments = new ArrayList<>();
    }

    @Override
    public void addBender(Bender bender) {
        switch (bender.getClass().getSimpleName()) {
            case "AirBender":
                this.airBenders.add((AirBender) bender);
                break;
            case "WaterBender":
                this.waterBenders.add((WaterBender) bender);
                break;
            case "FireBender":
                this.fireBenders.add((FireBender) bender);
                break;
            case "EarthBender":
                this.earthBenders.add((EarthBender) bender);
                break;
        }
    }

    @Override
    public void addMonument(Monument monument) {
        switch (monument.getClass().getSimpleName()) {
            case "AirMonument":
                this.airMonuments.add((AirMonument) monument);
                break;
            case "WaterMonument":
                this.waterMonuments.add((WaterMonument) monument);
                break;
            case "FireMonument":
                this.fireMonuments.add((FireMonument) monument);
                break;
            case "EarthMonument":
                this.earthMonuments.add((EarthMonument) monument);
                break;
        }
    }

    @Override
    public double getFireNationPower() {
        double nationPower = 0;
        int monumentPower = 0;
        for (FireBender fireBender : this.fireBenders) {
            nationPower += fireBender.getPower() * fireBender.getHeatAggression();
        }

        for (FireMonument fireMonument : this.fireMonuments) {
            monumentPower += fireMonument.getFireAffinity();
        }

        return nationPower + (nationPower / 100) * monumentPower;
    }

    @Override
    public double getWaterNationPower() {
        double nationPower = 0;
        int monumentPower = 0;
        for (WaterBender waterBender : this.waterBenders) {
            nationPower += waterBender.getPower() * waterBender.getWaterClarity();
        }

        for (WaterMonument waterMonument : this.waterMonuments) {
            monumentPower += waterMonument.getWaterAffinity();
        }
        return nationPower + (nationPower / 100) * monumentPower;
    }

    @Override
    public double getAirNationPower() {
        double nationPower = 0;
        int monumentPower = 0;
        for (AirBender airBender : this.airBenders) {
            nationPower += airBender.getPower() * airBender.getAerialIntegrity();
        }

        for (AirMonument airMonument : this.airMonuments) {
            monumentPower += airMonument.getAirAffinity();
        }
        return nationPower + (nationPower / 100) * monumentPower;
    }

    @Override
    public double getEarthNationPower() {
        double nationPower = 0;
        int monumentPower = 0;
        for (EarthBender earthBender : this.earthBenders) {
            nationPower += earthBender.getPower() * earthBender.getGroundSaturation();
        }

        for (EarthMonument earthMonument : this.earthMonuments) {
            monumentPower += earthMonument.getEarthAffinity();
        }

        return nationPower + (nationPower / 100) * monumentPower;
    }

    @Override
    public String status(String nation) {
        StringBuilder sb = new StringBuilder();
        switch (nation) {
            case "Air":
                sb.append("Air Nation").append(System.lineSeparator());
                if (this.airBenders.size() == 0) {
                    sb.append("Benders: None").append(System.lineSeparator());
                } else {
                    sb.append("Benders:").append(System.lineSeparator());
                    for (AirBender airBender : airBenders) {
                        sb.append("###").append(airBender.toString());
                    }
                }

                if (this.airMonuments.size() == 0) {
                    sb.append("Monuments: None").append(System.lineSeparator());
                } else {
                    sb.append("Monuments:").append(System.lineSeparator());
                    for (AirMonument airMonument : airMonuments) {
                        sb.append("###").append(airMonument.toString());
                    }
                }
                break;
            case "Fire":
                sb.append("Fire Nation").append(System.lineSeparator());
                if (this.fireBenders.size() == 0) {
                    sb.append("Benders: None").append(System.lineSeparator());
                } else {
                    sb.append("Benders:").append(System.lineSeparator());
                    for (FireBender fireBender : fireBenders) {
                        sb.append("###").append(fireBender.toString());
                    }
                }

                if (this.fireMonuments.size() == 0) {
                    sb.append("Monuments: None").append(System.lineSeparator());
                } else {
                    sb.append("Monuments:").append(System.lineSeparator());
                    for (FireMonument fireMonument : fireMonuments) {
                        sb.append("###").append(fireMonument.toString());
                    }
                }
                break;
            case "Water":
                sb.append("Water Nation").append(System.lineSeparator());
                if (this.waterBenders.size() == 0) {
                    sb.append("Benders: None").append(System.lineSeparator());
                } else {
                    sb.append("Benders:").append(System.lineSeparator());
                    for (WaterBender waterBender : waterBenders) {
                        sb.append("###").append(waterBender.toString());
                    }
                }

                if (this.waterMonuments.size() == 0) {
                    sb.append("Monuments: None").append(System.lineSeparator());
                } else {
                    sb.append("Monuments:").append(System.lineSeparator());
                    for (WaterMonument waterMonument : waterMonuments) {
                        sb.append("###").append(waterMonument.toString());
                    }
                }
                break;
            case "Earth":
                sb.append("Earth Nation").append(System.lineSeparator());
                if (this.earthBenders.size() == 0) {
                    sb.append("Benders: None").append(System.lineSeparator());
                } else {
                    sb.append("Benders:").append(System.lineSeparator());
                    for (EarthBender earthBender : earthBenders) {
                        sb.append("###").append(earthBender.toString());
                    }
                }

                if (this.earthMonuments.size() == 0) {
                    sb.append("Monuments: None").append(System.lineSeparator());
                } else {
                    sb.append("Monuments:").append(System.lineSeparator());
                    for (EarthMonument earthMonument : earthMonuments) {
                        sb.append("###").append(earthMonument.toString());
                    }
                }
                break;
        }
        return sb.toString();
    }

    @Override
    public void war() {
        double firstFightWinner = Math.max(getAirNationPower(), getWaterNationPower());
        double secondFightWinner = Math.max(getEarthNationPower(), getFireNationPower());
        double winner = Math.max(firstFightWinner, secondFightWinner);

        if (this.getAirNationPower() != winner) {
            this.airBenders.clear();
            this.airMonuments.clear();
        }

        if (this.getWaterNationPower() != winner) {
            this.waterBenders.clear();
            this.waterMonuments.clear();
        }

        if (this.getFireNationPower() != winner) {
            this.fireBenders.clear();
            this.fireMonuments.clear();
        }

        if (this.getEarthNationPower() != winner) {
            this.earthBenders.clear();
            this.earthMonuments.clear();
        }
    }
}
