package callofduty.core;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissionControlImplTest {

    private MissionControl missionControl;

    @Before
    public void setUp() {
        this.missionControl = new MissionControlImpl();
    }

    @Test
    public void generateMission() {
        Mission mission = missionControl.generateMission("1", 10.0, 10.0);
        String actualId = mission.getId();
        double actualRating = mission.getRating();
        double actualBounty = mission.getBounty();

        Assert.assertEquals("1", actualId);
        Assert.assertEquals(7.5, actualRating, 0.1);
        Assert.assertEquals(12.5, actualBounty, 0.1);

        Mission mission2 = missionControl.generateMission("2", 10.0, 10.0);

        String actualId2 = mission2.getId();
        double actualRating2 = mission2.getRating();
        double actualBounty2 = mission2.getBounty();

        Assert.assertEquals("2", actualId2);
        Assert.assertEquals(15.0, actualRating2, 0.1);
        Assert.assertEquals(20.0, actualBounty2, 0.1);

        Mission mission3 = missionControl.generateMission("3", 10.0, 10.0);

        String actualId3 = mission3.getId();
        double actualRating3 = mission3.getRating();
        double actualBounty3 = mission3.getBounty();

        Assert.assertEquals("3", actualId3);
        Assert.assertEquals(2.5, actualRating3, 0.1);
        Assert.assertEquals(15.0, actualBounty3, 0.1);
    }

    @Test
    public void overflowingBountyAndNegativeRating() {
        Mission mission = missionControl.generateMission("1", -10.0, Double.MAX_VALUE);
        String actualId = mission.getId();
        double actualRating = mission.getRating();
        double actualBounty = mission.getBounty();

        Assert.assertEquals("1", actualId);
        Assert.assertEquals(0.0, actualRating, 0.1);
        Assert.assertEquals(125000D, actualBounty, 0.1);
    }

    @Test
    public void overflowingRatingAndNegativeBounty() {
        Mission mission = missionControl.generateMission("1", Double.MAX_VALUE, -99999.9);
        String actualId = mission.getId();
        double actualRating = mission.getRating();
        double actualBounty = mission.getBounty();

        Assert.assertEquals("1", actualId);
        Assert.assertEquals(75.0, actualRating, 0.1);
        Assert.assertEquals(0D, actualBounty, 0.1);
    }

    @Test
    public void idBeingOver8Characters() {
        Mission mission = missionControl.generateMission("123456789321321", Double.MAX_VALUE, -99999.9);
        String actualId = mission.getId();

        Assert.assertEquals("12345678", actualId);
    }
}