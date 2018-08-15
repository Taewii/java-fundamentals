package p05_security_system.models;

import p05_security_system.contracts.KeyCardUI;
import p05_security_system.contracts.SecurityUI;

public class KeyCardCheck extends SecurityCheck implements KeyCardUI {

    private SecurityUI securityUI;

    public KeyCardCheck(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public boolean validateUser() {
        String code = securityUI.requestKeyCard();

        return isValid(code);
    }

    private boolean isValid(String code) {
        return true;
    }

    @Override
    public String requestKeyCard() {
        return "enter your pin code";
    }
}
