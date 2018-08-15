package p05_security_system.models;

import p05_security_system.contracts.KeyCardUI;
import p05_security_system.contracts.PinCodeUI;

import java.io.IOException;
import java.util.Scanner;

public class SecurityManager {

    private KeyCardUI keyCardCheck;
    private PinCodeUI pinCodeCheck;
    private ScannerUI scanner;

    public SecurityManager(KeyCardUI keyCardCheck, PinCodeUI pinCodeCheck, ScannerUI scanner) {
        this.keyCardCheck = keyCardCheck;
        this.pinCodeCheck = pinCodeCheck;
        this.scanner = scanner;
    }

    public void check() {
        int option = this.scanner.getOption();
        switch (option) {
            case 1:
                System.out.println(keyCardCheck.validateUser());
                break;
            case 2:
                System.out.println(pinCodeCheck.validateUser());
                break;
        }
    }
}
