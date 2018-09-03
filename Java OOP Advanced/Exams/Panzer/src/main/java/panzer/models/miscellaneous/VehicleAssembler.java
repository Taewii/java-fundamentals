package panzer.models.miscellaneous;

import panzer.contracts.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VehicleAssembler implements Assembler {

    private List<Part> allParts;
    private List<AttackModifyingPart> arsenalParts;
    private List<DefenseModifyingPart> shellParts;
    private List<HitPointsModifyingPart> enduranceParts;

    public VehicleAssembler() {
        this.allParts = new ArrayList<>();
        this.arsenalParts = new ArrayList<>();
        this.shellParts = new ArrayList<>();
        this.enduranceParts = new ArrayList<>();
    }

    @Override
    public double getTotalWeight() {
        return this.allParts.stream().mapToDouble(Part::getWeight).sum();
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal result = BigDecimal.ZERO;

        for (Part part : this.allParts) {
            result = result.add(part.getPrice());
        }

        return result;
    }

    @Override
    public long getTotalAttackModification() {
        return this.arsenalParts.stream().mapToLong(AttackModifyingPart::getAttackModifier).sum();
    }

    @Override
    public long getTotalDefenseModification() {
        return this.shellParts.stream().mapToLong(DefenseModifyingPart::getDefenseModifier).sum();
    }

    @Override
    public long getTotalHitPointModification() {
        return this.enduranceParts.stream().mapToLong(HitPointsModifyingPart::getHitPointsModifier).sum();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.arsenalParts.add((AttackModifyingPart) arsenalPart);
        this.allParts.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.shellParts.add((DefenseModifyingPart) shellPart);
        this.allParts.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.enduranceParts.add((HitPointsModifyingPart) endurancePart);
        this.allParts.add(endurancePart);
    }
}