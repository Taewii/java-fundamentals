package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends BasePart implements DefenseModifyingPart {

    private int defenceModifier;

    public ShellPart(String model, double weight, BigDecimal price, int defenceModifier) {
        super(model, weight, price);
        this.defenceModifier = defenceModifier;
    }

    @Override
    public int getDefenseModifier() {
        return this.defenceModifier;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(String.format("+%d Defence", this.getDefenseModifier()));

        return sb.toString();
    }
}
