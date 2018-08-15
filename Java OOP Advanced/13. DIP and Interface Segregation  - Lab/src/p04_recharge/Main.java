package p04_recharge;

import p04_recharge.contracts.Rechargeable;
import p04_recharge.contracts.Sleeper;
import p04_recharge.models.Employee;
import p04_recharge.models.RechargeStation;
import p04_recharge.models.Robot;

public class Main {
    public static void main(String[] args) {
        RechargeStation station = new RechargeStation();
        Rechargeable robot = new Robot("1", 50);
        Sleeper human = new Employee("2");

        human.work(5);
        human.sleep();
        robot.work(5);
        robot.recharge();
        station.recharge(robot);
    }
}
