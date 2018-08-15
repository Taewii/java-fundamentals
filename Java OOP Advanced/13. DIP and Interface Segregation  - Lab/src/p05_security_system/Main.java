package p05_security_system;

import p05_security_system.contracts.KeyCardUI;
import p05_security_system.contracts.PinCodeUI;
import p05_security_system.models.KeyCardCheck;
import p05_security_system.models.PinCodeCheck;
import p05_security_system.models.ScannerUI;
import p05_security_system.models.SecurityManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        ScannerUI scannerUI = new ScannerUI(new Scanner(System.in));
        KeyCardUI keyCardCheck = new KeyCardCheck(scannerUI);
        PinCodeUI pinCodeCheck = new PinCodeCheck(scannerUI);
        SecurityManager manager = new SecurityManager(keyCardCheck, pinCodeCheck, scannerUI);
        manager.check();
    }
}
