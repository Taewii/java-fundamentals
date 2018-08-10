package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class DummyTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 20;

    private Weapon weapon;
    private Target target;

    @Before
    public void startUp() {
        this.weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void targetLosesHealthWhenAttacked() {
        this.weapon.attack(this.target);

        Assert.assertEquals(10, this.target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionWhenAttacked() {
        this.weapon.attack(this.target);
        this.weapon.attack(this.target);
        this.weapon.attack(this.target);
    }

    @Test
    public void deadDummyCanGiveExperience() {
        this.weapon.attack(this.target);
        this.weapon.attack(this.target);

        Assert.assertEquals(20, target.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveExperience() {
        this.target.giveExperience();
    }
}
