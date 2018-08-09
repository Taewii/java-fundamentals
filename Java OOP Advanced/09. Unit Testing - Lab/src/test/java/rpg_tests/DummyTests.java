package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

public class DummyTests {

    @Test
    public void dummyLosesHealthWhenAttacked() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(20, 20);

        axe.attack(dummy);

        Assert.assertEquals(10, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionWhenAttacked() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(5, 20);

        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyCanGiveExperience() {
        Dummy dummy = new Dummy(5, 20);
        Hero hero = new Hero("gosho");

        hero.attack(dummy);
        Assert.assertEquals(20, hero.getExperience());
    }

    @Test
    public void aliveDummyCantGiveExperience() {
        Dummy dummy = new Dummy(20, 20);
        Hero hero = new Hero("gosho");

        hero.attack(dummy);
        Assert.assertEquals(0, hero.getExperience());
    }
}
