package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import panzer.contracts.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTest {

    private Assembler assembler;
    private AttackModifyingPart attackModifyingPart;
    private DefenseModifyingPart defenseModifyingPart;
    private HitPointsModifyingPart hitPointsModifyingPart;

    @Before
    public void setUp() {
        this.assembler = new VehicleAssembler();
        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addArsenalPart(attackModifyingPart);
        this.assembler.addEndurancePart(hitPointsModifyingPart);
        this.assembler.addShellPart(defenseModifyingPart);
    }

    @Test
    public void getTotalWeight() {
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.defenseModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(10.0);

        Assert.assertEquals(30.0, this.assembler.getTotalWeight(), 0.1);
    }

    @Test
    public void getTotalPrice() {
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(new BigDecimal(123456.123456789));
        Mockito.when(this.defenseModifyingPart.getPrice()).thenReturn(new BigDecimal(123456.123456789));
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(new BigDecimal(123456.123456789));

        Assert.assertEquals(new BigDecimal(370368.370370367), this.assembler.getTotalPrice());
    }

    @Test
    public void getTotalAttackModification() {
        AttackModifyingPart part = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(part);

        Mockito.when(part.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        Assert.assertEquals(2L * Integer.MAX_VALUE, this.assembler.getTotalAttackModification());
    }

    @Test
    public void getTotalDefenseModification() {
        DefenseModifyingPart part = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addShellPart(part);

        Mockito.when(part.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.defenseModifyingPart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        Assert.assertEquals(2L * Integer.MAX_VALUE, this.assembler.getTotalDefenseModification());
    }

    @Test
    public void getTotalHitPointModification() {
        HitPointsModifyingPart part = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addEndurancePart(part);

        Mockito.when(part.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        Assert.assertEquals(2L * Integer.MAX_VALUE, this.assembler.getTotalHitPointModification());
    }

    // these don't seem to be needed for the judge tests
    @Test
    @SuppressWarnings("unchecked")
    public void addArsenalPart() {
        AttackModifyingPart part = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(part);
        List<AttackModifyingPart> parts = null;

        try {
            Field arsenalPartsField = this.assembler.getClass().getDeclaredField("arsenalParts");
            arsenalPartsField.setAccessible(true);
            parts = (List<AttackModifyingPart>) arsenalPartsField.get(this.assembler);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(2, parts.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addShellPart() {
        DefenseModifyingPart part = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addShellPart(part);
        List<DefenseModifyingPart> parts = null;

        try {
            Field shellPartsField = this.assembler.getClass().getDeclaredField("shellParts");
            shellPartsField.setAccessible(true);
            parts = (List<DefenseModifyingPart>) shellPartsField.get(this.assembler);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(2, parts.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addEndurancePart() {
        HitPointsModifyingPart part = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addEndurancePart(part);
        List<HitPointsModifyingPart> parts = null;

        try {
            Field endurancePartsField = this.assembler.getClass().getDeclaredField("enduranceParts");
            endurancePartsField.setAccessible(true);
            parts = (List<HitPointsModifyingPart>) endurancePartsField.get(this.assembler);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(2, parts.size());
    }
}