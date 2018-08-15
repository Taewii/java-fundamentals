package p05_security_system.models;

import p05_security_system.contracts.SecurityUI;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerUI implements SecurityUI {

    private Scanner scanner;

    public ScannerUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getOption() {
        return Integer.parseInt(this.scanner.nextLine());
    }

    @Override
    public String requestKeyCard() {
        System.out.println("slide your key card");
        return this.scanner.nextLine();
    }

    @Override
    public int requestPinCode() {
        System.out.println("enter your pin code");
        return Integer.parseInt(this.scanner.nextLine());
    }
}
