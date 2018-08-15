package p05_security_system.models;

import p05_security_system.contracts.PinCodeUI;
import p05_security_system.contracts.SecurityUI;

public class PinCodeCheck extends SecurityCheck implements PinCodeUI {

    private SecurityUI securityUI;

    public PinCodeCheck(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public boolean validateUser() {
        int pin = securityUI.requestPinCode();

        return isValid(pin);
    }

    private boolean isValid(int pin) {
        return true;
    }

    @Override
    public int requestPinCode() {
        return this.securityUI.requestPinCode();
    }
}
