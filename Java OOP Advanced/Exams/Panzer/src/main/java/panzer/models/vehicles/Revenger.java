package panzer.models.vehicles;

import panzer.contracts.Assembler;

import java.math.BigDecimal;

import static panzer.Constants.*;

public class Revenger extends BaseVehicle {
    public Revenger(String model, double weight, BigDecimal price, int attack,
                    int defence, int hitPoints, Assembler vehicleAssembler) {
        super(
                model,
                weight,
                price.multiply(new BigDecimal(REVENGER_PRICE_MODIFIER)),
                (int) (attack * REVENGER_ATTACK_MODIFIER),
                (int) (defence * REVENGER_DEFENCE_MODIFIER),
                (int) (hitPoints * REVENGER_HITPOINTS_MODIFIER),
                vehicleAssembler);
    }
}
