package cresla.entities.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends BaseReactor {

    private int cryoProductionIndex;

    public CryoReactor(int id, Container moduleContainer, int cryoProductionIndex) {
        super(id, moduleContainer);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getEnergy() * this.cryoProductionIndex;
    }
}
