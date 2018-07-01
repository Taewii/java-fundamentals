package p01_bankAccountTestClient;

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
            int id = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Create":
                    createAccount(accounts, id);
                    break;
                case "Deposit":
                    depositToAccount(accounts.get(id), tokens[2]);
                    break;
                case "Withdraw":
                    withdrawFromAccount(accounts, tokens[2], id);
                        break;
                case "Print":
                    printIdAndCurrentBalance(accounts, id);
                    break;
            }
        }
    }

    private static void printIdAndCurrentBalance(Map<Integer, BankAccount> accounts, int id) {
        BankAccount acc;
        acc = accounts.get(id);
        if (acc != null) {
            System.out.println(accounts.get(id));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void withdrawFromAccount(Map<Integer, BankAccount> accounts, String token, int id) {
        BankAccount acc;
        double amountToWithDraw = Double.parseDouble(token);
        acc = accounts.get(id);
        if (acc != null) {
            if (acc.getBalance() < amountToWithDraw) {
                System.out.println("Insufficient balance");
            } else {
                acc.withdraw(amountToWithDraw);
            }
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void depositToAccount(BankAccount acc1, String token) {
        double amountToDeposit = Double.parseDouble(token);
        BankAccount acc = acc1;
        if (acc != null) {
            acc.deposit(amountToDeposit);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount(Map<Integer, BankAccount> accounts, int id) {
        if (!accounts.containsKey(id)) {
            BankAccount acc = new BankAccount();
            acc.setId(id);
            accounts.put(id, acc);
        } else {
            System.out.println("Account already exists");
        }
    }
}
