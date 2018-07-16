package p04_telephony;

import p04_telephony.contracts.Browsable;
import p04_telephony.contracts.Callable;

public class Smartphone implements Callable, Browsable {

    private String input;

    public Smartphone(String input) {
        this.input = input;
    }

    @Override
    public void browse() {
        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            if (token.matches("^[^\\d]*$")) {
                System.out.println("Browsing: " + token + "!");
            } else {
                System.out.println("Invalid URL!");
            }
        }
    }

    @Override
    public void call() {
        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            if (token.matches("^[\\d]+$")) {
                System.out.println("Calling... " + token);
            } else {
                System.out.println("Invalid number!");
            }
        }
    }
}
