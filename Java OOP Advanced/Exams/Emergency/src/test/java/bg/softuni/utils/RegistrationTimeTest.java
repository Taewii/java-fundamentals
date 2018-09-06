package bg.softuni.utils;

import bg.softuni.interfaces.Time;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationTimeTest {

    private Time time;

    @Before
    public void setUp() {
        this.time = new RegistrationTime("12:24 25/02/2016");
    }

    @Test
    public void getHour() {
        int actual = this.time.getHour();
        Assert.assertEquals(12, actual);
    }

    @Test
    public void getMinutes() {
        int actual = this.time.getMinutes();
        Assert.assertEquals(24, actual);
    }

    @Test
    public void getDay() {
        int actual = this.time.getDay();
        Assert.assertEquals(25, actual);
    }

    @Test
    public void getMonth() {
        int actual = this.time.getMonth();
        Assert.assertEquals(2, actual);
    }

    @Test
    public void getYear() {
        int actual = this.time.getYear();
        Assert.assertEquals(2016, actual);
    }

    @Test
    public void string() {
        String actual = this.time.toString();
        Assert.assertEquals("12:24 25/02/2016", actual);
    }
}