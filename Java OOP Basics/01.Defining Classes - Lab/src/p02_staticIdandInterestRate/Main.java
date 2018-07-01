package p02_staticIdandInterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount acc = new BankAccount();
                    accounts.put(acc.getId(), acc);
                    System.out.printf("Account ID%d created%n", acc.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amountToDeposit = Double.parseDouble(tokens[2]);
                    acc = accounts.get(id);
                    if (acc != null) {
                        acc.deposit(amountToDeposit);
                        System.out.printf("Deposited %.0f to ID%d%n", amountToDeposit, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    acc = accounts.get(id);
                    if (acc != null) {
                        System.out.printf("%.2f%n", acc.getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;

            }
        }
    }
}
