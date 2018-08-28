package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public class CryogenRod extends BaseModule implements EnergyModule {

    private int energyOutput;

    public CryogenRod(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Energy Output: %d", this.getEnergyOutput()));

        return sb.toString();
    }
}
