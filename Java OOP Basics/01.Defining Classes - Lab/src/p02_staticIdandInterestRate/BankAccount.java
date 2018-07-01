package p02_staticIdandInterestRate;

public class BankAccount {

    private static final double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int idSequence;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++idSequence;
    }

    public int getId() {
        return this.id;
    }

    public static void setInterestRate(double interest) {
        rate = interest;
    }

    public double getInterest(int years) {
        return this.balance * rate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
