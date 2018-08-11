package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;

import java.math.BigDecimal;

public class VehicleAssemblerTest {

    private Assembler vehicleAssembler;
    private AttackModifyingPart arsenalPart;
    private DefenseModifyingPart shellPart;
    private HitPointsModifyingPart endurancePart;

    @Before
    public void setUp() {
        this.vehicleAssembler = new VehicleAssembler();
        this.arsenalPart = Mockito.mock(AttackModifyingPart.class);
        this.shellPart = Mockito.mock(DefenseModifyingPart.class);
        this.endurancePart = Mockito.mock(HitPointsModifyingPart.class);
        this.vehicleAssembler.addArsenalPart(this.arsenalPart);
        this.vehicleAssembler.addShellPart(this.shellPart);
        this.vehicleAssembler.addEndurancePart(this.endurancePart);
    }

    @Test
    public void getTotalWeight() {
        Mockito.when(this.arsenalPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.shellPart.getWeight()).thenReturn(20.0);
        Mockito.when(this.endurancePart.getWeight()).thenReturn(30.0);

        Assert.assertEquals(60.0, this.vehicleAssembler.getTotalWeight(), 0.1);
    }

    @Test
    public void getTotalPrice() {
        Mockito.when(this.arsenalPart.getPrice()).thenReturn(BigDecimal.ZERO);
        Mockito.when(this.shellPart.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.endurancePart.getPrice()).thenReturn(BigDecimal.ONE);

        Assert.assertEquals(BigDecimal.valueOf(11), this.vehicleAssembler.getTotalPrice());
    }

    @Test
    public void getTotalAttackModification() {
        Mockito.when(this.arsenalPart.getAttackModifier()).thenReturn(20);
        AttackModifyingPart part = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part.getAttackModifier()).thenReturn(10);
        this.vehicleAssembler.addArsenalPart(part);

        Assert.assertEquals(30, this.vehicleAssembler.getTotalAttackModification());
    }

    @Test
    public void getTotalDefenseModification() {
        Mockito.when(this.shellPart.getDefenseModifier()).thenReturn(20);
        DefenseModifyingPart part = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(part.getDefenseModifier()).thenReturn(10);
        this.vehicleAssembler.addShellPart(part);

        Assert.assertEquals(30, this.vehicleAssembler.getTotalDefenseModification());
    }

    @Test
    public void getTotalHitPointModification() {
        Mockito.when(this.endurancePart.getHitPointsModifier()).thenReturn(20);
        HitPointsModifyingPart part = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part.getHitPointsModifier()).thenReturn(10);
        this.vehicleAssembler.addEndurancePart(part);

        Assert.assertEquals(30, this.vehicleAssembler.getTotalHitPointModification());
    }

    @Test
    public void testAddArsenalPart() {
        this.vehicleAssembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part1.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        this.vehicleAssembler.addArsenalPart(part1);
        this.vehicleAssembler.addArsenalPart(part2);

        Assert.assertEquals((long) Integer.MAX_VALUE + Integer.MAX_VALUE,
                this.vehicleAssembler.getTotalAttackModification());
    }

    @Test
    public void addShellPart() {
        this.vehicleAssembler = new VehicleAssembler();
        DefenseModifyingPart part1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part2 = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(part1.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        this.vehicleAssembler.addShellPart(part1);
        this.vehicleAssembler.addShellPart(part2);

        Assert.assertEquals((long) Integer.MAX_VALUE + Integer.MAX_VALUE,
                this.vehicleAssembler.getTotalDefenseModification());
    }

    @Test
    public void addEndurancePart() {
        this.vehicleAssembler = new VehicleAssembler();
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part2 = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        this.vehicleAssembler.addEndurancePart(part1);
        this.vehicleAssembler.addEndurancePart(part2);

        Assert.assertEquals((long) Integer.MAX_VALUE + Integer.MAX_VALUE,
                this.vehicleAssembler.getTotalHitPointModification());
    }
}