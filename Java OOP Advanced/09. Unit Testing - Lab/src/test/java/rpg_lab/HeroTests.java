package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTests {

    private Hero hero;
    private Weapon weapon;
    private Target target;

    @Before
    public void setUp() {
        this.weapon = Mockito.mock(Weapon.class);
        this.target = Mockito.mock(Target.class);
    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        this.hero = new Hero("gosho", this.weapon);
        Mockito.when(this.target.isDead()).thenReturn(true);
        Mockito.when(this.target.giveExperience()).thenReturn(10);

        this.hero.attack(this.target);

        Assert.assertEquals(10, this.hero.getExperience());
    }
}