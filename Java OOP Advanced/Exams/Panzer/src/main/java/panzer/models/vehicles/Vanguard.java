package panzer.models.vehicles;

import panzer.contracts.Assembler;

import java.math.BigDecimal;

import static panzer.Constants.*;

public class Vanguard extends BaseVehicle {

    public Vanguard(String model, double weight , BigDecimal price, int attack,
                    int defence, int hitPoints, Assembler vehicleAssembler) {
        super(
                model,
                weight * VANGUARD_WEIGHT_MODIFIER,
                price,
                (int) (attack * VANGUARD_ATTACK_MODIFIER),
                (int) (defence * VANGUARD_DEFENCE_MODIFIER),
                (int) (hitPoints * VANGUARD_HITPOINTS_MODIFIER),
                vehicleAssembler);
    }
}
