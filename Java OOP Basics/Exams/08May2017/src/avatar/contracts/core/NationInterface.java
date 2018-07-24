package avatar.contracts.core;

import avatar.entities.benders.Bender;
import avatar.entities.monuments.Monument;

public interface NationInterface {

    void addBender(Bender bender);

    void addMonument(Monument monument);

    double getFireNationPower();

    double getWaterNationPower();

    double getAirNationPower();

    double getEarthNationPower();

    String status(String nation);

    void war();
}
